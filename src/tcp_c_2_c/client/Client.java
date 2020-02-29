package tcp_c_2_c.client;

import util.NetworkUtil;

public class Client {

    private NetworkUtil networkUtil;
    private String userName;

    public Client(String userName, String serverIp, int port) {
        this.networkUtil = new NetworkUtil(serverIp, port);
        this.userName = userName;
        new ClientReadThread(this);
        new ClientWriteThread(this);
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
