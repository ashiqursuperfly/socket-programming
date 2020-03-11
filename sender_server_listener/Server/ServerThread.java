package sender_server_listener.Server;

import sender_server_listener.Client.Client;
import sender_server_listener.Client.SenderClient;
import sender_server_listener.Util.Message;
import sender_server_listener.Util.NetworkUtil;

public class ServerThread implements Runnable{
    private Thread thread;
    private NetworkUtil clientnc;
    private Server server;

    public ServerThread(NetworkUtil clientnc, Server server) {
        this.clientnc = clientnc;
        this.server = server;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (true){
                Object object = clientnc.readAsServer(server.clientMap);
                if (object != null) {
                    if (object instanceof String){
                        System.out.println("New Client: "+ object.toString());
                        if (server != null) {
                            var initMsg = (String)object;

                            if(initMsg.equals("Sender"))server.addClient(new SenderClient("Sender", clientnc));
                            else if(initMsg.equals("Listener"))server.addClient(new SenderClient("Listener",clientnc));
                            else System.out.println("Invalid Client Connecting");
                        }
                    }
                    else if (object instanceof Message){
                        Message message = (Message) object;
                        Client receiver = server.getClient("Listener");
                        if (receiver == null){
                            System.out.println("Receiver not found");
                            clientnc.write(0);
                        }
                        else {
                            System.out.println("Sending Msg to Listener: "+message.toString());
                            receiver.getNc().writeWithErrorChance(message,clientnc);
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
