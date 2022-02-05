package adapter;


import java.io.*;


public  class Adapter extends OutputStream implements Adaptee {

//https://ru.wikipedia.org/wiki/%D0%90%D0%B4%D0%B0%D0%BF%D1%82%D0%B5%D1%80_(%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F)#Java_-_%D0%BD%D0%B0%D1%81%D0%BB%D0%B5%D0%B4%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5
//String[] arr




    @Override
    public void w(String[] arr) throws IOException {
        //C:\Users\Alexander\Desktop\testTask\Lezina\src\adapter
        File file = new File("C:\\Users\\Alexander\\Desktop\\testTask\\Lezina\\src\\adapter\\test.txt");
        OutputStream os = new FileOutputStream(file);

        for (int i = 0; i < arr.length; i++) {
            byte[] buffer = arr[i].getBytes();
            os.write(buffer, 0, buffer.length);
        }
    }

    @Override
    public void write(int b) throws IOException {

    }
}





/*File file = new File("C:\\Users\\Alexander\\IdeaProjects\\Lezina\\src\\test.txt");
        OutputStream os = new FileOutputStream(file);

        for (int i = 0; i < arr.length; i++) {
            byte[] buffer = arr[i].getBytes();
            os.write(buffer, 0, buffer.length);
        }

    }

 */


