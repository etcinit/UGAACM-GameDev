package com.chromabits.ugaacm.Warped;

import android.opengl.GLSurfaceView;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

import com.chromabits.ugaacm.WarpDrive.control.Game;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;
import com.chromabits.ugaacm.WarpDrive.control.Screen;

public abstract class AndroidGame extends Activity implements Game {

    private GLSurfaceView glSurfaceV;
    private Screen screen;
    WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //We are not going to use the regular android UI since this is an openGL game
        //setContentView(R.layout.activity_main);

        // Request to remove window title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Go fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a surfaceView instance
        glSurfaceV = new GLSurfaceView(this);

        // Set renderer
        glSurfaceV.setRenderer(new GlRenderer());

        // Set main view
        setContentView(glSurfaceV);

        // Initialize objects
        screen = getInitScreen();

        // Creates a new wake lock
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Warped");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    public void setScreen(Screen screen) {

        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.updateLogic();
        this.screen = screen;

    }

    public Screen getCurrentScreen() {
        return this.screen;
    }

    protected void OnResume() {

        glSurfaceV.onResume();
        wakeLock.acquire();
        screen.resume();

    }

    protected void OnPause(){

        glSurfaceV.onPause();
        wakeLock.release();
        screen.pause();

        if (isFinishing())
            screen.dispose();

    }


    
}
