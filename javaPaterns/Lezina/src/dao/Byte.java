package dao;

import lab1.Transport;
import lab1.Utils;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.*;

public class Byte implements DAO {
    @Override
    public Object readFile(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));

        lab1.Transport t = (Transport) ois.readObject();
        return t;

    }

    @Override
    public void writeFile(String fileName, Object o) throws IOException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

        lab1.Transport t = (Transport) o;
        oos.writeObject(t);
        oos.flush();
        oos.close();
      //  FileReader reader = new FileReader(fileName);
        //BufferedReader bf = new BufferedReader(reader);
/*
        //Transport myCar = Utils.createInstance("mark", 5);
        String mark = bf.readLine();
        String size = bf.readLine();
        Transport myCar = Utils.createInstance(mark, Integer.parseInt(size));
        int i = 0;
        while (i < Integer.valueOf(size)) {
            String model = bf.readLine();
            String price = bf.readLine();
            myCar.setModelName((String.valueOf(i)), model);
            myCar.setPrice(model, Double.parseDouble(price));
            i++;
        }

 */
    }


}
    /*
    @Override
    public Transport readFileS(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

        lab1.Transport t = (Transport) ois.readObject();
        return t;
    }


     */
    /*
    @Override
    public Transport readFileT(String fileName) throws IOException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException {
        FileReader reader = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(reader);
        //Transport myCar = Utils.createInstance("mark", 5);
        String mark = bf.readLine();
        String size = bf.readLine();
        Transport myCar = Utils.createInstance(mark, Integer.parseInt(size));
        int  i = 0;
        while (i< Integer.valueOf(size) ) {
            String model = bf.readLine();
            String price = bf.readLine();
            myCar.setModelName((String.valueOf(i)), model);
            myCar.setPrice(model, Double.parseDouble(price));
            i++;
        }
        return myCar;
    }

     */

