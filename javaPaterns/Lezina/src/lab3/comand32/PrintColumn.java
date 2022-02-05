package lab3.comand32;

import lab1.Auto;

import java.io.FileWriter;
import java.io.IOException;

public class PrintColumn implements Command {

  private   Auto auto;



    public  PrintColumn(Auto a ){
        this.auto = a;
    }

    @Override
    public void print(FileWriter fw, Auto auto) throws IOException {
        fw.write(auto.getMark()+"\n");
        fw.write(String.valueOf(auto.getSizeModelArr())+"\n");
        for (int i = 0; i < auto.getSizeModelArr(); i++) {
            fw.write( auto.getModelNameArr()[i] + " " + auto.getPriceArr()[i] + "\n");
        }

    }
}
