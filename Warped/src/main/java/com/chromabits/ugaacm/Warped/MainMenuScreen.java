package com.chromabits.ugaacm.Warped;

import com.chromabits.ugaacm.WarpDrive.control.Game;
import com.chromabits.ugaacm.WarpDrive.control.Screen;

public class MainMenuScreen extends Screen {

    public MainMenuScreen(Game game) {

        super(game);

    }


    @Override
    public void updateLogic() {

        // Check for touch input, if player hits start,
        // Then set the screen to GameScreen with
        // game.setScreen(new GameScreen(game));

    }

    @Override
    public void renderScreen() {

        // Draw the menu elements

    }

    @Override
    public void backButton() {

        // Exit game?

    }


    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}

}