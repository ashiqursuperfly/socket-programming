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
                if (o instanceof SignUpData) {
                	System.out.println("New User : " + o);
                    var signUpData = (SignUpData) o;
                    var u = new User(signUpData.userName, signUpData.phoneNumber);
                    Server.getInstance().addNewClient(generateUniqueId(u), new Client(u, clientNetworkUtil));

                } else if (o instanceof End2EndData) {
                    var endData = (End2EndData) o;
                    System.out.println("New End2EndData : " +o);
                    var destClient = Server.getInstance().getClient(endData.destinationPhone);
                    var srcClient = Server.getInstance().getClient(endData.sourcePhone);

                    if(destClient != null){
                        destClient.getNetworkUtil().writeUnshared(endData);
                        System.out.println("Sending data from "+srcClient.user.userName+" to "+destClient.user.userName);
                    }
					else System.out.println("No user logged in with phone"+endData.destinationPhone);

                } else {
                    System.out.println("Error Object Read");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            clientNetworkUtil.closeConnection();
        }
    }

    private String generateUniqueId(User u) {
        var id = u.phoneNo;
        System.out.println("Generated unique id for new client :" + id);
        return id;
    }
}
