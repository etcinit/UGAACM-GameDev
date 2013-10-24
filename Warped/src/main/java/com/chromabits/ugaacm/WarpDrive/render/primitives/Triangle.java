package com.chromabits.ugaacm.WarpDrive.render.primitives;

import com.chromabits.ugaacm.WarpDrive.render.Color;
import com.chromabits.ugaacm.WarpDrive.render.Drawable;
import com.chromabits.ugaacm.WarpDrive.render.Vertex;
import com.chromabits.ugaacm.WarpDrive.render.VertexBuffer;

import javax.microedition.khronos.opengles.GL10;


/**
 * Created by Eduardo Trujillo on 10/19/13.
 */
public class Triangle implements Drawable {

    private VertexBuffer vertexBuffer; // Buffer for holding all the vertices
    private Color backgroundColor;

    public Triangle(Vertex v0, Vertex v1, Vertex v2){
        vertexBuffer = new VertexBuffer();

        // Set default color
        backgroundColor = Color.WHITE;

        vertexBuffer.add(v0);
        vertexBuffer.add(v1);
        vertexBuffer.add(v2);
    }

    public void setBgColor(Color c){
        backgroundColor = c;
    }


    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        // Set color
        backgroundColor.setGlColor(gl);

        // Point to the vertex buffer
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer.getBuffer());

        // Draw the vertices as a triangle strip
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertexBuffer.countVertices());

        // Disable client state
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
