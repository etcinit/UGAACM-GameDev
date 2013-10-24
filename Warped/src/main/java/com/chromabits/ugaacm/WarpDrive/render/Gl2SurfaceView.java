package com.chromabits.ugaacm.WarpDrive.render;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 10/22/13.
 */
public class Gl2SurfaceView extends GLSurfaceView {

    public Gl2SurfaceView(Context context) throws UnsupportedHardwareException {
        super(context);

        if(context instanceof Activity){
            ActivityManager man = (ActivityManager)context.getSystemService(context.ACTIVITY_SERVICE);

            prepareView(man);
        }
    }

    public Gl2SurfaceView(Context context, AttributeSet attrs) throws UnsupportedHardwareException {
        super(context, attrs);

        if(context instanceof Activity){
            ActivityManager man = (ActivityManager)context.getSystemService(context.ACTIVITY_SERVICE);

            prepareView(man);
        }
    }

    private void prepareView(ActivityManager man) throws UnsupportedHardwareException {
        // Check if the system supports OpenGL ES 2.0.
        final ActivityManager activityManager = man;
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if(supportsEs2){
            this.setEGLContextClientVersion(2);
        }else{
            throw new UnsupportedHardwareException();
        }
    }
}
