import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket socket = null;	
	private PrintWriter socketOutput = null;
	private BufferedReader socketInput = null;

	public void auction( String[] args ) {
		for (int i = 0; i < args.length; ++i)
			System.out.println(args[i]);

		try {

			// Create the socket
			socket = new Socket( "localhost", 6969 );

			socketOutput = new PrintWriter( socket.getOutputStream(), true );
			socketInput  = new BufferedReader( new InputStreamReader( socket.getInputStream() ));

		} catch ( UnknownHostException e )  {
			System.err.println("Could not connect to host on port 6969");
			System.exit(1);
		} catch ( IOException e ) {
			System.err.println( "Couldn't get I/O streams for the connection to host");
			System.exit(1);
		}

        String fromServer;
		
		try {
			// Send args to the server
			socketOutput.println(args);

			// Read from server
			fromServer = socketInput.readLine();
			System.out.println(fromServer);

			// Free resources
			socketOutput.close();
			socketInput.close();
			socket.close();
			
		} catch ( IOException e ) {
			System.err.println( "I/0 exception during execution" );
			System.exit(1);
		}
	}

	public static void main( String[] args ) {
		Client c = new Client();
		c.auction( args );
	}
}
