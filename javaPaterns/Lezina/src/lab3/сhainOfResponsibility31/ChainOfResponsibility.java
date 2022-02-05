package lab3.сhainOfResponsibility31;

import lab1.Transport;

import java.io.IOException;


public interface ChainOfResponsibility {

    public void write(Transport transport) throws IOException;

    public void setNext(ChainOfResponsibility chain);

}
