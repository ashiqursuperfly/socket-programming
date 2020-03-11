package sender_server_listener.Client;

import sender_server_listener.Util.NetworkUtil;

import java.util.Objects;

public class SenderClient implements Client {
    private NetworkUtil nc;
    private String uniqueName;

    public SenderClient(String uniqueName, String serverIP, int serverPort) {
        this.uniqueName = uniqueName;
        this.nc = new NetworkUtil(serverIP, serverPort);
    }
    public void clientThreadInit(){
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }

    public SenderClient(String uniqueName, NetworkUtil nc) {
        this.uniqueName = uniqueName;
        this.nc = nc;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SenderClient client = (SenderClient) o;
        return Objects.equals(uniqueName, client.uniqueName);
    }

    @Override
    public NetworkUtil getNc() {
        return nc;
    }

    @Override
    public String getUniqueName() {
        return uniqueName;
    }

    public static void main(String[] args) {
        try {

            new SenderClient("Sender", "localhost", 20000).clientThreadInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
