package com.chromabits.ugaacm.WarpDrive.render;

import com.chromabits.ugaacm.WarpDrive.render.Graphics.Format;

public interface Image {

    public int getWidth();

    public int getHeight();

    public Format getFormat();

    public void removeImage();

}