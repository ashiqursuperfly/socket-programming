package tcp_c_2_c.server;

import java.util.Objects;

public class User {
    public String userName;
    public String phoneNo;

    public User(String userName,String phoneNo) {
        this.phoneNo = phoneNo;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(phoneNo, user.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, phoneNo);
    }
}
