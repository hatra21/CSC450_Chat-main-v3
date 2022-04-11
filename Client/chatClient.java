import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class chatClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 2222);
        Scanner clientInput = new Scanner(s.getInputStream());
        String question = clientInput.nextLine();
        System.out.println(question);
        Scanner localInput = new Scanner(System.in);
        PrintStream clientOutput = new PrintStream(s.getOutputStream());

        // File transferring
        byte b[] = new byte[1024];
        InputStream inputStream = s.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("C:\\outputtext.txt");
        inputStream.read(b, 0, b.length);
        outputStream.write(b, 0, b.length);

        Thread lt = new Thread() {
            Boolean runningThread = true;

            public void run() {
                String line;
                while (runningThread) {
                    line = clientInput.nextLine();
                    System.out.println(line);

                    // if (line.equals("/quit")) {
                    // System.out.println("A client has left the chat.");

                    // runningThread = false;
                    // } else {
                    // System.out.println(line);
                }
            }
        };

        lt.start();

        String line;

        while (true) {

            line = localInput.nextLine();
            clientOutput.println(line);
            if (line.equals("/quit")) {
                break;
            }
            // clientOutput.println(localInput.nextLine());
        }
        System.out.println("A client has left the chat.");
        // lt.interrupt();
        System.exit(0);

    }
}
