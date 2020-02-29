package tcp_c_2_c.client;

import util.NetworkUtil;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        try {
            //TODO: take server IP & port as input
            String serverAddress = "10.15.221.72";
            int serverPort = 20000;
            System.out.println("Looking for Server at:" + serverAddress + ":" + serverPort);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter User Name:");
            var name = sc.nextLine();

            new Client(name, serverAddress, serverPort);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
