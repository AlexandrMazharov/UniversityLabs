package dao;

import lab1.Transport;
import lab1.Utils;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Text implements DAO{


    @Override
    public Object readFile(String fileName) throws IOException, ClassNotFoundException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException {
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

    @Override
    public void writeFile(String filename, Object t) throws IOException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException {
        Transport transport = (Transport) t;
        FileWriter nFile = new FileWriter(filename);

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



}
