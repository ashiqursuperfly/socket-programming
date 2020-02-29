package tcp_c_2_c.server;

import tcp_c_2_c.data.End2EndData;
import tcp_c_2_c.data.SignUpData;
import util.NetworkUtil;

public class ServerThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ServerThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				Object o = nc.read();
				if (o instanceof SignUpData){
					//TODO: add to map
					System.out.println("New User : "+ o);
				}
				else if (o instanceof End2EndData){
					//TODO: convey to end client
				}
				else {
					System.out.println("Error Object Read");
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			nc.closeConnection();
		}
	}
}
