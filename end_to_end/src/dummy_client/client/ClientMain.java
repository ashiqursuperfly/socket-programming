package dummy_client.client;

import tcp_c_2_c.server.User;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        try {
            //TODO: take server IP & port as input
            String serverAddress = "localhost";
            int serverPort = 20000;
            System.out.println("Looking for Server at:" + serverAddress + ":" + serverPort);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter User Name:");
            var name = sc.nextLine();
            System.out.println("Enter User Phone:");
            var phone = sc.nextLine();

            new Client(new User(name,phone), serverAddress, serverPort).initClientThreads();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
