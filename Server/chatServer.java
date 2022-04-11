import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;

public class chatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(2222);
        ArrayList<ChatWorkerThread> theThreads = new ArrayList<ChatWorkerThread>();

        FileInputStream fReader = new FileInputStream("C:\\Users\\hatra\\OneDrive\\Desktop\\csc450.txt");
        byte b[] = new byte[1024];

        while (true) {
            System.out.println("Listenning for Connection...");
            Socket client = s.accept(); // blocks
            ChatWorkerThread t = new ChatWorkerThread(client);
            theThreads.add(t);
            t.start();

            fReader.read(b, 0, b.length);
            OutputStream clientOs = client.getOutputStream();

        }

    }
}
