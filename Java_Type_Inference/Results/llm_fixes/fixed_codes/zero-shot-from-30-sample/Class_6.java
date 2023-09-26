import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import common_JDK.Model;
import common_JDK.View;
import common_JDK.Control;

class Class_6 implements Runnable {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Class_6());
    }

    @Override
    public void run() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class MainPanel extends JPanel {

    public MainPanel() {
        super(new BorderLayout());
        common_JDK.Model model = new common_JDK.Model();
        common_JDK.View view = new common_JDK.View(model);
        common_JDK.Control control = new common_JDK.Control(model, view);
        JLabel label = new JLabel("Guess what color!", JLabel.CENTER);
        this.add(label, BorderLayout.NORTH);
        this.add(view, BorderLayout.CENTER);
        this.add(control, BorderLayout.SOUTH);
    }
}