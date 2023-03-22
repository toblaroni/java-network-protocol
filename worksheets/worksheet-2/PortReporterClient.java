// Question 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PortReporterClient {
    public void connect() {
        try {
            // Try and connect to the server port
            Socket s = new Socket( "localhost", 5555 );

            System.out.println("Connection successful");
            
            // Print the source and destination ports of the socket
            System.out.println( "Source of connection: "      + s.getLocalPort() );
            System.out.println( "Destination of connection: " + s.getPort()      );

            // Close the socket
            s.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        PortReporterClient client = new PortReporterClient();
        client.connect();
    }
}
