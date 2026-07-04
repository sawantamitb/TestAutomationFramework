package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

    public static Iterator<User> readExcelFile(String filename) 
    {
        System.out.println("ExcelReaderUtility");
        File excelFile = new File(System.getProperty("user.dir") + "\\testData\\"  + filename);
        XSSFWorkbook workbook= null;
        Row row;
        Cell Username, Password;
        User user;
        List<User> usersList = new ArrayList<>();
        try
        {
            workbook = new XSSFWorkbook(excelFile);
        } 
        catch (InvalidFormatException | IOException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
       
        try
        {
             XSSFSheet sheet = workbook.getSheet("LoginTestData");
             Iterator<Row> rowiterator = sheet.iterator();
             rowiterator.next(); // Skip the header row
             while(rowiterator.hasNext())
            {
                row = rowiterator.next();
                Username = row.getCell(0);
                Password = row.getCell(1);
                System.out.println(Username.getStringCellValue() + "\t"+ Password.getStringCellValue());
                user = new User(Username.getStringCellValue(), Password.getStringCellValue());
                usersList.add(user);           
            }
            return usersList.iterator();           
                     
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read Excel file content: " + excelFile.getAbsolutePath(), e);
        }
        finally
        {
            try
            {
                if (workbook != null)
                {
                    workbook.close();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("Unable to close Excel file: " + excelFile.getAbsolutePath(), e);
            }
        } 
    }

    public static void main(String[] args) {
        Iterator<User> users = readExcelFile("logindata.xlsx");
       /*  while (users.hasNext()) {
            User user = users.next();
            System.out.println("Username: " + user.getUsername() + ", Password: " + user.getPassword());
        } */
    }
}
