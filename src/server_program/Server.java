package server_program;

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

				System.out.println("Accepted Client Socket");
				NetworkUtil nc = new NetworkUtil(clientSock);
				new ReadThread(nc);
				new WriteThread(nc, "Server");

			}
		} catch (Exception e) {
			System.out.println("Server couldnt start:" + e.toString());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.out.println("C-args:" + args.length);
		Server objServer = new Server();
	}
}
