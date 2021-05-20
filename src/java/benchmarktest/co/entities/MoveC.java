package benchmarktest.co.entities;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import static benchmarktest.co.gui.MainWindow.jBasicTable;


 // Implementation of GPU test
public final class MoveC extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private int i = 0;

     //Speed circle relocation
    private int speedByYAxis = 10;

     // Position of circle by Y Axis
    private int yPosition = 10;

      //Timer
    private javax.swing.Timer timer = new javax.swing.Timer(50, this);

     // Total time value

    private long timeout = System.currentTimeMillis();

    @Override
    public void paintComponent(final java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(180, yPosition, 90, 90);
        g2d.setColor(new java.awt.Color(2, 98, 241));
        g2d.fill(circle);
        timer.start();
    }


      //Move square 4 times
    public void moveUpDown() {
        this.setVisible(true);
        actionPerformed(null);
    }

    @Override
    public void actionPerformed(final java.awt.event.ActionEvent e) {
        int iterator = 2;
        if (yPosition < 0 || yPosition > 490)
            speedByYAxis = -speedByYAxis;
        yPosition += speedByYAxis;
        if (yPosition == 0)
            i++;
        repaint();
        if (i == iterator) {
            timer.stop();
            timeout = System.currentTimeMillis() - timeout;
            jBasicTable.setValueAt(getTimeout(), 0, 1);

            setVisible(false);

        }
    }

      //Get timeout
     // return time in milliseconds
    private long getTimeout() {
        return timeout;
    }


}