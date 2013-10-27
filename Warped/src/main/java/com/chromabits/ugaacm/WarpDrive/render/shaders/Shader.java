package com.chromabits.ugaacm.WarpDrive.render.shaders;

/**
 * Created by delta6 on 10/27/13.
 */
public interface Shader {

    public String getCode();

    public int getType();

    public int getHandle() throws Exception;

    public int load();
}
