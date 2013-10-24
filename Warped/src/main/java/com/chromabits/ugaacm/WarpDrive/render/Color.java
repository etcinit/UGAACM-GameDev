package com.chromabits.ugaacm.WarpDrive.render;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class Color {

    public static final Color RED = new Color(1.0f,0.0f,0.0f,1.0f);
    public static final Color GREEN = new Color(0.0f,1.0f,0.0f,1.0f);
    public static final Color BLUE = new Color(0.0f,0.0f,1.0f,1.0f);

    public static final Color WHITE = new Color(1.0f,1.0f,1.0f,1.0f);
    public static final Color BLACK = new Color(0.0f,0.0f,0.0f,1.0f);

    private float r,g,b,alpha;

    public Color(float r, float g, float b, float a){
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = a;
    }

    public void setGlColor(GL10 gl){
        gl.glColor4f(r,g,b,alpha);
    }

    public float getR() {
        return r;
    }

    public float getG(){
        return g;
    }

    public float getB(){
        return b;
    }

    public float getAlpha(){
        return alpha;
    }
}
