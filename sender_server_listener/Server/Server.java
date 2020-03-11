package sender_server_listener.Server;

import sender_server_listener.Client.Client;
import sender_server_listener.Client.SenderClient;
import sender_server_listener.Util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public Map<String, Client> clientMap;
    private ServerSocket serverSocket;

    public Server() {
        this.clientMap = new HashMap<>();
        try {
            this.serverSocket = new ServerSocket(20000);
            System.out.println("Server is Running !");

            while (true){
                Socket socket = serverSocket.accept();
                NetworkUtil networkUtil = new NetworkUtil(socket);
                System.out.println("Accepted Client Socket:"+socket.getInetAddress().toString()+":"+socket.getPort());
                new ServerThread(networkUtil, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addClient(SenderClient client){
        clientMap.put(client.getUniqueName(), client);
    }

    public void removeClient(SenderClient client){
        clientMap.remove(client.getUniqueName());
    }

    public Client getClient(String uniqueName){
        return clientMap.get(uniqueName);
    }

    public static void main(String[] args) {
        new Server();
    }
}
