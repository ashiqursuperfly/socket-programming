package client_program;

import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		try {
			String serverAddress = "localhost";
			int serverPort = 20000;
			System.out.println("Looking for Server at:" + serverAddress + ":" + serverPort);

			NetworkUtil nc = new NetworkUtil(serverAddress, serverPort);

			new ReadThread(nc);
			new WriteThread(nc, "Client");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
