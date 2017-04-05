package client;

/**
 * This Client connect to a Server (if it is up and running),
 * write a message to the server, reads a message from the server, which
 * is printed to the console, and closes the connection
 * 
 * @author Rick Mercer
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {

    try {
      // Connect to a Server and get the two streams from the server
      Socket server = new Socket("localhost", 4000);

      // Do some IO with the server
      ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
      ObjectInputStream input = new ObjectInputStream(server.getInputStream());

      
      // TODO: Add a loop that writes "Hello Server" to the Server
      // and then read from the server until the Server writes back Goodbye. 
      // Print whatever the Server writes, including the terminating String.

      
      // Close the connection to the server
      server.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
