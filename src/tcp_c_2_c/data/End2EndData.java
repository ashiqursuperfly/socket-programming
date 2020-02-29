package tcp_c_2_c.data;

import java.io.Serializable;

public class End2EndData implements Serializable {

    private static final long serialVersionUID = 103115L;

    public String sourcePhone, destinationPhone, message;

    public End2EndData(String sourcePhone, String destinationPhone, String message) {
        this.sourcePhone = sourcePhone;
        this.destinationPhone = destinationPhone;
        this.message = message;
    }

    @Override
    public String toString() {
        return "End2EndData{" +
                "sourcePhone='" + sourcePhone + '\'' +
                ", destinationPhone='" + destinationPhone + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
