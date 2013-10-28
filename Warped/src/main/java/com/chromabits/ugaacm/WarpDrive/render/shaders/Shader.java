package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;
import android.util.Log;

import com.chromabits.ugaacm.WarpDrive.render.GlProgram;

import java.util.ArrayList;

/**
 * Created by delta6 on 10/27/13.
 */
public abstract class Shader {

    protected ShaderStatus status;
    protected int handle;

    public Shader(){
        status = ShaderStatus.UNDEFINED;

        handle = -1;
    }

    public abstract String getCode();

    public abstract int getType();

    public int getHandle() throws Exception{
        if(handle == 0){
            throw new Exception("Handle is not available");
        }

        return handle;
    }

    public int load() throws Exception{
        if(status == ShaderStatus.COMPILED){
            throw new Exception("The shader is already compiled");
        }

        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        handle = GLES20.glCreateShader(this.getType());

        status = ShaderStatus.CREATED;

        // add the source code to the shader and compile it
        GLES20.glShaderSource(handle, this.getCode());
        GLES20.glCompileShader(handle);

        status = ShaderStatus.COMPILED;

        int[] compiled = new int[1];
        GLES20.glGetShaderiv(handle, GLES20.GL_COMPILE_STATUS, compiled, 0);
        if (compiled[0] == 0) {
            Log.e("WarpGL", "Could not compile shader " + getType() + ":");
            Log.e("WarpGL", GLES20.glGetShaderInfoLog(handle));
            GLES20.glDeleteShader(handle);
            status = ShaderStatus.DELETED;
            handle = -1;
            throw new Exception("Unable to compile shader");
        }

        return handle;
    }

    public void delete() throws Exception{
        if(status != ShaderStatus.DELETED && status != ShaderStatus.UNDEFINED){

            GLES20.glDeleteShader(handle);

            status = ShaderStatus.DELETED;
        }
    }

    public void attach(GlProgram glp) throws Exception{
        if(status != ShaderStatus.COMPILED){
            throw new Exception("A shader must be compiled before attaching it into a program");
        }

        GLES20.glAttachShader(glp.getHandle(),handle);
    }

    public ShaderStatus getStatus(){
        return status;
    }
}
