package Client2ClientShortVersion.Server;

import Client2ClientShortVersion.Client.Client;
import Client2ClientShortVersion.Util.Message;
import Client2ClientShortVersion.Util.NetworkUtil;

public class ServerThread implements Runnable{
    private Thread thread;
    private NetworkUtil clientnc;
    private Server server;

    public ServerThread(NetworkUtil clientnc, Server server) {
        this.clientnc = clientnc;
        this.server = server;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            while (true){
                Object object = clientnc.read();
                if (object != null){
                    if (object instanceof String){
                        System.out.println("New Client. Name : "+ object.toString());
                        server.addClient(new Client(object.toString(), clientnc));
                    }
                    else if (object instanceof Message){
                        Message message = (Message) object;
                        Client receiver = server.getClient(message.getReceiver());
                        if (receiver==null) System.out.println("Receiver not found");
                        else {
                            receiver.getNc().write(message);
                            System.out.println(message.getSender() + " to " + message.getReceiver() + " : " + message.getText());
                        }
                    }
                    else System.out.println("Invalid message");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            clientnc.closeConnection();
        }

    }
}
