package server;

import util.NetworkUtil;

public class ServerReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ServerReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				String s = (String) nc.read();
				if (s != null)
					System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		nc.closeConnection();
	}
}
