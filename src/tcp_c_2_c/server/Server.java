package tcp_c_2_c.server;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    private Server() {
        try {
            int port = 20000;
            serverSocket = new ServerSocket(port);
            System.out.println("Server is Running ! at port:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                var nc = new NetworkUtil(clientSocket);
                new ServerThread(nc);
            }
        } catch (Exception e) {
            System.out.println("Server couldn't start:" + e.toString());
        }
    }

    public static void main(String[] args) {
        new Server();
    }


}
