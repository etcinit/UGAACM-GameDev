package com.chromabits.ugaacm.WarpDrive.render.primitives;

import android.opengl.GLES20;

import com.chromabits.ugaacm.WarpDrive.render.Color;
import com.chromabits.ugaacm.WarpDrive.render.Drawable;
import com.chromabits.ugaacm.WarpDrive.render.GlProgram;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;
import com.chromabits.ugaacm.WarpDrive.render.Vertex;
import com.chromabits.ugaacm.WarpDrive.render.VertexBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/22/13.
 */
public class Shape{

    protected Color color;

    protected int mColorHandle;

    public Shape(){

    }

    public void setColor(Color c){
        color = c;
    }
}
