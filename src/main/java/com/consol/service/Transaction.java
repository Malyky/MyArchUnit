package com.consol.service;

public class Transaction {

    private CriticalPayload criticalPayload;

    @Secured
    public void securedWayToCall() {
        criticalPayload.getMyPayload();
    }


    public void notSecuredWay() {
        criticalPayload.getMyPayload();
    }
}
