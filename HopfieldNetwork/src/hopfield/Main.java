// rull hebb example matimatic https://www.youtube.com/watch?v=fywNKjpAQBM
package hopfield;

import recurent.Projections;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    //field
    private final static String FILENAME = "input.txt";
    private Map<String, Integer[][]> mapChars = new TreeMap<String, Integer[][]>();
    private List<String> characters = new ArrayList<String>();
    private List<String> fullCharacters = new ArrayList<String>();
    private Integer[][] mat;
    private static int n = 0, m = 0, i = 0, j = 0;
    private final static double THRESHOLD = 0;

    //methods
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.getDim();
        main.getCharacter();
        Weight w = new Weight(n, m);

        {//Learning by HEBB rule
            for (int i = 0; i < main.fullCharacters.size(); i++) {
                Hebb hebb = new Hebb(main.fullCharacters.get(i), main.mapChars.get(main.fullCharacters.get(i)), n, m, w);

            }
            saveWeight(w, "WeightHebbRule.txt");
        }

//        {//Learning by ProjectionRule rule
//            ArrayList<double[]> patterns = new ArrayList<>();
//            for (int i = 0; i < main.mapChars.size(); i++) {
//                Integer[][] old = main.mapChars.get(main.fullCharacters.get(i));
//                double[] newArr = new double[old.length * old[1].length];
//                int z = 0;
//                for (int k = 0; k < old.length; k++) {
//                    for (int p = 0; p < old[0].length; p++) {
//                        newArr[z] = old[k][p];
//                        z++;
//                    }
//                }
//                patterns.add(newArr);
//            }
//            Projections projections = new Projections(w);
//            projections.train(patterns);
//
//            saveWeight(w, "WeightProjectionRule.txt");
//        }

//        saveWeight(w, "Weight.txt");

        printWeigh(w);

//        7.	Исследовать зависимость погрешности классификации от реализованного алгоритма обучения.
//        8.	Исследовать зависимость погрешности классификации от уровня «искажения» классифицируемого объекта.

System.out.println();

        String filename = "../inputs/character";
        Hopfield hopfield = new Hopfield(n, m, w, THRESHOLD,filename);

        String filename2 = "../inputs/character2";
        Hopfield hopfield2 = new Hopfield(n, m, w, THRESHOLD,filename2);

        String filename3 = "../inputs/character3";
        Hopfield hopfield3 = new Hopfield(n, m, w, THRESHOLD,filename3);

        String filename4 = "../inputs/character4";
        Hopfield hopfield4 = new Hopfield(n, m, w, THRESHOLD,filename4);

        String filename5 = "../inputs/character5";
        Hopfield hopfield5 = new Hopfield(n, m, w, THRESHOLD,filename5);

        String filename6 = "../inputs/character6";
        Hopfield hopfield6 = new Hopfield(n, m, w, THRESHOLD,filename6);

        String filename7 = "../inputs/character7";
        Hopfield hopfield7 = new Hopfield(n, m, w, THRESHOLD,filename7);

        String filename8 = "../inputs/character8";
        Hopfield hopfield8 = new Hopfield(n, m, w, THRESHOLD,filename8);

        String filename9 = "../inputs/character9";
        Hopfield hopfield9 = new Hopfield(n, m, w, THRESHOLD,filename9);

        String filename10 = "../inputs/character10";
        Hopfield hopfield10 = new Hopfield(n, m, w, THRESHOLD,filename10);

        String filename11 = "../inputs/character11";
        Hopfield hopfield11 = new Hopfield(n, m, w, THRESHOLD,filename11);

        String filename12 = "../inputs/character12";
        Hopfield hopfield12 = new Hopfield(n, m, w, THRESHOLD,filename12);

        String filename13 = "../inputs/character13";
        Hopfield hopfield13 = new Hopfield(n, m, w, THRESHOLD,filename13);

        String filename14 = "../inputs/character14";
        Hopfield hopfield14 = new Hopfield(n, m, w, THRESHOLD,filename14);

        String filename15 = "../inputs/character15";
        Hopfield hopfield15 = new Hopfield(n, m, w, THRESHOLD,filename15);

        String filename16 = "../inputs/character16";
        Hopfield hopfield16 = new Hopfield(n, m, w, THRESHOLD,filename16);
//
        String filename17 = "../inputs/character17";
        Hopfield hopfield17 = new Hopfield(n, m, w, THRESHOLD,filename17);

        String filename18 = "../inputs/character18";
        Hopfield hopfield18 = new Hopfield(n, m, w, THRESHOLD,filename18);
//
        String filename19 = "../inputs/character19";
        Hopfield hopfield19 = new Hopfield(n, m, w, THRESHOLD,filename19);

        String filename20 = "../inputs/character20";
        Hopfield hopfield20 = new Hopfield(n, m, w, THRESHOLD,filename20);



    }

    // print Weight to console
    private static void printWeigh(Weight w) {
        System.out.println("Weight Matrix");
        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < n * m; j++) {
                System.out.print(w.getWeight()[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //save Weight to file
    private static void saveWeight(Weight w, String fileName) throws IOException {
        String pathName = fileName;
        FileWriter writer = new FileWriter(pathName, false);
        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < n * m; j++) {
                writer.write(w.getWeight()[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.close();
    }

    public void getCharacter() {
        try {
            File file = new File(Main.class.getResource(FILENAME).toURI());
            FileInputStream fileInput = new FileInputStream(file);
            int c = 0;
            mat = new Integer[n][m];
            while ((c = fileInput.read()) != -1) {
                getMatrix((char) c);
                if (((char) c) == '/') {
                    StringBuilder str = new StringBuilder();
                    while ((c = fileInput.read()) != -1) {
                        if ((char) c == '\n') {
                            break;
                        }
                        str.append((char) c);
                    }
                    String s = str.toString().replaceAll("[^A-Z0-9]", "");
                    fullCharacters.add(s);
                    if (!characters.contains(s.replaceAll("[0-9]", ""))) {
                        characters.add(s.replaceAll("[0-9]", ""));
                    }
                    mapChars.put(s, mat);
                    mat = new Integer[n][m];
                    i = 0;
                    j = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMatrix(char c) {
        if (c == '#') {
            mat[i][j] = 1;
            j++;
        }//if
        else if (c == '*') {
            mat[i][j] = -1;
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

    }//getMatrix method

    public void getDim() {
        try {
            File file = new File(Main.class.getResource(FILENAME).toURI());
            FileInputStream fileInput = new FileInputStream(file);
            int c = 0;
            boolean end = false;
            while ((char) (c = fileInput.read()) != '/') {
                if (((char) c) == '\n') {
                    n++;
                    end = true;
                }//if reached next line
                else if (!end && (((char) c) == '#' || ((char) c) == '*')) {
                    m++;
                }//else
            }//while
        }//try
        catch (Exception e) {
            e.printStackTrace();
        }//catch
    }//getDim method

}
