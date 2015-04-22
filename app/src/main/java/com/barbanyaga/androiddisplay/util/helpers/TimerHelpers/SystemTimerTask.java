package com.barbanyaga.androiddisplay.util.helpers.TimerHelpers;

/**
 * Created by barbanyaga on 21.04.2015.
 */
public abstract class SystemTimerTask {
    private boolean cancel;

    public abstract void run();

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
