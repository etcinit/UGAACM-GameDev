package com.chromabits.ugaacm.Warped;

import java.util.ArrayList;
import java.util.List;

import com.chromabits.ugaacm.WarpDrive.control.*;
import com.chromabits.ugaacm.WarpDrive.render.DrawQueue;
import com.chromabits.ugaacm.WarpDrive.render.GlRenderer;

public class GameScreen extends Screen {
    enum GameState {
        Ready, Running, Paused, GameOver
    }

    GameState state = GameState.Ready;

    // Variable Setup
    int livesLeft = 1;
    GlRenderer renderer;


    public GameScreen(Game game) {
        super(game);



        // Initialize game objects
        // TODO Auto-generated method stub


        // Define a rendering object
        // TODO Auto-generated method stub


    }

    @Override
    public void updateLogic() {

        // Check touch events to determine next state
        // TODO Auto-generated method stub

        if (state == GameState.Ready)
            updateReady();
        if (state == GameState.Running)
            updateRunning();
        if (state == GameState.Paused)
            updatePaused();
        if (state == GameState.GameOver)
            updateGameOver();

    }

    @Override
    public void addElements(DrawQueue curQueue) {

        // Draw Game Elements
        // TODO Auto-generated method stub


        // Draw UI
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI();
        if (state == GameState.Paused)
            drawPausedUI();
        if (state == GameState.GameOver)
            drawGameOverUI();

    }

    private void updateReady() {

        // If player touches screen
        state = GameState.Running;

    }

    private void updateRunning() {

        // Handle Touch Input
        // TODO Auto-generated method stub


        // Check miscellaneous events like death:
        if (livesLeft == 0) {
            state = GameState.GameOver;
        }


        // Call individual update() methods
        // TODO Auto-generated method stub


    }

    private void updatePaused() {

        // TODO Auto-generated method stub

    }

    private void updateGameOver() {

        // TODO Auto-generated method stub

    }

    private void nullify() {

        // Set all variables to null. Recreate them in the constructor
        // TODO Auto-generated method stub

        // Clean up memory.
        System.gc();
    }

    private void drawReadyUI() {

        // TODO Auto-generated method stub

    }

    private void drawRunningUI() {

        // TODO Auto-generated method stub

    }

    private void drawPausedUI() {

        // TODO Auto-generated method stub

    }

    private void drawGameOverUI() {

        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {

        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {

        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {

        // TODO Auto-generated method stub

    }

    @Override
    public void backButton() {

        // TODO Auto-generated method stub

    }
}