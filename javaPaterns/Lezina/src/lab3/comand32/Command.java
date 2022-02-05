package lab3.comand32;

import lab1.Auto;

import java.io.FileWriter;
import java.io.IOException;

public interface Command {


    void print(FileWriter fw, Auto auto) throws IOException;
}
