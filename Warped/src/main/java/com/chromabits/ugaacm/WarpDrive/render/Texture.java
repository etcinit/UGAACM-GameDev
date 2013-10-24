package com.chromabits.ugaacm.WarpDrive.render;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/19/13.
 */
public class Texture {

    private int textureHandle;

    public Texture(int textureHandle){
        this.textureHandle = textureHandle;
    }

    public int getHandle(){
        return textureHandle;
    }
}
