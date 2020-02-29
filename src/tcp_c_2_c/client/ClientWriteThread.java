package tcp_c_2_c.client;

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
			client.getNetworkUtil().writeUnshared(new SignUpData(client.getUserName()));

			Scanner input = new Scanner(System.in);
			while (true) {
				while (input.hasNextLine()) {
					String s = input.nextLine();
					//TODO:
					client.getNetworkUtil().write(client.getUserName() + ":" + s);
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		client.getNetworkUtil().closeConnection();
	}
}
