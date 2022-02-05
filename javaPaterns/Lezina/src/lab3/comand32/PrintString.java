package lab3.comand32;

import lab1.Auto;

import java.io.FileWriter;
import java.io.IOException;

public class PrintString implements Command {
    private Auto auto;

    public PrintString(Auto a) {
        this.auto = a;
    }


    @Override
    public void print(FileWriter fw, Auto auto) throws IOException {
        fw.write(auto.getMark()+" ");
        fw.write(String.valueOf(auto.getSizeModelArr())+" ");
        for (int i = 0; i < auto.getSizeModelArr(); i++) {
            fw.write("[" + auto.getModelNameArr()[i] + " " + auto.getPriceArr()[i] + "]");
        }

    }
}
