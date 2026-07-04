package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.ui.pojo.User;

public class CSVReaderUtility {

    public static Iterator<User> readCSVFile(String filename) 
    {
        System.out.println("CSVReaderUtility");
        File csvfile = new File(System.getProperty("user.dir") + "\\testData\\" + filename);
        FileReader fr = null;
        CSVReader csvReader = null;
        String[] nextLine;
        User userdata;
        List<User> usersList = new ArrayList<>();
        try
        {
            fr = new FileReader(csvfile);
        } 
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read CSV file path: " + csvfile.getAbsolutePath(), e);
        }
        try
        {
            csvReader = new CSVReader(fr);
            csvReader.readNext(); // Skip the header line
            while ((nextLine = csvReader.readNext()) != null)
            {
                System.out.println(Arrays.toString(nextLine));
                userdata = new User();
                //System.out.println("Username: " + nextLine[0] + ", Password: " + nextLine[1]);
                usersList.add(userdata);
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read CSV file content: " + csvfile.getAbsolutePath(), e);
        }
        finally
        {
            try
            {
                if (csvReader != null)
                {
                    csvReader.close();
                }
                if (fr != null)
                {
                    fr.close();
                }
            } 
            catch (Exception e) 
            {
                throw new RuntimeException("Unable to close CSV file: " + csvfile.getAbsolutePath(), e);
            }
        }     
        return usersList.iterator();
    }

    public static void main(String[] args) {
        Iterator<User> users = readCSVFile("logindata.csv");
       /*  for (User user : users) {
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        } */
    }
}
