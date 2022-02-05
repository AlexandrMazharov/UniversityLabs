package lab3.сhainOfResponsibility31;

import lab1.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class Writer2 implements ChainOfResponsibility {
    private ChainOfResponsibility chain;

    @Override
    public void write(Transport transport) throws IOException {
        FileWriter fw = new FileWriter("сhainOfResponsibility1_String.txt");
        System.out.println(">3");
        System.out.println(transport.getMark());
        fw.write(transport.getMark()+" ");
        fw.write(String.valueOf(transport.getSizeModelArr())+" ");
        for (int i = 0; i < transport.getSizeModelArr(); i++) {
            fw.write("[" + transport.getModelNameArr()[i] + " " + transport.getPriceArr()[i] + "]");
        }
        /*
        for (int i = 0; i < transport.getSizeModelArr(); i++) {
            //String arr = transport.getModelNameArr()[i];
            //double arrr = transport.getPriceArr()[i];
            System.out.println("[" + transport.getModelNameArr()[i] + " " + transport.getPriceArr()[i] + "]");

        }

         */
    }

    @Override
    public void setNext(ChainOfResponsibility chain) {
        this.chain = chain;
    }


}
