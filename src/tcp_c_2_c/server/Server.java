package tcp_c_2_c.server;

import tcp_c_2_c.client.Client;
import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server implements C2CServerInterface {

    private Map<String, Client> clientsMap;
    private ServerSocket serverSocket;
    private static Server instance = new Server();

    private Server() {
        clientsMap = new HashMap<>();
        try {
            int port = 20000;
            serverSocket = new ServerSocket(port);
            System.out.println("Server is Running ! at port:" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                var nc = new NetworkUtil(clientSocket);
                System.out.println("Accepted Client Socket:"+clientSocket.getInetAddress().toString()+":"+clientSocket.getPort());
                new ServerThread(nc);
            }
        } catch (Exception e) {
            System.out.println("Server couldn't start:" + e.toString());
        }
    }

    public static Server getInstance() {
        return instance;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void addNewClient(String id, Client c){
        clientsMap.put(id, c);
    }

    @Override
    public void removeClient(String id){
        clientsMap.remove(id);
    }

    @Override
    public Client getClient(String id) {
        return clientsMap.get(id);
    }

    public static void main(String[] args) { }

}
