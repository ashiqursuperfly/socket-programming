package client;

import util.NetworkUtil;

public class Client {
	public static void main(String[] args) {
		try {
			String serverAddress = "localhost";
			int serverPort = 20000;
			System.out.println("Looking for Server at:" + serverAddress + ":" + serverPort);

			NetworkUtil nc = new NetworkUtil(serverAddress, serverPort);

			new ClientReadThread(nc);
			new ClientWriteThread(nc, "Client");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
