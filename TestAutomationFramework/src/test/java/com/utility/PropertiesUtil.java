package com.utility;

import java.io.File;
import java.io.File.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

import java.io.FileNotFoundException;

public class PropertiesUtil {
// read the properties file

/* public static void main(String[] args)
{
    try {
        String value = readProperty(Env.QA, "URL");
        System.out.println("Value for the given key is: " + value);
    } catch (IOException e) {
        System.out.println("Error reading properties file: " + e.getMessage());
    }
} */


public static String readProperty(Env env, String propertyName) {
    // code to read the properties file and return the value for the given key
    System.out.println(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
    File propfile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
    FileReader fr = null;
    Properties prop = new Properties();
    try
    {
        fr = new FileReader(propfile);
        prop.load(fr);  

    }
   catch (FileNotFoundException e) {
        System.out.println("Properties file not found: " + e.getMessage());    }
     catch (IOException e) {
        System.out.println("Error reading properties file: " + e.getMessage());    }
    
    String value = prop.getProperty(propertyName);
    System.out.println("Value for the given key is: " + value);
    return value;
    
}
}
