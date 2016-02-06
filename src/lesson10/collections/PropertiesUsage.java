package lesson10.collections;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUsage {

    public static void main(String[] args) {
//        Reading properties(key-value pairs) from properties file
        Properties properties = new Properties();
        File file = new File("/home/temo/IdeaProjects/YakovFain/src/lesson10/collections/mailman.properties");
        try (FileInputStream in = new FileInputStream(file)) {
            properties.load(in);
        } catch (Exception e) {
            e.getMessage();
        }
        String from = properties.getProperty("from");
        String mailServer = properties.getProperty("SmtpServer");
        System.out.println(from);
        System.out.println(mailServer);

//For current application you can set properties by:
//        System.setProperties(properties);
//        System.out.println(System.getProperties());


//Reading properties(key-value pairs) from xml file
        Properties properties2 = new Properties();
        File file2 = new File("/home/temo/IdeaProjects/YakovFain/src/lesson10/collections/mailman.xml");
        try (FileInputStream in = new FileInputStream(file2)) {
            properties2.loadFromXML(in);
        } catch (Exception e) {
            e.getMessage();
        }
        String google = properties2.getProperty("google");
        System.out.println(google);
    }
}
