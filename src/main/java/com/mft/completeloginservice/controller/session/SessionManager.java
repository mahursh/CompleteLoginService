package com.mft.completeloginservice.controller.session;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SessionManager {
    public static Map<HttpSession, Session> sessionMap= new HashMap<>();


    public static void addHttpSession(HttpSession httpSession){

        sessionMap.put(httpSession,null);
    }

    public static void addWebSocketSession(HttpSession httpSession , Session session){
        sessionMap.put(httpSession,session);
    }

    public static boolean validateHttpSession(HttpSession httpSession){

        return sessionMap.containsKey(httpSession);
    }

    public static boolean validateWebSocketSession(Session session){

        return sessionMap.containsValue(session);
    }
    public static Session getWebSocketSession(HttpSession httpSession){
        return  sessionMap.get(httpSession);
    }

    public static Set<HttpSession> getHttpSession(){

        return sessionMap.keySet();
    }

    public static Collection<Session> getWebSocketSessions(){
        return sessionMap.values();
    }

    public static Map<HttpSession , Session> getSessionMap(){
        return sessionMap;
    }
}
