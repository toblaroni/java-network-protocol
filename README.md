# COMP2221 - Networks
## Worksheets
In COMP2221 worksheets I learnt clients and servers interact and how to create my own in Java. We also learnt how to use threads so the server can handle multiple clients at the same time.

## Coursework (30%)
In the coursework we had to design and develop a client and multi-threaded server application to solve the specified problem.
### Specification
Create a client and server for a simple online auction system that allows users to list all items currently in the auction, add new items and make bids on existing items.

**Server Requirements**
- Run continuosly
- Use an Executor to manage a fixed thread-pool with 30 connections
- Store all items in the auction, and the current bid for each item if at least one bid has been accepted for that item
- Accepted bids should also store the IP address of the client that made the bid.
- When a client attempts to add a new item, the message `Failure` should be returned if an item with the same name (case sensitive) already exists, otherwise `Success` is returned.
- If a client makes a bid for an item, the message `Failure` should be returned if the item doesn't exist on the server, or if the bid price is zero or a negative number.
- Otherwise, the message `Accepted` should be returned if the new bid exceeded the old bid, and `Rejected` otherwise.
- Create the file **log.txt** on the server directory and log every valid client request, with one line per request, in the following format: <br>
`date|time|client IP address|request` <br>
Nothing else should be output to the log file.

**Client Requirements**
- Accept one of the following commands as command line arguments, and perform the stated task in confunction with the server:
  - `show` -> Displays a table containing all items in the auction, with columns for the item name, current bid, and the IP address of the client that made the bid, if at least one bid has been accepted.
  - `item <string>` -> Adds a new item to the auction with a bid price of zero, meaning no bid has been made.
  - `bid <item> <value> -> Attempts to make a bid of <value> for the item <item>.
- Quits after each command.

The server should listen to a port number in the range 6000 to 6999. All code should adhere to the Java coding standards.

The purpose of this coursework was to assess our grasp of networking in Java. For my implementation I received 29/30 marks.
