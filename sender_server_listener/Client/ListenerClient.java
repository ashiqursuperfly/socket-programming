package sender_server_listener.Client;

import sender_server_listener.Util.NetworkUtil;

import java.util.Objects;

public class ListenerClient implements Client {
    private NetworkUtil nc;
    private String uniqueName;

    public ListenerClient(String uniqueName, String serverIP, int serverPort) {
        this.uniqueName = uniqueName;
        this.nc = new NetworkUtil(serverIP, serverPort);
    }
    public void clientThreadInit(){
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }



    public ListenerClient(String uniqueName, NetworkUtil nc) {
        this.uniqueName = uniqueName;
        this.nc = nc;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListenerClient client = (ListenerClient) o;
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
            new ListenerClient("Listener", "localhost", 20000).clientThreadInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
