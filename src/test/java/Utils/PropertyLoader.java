package test.java.Utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle res = ResourceBundle.getBundle("config");

    public static String getProperty(String name){
        return res.getString(name);
    }
}
