package com.chromabits.ugaacm.Warped;

import com.chromabits.ugaacm.WarpDrive.control.Screen;

public class Warped extends AndroidGame {

    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this);
    }

}
