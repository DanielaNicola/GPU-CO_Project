package benchmarktest.co.gui;

import benchmarktest.co.entities.MoveC;
import benchmarktest.co.utilClasses.PropertyReader;

import java.awt.*;


  //Class describes the graphic test window
class GraphicTestWindow extends javax.swing.JFrame {

    private final MoveC moveCTest = new MoveC();


    GraphicTestWindow() { //constructor
        super();
        setTitle("Test");
        setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(PropertyReader.ICON_PATH));
        setSize(PropertyReader.GRAPHIC_WINDOW_WIDTH, PropertyReader.GRAPHIC_WINDOW_HEIGHT);
        setResizable(false);
        java.awt.Dimension minimumSizeFrame = new java.awt.Dimension(PropertyReader.GRAPHIC_WINDOW_WIDTH, PropertyReader.GRAPHIC_WINDOW_HEIGHT);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();
        setVisible(true);
    }


     //Initialization of components
    private void initComponents() {

        add(moveCTest, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        moveCTest.moveUpDown();

    }
}
