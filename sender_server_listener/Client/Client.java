package sender_server_listener.Client;

import sender_server_listener.Util.NetworkUtil;

public interface Client {
    NetworkUtil getNc();

    String getUniqueName();
}
