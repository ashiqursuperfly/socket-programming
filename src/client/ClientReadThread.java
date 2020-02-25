package client;

import util.NetworkUtil;

public class ClientReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil nc;

    public ClientReadThread(NetworkUtil nc) {
        this.nc = nc;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) nc.read();
                if (s != null)
                    System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        nc.closeConnection();

    }
}
