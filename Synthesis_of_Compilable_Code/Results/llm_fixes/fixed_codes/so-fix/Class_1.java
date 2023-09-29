package common_JDK;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

@SuppressWarnings("serial")
public class Class_1 {
    private static void createBinaryApplet() throws IOException {
        java.applet.Applet applet = new java.applet.Applet() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.fillRect(0, 0, 10, 10);
            }
        };

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("applet.dat"));
        oos.writeObject(applet);
        oos.close();
    }

    public static void main(String[] args) {
        final java.awt.Frame frame = new java.awt.Frame("Applet Test");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                frame.dispose();
            }
        });

        final int prefHeight = 50;
        final int prefWidth = 50;

        java.awt.Container container = new java.awt.Container() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Graphics2D graphs = (Graphics2D) g;
                graphs.setBackground(Color.WHITE);
                graphs.clearRect(0, 0, prefWidth, prefHeight);
                g.setColor(Color.RED);
                g.fillRect(5, 5, 10, 10);
            }
        };

        container.setPreferredSize(new Dimension(prefWidth, prefHeight));

        frame.add(container);
        frame.pack();
        frame.setVisible(true);

        BufferedImage bufImage = new BufferedImage(prefWidth, prefHeight, BufferedImage.TYPE_INT_RGB);
        container.paint(bufImage.createGraphics());

        try {
            createBinaryApplet();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("applet.dat"));
            java.applet.Applet applet = (java.applet.Applet) ois.readObject();
            ois.close();

            container.add(applet);
            applet.setBounds(0, 0, prefWidth, prefHeight);
            applet.init();

            Graphics g = applet.getGraphics();
            g.drawImage(bufImage, 0, 0, applet);
            applet.paint(g);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Whoops");
        }
    }
}