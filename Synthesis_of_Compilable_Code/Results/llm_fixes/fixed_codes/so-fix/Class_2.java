import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class Class_2 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            public void run() {
                final JFrame frame = new JFrame("Nested Layout Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JPanel gui = new JPanel(new BorderLayout(5,5));
                gui.setBorder( new TitledBorder("BorderLayout(5,5)") );

                JPanel plafComponents = new JPanel(
                        new FlowLayout(FlowLayout.RIGHT, 3,3));
                plafComponents.setBorder(
                        new TitledBorder("FlowLayout(FlowLayout.RIGHT, 3,3)") );

                final UIManager.LookAndFeelInfo[] plafInfos =
                        UIManager.getInstalledLookAndFeels();
                String[] plafNames = new String[plafInfos.length];
                for (int ii=0; ii<plafInfos.length; ii++) {
                    plafNames[ii] = plafInfos[ii].getName();
                }
                final JComboBox<String> plafChooser = new JComboBox<String>(plafNames);
                plafComponents.add(plafChooser);

                final JCheckBox pack = new JCheckBox("Pack on PLAF change", true);
                plafComponents.add(pack);

                plafChooser.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        int index = plafChooser.getSelectedIndex();
                        try {
                            UIManager.setLookAndFeel(
                                    plafInfos[index].getClassName() );
                            SwingUtilities.updateComponentTreeUI(frame);
                            if (pack.isSelected()) {
                                frame.pack();
                                frame.setMinimumSize(frame.getSize());
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                } );

                gui.add(plafComponents, BorderLayout.NORTH);

                JPanel dynamicLabels = new JPanel(new BorderLayout(4,4));
                dynamicLabels.setBorder(
                        new TitledBorder("BorderLayout(4,4)") );
                gui.add(dynamicLabels, BorderLayout.WEST);

                final JPanel labels = new JPanel(new GridLayout(0,2,3,3));
                labels.setBorder(
                        new TitledBorder("GridLayout(0,2,3,3)") );

                JButton addNew = new JButton("Add Another Label");
                dynamicLabels.add( addNew, BorderLayout.NORTH );
                addNew.addActionListener( new ActionListener(){

                    private int labelCount = 0;

                    public void actionPerformed(ActionEvent ae) {
                        labels.add( new JLabel("Label " + ++labelCount) );
                        frame.validate();
                    }
                } );

                dynamicLabels.add( new JScrollPane(labels), BorderLayout.CENTER );

                String[] header = {"Name", "Value"};
                String[] a = new String[0];
                Properties properties = System.getProperties();
                String[] names = properties.stringPropertyNames().toArray(a);
                String[][] data = new String[names.length][2];
                for (int ii=0; ii<names.length; ii++) {
                    data[ii][0] = names[ii];
                    data[ii][1] = properties.getProperty(names[ii]);
                }
                DefaultTableModel model = new DefaultTableModel(data, header);
                JTable table = new JTable(model);
                try {
                    // 1.6+
                    table.setAutoCreateRowSorter(true);
                } catch(Exception continuewithNoSort) {
                }
            }
        };
    }
}