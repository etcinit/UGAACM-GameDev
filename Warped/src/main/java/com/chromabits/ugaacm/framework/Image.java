package com.chromabits.ugaacm.framework;

import com.chromabits.ugaacm.framework.Graphics.Format;

public interface Image {

    public int getWidth();

    public int getHeight();

    public Format getFormat();

    public void removeImage();

}