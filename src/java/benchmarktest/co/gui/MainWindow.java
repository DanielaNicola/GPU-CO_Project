package benchmarktest.co.gui;

import benchmarktest.co.utilClasses.PropertyReader;

import javax.swing.*;
import java.awt.*;



public class MainWindow extends javax.swing.JFrame {

    public static javax.swing.JTable jBasicTable;

    public static double[][] content;



    public String selectedColor,selectedIterations,selectedShape;

    private javax.swing.JPanel mainPanel;

    private javax.swing.JButton startButton;

    private javax.swing.JScrollPane jScrollPane1;

    public MainWindow() {
        super();
        setTitle("BenchMark Test");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(PropertyReader.ICON_PATH));
        setSize(PropertyReader.MAIN_WINDOW_WIDTH, PropertyReader.MAIN_WINDOW_HEIGHT);
        java.awt.Dimension minimumSizeFrame = new java.awt.Dimension(PropertyReader.MAIN_WINDOW_WIDTH_MIN, PropertyReader.MAIN_WINDOW_HEIGHT_MIN);
        setMinimumSize(minimumSizeFrame);
        setLayout(new GridBagLayout());
        initComponents();
        setVisible(true);
    }


    //Initialization of UI components
    private void initComponents() {
        content = new double[PropertyReader.ARRAY_ROWS][PropertyReader.ARRAY_COLUMNS];
        mainPanel = new javax.swing.JPanel(new GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("BenchMark Test"));
        startButton = new javax.swing.JButton("Start Test");

        jBasicTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane(jBasicTable);


        String[] colors= new String[] {"RED", "BLUE", "GREEN", "YELLOW", "PURPLE", "CYAN", "PINK", "BLACK"};
        String[] shapes= new String[] {"SQUARE","CIRCLE"};
        String[] numbers = new String[] {"1","2","3","4","5"};

        JComboBox<String> comboColor = new JComboBox<String>(colors);
        JComboBox<String> comboShape = new JComboBox<String>(shapes);
        JComboBox<String> comboNumber = new JComboBox<String>(numbers);
        mainPanel.setBackground(Color.pink);
        jBasicTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Anca's computer        NVIDIA GeForce 920M", "Test not run yet"},
                        {"Daniela's computer  Intel(R) UHD Graphics 620", "Test not run yet"},
                        {"Sarah's computer      Intel(R) UHD Graphics 620", "Test not run yet"},
                        {"Silviu's computer       NVIDIA GeForce GTX 1650Ti", "Test not run yet"},
                        {"NVIDIA GeForce GTX 1650", "Test not run yet"},
                        {"AMD Radeon RX 580 ", "Test not run yet"},
                        {"Intel(R) HD Graphics 520", "Test not run yet"},
                        {"NVIDIA GeForce GTX 1660Ti", "Test not run yet"},
                        {"NVIDIA GeForce GTX 1050", "Test not run yet"},
                        {"AMD Radeon R5 graphics", "Test not run yet"},
                        {"AMD Radeon RX 570", "Test not run yet"},
                        {"NVIDIA GeForce GTX 1060", "Test not run yet"},
                        {"Intel(R) HD Graphics Family", "Test not run yet"},
                        {"Tested computer", "Test not run yet"},
                },
                new String[]{"№",  "GRAPHIC TEST(ms)" }
        ));
        jBasicTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jBasicTable);


        add(mainPanel, new GridBagConstraints(0, 0, 2, 1, .07, .1,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(startButton, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 1, 1, .15, .01,
                GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));

        mainPanel.add(comboColor);
        mainPanel.add(comboShape);
        mainPanel.add(comboNumber);

        mainPanel.add(jScrollPane1, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 4, 1, 1.0, 1.01,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                selectedColor=(String)comboColor.getSelectedItem();
                selectedIterations=(String)comboNumber.getSelectedItem();
                selectedShape=(String)comboShape.getSelectedItem();
                GraphicTestWindow startTest = new GraphicTestWindow(selectedColor,selectedShape,selectedIterations);

            }
        });



    }





}
