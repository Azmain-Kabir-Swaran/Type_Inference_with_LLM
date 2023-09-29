import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.SwingWorker;

public class Class_22 {
    JFrame progressFrame;
    JProgressBar progressBar;
    JLabel label = new JLabel("Calculating");
    Container pane;

    double amountSaved = 0;
    int i = 0;
    int iterations;

    public void createGui(int iterations) {
        //Create all components
        progressFrame = new JFrame("Calculation Progress");
        progressFrame.setSize(300, 100);
        pane = progressFrame.getContentPane();
        pane.setLayout(null);
        label = new JLabel("Calculating");
        label.setBounds(115, 35, 200, 25);
        progressBar = new JProgressBar(0, iterations);
        progressBar.setBounds(10, 10, 280, 20);
        progressBar.setStringPainted(true);
        //Add components to pane
        pane.add(progressBar);
        pane.add(label);
        //Make frame visible
        progressFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        progressFrame.setResizable(false); //No resize
        progressFrame.setLocationRelativeTo(null);
        progressFrame.setVisible(true);
    }

    public void runCalcs(double MP, double StepAmt, double L1, double L2,
                         double C1, double C2, double IM1, double IM2, double M1Start, double M2Start) {

        progressBar.setIndeterminate(false);
        TwoWorker task = new TwoWorker(MP, StepAmt, L1, L2, C1, C2, IM1, IM2, M1Start, M2Start);
        task.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("progress".equals(e.getPropertyName())) {
                    progressBar.setIndeterminate(false);
                    progressBar.setValue((Integer) e.getNewValue());
                }
            }
        });
        task.execute();
    }

    public class TwoWorker extends SwingWorker<Double, Double> {

        private final double MP, StepAmt, L1, L2,
                C1, C2, IM1, IM2, M1Start, M2Start;

        public TwoWorker(double MPa, double StepAmta, double L1a, double L2a,
                         double C1a, double C2a, double IM1a, double IM2a, double M1Starta, double M2Starta) {

            MP = MPa;
            StepAmt = StepAmta;
            L1 = L1a;
            L2 = L2a;
            C1 = C1a;
            C2 = C2a;
            IM1 = IM1a;
            IM2 = IM2a;
            M1Start = M1Starta;
            M2Start = M2Starta;
        }
        
        @Override
        protected Double doInBackground() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }
    }
}