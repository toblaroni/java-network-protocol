import java.net.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class ClientHandler extends Thread {

    // The client socket that's passed in from the server
    private Socket socket = null;
    ArrayList<String[]> items = new ArrayList<String[]>();

    public ClientHandler( Socket socket, ArrayList<String[]> items ) {
        super( "ClientHandler" );
        this.socket = socket;
        this.items = items;
    }

    // This is where all our code is ran when expanding thread.
    public void run() {

        try {

            // IO streams to/from the client
            PrintWriter out = new PrintWriter( socket.getOutputStream(), true );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));

            // Logging
            InetAddress inet  = socket.getInetAddress();  // IP
            String clientAddr = inet.getHostAddress();
            LocalDate date    = java.time.LocalDate.now();
            LocalTime time    = java.time.LocalTime.now();  // ** FORMAT **

            
            String inputLine, outputLine;
            inputLine = in.readLine();

            // Process the input with the protocol
            AuctionProtocol p = new AuctionProtocol( inputLine, clientAddr, items );
            outputLine = p.processRequest();

            out.println( outputLine );

            // Free up resources
            out.close();
            in.close();
            socket.close();

        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
