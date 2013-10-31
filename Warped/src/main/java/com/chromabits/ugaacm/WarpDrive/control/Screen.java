package com.chromabits.ugaacm.WarpDrive.control;

import com.chromabits.ugaacm.WarpDrive.render.DrawQueue;

/*
    This class should provide methods to alter the "screen". There should
    be different screens for each game mode, as well as levels (e.g. Loading Screen, Menu Screen).
 */
public abstract class Screen {
    public final Game game;

    public Screen(Game game) {
        this.game = game;
    }

    // Each of these update methods should be called by it's appropriate thread.
    public abstract void updateLogic();

//    public abstract void updateSound();

    public abstract void addElements(DrawQueue curQueue);


    public abstract void pause();

    public abstract void resume();

    public abstract void backButton();

    // Recycle the screen if we're finished with it.
    public abstract void dispose();

}
