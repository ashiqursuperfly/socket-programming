package tcp_c_2_c.client;

import tcp_c_2_c.server.User;
import util.NetworkUtil;

public class Client {

    private NetworkUtil networkUtil;
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
