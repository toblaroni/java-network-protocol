import java.net.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class ClientHandler extends Thread {

    // The client socket that's passed in from the server
    private Socket socket = null;

    public ClientHandler( Socket socket ) {
        super( "ClientHandler" );
        this.socket = socket;
    }

    // This is where all our code is ran when expanding thread.
    public void run() {

        try {

            // IO streams to/from the client
            PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));

            // Logging
            InetAddress inet = socket.getInetAddress();  // IP
            LocalDate date = java.time.LocalDate.now();
            LocalTime time = java.time.LocalTime.now();  // ** FORMAT **

            System.out.println( date + " | " + time + " | " + inet );
            
            String inputLine, outputLine;
            inputLine = in.readLine();
            System.out.println(inputLine);
            out.println("Suck your mother");

            // Free up resources
            out.close();
            in.close();
            socket.close();

        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
