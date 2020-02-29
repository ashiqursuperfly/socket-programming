package tcp_c_2_c.server;

import tcp_c_2_c.client.Client;
import tcp_c_2_c.data.End2EndData;
import tcp_c_2_c.data.SignUpData;
import util.NetworkUtil;

public class ServerThread implements Runnable {
	private Thread thr;
	private NetworkUtil clientNetworkUtil;

	public ServerThread(NetworkUtil clientNetworkUtil) {
		this.clientNetworkUtil = clientNetworkUtil;
		this.thr = new Thread(this);
		thr.start();
	}

	public void run() {
		try {
			while (true) {
				Object o = clientNetworkUtil.read();
				if (o instanceof SignUpData){
					System.out.println("New User : "+ o);
					var signUpData = (SignUpData) o;
					Server.getInstance().addNewUser(generateUniqueId() , new User(signUpData.userName));
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
			clientNetworkUtil.closeConnection();
		}
	}

	private String generateUniqueId() {
		var id = clientNetworkUtil.getSocket().getInetAddress().toString() + clientNetworkUtil.getSocket().getPort();
		System.out.println("Generated unique id for new client :"+id);
		return id;
	}
}
