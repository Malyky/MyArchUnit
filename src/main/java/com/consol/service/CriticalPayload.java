package com.consol.service;

public class CriticalPayload {

    @Payload
    private int myPayload;

    public int getMyPayload() {
        return myPayload;
    }

    public void setMyPayload(int myPayload) {
        this.myPayload = myPayload;
    }
}


