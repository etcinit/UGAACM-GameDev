package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/20/13.
 */
public class DrawQueue implements Drawable{

    private Color backgroundColor;

    private ArrayList<Drawable> contents;

    public DrawQueue(){
        contents = new ArrayList<Drawable>();
        backgroundColor = Color.BLACK;
    }

    public void add(Drawable object){
        contents.add(object);
    }

    public void setBgColor(Color backgroundColor){
        this.backgroundColor = backgroundColor;
    }

    public Color getBgColor(){
        return backgroundColor;
    }

    public boolean isNotEmpty(){
        if(contents.size() > 0){
            return true;
        }
        return false;
    }

    public void clear(){
        contents.clear();
    }

    @Override
    public void draw(GlRendererContext glrc) {
        for (Drawable object : contents) {
            object.draw(glrc);
        }
    }
}
