package server_program;

import util.NetworkUtil;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				// TODO: handle other type of objects
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
