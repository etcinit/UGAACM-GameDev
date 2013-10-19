package com.chromabits.ugaacm.framework;

import android.graphics.Paint;
import android.graphics.Matrix;
import android.graphics.Color;

public interface Graphics {

    // Different formats are more efficient. Google it before you guys call newImage().
    public static enum Format {
        ARGB8888, ARGB4444, RGB565
    }

    public Image newImage(String fileName, Format format);
	
	public void colorBackground(Color color);

    public void drawImage(Image image, int x, int y);

    public void drawImage(Image image, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);
    
    public void drawRotatedImage(Image image, int x, int y, Matrix m);

    public void drawString(String text, int x, int y, Paint paint);

}