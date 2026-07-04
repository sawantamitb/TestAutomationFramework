package com.ui.dataproviders;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginDataProvider {

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider() 
    {
        Gson gson = new Gson();
        File testDataFile = new File(System.getProperty("user.dir") + "\\testData\\logindata.json");
        FileReader fileReader = null;
        try 
        {
            fileReader = new FileReader(testDataFile);
        } catch (Exception e) 
        {
            throw new RuntimeException("Unable to read test data file: " + testDataFile.getAbsolutePath(), e);
        }
        try  
        {
            TestData testData = gson.fromJson(fileReader, TestData.class);
            List<Object[]> dataToReturn = new ArrayList<Object[]>();
            if (testData != null && testData.getData() != null) {
                for (User user : testData.getData()) {
                    dataToReturn.add(new Object[] { user });
                }
            }
            return dataToReturn.iterator();
        } catch (Exception e) {
            throw new RuntimeException("Unable to read test data file: " + testDataFile.getAbsolutePath(), e);
        }
    }
}
