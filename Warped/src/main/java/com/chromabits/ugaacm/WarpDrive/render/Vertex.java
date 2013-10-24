package com.chromabits.ugaacm.WarpDrive.render;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class Vertex {

    private float x,y,z;
    private Color color;
    private boolean isColorSet;

    public float[] getFloatArray(boolean noColor){
        if(!isColorSet || noColor){
            float values[] = new float[3];

            values[0] = x;
            values[1] = y;
            values[2] = z;

            return values;
        }else{
            float values[] = new float[7];

            values[0] = x;
            values[1] = y;
            values[2] = z;

            values[3] = color.getR();
            values[4] = color.getG();
            values[5] = color.getB();
            values[6] = color.getAlpha();

            return values;
        }
    }

    public Vertex(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;

        isColorSet = false;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getZ(){
        return z;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        isColorSet = true;
        this.color = color;
    }

    public boolean isColorSet(){
        return isColorSet;
    }

    public int getArraySize(){
        if(isColorSet){
            return 7;
        }

        return 3;
    }
}
