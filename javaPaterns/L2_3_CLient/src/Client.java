import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    private static double serverWord ;

    public static double mull(Double a, Double b) {
        try {
            try {
                clientSocket = new Socket("localhost", 5000); // этой строкой мы запрашиваем
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write(a + "\n"); // отправляем сообщение на сервер
                out.flush();
                out.write(b + "\n");
                out.flush();
                serverWord = Double.parseDouble(in.readLine()); // ждём, что скажет сервер
                System.out.println("Получили от сервера: "+serverWord); // получив - выводим на экран
            } finally { // в любом случае необходимо закрыть сокет и потоки

                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        return serverWord;
    }
}