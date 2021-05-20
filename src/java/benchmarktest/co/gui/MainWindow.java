package benchmarktest.co.gui;

import benchmarktest.co.utilClasses.PropertyReader;

import java.awt.*;


  //Class describes the main window UI
public class MainWindow extends javax.swing.JFrame {

      //Table container.
    public static javax.swing.JTable jBasicTable;

      //Table content.
    public static double[][] content;

     // Main window panel
    private javax.swing.JPanel mainPanel;

   // Start test button
    private javax.swing.JButton startButton;


     //Scroll bar
    private javax.swing.JScrollPane jScrollPane1;

     // Default constructor.
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
        jBasicTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {"Tested computer", "NULL"},
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

        mainPanel.add(jScrollPane1, new GridBagConstraints(0, GridBagConstraints.RELATIVE, 4, 1, 1.0, .01,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });



    }


       //Starting test after clicking button
      // param evt mouse click event
     //see java.awt.event.MouseEvent
    private void startButtonMouseClicked(final java.awt.event.MouseEvent evt) {
        GraphicTestWindow startTest = new GraphicTestWindow();
    }


}
