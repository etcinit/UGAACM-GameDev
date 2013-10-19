    package com.chromabits.ugaacm.Warped;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.chromabits.ugaacm.Warped.opengl.GlRenderer;

    public class MainActivity extends Activity {

        private GLSurfaceView glSurfaceV;

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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        protected void OnResume(){
            glSurfaceV.onResume();
        }

        protected void OnPause(){
            glSurfaceV.onPause();
        }
    
}
