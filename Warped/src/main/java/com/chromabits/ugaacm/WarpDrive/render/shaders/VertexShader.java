package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;
import android.util.Log;

import com.chromabits.ugaacm.WarpDrive.render.GlProgram;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/27/13.
 */
public class VertexShader extends Shader{

    private String code;
    private int handle;

    public VertexShader(String code){
        super();

        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public int getType() {
        return GLES20.GL_VERTEX_SHADER;
    }


    public static VertexShader getBasicShader(){
        return new VertexShader("attribute vec4 vPosition;" +
                "void main() {" +
                "  gl_Position = vPosition;" +
                "}");
    }
}
