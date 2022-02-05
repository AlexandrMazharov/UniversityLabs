package lab1;

import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;


import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String args[]) throws NoSuchFieldException, DuplicateModelNameException, NoSuchModelNameException, CloneNotSupportedException, IOException, ClassNotFoundException {
/*
        Singletone s = Singletone.getInstance();
        Singletone s2 = Singletone.getInstance();
        //   Utils.setFactory(Moto::new);
        Transport myCar = Utils.createInstance("mark", 5);


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

        System.out.println();
        Utils.printCosole(myCar);

        myCar.addModel("model5", 3000);
        myCar.setModelName("model2", "model22");

        System.out.println();
        Utils.printCosole(myCar);

        myCar.delModel("model4");

        // myCar.setModelName("model2", "model4");//exeption.DuplicateModelNameException;//+метод для модификации значения названия модели, ???
        //myCar.setModelName("f", "fgfg");//NoSuchModelNameException

        Utils.printCosole(myCar);
        System.out.println();
        System.out.println("Средняя цена: " + Utils.getAverage(myCar));

        Utils.setFactory(Moto::new);
        Transport t = (Transport) myCar.clone();
        t.setModelName("model22", "mooooodel");
        t.delModel("model0");
        Utils.printCosole(myCar);
        Utils.printCosole(t);

        System.out.println();
        Transport[] tr = {new Auto("m", 4), new Moto("m", 2)};

        TranportFactory[] tranportFactories = {new AutoFactory(), new MotoFactory()};
        // iterate over creators and create products
        for (TranportFactory factory : tranportFactories) {
            Transport product = factory.createInstance("m", 3);
            System.out.printf("Created {%s}\n", product.getClass());
        }


 */
///3.3 https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm

        Auto car = new Auto("mark", 5);
        car.setModelName("0", "model0");
        car.setPrice("model0", 2000);
        car.setModelName("1", "model1");
        car.setPrice("model1", 1000);
        car.setModelName("2", "model2");
        car.setPrice("model2", 2000);
        car.setModelName("3", "model3");
        car.setPrice("model3", 2000);
        car.setModelName("4", "model4");
        car.setPrice("model4", 2000);

        for (Iterator iter = car.getIterator(); iter.hasNext(); ) {
            Auto.ModelAuto auto = (Auto.ModelAuto) iter.next();
            System.out.println(auto.toString());
        }


    }
}



