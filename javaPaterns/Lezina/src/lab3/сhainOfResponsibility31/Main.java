package lab3.сhainOfResponsibility31;

import lab1.Transport;
import lab1.Utils;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;

import java.io.IOException;

public class Main {

    public static void main(String args[]) throws NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException, IOException {
/*https://javarush.ru/groups/posts/584-patternih-proektirovanija
https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
Описание:
        Позволяет избежать жесткой зависимости отправителя запроса от его получателя,
         при этом запрос может быть обработан несколькими объектами.
 */
/*
Реализовать паттерн Chain of Responsibility, обеспечивающий вывод полей
объекта типа Transport в текстовый файл в столбик или в одну строку.
Для этого нужно разработать интерфейс Chain of Responsibility и два класса-наследника,
каждый из которых осуществляет вывод соответствующим образом. В интерфейсе должен быть описан метод записи,
в качестве параметра принимающий Транспортное средство, а также метод установки следующего в цепочке.
Первая реализация этого интерфейса в цепочке выводит информацию в одну строку, если количество моделей
меньше или равно 3. Вторая реализация в цепочке выводит информацию в столбик, если количество моделей больше 3.
Проверить работу паттерна в методе main().

 */

        Transport myCar = Utils.createInstance("mark", 5);
        Transport myCar2 = Utils.createInstance("mark", 2);

        ChainOfResponsibility chain = new Writer1();
        ChainOfResponsibility payPalPayment = new Writer2();
        chain.setNext(payPalPayment);
        chain.write(myCar);

        ChainOfResponsibility chain1 = new Writer1();
        ChainOfResponsibility payPalPayment2 = new Writer2();
        chain1.setNext(payPalPayment2);
        chain.write(myCar2);


    }
}

