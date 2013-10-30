package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/20/13.
 */
public class DrawQueue implements Drawable{

    private ArrayList<Drawable> contents;

    public DrawQueue(){
        contents = new ArrayList<Drawable>();
    }

    public void addObject(Drawable object){
        contents.add(object);
    }

    public boolean isNotEmpty(){
        if(contents.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    public void draw(GlProgram glp) {
        for (Drawable object : contents) {
            object.draw(glp);
        }
    }
}
