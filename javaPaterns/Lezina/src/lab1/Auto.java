package lab1;

import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.ModelPriceOutOfBoundsException;
import lab1.exeption.NoSuchModelNameException;

import lab3.comand32.Command;
import lab3.visitor38.PrintVisitor;
import lab3.visitor38.Visitor;


import java.io.*;
import java.util.Arrays;

public class Auto implements Transport, Cloneable, Serializable {
    private String autoMark;
    private ModelAuto[] modelArr;

    @Override
    public void accept(Visitor visitor) {
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(this);
    }

    ////Memento
    public static class Memento {
        private static byte[] state;

        public static void setAuto(Auto auto) throws IOException {
            try (ByteArrayOutputStream b = new ByteArrayOutputStream()) {
                try (ObjectOutputStream o = new ObjectOutputStream(b)) {
                    o.writeObject(auto);
                }
                state = b.toByteArray();
            }
        }

        public static Auto getAuto() throws IOException, ClassNotFoundException {
            try (ByteArrayInputStream b = new ByteArrayInputStream(state)) {
                try (ObjectInputStream o = new ObjectInputStream(b)) {
                    Auto a = (Auto) o.readObject();
                    return a;
                }
            }
        }

    }

    public void setMemento() throws IOException, ClassNotFoundException {
        Memento.getAuto();
    }

    public void createMemento() throws IOException {
        Memento.setAuto(this);
    }

    /////


    public void setMark(String am, int k) {
        this.autoMark = am;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        Auto result = (Auto) super.clone();
        result.modelArr = modelArr.clone();
        for (int i = 0; i < this.modelArr.length; i++) {
            result.modelArr[i] = (ModelAuto) modelArr[i].clone();
        }
        return result;

    }


    public Auto(String mark, Integer k) {
        this.autoMark = mark;
        this.modelArr = new ModelAuto[k];
        for (int i = 0; i < modelArr.length; i++) {
            ModelAuto ma = new ModelAuto(Integer.toString(i), 0);
            this.modelArr[i] = ma;

        }
    }


    //3.3
    public java.util.Iterator<Auto> getIterator() {
        return new AutoIterator();

    }


    //3.3
    private class AutoIterator implements java.util.Iterator {
       // Auto[] autoList;
        int pos = 0;

        public AutoIterator() {

        }

        @Override
        public boolean hasNext() {
            if (pos < modelArr.length)
                return true;
            else return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) return modelArr[pos++];

            return null;
        }
    }

    protected static class ModelAuto implements Cloneable, Serializable {
        private String modelName;
        private double modelPrice;

        //3.3
        @Override
        public String toString() {
            return "ModelAuto{" +
                    "modelName='" + modelName + '\'' +
                    ", modelPrice=" + modelPrice +
                    '}';
        }

        public ModelAuto(String n, double p) {
            this.modelName = n;
            this.modelPrice = p;
        }

        public ModelAuto clone() throws CloneNotSupportedException {

            return (ModelAuto) super.clone();
        }

        public double getModelPrice() {
            return modelPrice;
        }

        public void setModelPrice(double modelPrice) {
            this.modelPrice = modelPrice;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }
    }

    @Override
    public String getMark() {
        return this.autoMark;
    }

    private boolean checkPrice(double price) {
        if (price <= 0) return false;
        else return true;
    }

    private boolean checkModelNameRepeat(String name) {

        //true если повторений нет
        int i = 0;
        while (i < this.modelArr.length) {

            if (this.modelArr[i].modelName.equals(name)) return false;
            i++;
        }
        return true;

    }

    @Override
    public void setMark(String mark) {
        this.autoMark = autoMark;
    }

    @Override
    public void addModel(String name, double price) throws NoSuchFieldException {
        if (checkModelNameRepeat(name)) {
            if (checkPrice(price)) {

                ModelAuto[] copy = Arrays.copyOf(this.modelArr, this.modelArr.length + 1);
                copy[copy.length - 1] = new ModelAuto(name, price);
                this.modelArr = copy;
            } else
                throw new ModelPriceOutOfBoundsException("ModelPriceOutOfBoundsException ");
        } else throw new NoSuchFieldException("NoSuchFieldException");

    }

    public void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        if (!checkModelNameRepeat(name)) {
            if (checkModelNameRepeat(newName)) {
                for (int index = 0; index < this.modelArr.length; index++) {
                    if (this.modelArr[index].getModelName().equals(name)) {
                        this.modelArr[index].setModelName(newName);
                        break;
                    }
                }
            } else throw new DuplicateModelNameException("DuplicateModelNameException");
        } else throw new NoSuchModelNameException("NoSuchModelNameException ");
    }

    @Override
    public String[] getModelNameArr() {
        String[] arr = new String[this.modelArr.length];
        for (int i = 0; i < this.modelArr.length; i++) {
            arr[i] = modelArr[i].getModelName();
        }
        return arr;
    }

    @Override
    public double getPrice(String name) throws NoSuchModelNameException {
        if (!checkModelNameRepeat(name)) {
            for (int index = 0; index < this.modelArr.length; index++) {
                if (this.modelArr[index].getModelName().equals(name)) {
                    double p = this.modelArr[index].getModelPrice();
                    System.out.println("getPriceByModel. Name:" + name + "price:" + p);
                    return p;
                }
            }
        } else throw new NoSuchModelNameException("NoSuchModelNameException ");
        return -1;
    }

    @Override
    public void setPrice(String name, double price) {
        if (checkPrice(price)) {
            for (int index = 0; index < this.modelArr.length; index++) {
                if (this.modelArr[index].getModelName().equals(name)) {
                    this.modelArr[index].setModelPrice(price);
                    //System.out.println("setPrice. Name:" + name + "_new price:" + price);
                }
            }
        } else throw new ModelPriceOutOfBoundsException("ModelPriceOutOfBoundsException");
    }

    @Override
    public double[] getPriceArr() {
        double arr[] = new double[this.modelArr.length];
        for (int i = 0; i < this.modelArr.length; i++) {
            arr[i] = this.modelArr[i].getModelPrice();
        }
        return arr;
    }

    @Override
    public void delModel(String name) throws NoSuchModelNameException {
        if (!checkModelNameRepeat(name)) {
            int index = -1;
            for (int i = 0; i < this.modelArr.length; i++) {
                if (this.modelArr[i].getModelName().equals(name)) index = i;
            }
            ModelAuto[] newArr = new ModelAuto[this.modelArr.length - 1];
            System.arraycopy(this.modelArr, 0, newArr, 0, index);
            System.arraycopy(this.modelArr, index + 1, newArr, index, this.modelArr.length - index - 1);
            this.modelArr = newArr;
        } else throw new NoSuchModelNameException("NoSuchModelNameException ");
        //System.arrayCopy(from, fromIndex, to, toIndex, count);
        //from - массив, который копируем
        //fromIndex - индекс в массиве from начиная с которого берем элементы для копирования
        //to - массив в которой копируем
        //toIndex - индекс в массиве to начиная с которого вставляем элементы
        //count - количество элементов которые берем из массива from и вставляем в массив to
        //Массив to должен иметь достаточный размер, чтобы в нем уместились все копируемые элементы.


    }

    @Override
    public int getSizeModelArr() {
        return modelArr.length;
    }

    private Command printComand;// true - в столбец, fasle в строку

    public void print(FileWriter fw) throws IOException {
        if (printComand != null)
            printComand.print(fw, this);


    }

    public void setPrintCommand(Command p) {

        this.printComand = p;
    }

}

