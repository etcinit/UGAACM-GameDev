package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by ${MyName} on 10/20/13.
 */
public class World implements Drawable{

    private ArrayList<Drawable> contents;

    public World(){
        contents = new ArrayList<Drawable>();
    }

    public void addObject(Drawable object){
        contents.add(object);
    }


    @Override
    public void draw(GL10 gl) {
        for (Drawable object : contents) {
            object.draw(gl);
        }
    }
}
