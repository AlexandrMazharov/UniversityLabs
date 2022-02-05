package dao;

import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.IOException;

public interface DAO<Transport> {

//риад
    //write

    Transport readFile(String filename) throws IOException, ClassNotFoundException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException;

    void writeFile(String filename,Transport transport) throws IOException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException;
    //два класса наследника. 1 читает ипишет в текст, 2 в байтовом

//    lab1.Transport readFileS(String fileName) throws IOException, ClassNotFoundException;
    //  lab1.Transport readFileT(String fileName) throws IOException, NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException;

}
