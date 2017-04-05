package server;

/**
 * This server waits for one connection, reads the Clients message, which is 
 * printed to a console, writes a message to the Client, and closes the connection.
 * 
 * @author Rick Mercer
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {

    try {
      // Create a ServerSocket and wait for a Client to connect
      ServerSocket server = new ServerSocket(4000);
      Socket connection = server.accept();
      // Make both connection steams available 
      ObjectOutputStream output = new ObjectOutputStream(connection.getOutputStream());
      ObjectInputStream input = new ObjectInputStream(connection.getInputStream());
      
      // TODO: Add a loop that reads from one connected client and
      // write backs "Hello Client".  Write back Goodbye to terminate
      // both the client and server.  Print whatever the Client writes.
      while(true){
      	output.write("GoodBye");
	server.close();
      }
      
      // Close the connection
      connection.close();
    } catch (IOException e) {
    }
  }
}
