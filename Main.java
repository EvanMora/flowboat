import javax.swing.SwingUtilities;

import gui.MainWindow;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
