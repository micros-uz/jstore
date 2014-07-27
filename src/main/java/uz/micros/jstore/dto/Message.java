package uz.micros.jstore.dto;

public final class Message {

    private final MessageType type;

    private final String text;

    public Message(MessageType type, String text) {
        this.type = type;
        this.text = text;
    }

    public MessageType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return type + ": " + text;
    }

}