package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import core.Task;

public class TaskPanel extends JPanel implements ActionListener {
    private JCheckBox check;
    private JButton deleteBtn;
    
    public TaskPanel(Task task) {
        setBackground(new Color(0x372a51));
        setVisible(true);

        check = new JCheckBox(task.getName());
        check.setBackground(new Color(0x372a51));
        check.setForeground(new Color(0xf5f6df));
        add(check);

        deleteBtn = new JButton("Del");
        deleteBtn.setVisible(false);
        add(deleteBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteBtn) {

        }
    }
}
