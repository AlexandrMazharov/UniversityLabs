package dao;

import lab1.Transport;
import lab1.Utils;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.*;


public class MainDao {


    public static void main(String args[]) throws IOException, NoSuchModelNameException, NoSuchFieldException, DuplicateModelNameException, ClassNotFoundException {
        String textFileName = "readtext";
        String textFileName2 = "writetext2";
        String objectFileName = "readobject";
        String objectFileName2 = "writeobject2";
        //   Utils.setFactory(Moto::new);
        Transport myCar = Utils.createInstance("mark", 5);
        myCar.setModelName("0", "model0");
        myCar.setPrice("model0", 2000);
        myCar.setModelName("1", "model1");
        myCar.setPrice("model1", 1000);
        myCar.setModelName("2", "model2");
        myCar.setPrice("model2", 2000);
        myCar.setModelName("3", "model3");
        myCar.setPrice("model3", 2000);
        myCar.setModelName("4", "model4");
        myCar.setPrice("model4", 2000);

        Byte dao = new Byte();
        dao.writeFile(objectFileName,myCar);
        Transport transport = (Transport) dao.readFile(objectFileName);
        Utils.printCosole(transport);
        //dao.writeFile(objectFileName2,myCar);

        Text dao2 = new Text();
        dao2.writeFile(textFileName2,myCar);
        Transport transport1 = (Transport) dao2.readFile(textFileName2);
        Utils.printCosole(transport1);


        /*

        Transport transport = (Transport) dao.readFile(objectFileName);


        FileOutputStream fos = new FileOutputStream(objectFileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(myCar);
        oos.flush();
        oos.close();

        FileWriter nFile = new FileWriter(textFileName);
        nFile.close();

        writeFile(myCar, textFileName);

        Byte dao = new Byte();
        Transport transport = (Transport) dao.readFile(objectFileName);
        Utils.printCosole(transport);

        Transport transport1 = (Transport) dao.readFile(textFileName);
        Utils.printCosole(transport1);


         */
    }
/*
    public static void writeFile(Transport transport, String fileName) throws IOException, NoSuchFieldException, NoSuchModelNameException {
        FileWriter nFile = new FileWriter(fileName);

        nFile.write(transport.getMark() + "\n");
        nFile.write(transport.getSizeModelArr() + "\n");
        //int s=transport.getSizeModelArr();
        String[] modelarr = transport.getModelNameArr();
        for (int i = 0; i < transport.getSizeModelArr(); i++) {
            nFile.write(modelarr[i] + "\n");
            nFile.write(String.valueOf(transport.getPrice(modelarr[i])) + "\n");

        }
        nFile.close();
    }

 */


}


