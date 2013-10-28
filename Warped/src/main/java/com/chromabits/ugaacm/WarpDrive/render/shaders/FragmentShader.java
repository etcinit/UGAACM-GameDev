package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/27/13.
 */
public class FragmentShader extends Shader{

    private String code;

    public FragmentShader(String code){
        super();

        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    @Override
    public int getType() {
        return GLES20.GL_FRAGMENT_SHADER;
    }


    public static FragmentShader getBasicShader(){
        return new FragmentShader("precision mediump float;" +
                "uniform vec4 vColor;" +
                "void main() {" +
                "  gl_FragColor = vColor;" +
                "}");
    }
}
