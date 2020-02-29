package tcp_c_2_c.server;

import util.NetworkUtil;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server implements C2CServerInterface {

    private Map<String, User> clientsMap;
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
                System.out.println("Accepted Client Socket:"+clientSocket.getInetAddress().toString()+":"+clientSocket.getLocalPort());
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
    public void addNewUser(String id, User u){
        clientsMap.put(id, u);
    }

    @Override
    public void removeUser(String id){
        clientsMap.remove(id);
    }

    @Override
    public User getUser(String id) {
        return clientsMap.get(id);
    }

    public static void main(String[] args) { }

}
