package com.chromabits.ugaacm.WarpDrive.UI;

import com.chromabits.ugaacm.WarpDrive.render.Drawable;

public interface ComponentInterface extends Drawable {

    public int getX();
    public void setX(int x);

    public int getY();
    public void setY(int y);

    public int getHeight();
    public void setHeight(int height);

    public int getWidth();
    public void setWidth(int width);

    public int getPriority();
    public void setPriority(int priority);

    public String getID();
    public void setID(String ID);

    public Text getText();
    public void setText(Text text);

}
