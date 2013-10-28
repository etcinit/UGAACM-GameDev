package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/27/13.
 */
public class FragmentShader implements Shader{

    private String code;
    private int handle;

    public FragmentShader(String code){
        this.code = code;
        handle = -1;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public int getType() {
        return GLES20.GL_FRAGMENT_SHADER;
    }

    @Override
    public int getHandle() throws Exception {
        if(handle == -1){
            throw new Exception("Handle is not available");
        }

        return handle;
    }

    @Override
    public int load() {
        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        handle = GLES20.glCreateShader(this.getType());

        // add the source code to the shader and compile it
        GLES20.glShaderSource(handle, this.getCode());
        GLES20.glCompileShader(handle);

        return handle;
    }

    public static FragmentShader getBasicShader(){
        return new FragmentShader("precision mediump float;" +
                "uniform vec4 vColor;" +
                "void main() {" +
                "  gl_FragColor = vColor;" +
                "}");
    }
}
