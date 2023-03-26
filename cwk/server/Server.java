import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Server {
	public static void main( String[] args ) throws IOException {

		ServerSocket server = null;
		ExecutorService service = null;
		ArrayList<String[]> items = new ArrayList<String[]>();

		// Listen on port 6969
		try {
			server = new ServerSocket(6969);
		} catch ( IOException e ) {
				System.err.println( "Could not listen on port 6969. Port may be being used by another process." );
				System.exit(-1);
		}

		// Initialise the fixed size executor
		service = Executors.newFixedThreadPool(30);

		// For every new client we submit a new handler to the thread pool
		while ( true ) {
			Socket client = server.accept();  // Blocks until connection is made
			service.submit( new ClientHandler(client, items) );
		}
	}
}
