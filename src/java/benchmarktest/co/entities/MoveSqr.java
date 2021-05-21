package benchmarktest.co.entities;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import static benchmarktest.co.gui.MainWindow.jBasicTable;


// Implementation of GPU test
public final class MoveSqr extends javax.swing.JPanel implements java.awt.event.ActionListener {
    private int i = 0;

    //Speed square relocation
    private int speedByYAxis = 10;

    // Position of square by Y Axis
    private int yPosition = 10;

    private String color;
    private String iterations;
    private String shape;

    public void read(String color,String shape, String iterations)
    {
        this.color=color;
        this.iterations=iterations;
        this.shape=shape;
    }

    //Timer
    private javax.swing.Timer timer = new javax.swing.Timer(50, this);

    // Total time value

    private long timeout = System.currentTimeMillis();

    @Override
    public void paintComponent(final java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D square= new Rectangle2D.Double(610, yPosition, 2, 2);
        Ellipse2D circle= new Ellipse2D.Double(610, yPosition, 2, 2);;
        switch (shape)
        {
            case "SQUARE":
                square= new Rectangle2D.Double(245, yPosition, 90, 90);
                break;
            case "CIRCLE":
                circle= new Ellipse2D.Double(245, yPosition, 90, 90);
                break;
            default:
                break;
        }
        switch(color) {
            case "RED":
                g2d.setColor(new java.awt.Color(255,0,0));
                break;
            case "BLUE":
                g2d.setColor(new java.awt.Color(0,0,255));
                break;
            case "GREEN":
                g2d.setColor(new java.awt.Color(0,255,0));
                break;
            case "YELLOW":
                g2d.setColor(new java.awt.Color(255, 255, 0));
                break;
            case "PURPLE":
                g2d.setColor(new java.awt.Color(149,0, 255));
                break;
            case "CYAN":
                g2d.setColor(new java.awt.Color(0, 255, 255));
                break;
            case "PINK":
                g2d.setColor(new java.awt.Color(255, 156, 238, 205));
                break;
            case "BLACK":
                g2d.setColor(new java.awt.Color(0,0,0));
                break;
            default:
                break;
            // code block
        }
        switch (shape)
        {
            case "SQUARE":

                g2d.fill(square);
                break;
            case "CIRCLE":

                g2d.fill(circle);
                break;
            default:
                break;
        }

        g2d.fill(square);
        timer.start();
    }


    //Move square 4 times
    public void moveUpDown() {
        this.setVisible(true);
        actionPerformed(null);
    }

    @Override
    public void actionPerformed(final java.awt.event.ActionEvent e) {
        int iterator =Integer.parseInt(iterations)*2;
        if (yPosition < 0 || yPosition > 490)
            speedByYAxis = -speedByYAxis;
        yPosition += speedByYAxis;
        if (yPosition == 0)
            i++;
        repaint();
        if (i == iterator) {
            timer.stop();
            timeout = System.currentTimeMillis() - timeout;
            jBasicTable.setValueAt(getTimeout(), 13, 1);

            setVisible(false);

        }
    }

    //Get timeout
    // return time in milliseconds
    private long getTimeout() {
        return timeout;
    }


}