package com.example.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MessageBean implements Serializable {

    private String message; // Текст для відправлення
    private String lastMessage; // Останнє отримане повідомлення

    @Inject
    private MessageSender messageSender;

    @Inject
    private MessageReceiver messageReceiver;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void sendMessage() {
        try {
            messageSender.sendMessage(message);
            lastMessage = "Повідомлення надіслано: " + message;
        } catch (Exception e) {
            lastMessage = "Помилка відправлення повідомлення.";
            e.printStackTrace();
        }
    }

    public void receiveMessage() {
        try {
            String received = messageReceiver.receiveMessage();
            lastMessage = received != null ? "Отримано повідомлення: " + received : "Черга порожня.";
        } catch (Exception e) {
            lastMessage = "Помилка отримання повідомлення.";
            e.printStackTrace();
        }
    }
}
