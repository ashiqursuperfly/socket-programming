package tcp_c_2_c.client;

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
                String s = (String) client.getNetworkUtil().read();
                if (s != null)
                    System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        client.getNetworkUtil().closeConnection();

    }
}
