import java.util.ArrayList;
import java.util.Arrays;


public class AuctionProtocol {
    // Array list of string arrays
    // Items will be stored as [item, bid, IP]
    ArrayList<String[]> items = new ArrayList<String[]>();
    private String request, IP;
    private String[]reqArr;

    public AuctionProtocol( String request, String IP, ArrayList<String[]> items ) {
        this.request = request;
        this.IP = IP;
        this.reqArr = request.split(" ");
        this.items = items;

    }

    private String show() {

        if ( items.size() == 0 ) {
            return "There are currently no items in this auction.";
        }
        
        StringBuilder retStr = new StringBuilder();

        // Loop throught the items and add them to the stringbuilder
        for ( int i = 0; i < items.size(); ++i ) {
            // Add the string as <item> : <bid> : <IP>
            retStr.append( items.get(i)[0] );  // Item
            retStr.append( " : " );
            retStr.append( items.get(i)[1] );  // Bid
            retStr.append( " : " );
            retStr.append( items.get(i)[2] );  // Bidder
            retStr.append( "\n" );  // Bidder
        }

        System.out.println(retStr);
        return retStr.toString(); // Return the stringbuilder as a string

    }

    
    private String addItem() {
        if ( reqArr.length != 2 ) {
            return "Error: Usage 'item <string>'";
        }

        String itemName = reqArr[1];

        // Check the item doesn't already exist
        for ( int i = 0; i < items.size(); ++i ) {
            if ( items.get(i)[0].equals(itemName) ) {
                return "Failure";
            }
        }

        // Add the item to items
        String[] item = { itemName, "0.0", IP };
        items.add( item ); 

        return "Success";
    }

    
    public String processRequest() {

        // If the request is show call the show() function
        if ( request.equalsIgnoreCase("show") )
            return show();

        // For item <string> we want to add the item to the array list and return success / failure
        if ( reqArr[0].equalsIgnoreCase("item") )
            return addItem();

        // For bid <item> <value> we want to update the current bid and return accepted or rejected

        return "Failure";

    }
}
