package Client2ClientShortVersion.Client;

import Client2ClientShortVersion.Util.NetworkUtil;

import java.util.Scanner;

public class Client {
    private NetworkUtil nc;
    private String uniqueName;

    public Client(String uniqueName, String serverIP, int serverPort) {
        this.uniqueName = uniqueName;
        this.nc = new NetworkUtil(serverIP, serverPort);
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }

    public Client(String uniqueName, NetworkUtil clientnc) {
        this.uniqueName = uniqueName;
        this.nc = clientnc;
    }

    public NetworkUtil getNc() {
        return nc;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public static void main(String[] args) {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Unique User Name:");
            String name = sc.nextLine();

            new Client(name, "localhost", 20000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
