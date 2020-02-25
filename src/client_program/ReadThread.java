package client_program;

import java.io.*;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;

	public static void writeFile(String fileRelPath, String data) throws Exception {
		File file = new File(fileRelPath);
		BufferedWriter buffer = new BufferedWriter(
				new FileWriter(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
		buffer.write(data);
		buffer.close();
		System.out.println("Success writing to client container");
	}

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			String s = (String) nc.read();
			if (s != null) {
				System.out.println(s);
				writeFile("dataOut.txt", s);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		nc.closeConnection();
	}
}
