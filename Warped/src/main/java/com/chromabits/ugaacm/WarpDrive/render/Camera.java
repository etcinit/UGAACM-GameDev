package com.chromabits.ugaacm.WarpDrive.render;

import android.opengl.Matrix;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 11/1/13.
 */
public class Camera {

    private Vertex mEye, mLookAt, mUp;

    public Camera(){
        mEye = new Vertex(0.0f,0.0f,1.5f);
        mLookAt = new Vertex(0.0f,0.0f,-5.0f);
        mUp = new Vertex(0.0f,1.0f,0.0f);
    }

    public void setEye(Vertex eye){
        mEye = eye;
    }

    public void setLookAt(Vertex lookAt){
        mLookAt = lookAt;
    }

    public void setUp(Vertex up){
        mUp = up;
    }

    public float[] getViewMatrix(){
        float[] viewM = new float[16];

        Matrix.setLookAtM(viewM, 0, mEye.getX(), mEye.getY(), mEye.getZ(),
                mLookAt.getX(), mLookAt.getY(), mLookAt.getZ(),
                mUp.getX(), mUp.getY(), mUp.getZ());

        return viewM;
    }
}
