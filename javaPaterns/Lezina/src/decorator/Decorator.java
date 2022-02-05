package decorator;

import lab1.Transport;
import lab1.exeption.DuplicateModelNameException;
import lab1.exeption.NoSuchModelNameException;
import lab3.visitor38.Visitor;

public class Decorator implements Transport {
    protected Transport transport;

    public Decorator(Transport t) {
        this.transport = t;
    }


    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public  synchronized String getMark() {
        return transport.getMark();
    }

    @Override
    public  synchronized void setMark(String mark) {
        transport.setMark(mark);
    }

    @Override
    public synchronized Object clone() throws CloneNotSupportedException {
     return   transport.clone();
    }

    @Override
    public  synchronized void setModelName(String name, String newName) throws DuplicateModelNameException, NoSuchModelNameException, NoSuchFieldException {
        transport.setModelName(name, newName);
    }

    @Override
    public synchronized String[] getModelNameArr() {
        return transport.getModelNameArr();
    }

    @Override
    public synchronized double getPrice(String name) throws NoSuchModelNameException, NoSuchFieldException {
        return transport.getPrice(name);
    }

    @Override
    public synchronized void setPrice(String name, double price) {
        transport.setPrice(name, price);
    }

    @Override
    public synchronized double[] getPriceArr() {
        return transport.getPriceArr();
    }

    @Override
    public synchronized void addModel(String name, double price) throws DuplicateModelNameException, NoSuchFieldException {
        transport.addModel(name, price);
    }

    @Override
    public synchronized void delModel(String name) throws NoSuchModelNameException, NoSuchFieldException {
        transport.delModel(name);
    }

    @Override
    public synchronized int getSizeModelArr() {
        return transport.getSizeModelArr();
    }
}
