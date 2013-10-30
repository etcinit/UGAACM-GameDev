package com.chromabits.ugaacm.WarpDrive.control;

import android.util.Log;

import com.chromabits.ugaacm.WarpDrive.render.Color;
import com.chromabits.ugaacm.WarpDrive.render.DrawQueue;
import com.chromabits.ugaacm.WarpDrive.render.Gl2SurfaceView;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;
import com.chromabits.ugaacm.WarpDrive.render.Vertex;
import com.chromabits.ugaacm.WarpDrive.render.primitives.Rectangle;

/**
 * Main Engine Thread
 *
 * - Contains main game loop
 * - Directs how and when functions are processed in the game
 *
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/29/13.
 */
public class Engine implements Runnable {

    private Game game;

    private GlRenderer renderer;
    private Gl2SurfaceView view;
    private DrawQueue drawQueue;

    private boolean finishing;
    private boolean isFirstRun;
    private boolean isPaused;
    private Object pauseLock;

    public Engine(Game game, GlRenderer renderer, Gl2SurfaceView view){
        this.game = game;
        this.renderer = renderer;
        this.view = view;

        finishing = false;
        isFirstRun = true;
        isPaused = false;
        pauseLock = new Object();
    }

    @Override
    public void run() {
        while(!finishing){
            // First run stuff
            if(isFirstRun){
                firstRun();
            }else{
                renderer.waitForDraw();
            }

            // We are only using one draw queue for now
            // The engine is supposed to swap two of them every frame
            renderer.setDrawQueue(drawQueue);

            // Detect is the engine is pausing
            synchronized (pauseLock){
                if(isPaused){
                    // While the engine paused, wait until a signal
                    while(isPaused){
                        try {
                            Log.i("WarpDrive","Engine waiting to resume");
                            pauseLock.wait();
                        } catch (InterruptedException e) {
                            // Not a big problem if it is interrupted
                            Log.w("WarpDrive","Engine interrupted");
                            e.printStackTrace();
                        }
                    }
                    Log.i("WarpDrive","Engine resuming");
                }
            }
        }
    }

    private void firstRun(){
        drawQueue = new DrawQueue();

        // Create some rectangles
        Rectangle r1 = new Rectangle(new Vertex(-0.5f,-0.5f,0.0f), new Vertex(-0.2f,-0.2f,0.0f));
        Rectangle r2 = new Rectangle(new Vertex(-0.5f,0.2f,0.0f), new Vertex(-0.2f,0.5f,0.0f));
        Rectangle r3 = new Rectangle(new Vertex(0.2f,0.2f,0.0f), new Vertex(0.5f,0.5f,0.0f));
        Rectangle r4 = new Rectangle(new Vertex(0.2f,-0.5f,0.0f), new Vertex(0.5f,-0.2f,0.0f));

        r1.setColor(Color.BLUE);
        r2.setColor(Color.GREEN);
        r3.setColor(Color.RED);

        drawQueue.addObject(r1);
        drawQueue.addObject(r2);
        drawQueue.addObject(r3);
        drawQueue.addObject(r4);

        isFirstRun = false;
    }

    public void onResume(){
        // Resume engine
        synchronized (pauseLock){
            isPaused = false;
            pauseLock.notifyAll();
        }

        // Resume gl view
        view.onResume();
    }

    public void onPause(){
        synchronized (pauseLock){
            isPaused = true;
        }

        // Pause gl view
        renderer.onPause();
        view.onPause();
    }

    public void onStopping(){
        synchronized (pauseLock){
            finishing = true;
            isPaused = false;
            pauseLock.notifyAll();
        }
    }
}
