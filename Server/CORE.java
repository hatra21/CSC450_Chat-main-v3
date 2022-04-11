import java.io.PrintStream;
import java.util.ArrayList;

public class CORE {
    private static ArrayList<PrintStream> theClientStreams = new ArrayList<PrintStream>();

    // public static void addClientThreadPrintStream(PrintStream ps) {
    // System.out.println("adding client thread");
    // CORE.theClientStreams.add(ps);
    // }

    // public static synchronized void removeClientThreadPrintStream(PrintStream ps)
    // {
    // System.out.println("removing client thread");
    // ps.close();
    // CORE.theClientStreams.remove(ps);
    // }

    // THREAD SAFETY METHOD
    public static synchronized void changeCLientThreadPrintStream(PrintStream ps, String action) {
        if (action.equals("add")) {
            CORE.theClientStreams.add(ps);
        } else if (action.equals("remove")) {
            CORE.theClientStreams.remove(ps);
        }
    }

    public static void broadcastMessage(String message) {
        System.out.println("About to broadcast....");
        for (PrintStream ps : CORE.theClientStreams) {
            ps.println(message);
        }
    }
}
