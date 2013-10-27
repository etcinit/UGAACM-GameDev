package com.chromabits.ugaacm.WarpDrive.render;

import android.opengl.GLES20;

import com.chromabits.ugaacm.WarpDrive.render.shaders.Shader;

/**
 * Created by delta6 on 10/27/13.
 */
public class GlProgram {

    private int handle;

    public GlProgram(){
        this.handle = GLES20.glCreateProgram();
    }

    public void attachShader(Shader s){
        GLES20.glAttachShader(this.handle,s.get);
    }

    public int getHandle(){
        return this.handle;
    }
}
