package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataLoad {

    public static String dataLoad(String data) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\User\\IdeaProjects\\Angular Flutter\\src\\main\\resources\\Data.properties");
        prop.load(fis);
        return prop.getProperty(data);
    }
}
