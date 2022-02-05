package lab3.comand32;

import lab1.Auto;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws NoSuchModelNameException, NoSuchFieldException, DuplicateModelNameException, IOException {
/*
3.2	Разработка приложения с использованием паттерна Command
Реализовать паттерн Command, обеспечивающий вывод полей объекта типа
Автомобиль в текстовый файл в столбик или в одну строку.
Для этого нужно разработать интерфейс Command и два класса-наследника,
каждый из которых осуществляет печать соответствующим образом.
В классе Автомобиль описать метод print(), которому в качестве параметра передавать поток,
куда должна производиться печать. Метод должен обращаться к экземпляру класса, реализующего
интерфейс команды (один из двух классов-наследников). Для задания команды добавить метод
setPrintCommand() у класса Автомобиль.

 */
        //https://dzone.com/articles/design-patterns-command
        Auto myCar = new Auto("mark", 5);
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


        //RemoteControl control = new RemoteControl();
        //Light light = new Light();

        Command pc = new PrintColumn(myCar);
        Command ps = new PrintString(myCar);
        //switch on

        File file = new File("command_column");
        FileWriter fw = new FileWriter(file);
        myCar.setPrintCommand(pc);
        myCar.print(fw);
        fw.flush();
        fw.close();

        File file2 = new File("command_str");
        FileWriter fww = new FileWriter(file2);
        myCar.setPrintCommand(ps);
        myCar.print(fww);
        fww.flush();
        fww.close();


///3


    }
}
