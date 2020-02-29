package tcp_c_2_c.data;

import java.io.Serializable;

public class End2EndData implements Serializable {

    private static final long serialVersionUID = 103115L;

    public String sourceIp,destinationIp,message;

    public End2EndData(String sourceIp, String destinationIp, String message) {
        this.sourceIp = sourceIp;
        this.destinationIp = destinationIp;
        this.message = message;
    }

    @Override
    public String toString() {
        return "End2EndData{" +
                "sourceIp='" + sourceIp + '\'' +
                ", destinationIp='" + destinationIp + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
