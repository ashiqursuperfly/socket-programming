package tcp_c_2_c.data;

import java.io.Serializable;

public class SignUpData implements Serializable {

    private static final long serialVersionUID = 103115L;

    public String userName;

    public SignUpData(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SignUpData{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
