package lab3.visitor38;

import lab1.Auto;
import lab1.Moto;

public class PrintVisitor implements Visitor {

    public void visit(Auto auto) {
        System.out.print(auto.getMark() + ":");
        for (int i = 0; i < auto.getSizeModelArr(); i++) {
            System.out.println(auto.getModelNameArr()[i]);
            System.out.println(auto.getPriceArr()[i]);
        }
    }

    public void visit(Moto moto) {
        System.out.print("Moto");
        System.out.print(moto.getMark()+" ");
        for (int i = 0; i < moto.getSizeModelArr(); i++) {
            System.out.print( moto.getModelNameArr()[i] + " " + moto.getPriceArr()[i] + "|");
        }

    }
}

