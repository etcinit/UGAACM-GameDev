package com.chromabits.ugaacm.WarpDrive.render.primitives;

import android.opengl.GLES20;

import com.chromabits.ugaacm.WarpDrive.render.Color;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;
import com.chromabits.ugaacm.WarpDrive.render.Vertex;
import com.chromabits.ugaacm.WarpDrive.render.VertexBuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Triangle extends Shape{

    public Triangle() {
        super();

        vertexBuffer.add(new Vertex(0.0f,  0.622008459f, 0.0f));
        vertexBuffer.add(new Vertex(-0.5f, -0.311004243f, 0.0f));
        vertexBuffer.add(new Vertex(0.5f, -0.311004243f, 0.0f));

        // TODO: Remove
        color = Color.ANDROID_GREEN;
    }
}
