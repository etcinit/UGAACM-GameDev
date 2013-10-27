package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/27/13.
 */
public class VertexShader implements Shader{

    private String code;
    private int handle;

    public VertexShader(String code){
        this.code = code;
        this.handle = -1;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public int getType() {
        return GLES20.GL_VERTEX_SHADER;
    }

    @Override
    public int getHandle() throws Exception{
        if(handle == 0){
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

    public static VertexShader getBasicShader(){
        return new VertexShader("attribute vec4 vPosition;" +
                "void main() {" +
                "  gl_Position = vPosition;" +
                "}");
    }
}
