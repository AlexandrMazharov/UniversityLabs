//package Utils;
////
//import java.io.*;
////
//
//public class Generate1 {
//
//    private static void writeFile(int[][] arr, String charName) {
//        charName = charName + ".txt";
//
//        try (FileWriter writer = new FileWriter(charName, true)) {
//            // запись всей строки
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr[i].length; j++) {
//                    writer.write(String.valueOf(arr[i][j]));
//                }
//                writer.append('\n');
//            }
//            writer.append('\n');
//            writer.flush();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    private static void delSample() {
//        File file0 = new File("myChar0.txt");
//        File file1 = new File("myChar1.txt");
//        File file2 = new File("myChar2.txt");
//        File file3 = new File("myChar3.txt");
//        File file4 = new File("myChar4.txt");
//        File file5 = new File("myChar5.txt");
//        File file6 = new File("myChar6.txt");
//        File file7 = new File("myChar7.txt");
//        File file8 = new File("myChar8.txt");
//        File file9 = new File("myChar9.txt");
//
//        file0.delete();
//        file1.delete();
//        file2.delete();
//        file3.delete();
//        file4.delete();
//        file5.delete();
//        file6.delete();
//        file7.delete();
//        file8.delete();
//        file9.delete();
//
//
//    }
//
////    public static void main(String[] args) {
////        int sampleSize = 10; // количество классов 0..9
////        int count = 10; // количество искаженных точек
////        delSample();// удаляем старую выборку
////        for (int i = 0; i < sampleSize; i++) {
////
////            writeFile(distortion(MySample.myChar0, count), "myChar0");
////            writeFile(distortion(MySample.myChar1, count), "myChar1");
////            writeFile(distortion(MySample.myChar2, count), "myChar2");
////            writeFile(distortion(MySample.myChar3, count), "myChar3");
////            writeFile(distortion(MySample.myChar4, count), "myChar4");
////            writeFile(distortion(MySample.myChar5, count), "myChar5");
////            writeFile(distortion(MySample.myChar6, count), "myChar6");
////            writeFile(distortion(MySample.myChar7, count), "myChar7");
////            writeFile(distortion(MySample.myChar8, count), "myChar8");
////            writeFile(distortion(MySample.myChar9, count), "myChar9");
////
////        }
////    }
////
//////    private int[][] myChar2;
////
////    // искажение одного изображения
////    public static int[][] distortion(int[][] arr, int count) {
//////        count - количество искаженных символов
//////        arr массив для искажения
////        int size = arr.length * arr[1].length;
//////        System.out.println(size);
////
////        int[] coverItems = new int[count];
////        // находит элементы которые поменяем
////
////        // System.out.print("Искажены: ");
////        for (int i = 0; i < count; i++) {
////            coverItems[i] = (int) (Math.random() * size);
//////            System.out.print(coverItems[i] + ",");
////        }
//////        System.out.println("");
////        int localCOunter = 0;
////        //перебрать исзходный массив
////        for (int i = 0; i < arr.length; i++) {
////            for (int j = 0; j < arr[i].length; j++) {
////// если жлемент массива имеет идекс равный одному из коверИтем, томеняет ему значение
////                for (int z = 0; z < coverItems.length; z++) {
////                    if (coverItems[z] == localCOunter) {
////                        if (arr[i][j] == 0) arr[i][j] = 1;
////                        else {
////                            arr[i][j] = 0;
////                        }
////                    }
////                }
////                localCOunter++;
////            }
////        }
////        return arr;
////    }
////}
