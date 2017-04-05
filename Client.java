/*
 * Name: Scott Sorce 
 * Class: CS 335
 * SL: Bree Lubers
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args)
	{
		try {
			Socket server = new Socket("localhost", 6200);
			ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(server.getInputStream());
			Scanner keyboard = new Scanner(System.in);
			Object str = new Object();
			while (!str.toString().toLowerCase().equals("quit")) {
				System.out.print("Enter a message: ");
				str = keyboard.next();
				System.out.println(str.toString());
				output.writeObject(str);
				output.flush();
				try {
					str = input.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Hi client, you wrote: " + str);
			}
			server.close();
			output.close();
			input.close();
			keyboard.close();
			System.out.println("You entered the magic word");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
