package lab3.visitor38;

import lab1.Auto;
import lab1.Moto;

public interface Visitor {

    void visit(Auto auto);
    void visit(Moto moto);


}
