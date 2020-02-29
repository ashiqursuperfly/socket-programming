package dummy_client.client;

import tcp_c_2_c.data.End2EndData;
import tcp_c_2_c.data.SignUpData;

import java.util.Scanner;

public class ClientWriteThread implements Runnable {

    private Thread thr;
    private Client client;

    public ClientWriteThread(Client client) {
        this.client = client;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {

        try {
            client.getNetworkUtil().write(new SignUpData(client.user.userName, client.user.phoneNo));

            Scanner input = new Scanner(System.in);
            while (true) {

                    System.out.println("Enter Unique Phone Number(to whom you want to send):");
                    String dest = input.nextLine();
                    System.out.println("Enter Message:");
                    String msg = input.nextLine();

                    client.getNetworkUtil().write(new End2EndData(client.user.phoneNo, dest, msg));

            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        client.getNetworkUtil().closeConnection();
    }
}
