package com.barbanyaga.androiddisplay.util.helpers.TimerHelpers;

import android.os.Handler;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by barbanyaga on 21.04.2015.
 */
public class SystemTimerAndroid {
    private final Timer clockTimer;

    public SystemTimerAndroid() {
        clockTimer = new Timer();
        clockTimer.schedule(new Task(), 1 * 1000, 1 * 1000);
    }

    private class Task extends TimerTask {
        public void run() {
            timerHandler.sendEmptyMessage(0);
        }
    }

    private final Handler timerHandler = new Handler() {
        public void handleMessage(Message msg) {
            // runs in context of the main thread
            timerSignal();
        }
    };

    private List<SystemTimerTask> clockListener = new ArrayList<SystemTimerTask>();


    private void timerSignal() {
        for (SystemTimerTask listener : clockListener) {
            if (!listener.isCancel()) {
                listener.run();
            } else {
                clockListener.remove(listener);
            }
        }
    }

    public void killTimer() {
        clockTimer.cancel();
    }

    public void addListener(SystemTimerTask listener) {
        clockListener.add(listener);
    }
}
