import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                server = new ServerSocket(5000); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу
                //   объявить о своем запуске
                clientSocket = server.accept(); // accept() будет ждать пока
                //кто-нибудь не захочет подключиться
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    String word1 = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.print("Получили: " + word1);
                    String word2 = in.readLine(); // ждём пока клиент что-нибудь нам напишет
                    System.out.print("Получили: " + word2);
                    double res = Double.parseDouble(word1) * Double.parseDouble(word2);
                    //             IMath p = new MathProxy();
                    //                 double res = p.mul(Double.parseDouble(String.valueOf(word1)), Double.parseDouble(String.valueOf(word2)));
                    System.out.print("Результат умножения" + res);
                    out.write(String.valueOf(res));
                    out.flush(); // выталкиваем все из буфера

                } finally { // в любом случае сокет будет закрыт

                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
