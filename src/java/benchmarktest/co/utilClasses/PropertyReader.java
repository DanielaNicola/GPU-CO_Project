package benchmarktest.co.utilClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


//PropertyReader is a  class for reading information from .property file
public final class PropertyReader {
    //Property file location
    private static final String PROPERTIES_FILE = "src\\resources\\property\\config.properties";
    private static PropertyReader instance;

    public static final int MAIN_WINDOW_WIDTH = Integer.parseInt(getInstance().
            properties.getProperty("main-window-width"));

    public static final int MAIN_WINDOW_HEIGHT = Integer.parseInt(getInstance().
            properties.getProperty("main-window-height"));

    public static final int MAIN_WINDOW_WIDTH_MIN = Integer.parseInt(getInstance().
            properties.getProperty("main-window-width-min"));

    public static final int MAIN_WINDOW_HEIGHT_MIN = Integer.parseInt(getInstance().
            properties.getProperty("main-window-height-min"));

    public static final int GRAPHIC_WINDOW_WIDTH = Integer.parseInt(getInstance().
            properties.getProperty("graphic-window-width"));

    public static final int GRAPHIC_WINDOW_HEIGHT = Integer.parseInt(getInstance().
            properties.getProperty("graphic-window-height"));

    public static final String ICON_PATH = getInstance().
            properties.getProperty("icon-path");

    // Store number of the array rows
    public static final int ARRAY_ROWS = Integer.parseInt(getInstance().
            properties.getProperty("array-rows"));

    //Store number of array columns
    public static final int ARRAY_COLUMNS = Integer.parseInt(getInstance().
            properties.getProperty("array-columns"));

    private Properties properties;


    // load .properties file
    private PropertyReader() {
        properties = new Properties();
        FileInputStream propertiesFile = null;
        try {
            propertiesFile = new FileInputStream(PROPERTIES_FILE);
            properties.load(propertiesFile);
        } catch (FileNotFoundException ex) {
            System.err.println("Properties config file not found");
        } catch (IOException ex) {
            System.err.println("Error while reading file");
        } finally {
            try {
                assert propertiesFile != null;
                propertiesFile.close();
            } catch (NullPointerException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    private static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }
}
