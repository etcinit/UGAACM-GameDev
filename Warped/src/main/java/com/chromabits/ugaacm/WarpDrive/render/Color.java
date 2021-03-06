package com.chromabits.ugaacm.WarpDrive.render;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class Color {

    public static final Color RED = new Color(1.0f,0.0f,0.0f,1.0f);
    public static final Color GREEN = new Color(0.0f,1.0f,0.0f,1.0f);
    public static final Color BLUE = new Color(0.0f,0.0f,1.0f,1.0f);

    public static final Color ANDROID_GREEN = new Color(0.63671875f, 0.76953125f, 0.22265625f, 1.0f);

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

    public float[] getFloatArray(){
        float[] result = new float[4];

        result[0] = r;
        result[1] = g;
        result[2] = b;
        result[3] = alpha;

        return result;
    }
}
