// example https://github.com/yogonza524/HopfieldNetwork/blob/master/src/main/java/com/core/hopfield/Hopfield.java

package recurent;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import hopfield.Weight;

public class Projections {
    private ArrayList<double[]> patterns;
    private ArrayList<double[]> aux;

    private Map<String, Integer> mapChars;

    private Weight w;

    public Projections(Weight w) {

        this.w = w;

    }
// W = X(X^T*X)^(-1)
    public void train(ArrayList<double[]> patterns) {
        this.patterns = patterns;
        Iterator<double[]> i = patterns.iterator();
        while (i.hasNext()) {
            if (i.next().length != this.w.getWeight().length) {
                throw new IndexOutOfBoundsException("All patterns must have " + this.w.getWeight().length + " dimensions");
            }
        }
        i = patterns.iterator();
        while (i.hasNext()) {
            double[] v = i.next();
            double[][] wAux = Matrix.subtract(Matrix.multiply(v, v), Matrix.identity(this.w.getWeight().length));
            this.w.setAllWeight( Matrix.add(w.getWeight(), wAux));
        }
    }


}

