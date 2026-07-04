package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility 
{
    public static String readJSON(Env env) 
    {
        System.out.println("JSONUtility");
        Gson gson = new Gson();
        File jsonFile = resolveConfigFile();
        FileReader fr = null;
        try
        {
            fr = new FileReader(jsonFile);
        } 
        catch (Exception e)
        {
            throw new RuntimeException("Unable to read config file: " + jsonFile.getAbsolutePath(), e);
        }

        try 
        {
            Config config = gson.fromJson(fr, Config.class);
            if (config == null || config.getEnvironments() == null || !config.getEnvironments().containsKey(env.name())) 
            {
                throw new IllegalArgumentException("Environment '" + env + "' was not found in config.json");
            }
            Environment environment = config.getEnvironments().get(env.name());
            return environment.getUrl();
        } catch (Exception e) {
            throw new RuntimeException("Unable to read config file: " + jsonFile.getAbsolutePath(), e);
        }
    }

    public static void main(String[] args) {
        System.out.println(readJSON(Env.QA));
    }

    private static File resolveConfigFile() {
        File currentDir = new File(System.getProperty("user.dir"));
        File configFile = new File(currentDir, "config" + File.separator + "config.json");
        if (!configFile.exists()) {
            throw new IllegalStateException("Config file not found at: " + configFile.getAbsolutePath());
        }
        return configFile;
    }
}
