package lab1;

import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;
import lab3.visitor38.Visitor;


public interface Transport extends Cloneable {
    /*
     interface ModelAuto{
         void ModelAuto(double p, String n);
         public double getModelPrice() ;
         public void setModelPrice(double modelPrice) ;
         public String getModelName() ;
         public void setModelName(String modelName);
     }
     */
    void accept(Visitor visitor);

    String mark = null;//void setMark(String mark);//поле типа String, хранящее марку автомобиля,

    String getMark();//метод для получения марки автомобиля,

    void setMark(String mark);//метод для модификации марки автомобиля,

    //внутренний класс Модель, имеющий поля название модели и её цену, а также конструктор (класс Автомобиль хранит массив Моделей),
    //  void setModel();
    Object clone() throws CloneNotSupportedException;

    void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException, NoSuchFieldException;//метод для модификации значения названия модели,

    public String[] getModelNameArr();//метод, возвращающий массив названий всех моделей,

    double getPrice(String name) throws NoSuchModelNameException, NoSuchFieldException;//метод для получения значения цены модели по её названию,

    void setPrice(String name, double price);//метод для модификации значения цены модели по её названию,

    double[] getPriceArr();//метод, возвращающий массив значений цен моделей,

    void addModel(String name, double price) throws DuplicateModelNameException, NoSuchFieldException;//метод добавления названия модели и её цены (путем создания нового массива Моделей), использовать метод Arrays.copyOf(),

    void delModel(String name) throws NoSuchModelNameException, NoSuchFieldException;//метод удаления модели с заданным именем и её цены, использовать методы System.arraycopy, Arrays.copyOf(),

    int getSizeModelArr();//метод для получения размера массива Моделей.
}
