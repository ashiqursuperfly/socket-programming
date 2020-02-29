package tcp_c_2_c.server;

import tcp_c_2_c.client.Client;

public interface C2CServerInterface {
    void addNewUser(String id, User u);

    void removeUser(String id);

    User getUser(String id);
}
