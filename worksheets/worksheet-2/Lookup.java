//
// Very simple class that uses java.net.InetAddress to convert a hostname to an IP address.
// Compile as usual (i.e. javac Lookup.java), then run with:
//
// java Lookup <hostname>
//
// ... and you should get the IP address, or an error message. There are various ways
// of improving on this, such as checking the user provided a hostname, and perhaps
// looping over multiple hostnames if more than one was provided.

import java.io.IOException;
import java.net.*;	// For InetAddress and UnknownHostException.

public class Lookup {

	private InetAddress[] inet;

	public void resolve(String host) {
		try {
			// Try to create an instance of InetAddress using the factory method (public static).
			// If fails, may throw an instance of UnknownHostException.
			inet = InetAddress.getAllByName( host );

			// Use two getter methods to print the results. Can also just print the object itself (which combines both).
            for ( int i = 0; i < inet.length; i ++ ) {
                System.out.println( "Host name : " + inet[i].getHostName()    );
                System.out.println( "IP Address: " + inet[i].getHostAddress() );
                System.out.println( "Sending Ping Request to " + inet[i] );
                System.out.println( inet[i].isReachable( 10000 ) ? "Host is reachable" : "Host is not reachable" );
            }
		}
		catch( IOException e ) { 		// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}

	public static void main( String[] args ) {
		Lookup lookup = new Lookup();
		lookup.resolve( args[0] );				// The first command line argument is args[0].
	}
}

