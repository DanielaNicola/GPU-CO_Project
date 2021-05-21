package benchmarktest.co.gui;

import benchmarktest.co.entities.MoveSqr;
import benchmarktest.co.utilClasses.PropertyReader;

import java.awt.*;

import static benchmarktest.co.gui.MainWindow.jBasicTable;


class GraphicTestWindow extends javax.swing.JFrame {

    String color,iterations,shape;
    String[][] values={ {"5848","11690","16947","24395","28669"},
            {"5125","10306","15538","20750","25973"},
            {"5899","11791","17652","23428","29455"},
            {"6264","12601","19008","25344","31678"},
            {"6278","12535","18968","25353","25802"},
            {"5740","11742","17783","22085","28669"},
            {"6357","12657","19011","25417","31772"},
            {"6168","12432","18686","24982","31244"},
            {"6266","12635","18933","25403","31765"},
            {"5199","10504","16029","21047","26290"},
            {"6232","12617","18911","25263","31654"},
            {"6198","12565","18892","25192","31539"},
            {"6078","12073","18222","24308","30339"}
    };
    int i;

    private final MoveSqr moveSqrTest = new MoveSqr();


    GraphicTestWindow(String color,String shape, String iterations) {
        super();
        this.color=color;
        this.iterations=iterations;
        this.shape=shape;
        i=(Integer.parseInt(this.iterations)-1);
        moveSqrTest.read(color,shape,iterations);
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

        add(moveSqrTest, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));


        moveSqrTest.moveUpDown();

        for(int k=0;k<13;k++)
        {
            jBasicTable.setValueAt(values[k][i], k, 1);
        }


    }
}
