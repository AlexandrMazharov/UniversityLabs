package lab3.сhainOfResponsibility31;

import lab1.Transport;

import java.io.FileWriter;
import java.io.IOException;

public class Writer1 implements ChainOfResponsibility {
    private ChainOfResponsibility chain;
    @Override
    public void write(Transport transport) throws IOException {
        if (transport.getSizeModelArr() < 3) {
            FileWriter fw = new FileWriter("сhainOfResponsibility1_Column.txt");
            fw.write(transport.getMark()+"\n");
            fw.write(String.valueOf(transport.getSizeModelArr())+"\n");
            for (int i = 0; i < transport.getSizeModelArr(); i++) {
                fw.write( transport.getModelNameArr()[i] + " " + transport.getPriceArr()[i] + "\n");
            }
            /*
            System.out.println("<3");
            System.out.print(transport.getMark());
            for(int i=0;i<transport.getSizeModelArr();i++){
                System.out.print("[" + transport.getModelNameArr()[i] + " " + transport.getPriceArr()[i] + "]");
            }

             */
        }
        else {
            this.chain.write(transport);
        }
    }


    @Override
    public void setNext(ChainOfResponsibility nextChain) {
        this.chain = nextChain;
    }


}
