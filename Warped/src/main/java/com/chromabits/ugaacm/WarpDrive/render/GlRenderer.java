package com.chromabits.ugaacm.WarpDrive.render;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;

import com.chromabits.ugaacm.WarpDrive.render.primitives.Rectangle;
import com.chromabits.ugaacm.WarpDrive.render.primitives.Triangle;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class GlRenderer implements Renderer{

    private World currentWorld;

    private float[] mViewMatrix = new float[16];

    public GlRenderer(){
        currentWorld = new World();

        // Test code
        Rectangle r1 = new Rectangle(new Vertex(-0.5f,-0.5f,0.0f), new Vertex(-0.2f,-0.2f,0.0f));
        Rectangle r2 = new Rectangle(new Vertex(-0.5f,0.2f,0.0f), new Vertex(-0.2f,0.5f,0.0f));
        Rectangle r3 = new Rectangle(new Vertex(0.2f,0.2f,0.0f), new Vertex(0.5f,0.5f,0.0f));
        Rectangle r4 = new Rectangle(new Vertex(0.2f,-0.5f,0.0f), new Vertex(0.5f,-0.2f,0.0f));


        r1.setBgColor(Color.BLUE);
        r2.setBgColor(Color.GREEN);
        r3.setBgColor(Color.RED);

        currentWorld.addObject(r1);
        currentWorld.addObject(r2);
        currentWorld.addObject(r3);
        currentWorld.addObject(r4);
    }

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
        GLES20.glViewport(0,0,width,height);
        //gl.glViewport(0,0,width,height);

        // Select projection matrix
        //gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset projection matrix
        //gl.glLoadIdentity();

        lookAt(new Vertex(0.0f,0.0f,1.5f),
                new Vertex(0.0f,0.0f,-5.0f),
                new Vertex(0.0f,1.0f,0.0f));

        // Calculate aspect ratio
        //GLU.gluPerspective(gl, 45.0f, (float)width/(float)height, 0.1f, 100.0f);

        // Select model view matrix
        //gl.glMatrixMode(GL10.GL_MODELVIEW);

        // Reset model view matrix
        //gl.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Clear the screen and the depth buffer
        //gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        // Reset model view matrix
        //gl.glLoadIdentity();

        // Move "camera" away by 5 units
        //gl.glTranslatef(0.0f,0.0f,-5.0f);

        // TEMPORAL TEST CODE
        // Draw a triangle
        //Triangle t1 = new Triangle(new Vertex(-0.5f,-0.5f,0.0f),
        //        new Vertex(0.5f,-0.5f,0.0f),
        //        new Vertex(0.0f,0.5f,0.0f));
        //t1.draw(gl);

        currentWorld.draw(gl);
    }

    /**
     * Set where the "camera" is looking at
     * @param eye The position of the camera in the world
     * @param look Direction vector pointing where the camera is looking at
     * @param up Direction vector for where "up" is in the world
     */
    public void lookAt(Vertex eye, Vertex look, Vertex up){
        Matrix.setLookAtM(mViewMatrix, 0, eye.getX(), eye.getY(), eye.getZ(),
                look.getX(), look.getY(), look.getZ(),
                up.getX(), up.getY(), up.getZ());
    }
}
