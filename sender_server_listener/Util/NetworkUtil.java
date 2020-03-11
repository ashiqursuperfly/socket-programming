package sender_server_listener.Util;

import sender_server_listener.Client.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

public class NetworkUtil {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public NetworkUtil(String s, int port) {
        try {
            this.socket = new Socket(s, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In NetworkUtil : " + e.toString());
        }
    }

    public NetworkUtil(Socket s) {
        try {
            this.socket = s;
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In NetworkUtil : " + e.toString());
        }
    }

    public Object read() {
        Object o = null;
        try {
            o = ois.readUnshared(); // preferrable over readObject
        } catch (Exception e) {
//            System.out.println("Reading Error in network : " + e.toString());
        }
        return o;
    }

    public void write(Object o) {
        try {
            oos.writeUnshared(o); // preferrable over writeObject
        } catch (IOException e) {
            // System.out.println("Writing  Error in network : " + e.toString());
        }
    }

    public void writeWithErrorChance(Object o,NetworkUtil sender) {
        try {
            oos.writeUnshared(o); // preferrable over writeObject
            sender.write(1);
        } catch (IOException e) {
            // System.out.println("Writing  Error in network : " + e.toString());
            sender.write(0);
        }

    }

    public void closeConnection() {
        try {
            ois.close();
            oos.close();
            System.out.println("Closing Connection");
        } catch (Exception e) {
            System.out.println("Closing Error in network : " + e.toString());
        }
    }

    public Object readAsServer(Map<String, Client> clientMap) {
        Object o = null;
        try {
            o = ois.readUnshared(); // preferrable over readObject
        } catch (Exception e) {
            clientMap.remove("Listener");
        }
        return o;
    }
}

