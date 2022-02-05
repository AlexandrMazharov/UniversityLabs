package lab1;

import decorator.Decorator;

public class Utils {

    //среднее арифметическое
    public static double getAverage(Transport transport) {
        int i;
        double summ = 0;
        for (i = 0; i < transport.getSizeModelArr(); i++) {
            summ += transport.getPriceArr()[i];
        }
        return summ / transport.getSizeModelArr();
    }

    public static void printCosole(Transport transport) {
        System.out.println("");
        System.out.println("Марка: " + transport.getMark());
        int k = transport.getSizeModelArr();
        for (int i = 0; i < transport.getSizeModelArr(); i++) {
//            String arr = transport.getModelNameArr()[i];
  //          double arrr = transport.getPriceArr()[i];
            System.out.print("[" + transport.getModelNameArr()[i] + " " + transport.getPriceArr()[i] + "]");
        }

    }


    private static TranportFactory factory = new AutoFactory();

//    public double getAveragePrice(String mark){}

    public static void setFactory(TranportFactory f) {
        factory = f;
    }

    public static Transport createInstance(String name, int suze) throws NoSuchFieldException {
        return factory.createInstance(name, suze);
    }


    public static Transport synchronizedTransport(Transport t) {
return new Decorator(t);
    }


}
