package com.chromabits.ugaacm.WarpDrive.UI;

import java.util.Vector;

public class Button extends Component {

    private static Vector<Button> buttons;

    private boolean isClickable;

    // Constructors
    public Button(Component baseComponent, boolean isClickable) {

        super(baseComponent);
        this.isClickable = isClickable;

        baseComponent = null;
        // TODO Add sorting and remove

    }

    // Clickable
    public boolean isClickable() {
        return this.isClickable;
    }
    public void setClickable(boolean isClickable) {
        this.isClickable = isClickable;
    }

    // Intersects
    public boolean intersects(int x, int y) { // Replace parameter with Touch object once Input is complete - TODO
        return (x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height);
    }

}
