package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
//private static final int MAX_ATTEMPTS1 = (Integer.parseInt(String.valueOf(PropertiesUtil.readProperty(Env.QA,"MAX_ATTEMPTS")))); // Set the maximum number of retries
private static final int MAX_ATTEMPTS = JSONUtility.readJSON(Env.QA).getMAX_ATTEMPTS();
    

private static int currentAttempt = 1; // Track the current attempt count

    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt <= MAX_ATTEMPTS) {
            currentAttempt++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
    }   

}
