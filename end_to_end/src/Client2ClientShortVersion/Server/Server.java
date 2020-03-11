package Client2ClientShortVersion.Server;

import Client2ClientShortVersion.Client.Client;
import Client2ClientShortVersion.Util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private Map<String, Client> clientMap;
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

    public void addClient(Client client){
        clientMap.put(client.getUniqueName(), client);
    }

    public void removeClient(Client client){
        clientMap.remove(client.getUniqueName());
    }

    public Client getClient(String uniqueName){
        return clientMap.get(uniqueName);
    }

    public static void main(String[] args) {
        new Server();
    }
}
