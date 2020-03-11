package Client2ClientShortVersion.Util;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String receiver;
    private String text;

    private static final long serialVersionUID = 103106L;
    public Message(String sender, String receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return sender + " : " + text;
    }
}
