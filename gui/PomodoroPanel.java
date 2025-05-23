package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.PomodoroTimer;
import core.TimerUpdateListener;

public class PomodoroPanel extends JPanel implements ActionListener, TimerUpdateListener {

    private final PomodoroTimer timer;
    private final JLabel typeLabel;
    private final JLabel pomodoroLabel;
    private final JButton startBtn;
    private final JButton resetBtn;

    private final Font textFont;
    private final Font timerFont;
    final Color fgColor = new Color(0xf5f6df);
    final Color btnColor = new Color(0x5a8f78);

    public PomodoroPanel(int width, int height, Color bgColor) {
        setBackground(bgColor);
        setBounds(0, 0, width, height / 3);
        setLayout(new GridLayout(3, 1));
        setVisible(true);

        textFont = new Font("consolas", Font.PLAIN, 24);
        timerFont = new Font("Consolas", Font.BOLD, 30);

        typeLabel = new JLabel();
        typeLabel.setFont(textFont);
        typeLabel.setForeground(fgColor);
        typeLabel.setHorizontalAlignment(JLabel.CENTER);
        add(typeLabel);

        pomodoroLabel = new JLabel();
        pomodoroLabel.setFont(timerFont);
        pomodoroLabel.setForeground(fgColor);
        pomodoroLabel.setHorizontalAlignment(JLabel.CENTER);
        add(pomodoroLabel);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.setVisible(true);
        add(btnPanel);

        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(this);
        resetBtn.setEnabled(false);
        btnPanel.add(resetBtn);

        startBtn = new JButton("Start");
        startBtn.addActionListener(this);
        btnPanel.add(startBtn);

        timer = new PomodoroTimer(1,5, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            timer.togglePause();
            if (timer.isRunning()) {
                resetBtn.setEnabled(false);
                startBtn.setText("Pause");
            } else if (!timer.isRunning()) {
                resetBtn.setEnabled(true);
                startBtn.setText("Start"); 
            }
        } else if (e.getSource() == resetBtn) {
            timer.resetTime();
        }
    }

    @Override
    public void onTimerUpdate(String time, boolean isRest) {
        pomodoroLabel.setText(time);
        if (isRest)
            typeLabel.setText("Rest");
        else 
            typeLabel.setText("Productivity");
        
    }

    @Override
    public void onTimerTypeChage() {
        startBtn.setText("Start");
    }

    @Override
    public void timeFinished() {
        Toolkit.getDefaultToolkit().beep();
    }
}