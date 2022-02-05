package lab1;

import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.ModelPriceOutOfBoundsException;
import lab1.exeption.NoSuchModelNameException;
import lab3.visitor38.PrintVisitor;
import lab3.visitor38.Visitor;

import java.io.Serializable;

public class Moto implements Transport, Cloneable, Serializable {
    private String markMoto;
    @Override
    public void accept(Visitor visitor) {
        PrintVisitor printVisitor = new PrintVisitor();
        printVisitor.visit(this);
    }
    private class ModelMoto implements Cloneable,Serializable {
        private String nameModel = null;
        private double price = Double.NaN;
        private ModelMoto prev = null;
        private ModelMoto next = null;

        public ModelMoto clone() throws CloneNotSupportedException {
            return (ModelMoto) super.clone();
        }

        public ModelMoto(String name, double p) {
            this.nameModel = name;
            this.price = p;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Moto result = (Moto) super.clone();

        ModelMoto pointer = this.head.next;
        ModelMoto pointer2 = result.head.next;
        while (pointer != head) {
            pointer2 = pointer.clone();
            pointer = pointer.next;
        }
        return result;
    }

    private ModelMoto head = new ModelMoto(null, 0);

    {
        head.prev = head;
        head.next = head;
    }

    private int size = 0;

    public Moto(String name, int k) throws NoSuchFieldException {
        this.markMoto = name;
        ModelMoto pointer = this.head.next;
        int i = 0;
        while (i < k) {
            ModelMoto mt = new ModelMoto(Integer.toString(i), -1);
            pointer = mt;
            head.prev.next = mt;
            mt.next = head;
            mt.prev = head.prev;
            head.prev = mt;
            size++;
            i++;
        }
    }

    @Override
    public void setMark(String mark) {
        this.markMoto = mark;
    }



    @Override
    public String getMark() {
        return this.markMoto;
    }

    private boolean checkModelPrice(double p) {
        if (p < 0) return false;
        else return true;
    }

    //проверка на повторы. фалсе если повторы есть
    public boolean checkModelNameRepeat(String name) {
        ModelMoto pointer = this.head.next;
        while (pointer != head) {
            if (pointer.nameModel.equals(name)) return false;
            pointer = pointer.next;
        }
        return true;
    }

    @Override
    public void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchFieldException, NoSuchModelNameException {
        if (!checkModelNameRepeat(name)) {
            if (checkModelNameRepeat(newName)) {
                int i = 0;
                ModelMoto pointer = this.head.next;
                while (pointer.next != head && (!pointer.nameModel.equals(name))) {
                    pointer = pointer.next;
                }
                pointer.nameModel = newName;
                System.out.println("old name: " + name + " new name: " + newName);
            } else throw new DuplicateModelNameException("DuplicateModelNameException");
        } else throw new NoSuchModelNameException("NoSuchModelNameException");
    }

    @Override
    public String[] getModelNameArr() {
        String arr[] = new String[size];
        ModelMoto pointer = this.head.next;
        int i = 0;
        while (pointer != head) {
            arr[i] = pointer.nameModel;
            pointer = pointer.next;
            i++;
        }
        return arr;
    }

    @Override
    public double getPrice(String name) throws NoSuchFieldException {
        if (!checkModelNameRepeat(name)) {
            ModelMoto pointer = this.head.next;
            double p = -1;
            while (pointer != head) {
                pointer = pointer.next;
                if (pointer.nameModel.equals(name)) p = pointer.price;
            }
            return p;
        } else throw new NoSuchFieldException("NoSuchFieldException");
    }

    @Override
    public void setPrice(String name, double price) {
        if (checkModelPrice(price)) {
            ModelMoto pointer = this.head.next;
            while (pointer != head) {
                if (pointer.nameModel.equals(name)) pointer.price = price;
                pointer = pointer.next;
            }
        } else throw new ModelPriceOutOfBoundsException("ModelPriceOutOfBoundsException");
    }

    @Override
    public double[] getPriceArr() {
        double arr[] = new double[size];
        ModelMoto pointer = this.head.next;
        int i = 0;
        while (pointer != head) {

            arr[i] = pointer.price;
            pointer = pointer.next;
            i++;
        }
        return arr;
    }

    @Override
    public void addModel(String name, double price) throws NoSuchFieldException {
        if (checkModelNameRepeat(name)) {
            if (checkModelPrice(price)) {

                ModelMoto mt = new ModelMoto(name, price);
                head.prev.next = mt;
                mt.next = head;
                mt.prev = head.prev;
                head.prev = mt;
                size++;
            } else throw new ModelPriceOutOfBoundsException("ModelPriceOutOfBoundsException");
        } else throw new NoSuchFieldException("NoSuchFieldException");
    }

    @Override
    public void delModel(String name) throws NoSuchFieldException {
        if (!checkModelNameRepeat(name)) {
            ModelMoto pointer = this.head.next;
            while (!pointer.nameModel.equals(name)) {
                pointer = pointer.next;
            }
            if (pointer.nameModel.equals(name)) {
                pointer.prev.next = pointer.next;
                pointer.next.prev = pointer.prev;
                size--;
            }
        } else throw new NoSuchFieldException("NoSuchFieldException");
    }

    @Override
    public int getSizeModelArr() {
        return this.size;
    }

    public double getAveragePrice() {
        double summ = 0;
        ModelMoto pointer = this.head.next;
        while (pointer != head) {
            summ += pointer.price;
            pointer = pointer.next;
        }
        return summ / this.size;
    }


}

