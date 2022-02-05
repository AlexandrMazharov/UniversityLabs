package lab3.memento34;

import lab1.Auto;
import lab1.Utils;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DuplicateModelNameException, NoSuchModelNameException, ClassNotFoundException {

        ////////////////Memento 3.4
/*
3.4	Разработка приложения с использованием паттерна Memento
Реализовать паттерн Memento, обеспечивающий сохранение текущего состояния объекта типа Автомобиль. Для этого нужно разработать соответствующий публичный статический внутренний класс, который будет сохранять состояние текущего объекта в сериализованном виде в массив байт (использовать класс ByteArrayOutputStream) и затем считывать сохраненное состояние. Соответствующие методы назвать setAuto() и getAuto(). В классе Автомобиль описать методы createMemento() и setMemento(), которые будут обращаться к соответствующим методам класса Memento. Проверить работу паттерна в методе main().

 */
        Auto carr = new Auto("mark", 5);
        Utils.printCosole(carr);
        carr.createMemento();
        carr.setModelName("1", "model1");
        Utils.printCosole(carr);
        Auto auto = Auto.Memento.getAuto();
        Utils.printCosole(auto);
    }
}
