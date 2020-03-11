package sender_server_listener.Client;

import sender_server_listener.Util.Message;

import java.util.Scanner;

public class ClientWriteThread implements Runnable{
    private Thread thread;
    private Client client;

    public ClientWriteThread(Client client) {
        this.client = client;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            client.getNc().write(client.getUniqueName());

            if(client.getUniqueName().equals("Sender")) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter message :");
                    String message = scanner.nextLine();
                    client.getNc().write(new Message(message));
                }
            }
            else {
                System.out.println("Listening:");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
