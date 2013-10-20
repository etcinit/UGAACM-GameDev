package com.chromabits.ugaacm.WarpDrive.render;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Color;

public class AndroidGraphics implements Graphics {
    AssetManager assets;
    Bitmap frameBuffer;
    Canvas canvas;
    Paint paint;
    Rect subsetRect = new Rect();
    Rect newRect = new Rect();

    public AndroidGraphics(AssetManager assets, Bitmap frameBuffer) {

        this.assets = assets;
        this.frameBuffer = frameBuffer;
        this.canvas = new Canvas(frameBuffer);
        this.paint = new Paint();

    }

    @Override
    public Image newImage(String fileName, Format format) {
        Config config = null;
        if (format == Format.RGB565)
            config = Config.RGB_565;
        else if (format == Format.ARGB4444)
            config = Config.ARGB_4444;
        else
            config = Config.ARGB_8888;

        Options options = new Options();
        options.inPreferredConfig = config;
        
        
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in, null, options);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load bitmap from asset '"
                    + fileName + "'");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) { }
            }
        }

        if (bitmap.getConfig() == Config.RGB_565)
            format = Format.RGB565;
        else if (bitmap.getConfig() == Config.ARGB_4444)
            format = Format.ARGB4444;
        else
            format = Format.ARGB8888;

        return new AndroidImage(bitmap, format);
    }

    @Override
    public void colorBackground(Color color) {

        // TODO

    }

    @Override
    public void drawImage(Image image, int x, int y) {

        canvas.drawBitmap(((AndroidImage)image).bitmap, x, y, null);

    }

    @Override
    public void drawImage(Image Image, int x, int y, int subsetX, int subsetY, int subsetWidth, int subsetHeight) {

        // This rectangle is the subset of the Image, useful for sprite sheets, but typically left null
        subsetRect.left = subsetX;
        subsetRect.top = subsetY;
        subsetRect.right = subsetX + subsetWidth;
        subsetRect.bottom = subsetY + subsetHeight;
        
        // This rectangle is where you want the bitmap to be scaled/translated to
        newRect.left = x;
        newRect.top = y;
        newRect.right = x + subsetWidth;
        newRect.bottom = y + subsetHeight;

        canvas.drawBitmap(((AndroidImage) Image).bitmap, subsetRect, newRect, null);
    }

    @Override
    public void drawRotatedImage(Image image, int x, int y, Matrix m) {

    	Bitmap newBitmap = Bitmap.createBitmap(((AndroidImage)image).bitmap, 0, 0, image.getWidth(), image.getHeight(), m, true);
    	canvas.drawBitmap(newBitmap, (x - newBitmap.getWidth())/2, (y - newBitmap.getHeight())/2, null);

    }

    @Override
    public void drawString(String text, int x, int y, Paint paint) {

        canvas.drawText(text, x, y, paint);

    }

}