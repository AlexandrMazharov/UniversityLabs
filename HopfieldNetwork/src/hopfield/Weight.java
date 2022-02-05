package hopfield;

public class Weight {
    //field
    private double[][] w;

    //methods
    public Weight(int n, int m) {
        w = new double[n * m][n * m];
        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < n * m; j++) {
                w[i][j] = 0;
            }
        }
    }//constructor


    public void setWeight(int value, int i, int j) {
        w[i][j] += value;
    }//setWeight method


    public double[][] getWeight() {
        return w;
    }//getWeight method


	public void setAllWeight(double[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[1].length; j++) {
				this.w[i][j] = arr[i][j];
			}
		}
	}
}//Weight class
