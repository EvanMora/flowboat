package gui;

import java.awt.Color;

import javax.swing.JFrame;

public class MainWindow extends JFrame {

    final private PomodoroPanel pomodoroPanel;
    final private TasksListPanel tasksPanel;

    final int width = 300;
    final int height = 450;
    final Color bgColor = new Color(0x372a51);

    public MainWindow() {

        // Set up
        setTitle("Flow Boat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height + 36);
        setLayout(null);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
        
        pomodoroPanel = new PomodoroPanel(width, height, bgColor);
        add(pomodoroPanel);
        
        tasksPanel = new TasksListPanel(width, height, bgColor);
        add(tasksPanel);
    } 
}