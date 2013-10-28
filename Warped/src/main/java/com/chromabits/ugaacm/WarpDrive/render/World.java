package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/20/13.
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
    public void draw(GlProgram glp) {
        for (Drawable object : contents) {
            object.draw(glp);
        }
    }
}
