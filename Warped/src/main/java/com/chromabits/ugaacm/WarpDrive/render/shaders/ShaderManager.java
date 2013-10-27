package com.chromabits.ugaacm.WarpDrive.render.shaders;

import android.opengl.GLES20;

import java.util.ArrayList;

/**
 * Created by delta6 on 10/27/13.
 */
public class ShaderManager {

    private ArrayList<Integer> shaderHandles;

    public int load(Shader s){
        int shader = s.load();

        // add shader to handle list
        shaderHandles.add(shader);

        return shader;
    }
}
