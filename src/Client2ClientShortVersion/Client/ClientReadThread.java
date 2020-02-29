package Client2ClientShortVersion.Client;

import Client2ClientShortVersion.Util.Message;

public class ClientReadThread implements Runnable{
    private Thread thread;
    private Client client;

    public ClientReadThread(Client client) {
        this.thread = new Thread(this);
        this.client = client;
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true){
                Object object = client.getNc().read();
                if (object != null){
                    if (object instanceof Message){
                        System.out.println(object);
                    }
                    else System.out.println("Invalid message");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        client.getNc().closeConnection();

    }
}
