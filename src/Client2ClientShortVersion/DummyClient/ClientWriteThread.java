package Client2ClientShortVersion.DummyClient;

import Client2ClientShortVersion.Util.Message;

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
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Enter name of the person you want to text :");
                String name = scanner.nextLine();
                System.out.println("Enter message :");
                String message = scanner.nextLine();
                client.getNc().write(new Message(client.getUniqueName(), name, message));
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
