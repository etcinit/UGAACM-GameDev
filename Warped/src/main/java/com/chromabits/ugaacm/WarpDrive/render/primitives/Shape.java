package com.chromabits.ugaacm.WarpDrive.render.primitives;

import android.opengl.GLES20;

import com.chromabits.ugaacm.WarpDrive.render.Drawable;
import com.chromabits.ugaacm.WarpDrive.render.VertexBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/22/13.
 */
public class Shape implements Drawable{

    private VertexBuffer vertexBuffer;

    @Override
    public void draw(GL10 gl) {
        GLES20.glEnable(GLES20.GL_VERTEX_);
    }
}
