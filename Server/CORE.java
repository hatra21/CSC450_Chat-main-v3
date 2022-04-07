import java.io.PrintStream;
import java.util.ArrayList;

public class CORE {
    private static ArrayList<PrintStream> theClientStreams = new ArrayList<PrintStream>();

    public static void addClientThreadPrintStream(PrintStream ps) {
        System.out.println("adding client thread");
        CORE.theClientStreams.add(ps);
    }

    public static synchronized void removeClientThreadPrintStream(PrintStream ps) {
        System.out.println("removing client thread");
        ps.close();
        CORE.theClientStreams.remove(ps);
    }

    public static void broadcastMessage(String message) {
        System.out.println("About to broadcast....");
        for (PrintStream ps : CORE.theClientStreams) {
            ps.println(message);
            // if (message.equals("/quit")) {
            // removeClientThreadPrintStream(ps);
            // } else {
            // ps.println(message);
            // }
        }
    }
}
