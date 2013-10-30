package com.chromabits.ugaacm.Warped;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.chromabits.ugaacm.WarpDrive.control.Bootstrapper;
import com.chromabits.ugaacm.WarpDrive.control.Engine;
import com.chromabits.ugaacm.WarpDrive.render.Gl2SurfaceView;
import com.chromabits.ugaacm.WarpDrive.render.UnsupportedHardwareException;

public class GameActivity extends Activity {

    private GLSurfaceView glSurfaceV;
    private Gl2SurfaceView glView;
    private Engine engine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Attempt to load a game engine with Warped
        try{
            engine = new Bootstrapper(this).init(new Warped());
        }
        catch(UnsupportedHardwareException ex){
            // Hardware doesn't support GL ES 2
            // TODO: Inform the user that their hardware is not supported
            ex.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected void onResume() {
        super.onResume();

        // Notify engine that the application is resuming
        if(engine != null){
            engine.onResume();
        }
    }

    protected void onPause(){
        super.onPause();

        // Notify engine that the application pausing
        if(engine != null){
            engine.onPause();

            if(isFinishing()){
                engine.onStopping();
            }
        }
    }
}