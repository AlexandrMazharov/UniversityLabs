package lab3.visitor38;

import lab1.Auto;
import lab1.Moto;

public class Main {
    public static  void main(String args[]) throws NoSuchFieldException {

        //https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D1%81%D0%B5%D1%82%D0%B8%D1%82%D0%B5%D0%BB%D1%8C_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)
        Auto auto = new Auto("mark", 4);
        Moto moto = new Moto("mark", 4);

        Visitor visitor = new PrintVisitor();
        auto.accept(visitor);

        Visitor visitorr = new PrintVisitor();
         moto.accept(visitorr);


    }
}
