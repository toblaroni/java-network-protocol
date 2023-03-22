// Question 5
import java.net.*;
import java.io.*;
import java.util.*;

public class DAClientHandler extends Thread {
    private Socket socket = null;

    // Feel free to add any 'hilarious' one-line advice strings here.
    private String[] adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut"
    };

    public DAClientHandler(Socket socket) {
        super("DAClientHandler");
        this.socket = socket;
    }

    // The advice sent to the client is just randomly selected from the above list.
    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
    
    public void run() {
        try {
            // Get information about the connection and the date/time, and print to screen.
            // Normally you would not print
            // this information - it would e.g. be sent to a log file - this is just for
            // demonstration purposes.
            InetAddress inet = socket.getInetAddress();
            Date date = new Date();
            System.out.println("\nDate " + date.toString());
            System.out.println("Connection made from " + inet.getHostName());

            // Send a single line of text to the client.
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            String advice = getAdvice();
            writer.println(advice); // Write to client

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            writer.close();
            System.out.println(advice); // Local server echo
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
