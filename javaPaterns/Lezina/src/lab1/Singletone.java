package lab1;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.*;

public class Singletone {
    private  static Singletone instanse;

    public void myProperty() throws IOException {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            //C:\Users\Alexander\Desktop\testTask\Lezina\src\lab1\resources
            //FileInputStream fstream = new FileInputStream("C:\\Users\\Alexander\\IdeaProjects\\Lezina\\src\\lab1\\resources\\config.properties");
            FileInputStream fstream = new FileInputStream(
                    "C:\\Users\\Alexander\\Desktop\\testTask\\Lezina\\src\\lab1\\resources\\config.properties");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Singletone() throws IOException {
        myProperty();
    }

    public synchronized static Singletone getInstance() throws IOException {
        if (instanse == null) {
            instanse = new Singletone();
        }
        return instanse;
    }
}
