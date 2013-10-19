package com.chromabits.ugaacm.opengl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

/**
 * Created by delta6 on 10/19/13.
 */
public class GlRenderer implements Renderer{

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        // Do nothing for now
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Prevent divide by zero
        if(height == 0){
            height = 1;
        }

        // Reset viewport
        gl.glViewport(0,0,width,height);

        // Select projection matrix
        gl.glMatrixMode(GL10.GL_PROJECTION);

        // Reset projection matrix
        gl.glLoadIdentity();


        // Calculate aspect ratio
        GLU.gluPerspective(gl, 45.0f, (float)width/(float)height, 0.1f, 100.0f);

        // Select model view matrix
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        // Reset model view matrix
        gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear the screen and the depth buffer
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        // Reset model view matrix
        gl.glLoadIdentity();

        // Move "camera" away by 5 units
        gl.glTranslatef(0.0f,0.0f,-5.0f);

        // TEMPORAL TEST CODE
        // Draw a triangle
        Triangle t1 = new Triangle(new Vertex(-0.5f,-0.5f,0.0f),
                new Vertex(0.5f,-0.5f,0.0f),
                new Vertex(0.0f,0.5f,0.0f));
        t1.draw(gl);
    }
}
