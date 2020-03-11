package sender_server_listener.Util;

import java.io.Serializable;

public class Message implements Serializable {

    private String text;

    private static final long serialVersionUID = 203206L;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
