package Client2ClientShortVersion.DummyClient;

import Client2ClientShortVersion.Util.NetworkUtil;

import java.util.Objects;
import java.util.Scanner;

public class Client {
    private NetworkUtil nc;
    private String uniqueName;

    public Client(String uniqueName, String serverIP, int serverPort) {
        this.uniqueName = uniqueName;
        this.nc = new NetworkUtil(serverIP, serverPort);
    }
    public void clientThreadInit(){
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }

    public Client(String uniqueName, NetworkUtil nc) {
        this.uniqueName = uniqueName;
        this.nc = nc;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(uniqueName, client.uniqueName);
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

            new Client(name, "localhost", 20000).clientThreadInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
