package com.chromabits.ugaacm.WarpDrive.render;

import android.graphics.Bitmap;

import com.chromabits.ugaacm.WarpDrive.render.Image;
import com.chromabits.ugaacm.WarpDrive.render.Graphics.Format;

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
 