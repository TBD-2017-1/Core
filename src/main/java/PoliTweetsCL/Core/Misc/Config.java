package PoliTweetsCL.Core.Misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    protected Properties app;

    public Config() {
        loadProperties();
    }

    protected void loadProperties(){
        try{
            app = new Properties();
            FileInputStream file;
            File jarPath=new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParent();
            app.load(new FileInputStream(propertiesPath+ "/appDefault.properties"));
        }catch (Exception e){
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            try(InputStream resourceStream = loader.getResourceAsStream("appDefault.properties")) {
                app.load(resourceStream);
            }catch (Exception ioe){
                ioe.printStackTrace();
            }
        }
    }

    public Properties getPropertiesObj(){return app;}
    public String mongoGet(String property){return app.getProperty("mongo."+property);}
    public String mysqlGet(String property){return app.getProperty("mysql."+property);}
    public String appGet(String property){return app.getProperty("app."+property);}
    public String get(String property){return app.getProperty(property);}



}
