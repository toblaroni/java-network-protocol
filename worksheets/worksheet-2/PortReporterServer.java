// Question 4

import java.io.*;
import java.net.*;

public class PortReporterServer {

    public void runServer() {
        try {
            // Listen on port 5555
            ServerSocket serverSock = new ServerSocket(5555);

            // Continue waiting for connections from clients
            while (true) {
                Socket sock = serverSock.accept();

                System.out.println("Connection Recieved");

                // Print out the source and destination of the socket
                System.out.println( "Destination of connection: " + sock.getPort() );
                System.out.println( "Source of connection: "      + sock.getLocalPort()      );

                // Close the socket
                sock.close();
            }
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        PortReporterServer server = new PortReporterServer();
        server.runServer();
    }
    
}
