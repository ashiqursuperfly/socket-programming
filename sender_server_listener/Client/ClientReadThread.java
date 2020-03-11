package sender_server_listener.Client;

import sender_server_listener.Util.Message;

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
                    if (object instanceof Integer){
                        System.out.println("Status:"+object);
                    }
                    else if (object instanceof Message){
                        System.out.println("Message from Sender:"+object.toString());
                    }
                    else System.out.println("Invalid Server Response");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        client.getNc().closeConnection();

    }
}
