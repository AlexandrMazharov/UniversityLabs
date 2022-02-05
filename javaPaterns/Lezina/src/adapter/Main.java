package adapter;


import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.IOException;
import java.io.OutputStream;

public class Main {

    public static void main(String args[]) throws NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException, IOException {


        String[] arr = {"string1", "234234234", "32e342432423", "234234234234", "234234234"};
        Adaptee a = new Adapter() ;
        a.w(arr);

    }
}


