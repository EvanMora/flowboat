package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import core.Task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TasksListPanel extends JPanel implements ActionListener {

    final private JLabel title;
    final private JButton addBtn;
    final private JPanel tasksContainer;
    final private JScrollPane taskListPanel;
    final private JPanel input;
    final private JTextField entry;
    final private JButton okBtn;
    final Color fgColor = new Color(0xf5f6df);
    Font font = new Font("consolas", Font.PLAIN, 26);

    public TasksListPanel(int width,int height, Color bgColor) {
        // Setup
        setBounds(0, height / 3 , width, (height / 3) * 2);
        setLayout(new BorderLayout());
        setBackground(bgColor);
        setVisible(true);

        // Title: Label
        title = new JLabel("Tasks");
        title.setForeground(fgColor);
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);
        
        // Panel: Were you will find the list of task
        tasksContainer = new JPanel();
        tasksContainer.setLayout(new BoxLayout(tasksContainer, BoxLayout.Y_AXIS));
        tasksContainer.setBackground(bgColor);
        tasksContainer.setVisible(true);

        taskListPanel = new JScrollPane(tasksContainer);
        taskListPanel.setVisible(true);
        add(taskListPanel, BorderLayout.CENTER);
        
        // Footer for add a task
        addBtn = new JButton("Add");
        addBtn.addActionListener(this);
        addBtn.setVisible(true);
        add(addBtn, BorderLayout.SOUTH);

        input = new JPanel();
        input.setVisible(true);

        entry = new JTextField(19);
        input.add(entry);

        okBtn = new JButton("Ok");
        okBtn.addActionListener(this);
        input.add(okBtn);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            remove(addBtn);
            add(input, BorderLayout.SOUTH);
        } else if (e.getSource() == okBtn) {
            if (!entry.getText().equals("")) {
                tasksContainer.add((new TaskPanel(new Task(entry.getText()))));
                entry.setText("");
            }
            remove(input);
            add(addBtn, BorderLayout.SOUTH);
        }
        repaint();
    }
}