package com.chromabits.ugaacm.WarpDrive.control;

import com.chromabits.ugaacm.WarpDrive.render.Gl2SurfaceView;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;

/**
 * Main Engine Thread
 *
 * - Contains main game loop
 * - Directs how and when functions are processed in the game
 *
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/29/13.
 */
public class EngineThread implements Runnable {

    private Game game;
    private GlRenderer renderer;
    private Gl2SurfaceView view;

    public EngineThread(Game game, GlRenderer renderer, Gl2SurfaceView view){
        this.game = game;
        this.renderer = renderer;
        this.view = view;
    }

    @Override
    public void run() {

    }

    public void onResume(){
        // Resume gl view
        view.onResume();
    }

    public void onPause(){
        // Pause gl view
        view.onPause();
    }

    public void isFinishing(){

    }
}
