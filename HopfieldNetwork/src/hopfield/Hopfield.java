package hopfield;


import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

public class Hopfield {
    public int[] myChar1 = new int[]{-1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1,};
    public int[] myChar2 = new int[]{-1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,};
    public int[] myChar3 = new int[]{-1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, 1, 1, 1, 1, 1, -1,};
    public int[] myChar4 = new int[]{-1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1,};
    public int[] myChar5 = new int[]{-1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1};
    public int[] myChar6 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int[] myChar7 = new int[]{-1, -1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1};
    public int[] myChar8 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, -1, 1, -1, -1, -1, 1, -1, -1, 1, 1, 1, 1, 1, -1, 1, -1, -1, -1, -1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1};
    public int[] myChar9 = new int[]{-1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, -1, -1, -1, -1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1};
    public int[] myChar0 = new int[]{-1, -1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, -1, -1, 1, 1, 1, -1, -1};
    //field
    private Integer[][] mat;
    private int[] input;
    private int[] test;
    private Weight w;
    //	private final static String FILENAME = "character";
    private String filename;
    private double threshold;
    private int n, m, i = 0, j = 0, z = 0;

    //methods
    public Hopfield(int n, int m, Weight w, double threshold, String filename) {
        this.threshold = threshold;
        this.w = w;
        this.mat = new Integer[n][m];
        this.n = n;
        this.m = m;
        input = new int[n * m];
        this.filename = filename;
        getInput();
//        System.out.println();
//        System.out.println("the input character is:");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (mat[i][j] == 1) {
//                    System.out.print("# ");
//                } else if (mat[i][j] == -1) {
//                    System.out.print("* ");
//                }
//            }
//            System.out.println();
//        }
        test();
    }//constructor

    public void test() {
        double[][] weight = w.getWeight();
        test = input;
        int[] test2 = new int[n * m];
        int iter = 0;
        boolean c = true;
        while (c) {
            c = false;
            iter++;
            for (int i = 0; i < n * m; i++) {
                int y_in = 0;
                //summ
                for (int j = 0; j < n * m; j++) {
                    y_in += test[j] * weight[i][j];
                }//for j
                //sign
                y_in += input[i];
                int x = test[i];
                if (y_in > threshold) {

                    test[i] = 1;
                }// if x > threshold
                else if (y_in < threshold) {

                    test[i] = -1;
                }// else if x < threshold
                if (test[i] != x) {
                    c = true;
                }

            }

        }

//        System.out.println();


        if (Arrays.equals(myChar1, test)) {
            System.out.print("1");
        } else if (Arrays.equals(myChar2, test)) {
            System.out.print("2");
        } else if (Arrays.equals(myChar3, test)) {
            System.out.print("3");
        } else if (Arrays.equals(myChar4, test)) {
            System.out.print("4");
        } else if (Arrays.equals(myChar5, test)) {
            System.out.print("5");
        } else if (Arrays.equals(myChar6, test)) {
            System.out.print("6");
        } else if (Arrays.equals(myChar7, test)) {
            System.out.print("7");
        } else if (Arrays.equals(myChar8, test)) {
            System.out.print("8");
        } else if (Arrays.equals(myChar9, test)) {
            System.out.print("9");
        } else if (Arrays.equals(myChar0, test)) {
            System.out.print("0");
        } else {
            System.out.print("НЕ РАСПОЗНАЛИ");
        }
        System.out.println("__Распознали за " + iter + "  итераций  " + "file: " + filename);

//		System.out.println();
		int count = 0;
//		for(int i = 0 ; i < n ; i++)
//		{
//			for(int j = 0 ; j < m ; j++)
//			{
//				if(test[count] == 1)
//				{
//					System.out.print("# ");
//				}
//				else if(test[count] == -1)
//				{
//					System.out.print("* ");
//				}
//				count++;
//			}
//			System.out.println();
//		}
        //

    }//test method

    public void getInput() {
        try {
            File file = new File(Main.class.getResource(filename).toURI());
            FileInputStream fileInput = new FileInputStream(file);
            int c = 0;
            while ((c = fileInput.read()) != -1) {
                getMatrix((char) c);
            }//while
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//getInput method


    public void getMatrix(char c) {
        if (c == '#') {
            mat[i][j] = 1;
            input[z] = 1;
            z++;
            j++;
        }//if
        else if (c == '*') {
            mat[i][j] = -1;
            input[z] = -1;
            z++;
            j++;
        }//else

        if (j >= m) {
            j = 0;
            i++;
        }//if j>=m
        if (i >= n) {
            i = 0;
            j = 0;
        }//if i>=n

    }
}

class MySample {

    public int[] myChar0 = new int[]{

    };
    public int[] myChar1 = new int[]{
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, -1, 1, 1, -1, -1,
    };
    public int[] myChar2 = new int[]{
            -1, 1, 1, 1, 1, 1, 1,
            -1, 1, 1, 1, 1, 1, 1,
            -1, -1, -1, -1, 1, 1, -1,
            -1, -1, -1, 1, 1, -1, -1,
            -1, -1, 1, 1, -1, -1, -1,
            -1, 1, 1, -1, -1, -1, -1,
            1, 1, -1, -1, -1, -1, -1,
            1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1,
    };
    public int[] myChar3 = new int[]{
            -1, -1, 1, 1, 1, 1, 1,
            -1, -1, -1, -1, -1, 1, -1,
            -1, -1, -1, -1, 1, -1, -1,
            -1, -1, -1, 1, -1, -1, -1,
            -1, -1, -1, -1, 1, -1, -1,
            -1, -1, -1, -1, -1, 1, -1,
            -1, -1, -1, -1, -1, -1, 1,
            -1, -1, -1, -1, -1, -1, 1,
            -1, 1, 1, 1, 1, 1, -1,
    };
    public int[][] myChar4 = new int[][]{
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
    };
    public int[][] myChar5 = new int[][]{
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    };
    public int[][] myChar6 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1},
    };

    public int[][] myChar7 = new int[][]{
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
    };
    public int[][] myChar8 = new int[][]{
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    };
    public int[][] myChar9 = new int[][]{
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
    };
}