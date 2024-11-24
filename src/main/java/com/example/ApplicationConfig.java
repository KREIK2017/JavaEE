package com.example;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api") // Базовий шлях для всіх REST-запитів
public class ApplicationConfig extends Application {
    // Конфігурація REST API
}
