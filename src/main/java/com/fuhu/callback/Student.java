package com.fuhu.callback;

public class Student {
    private  int id;
    private  String name;
    Callback callbackHandler;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void notifyOther() {
        if (callbackHandler != null) {
            callbackHandler.onCompletion("hello", "world");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Callback getCallbackHandler() {
        return callbackHandler;
    }

    public void setCallbackHandler(Callback callbackHandler) {
        this.callbackHandler = callbackHandler;
    }
	
}
