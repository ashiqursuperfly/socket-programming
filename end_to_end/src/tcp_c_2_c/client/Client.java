package tcp_c_2_c.client;

import tcp_c_2_c.server.User;
import util.NetworkUtil;

import java.util.Objects;

public class Client {

    private NetworkUtil networkUtil;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(user, client.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    public User user;

    public Client(User user, String serverIp, int port) {
        this.networkUtil = new NetworkUtil(serverIp, port);
        this.user = user;
    }

    public Client(User user, NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.user = user;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void initClientThreads(){
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }
}
