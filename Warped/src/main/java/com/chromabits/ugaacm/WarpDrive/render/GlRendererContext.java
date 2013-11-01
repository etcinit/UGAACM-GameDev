package com.chromabits.ugaacm.WarpDrive.render;

import java.util.ArrayList;

/**
 * Created by Eduardo Trujillo <ed@chromabits.com> on 11/1/13.
 */
public class GlRendererContext {

    private GlProgram defaultProgram;
    private ArrayList<GlProgram> programs;

    public GlRendererContext(GlProgram defaultProgram){
        programs = new ArrayList<GlProgram>();

        programs.add(defaultProgram);

        this.defaultProgram = programs.get(0);
    }

    public GlProgram getDefaultProgram(){
        return defaultProgram;
    }
}
