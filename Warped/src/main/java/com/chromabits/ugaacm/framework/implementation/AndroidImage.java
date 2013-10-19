package com.chromabits.ugaacm.framework.implementation;

import android.graphics.Bitmap;

import com.chromabits.ugaacm.framework.Image;
import com.chromabits.ugaacm.framework.Graphics.Format;

public class AndroidImage implements Image {
    Bitmap bitmap;
    Format format;
    
    public AndroidImage(Bitmap bitmap, Format format) {

        this.bitmap = bitmap;
        this.format = format;

    }

    @Override
    public int getWidth() {

        return bitmap.getWidth();

    }

    @Override
    public int getHeight() {

        return bitmap.getHeight();

    }

    @Override
    public Format getFormat() {

        return format;

    }

    @Override
    public void removeImage() {

        bitmap.recycle();

    }      
}
 