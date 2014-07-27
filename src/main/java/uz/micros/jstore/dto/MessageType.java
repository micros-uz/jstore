package uz.micros.jstore.dto;

public enum MessageType {

    INFO,
    SUCCESS,
    WARNING,
    ERROR;

    private final String cssClass;

    private MessageType() {
        cssClass = name().toLowerCase();
    }

    public String getCssClass() {
        return cssClass;
    }
}