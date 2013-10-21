package com.chromabits.ugaacm.Warped;

import com.chromabits.ugaacm.WarpDrive.control.Game;
import com.chromabits.ugaacm.WarpDrive.control.Screen;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }


    @Override
    public void updateLogic() {

        // This is where the resourceManager should load everything

        game.setScreen(new MainMenuScreen(game));

    }


    @Override
    public void renderScreen() {

        // Only needed if we want a viewable load screen

    }


    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}
    @Override
    public void backButton() {}

}