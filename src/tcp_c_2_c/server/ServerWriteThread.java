package tcp_c_2_c.server;

import util.NetworkUtil;

import java.util.Scanner;

public class ServerWriteThread implements Runnable {

	private Thread thr;
	private NetworkUtil nc;
	private String name;

	public ServerWriteThread(NetworkUtil nc, String name) {
		this.nc = nc;
		this.name = name;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			Scanner input = new Scanner(System.in);
			while (true) {
				while (input.hasNextLine()) {
					String s = input.nextLine();
					nc.write(name + ":" + s);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		nc.closeConnection();
	}
}
