package com.example.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    private static final CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("Користувач підключився: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("Отримано повідомлення: " + message);
        // Відправляємо відповідь назад
        for (Session s : sessions) {
            if (s.isOpen()) {
                s.getAsyncRemote().sendText("Сервер отримав: " + message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.println("Користувач відключився: " + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Помилка: " + throwable.getMessage());
    }
}
