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
public class Shape implements Drawable{

    protected Color color;

    protected int mColorHandle;
    protected int mPositionHandle;

    protected VertexBuffer vertexBuffer;

    public Shape(){
        // Set a default color
        color = Color.WHITE;

        // Initialize vertexBuffer
        vertexBuffer = new VertexBuffer();
    }

    public void setColor(Color c){
        color = c;
    }

    @Override
    public void draw(GlProgram glp) {
        int mProgram = glp.getHandle();

        // Add program to OpenGL environment
        GLES20.glUseProgram(mProgram);

        // get handle to vertex shader's vPosition member
        mPositionHandle = GLES20.glGetAttribLocation(mProgram, "vPosition");

        // Enable a handle to the triangle vertices
        GLES20.glEnableVertexAttribArray(mPositionHandle);

        // Prepare the triangle coordinate data
        GLES20.glVertexAttribPointer(mPositionHandle, Vertex.COORDS_PER_VERTEX,
                GLES20.GL_FLOAT, false,
                Vertex.getStride(), vertexBuffer.getBuffer());

        // get handle to fragment shader's vColor member
        mColorHandle = GLES20.glGetUniformLocation(mProgram, "vColor");

        // Set color for drawing the triangle
        GLES20.glUniform4fv(mColorHandle, 1, color.getFloatArray(), 0);

        // Draw the triangle
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, vertexBuffer.count());

        // Disable vertex array
        GLES20.glDisableVertexAttribArray(mPositionHandle);
    }
}
