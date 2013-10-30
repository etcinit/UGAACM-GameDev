package com.chromabits.ugaacm.WarpDrive.render.primitives;

import com.chromabits.ugaacm.WarpDrive.render.Vertex;

public class Triangle extends Shape{

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        super();

        vertexBuffer.add(v1);
        vertexBuffer.add(v2);
        vertexBuffer.add(v3);
    }
}
