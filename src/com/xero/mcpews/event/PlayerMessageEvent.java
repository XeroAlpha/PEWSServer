package com.xero.mcpews.event;

public class PlayerMessageEvent extends BaseEvent {
    public static final EventType TYPE = EventType.registerEventType("PlayerMessage", PlayerMessageEvent.class);

    public static final String MESSAGE_CHAT = "chat";
    public static final String MESSAGE_SAY = "say";

    private String Message;
    private String Sender;
    private String MessageType;

    public String getMessage() {
        return Message;
    }

    public String getSender() {
        return Sender;
    }

    public String getMessageType() {
        return MessageType;
    }

    @Override
    public EventType getType() {
        return TYPE;
    }
}
