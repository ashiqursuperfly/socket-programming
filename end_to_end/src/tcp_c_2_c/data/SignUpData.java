package tcp_c_2_c.data;

import java.io.Serializable;

public class SignUpData implements Serializable {

    public String userName,phoneNumber;

    private static final long serialVersionUID = 103115L;

    public SignUpData(String userName, String phoneNumber) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SignUpData{" +
                "userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
