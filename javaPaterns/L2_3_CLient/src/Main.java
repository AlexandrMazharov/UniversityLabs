import java.io.*;
import java.net.Socket;

public class Main {
    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {

        IMath p = new MathProxy();
        System.out.print("Маин. Результат умножения:"+p.mul(4, 3));
    }
}