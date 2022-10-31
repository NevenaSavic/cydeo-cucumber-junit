package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties(); //pravimo objekat od properties class

    static {  //to run our logic before everything else


        try {

            //we need to open the file in java memory: fileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //load the properties object using FileInputStream
            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }

    }

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }











}
