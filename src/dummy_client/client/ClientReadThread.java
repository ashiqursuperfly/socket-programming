package dummy_client.client;

import tcp_c_2_c.data.End2EndData;

public class ClientReadThread implements Runnable {
    private Thread thr;
    private Client client;

    public ClientReadThread(Client client) {
        this.client = client;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                var o = client.getNetworkUtil().read();
                if(o != null) {
                    if (o instanceof End2EndData) {
                        System.out.println((End2EndData) o);
                    } else {
                        System.out.println("Error Object Read " + o);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        client.getNetworkUtil().closeConnection();

    }
}
