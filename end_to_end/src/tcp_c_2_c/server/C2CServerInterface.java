package tcp_c_2_c.server;

import tcp_c_2_c.client.Client;

public interface C2CServerInterface {

    void addNewClient(String id, Client c);

    void removeClient(String id);

    Client getClient(String id);
}
