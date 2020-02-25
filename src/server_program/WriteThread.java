package server_program;

import util.NetworkUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteThread implements Runnable {

	private String readFile(String fileRelPath) throws Exception {
		File file = new File(fileRelPath);

		BufferedReader br = new BufferedReader(
				new FileReader(new File("").getAbsolutePath() + System.getProperty("file.separator") + file));
		StringBuilder sb = new StringBuilder();
		String st;
		while ((st = br.readLine()) != null)
			sb.append(st);

		br.close();
		return sb.toString();
	}

	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThread(NetworkUtil nc, String name) {
		this.nc = nc;
		this.name = name;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date date = new Date();
					String s = readFile("data.txt");
					nc.write(name + ":" + formatter.format(date) + ":" + s);
					Thread.sleep(3000);

				} catch (Exception e) {
					nc.write(name + ":" + null);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		nc.closeConnection();
	}
}
