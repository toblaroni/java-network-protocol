//
// The server for the 'daily advice' application, where the client requests a
// single line of advice from the server and then closes the connection.
//

import java.io.*;
import java.net.*;
import java.util.*;

public class DailyAdviceServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(4242);
        } catch (IOException e) {
            System.err.println(e);
        }

        while (listening)
            new DAClientHandler(serverSocket.accept()).start(); // Create a new thread for each connection

        serverSocket.close();
    }


}