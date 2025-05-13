package gui;

import java.awt.Color;
// import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import core.Task;

public class TaskPanel extends JPanel {
    JCheckBox check;
    
    public TaskPanel(Task task) {
        setBackground(new Color(0x372a51));
        // setSize(300, 40);
        // setLayout(new FlowLayout());
        setVisible(true);

        check = new JCheckBox(task.getName());
        check.setBackground(new Color(0x372a51));
        check.setForeground(new Color(0xf5f6df));
        add(check);
    }
}
