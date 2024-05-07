package library;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    public static String getTestdata(String property) {

    	String path = new File("properties/testdata.properties").getAbsolutePath();
    	String val = null;
    	Properties prop = new Properties();
    	
        try (InputStream input = new FileInputStream(path)) {
            prop.load(input);
            val = prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return val;
    }  
    
    public static String getConfig(String property) {

    	String path = new File("properties/config.properties").getAbsolutePath();
    	String val = null;
    	Properties prop = new Properties();
    	
        try (InputStream input = new FileInputStream(path)) {
            prop.load(input);
            val = prop.getProperty(property);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return val;
    }  
    
}