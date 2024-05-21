package com.mft.completeloginservice.controller.session;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener(value = "listener")
public class SessionListener implements HttpSessionListener {
    private static long online;
    private static long visited;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created");
        System.out.println("Online  : "+  ++online);
        System.out.println("Visited : "+  ++visited);

        HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroyed");
        System.out.println("Online  : "+  --online);

        HttpSessionListener.super.sessionDestroyed(se);
    }
}
