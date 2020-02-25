package server;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private ServerSocket ServSock;

	Server() {
		try {
			int port = 20000;
			ServSock = new ServerSocket(port);
			System.out.println("Server is Running ! at port:" + port);
			while (true) {
				Socket clientSock = ServSock.accept();
				initiateCommunicationWithClient(clientSock);
			}
		} catch (Exception e) {
			System.out.println("Server couldn't start:" + e.toString());
		}
	}

	private void initiateCommunicationWithClient(Socket clientSocket){
		NetworkUtil nc = new NetworkUtil(clientSocket);
		new ServerWriteThread(nc, "Server"); // S --> C
		new ServerReadThread(nc); // C --> S
	}

	public static void main(String[] args) {
		new Server();
	}
}
