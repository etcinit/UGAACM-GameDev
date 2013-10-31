package com.chromabits.ugaacm.Warped;

import com.chromabits.ugaacm.WarpDrive.control.Game;
import com.chromabits.ugaacm.WarpDrive.control.Screen;
import com.chromabits.ugaacm.WarpDrive.render.Color;
import com.chromabits.ugaacm.WarpDrive.render.DrawQueue;
import com.chromabits.ugaacm.WarpDrive.render.Vertex;
import com.chromabits.ugaacm.WarpDrive.render.primitives.Rectangle;

public class MainMenuScreen extends Screen {


    private Rectangle r1, r2, r3, r4;
    private boolean anim;

    public MainMenuScreen(Game game) {

        super(game);
        anim = false;

        // Create some rectangles
        r1 = new Rectangle(new Vertex(-0.5f,-0.5f,0.0f), new Vertex(-0.2f,-0.2f,0.0f));
        r2 = new Rectangle(new Vertex(-0.5f,0.2f,0.0f), new Vertex(-0.2f,0.5f,0.0f));
        r3 = new Rectangle(new Vertex(0.2f,0.2f,0.0f), new Vertex(0.5f,0.5f,0.0f));
        r4 = new Rectangle(new Vertex(0.2f,-0.5f,0.0f), new Vertex(0.5f,-0.2f,0.0f));

        r1.setColor(Color.BLUE);
        r2.setColor(Color.GREEN);
        r3.setColor(Color.RED);

    }


    @Override
    public void updateLogic() {

        if(anim){
            r1.setColor(Color.BLUE);
            r2.setColor(Color.GREEN);
            r3.setColor(Color.RED);
            anim = !anim;
        }else{
            r1.setColor(Color.GREEN);
            r2.setColor(Color.RED);
            r3.setColor(Color.BLUE);
            anim = !anim;
        }

    }

    @Override
    public void addElements(DrawQueue curQueue) {

        curQueue.add(r1);
        curQueue.add(r2);
        curQueue.add(r3);
        curQueue.add(r4); // Draw the menu elements

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