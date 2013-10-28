package com.chromabits.ugaacm.WarpDrive.render;

import android.opengl.GLES20;
import android.util.Log;

import com.chromabits.ugaacm.WarpDrive.render.shaders.Shader;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/27/13.
 */
public class GlProgram {

    private int handle;

    public GlProgram(){
        this.handle = GLES20.glCreateProgram();
    }

    public void attachShader(Shader s){
        try {
            GLES20.glAttachShader(this.handle,s.getHandle());
            GlRenderer.checkGlError("glAttachShader");
        } catch (Exception e) {
            // TODO: Do something about this
            Log.e("Warped", "Error (2): " + e.getLocalizedMessage(),e.getCause());
            e.printStackTrace();
        }
    }

    public void link(){
        GLES20.glLinkProgram(handle);
        int[] linkStatus = new int[1];
        GLES20.glGetProgramiv(handle, GLES20.GL_LINK_STATUS, linkStatus, 0);
        if (linkStatus[0] != GLES20.GL_TRUE) {
            Log.e("WarpGL", "Could not link program: ");
            Log.e("WarpGL", GLES20.glGetProgramInfoLog(handle));
            GLES20.glDeleteProgram(handle);
            handle = 0;
        }
    }

    public int getHandle(){
        return this.handle;
    }
}
