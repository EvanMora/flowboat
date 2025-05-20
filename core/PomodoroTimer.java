package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PomodoroTimer implements ActionListener {

    private int productivityTime;
    private int restTime;
    private int minutes;
    private int seconds;
    private boolean isRunning = false;
    private boolean isRest = false;
    TimerUpdateListener listener;
    final private Timer timer = new Timer(1000, this);

    public PomodoroTimer(int productivityTime, int restTime, TimerUpdateListener listener) {
        this.productivityTime = productivityTime;
        this.restTime = restTime;
        this.minutes = productivityTime;
        this.seconds = 0;
        this.listener = listener;
        updateTimer();
    }

    public void resetTime() {
        if (isRest) {
            minutes = restTime;
            seconds = 0;
        } else {
            minutes = productivityTime; 
            seconds = 0;
        }
        updateTimer();
    }

    public void toggleRest() {
        if (!isRest) {
            minutes = restTime;
            isRest = true;
        } else {
            minutes = productivityTime;
            isRest = false;
        }
    }

    public void togglePause() {
        if (!isRunning) {
            timer.start();
            isRunning = true;
        } else {
            timer.stop();
            isRunning = false;
        }
    }

    public String getTime() {
        return String.format("%02d:%02d", minutes, seconds);
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isRest() {
        return isRest;
    }

    private void updateTimer() {
        listener.onTimerUpdate(getTime(), isRest);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (seconds == 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--;
        }
        if (minutes == 0 && seconds == 0) {
            listener.timeFinished();
            timer.stop();
            isRunning = false;
            listener.onTimerTypeChage();
            toggleRest();
        }
        updateTimer();
    }
}