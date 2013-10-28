package com.chromabits.ugaacm.WarpDrive.render;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.util.Log;

import com.chromabits.ugaacm.WarpDrive.render.primitives.Rectangle;
import com.chromabits.ugaacm.WarpDrive.render.primitives.Triangle;
import com.chromabits.ugaacm.WarpDrive.render.shaders.FragmentShader;
import com.chromabits.ugaacm.WarpDrive.render.shaders.VertexShader;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class GlRenderer implements Renderer{

    private World currentWorld;
    private GlProgram glp;

    private Triangle t1;

    private float[] mViewMatrix = new float[16];

    public GlRenderer(){

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        // Set the background frame color
        GLES20.glClearColor(0.0f, 0.5f, 0.0f, 1.0f);

        try{
            glp = new GlProgram();
            VertexShader vs = VertexShader.getBasicShader();
            FragmentShader fs = FragmentShader.getBasicShader();
            vs.load();
            fs.load();
            glp.attachShader(vs);
            glp.attachShader(fs);
            glp.link();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        currentWorld = new World();

        // Test code
        Rectangle r1 = new Rectangle(new Vertex(-0.5f,-0.5f,0.0f), new Vertex(-0.2f,-0.2f,0.0f));
        Rectangle r2 = new Rectangle(new Vertex(-0.5f,0.2f,0.0f), new Vertex(-0.2f,0.5f,0.0f));
        Rectangle r3 = new Rectangle(new Vertex(0.2f,0.2f,0.0f), new Vertex(0.5f,0.5f,0.0f));
        Rectangle r4 = new Rectangle(new Vertex(0.2f,-0.5f,0.0f), new Vertex(0.5f,-0.2f,0.0f));


        r1.setColor(Color.BLUE);
        r2.setColor(Color.GREEN);
        r3.setColor(Color.RED);

        currentWorld.addObject(r1);
        currentWorld.addObject(r2);
        currentWorld.addObject(r3);
        currentWorld.addObject(r4);

        t1 = new Triangle();

        //currentWorld.addObject(t1);


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Prevent divide by zero
        //if(height == 0){
        //    height = 1;
        //}

        // Reset viewport
        GLES20.glViewport(0,0,width,height);
        //gl.glViewport(0,0,width,height);

        // Select projection matrix
        //gl.glMatrixMode(GL10.GL_PROJECTION);
        // Reset projection matrix
        //gl.glLoadIdentity();

        //lookAt(new Vertex(0.0f,0.0f,1.5f),
        //        new Vertex(0.0f,0.0f,-5.0f),
        //        new Vertex(0.0f,1.0f,0.0f));

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
        //t1.draw(glp);

        currentWorld.draw(glp);
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

    /**
     * Utility method for debugging OpenGL calls. Provide the name of the call
     * just after making it:
     *
     * <pre>
     * mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");
     * MyGLRenderer.checkGlError("glGetUniformLocation");</pre>
     *
     * If the operation is not successful, the check throws an error.
     *
     * @param glOperation - Name of the OpenGL call to check.
     */
    public static void checkGlError(String glOperation) {
        int error;
        while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
            Log.e("WarpGL", glOperation + ": glError " + error);
            throw new RuntimeException(glOperation + ": glError " + error);
        }
    }

    public static int loadShader(int type, String shaderCode){

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);

        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }
}
