package com.skt.mdp.DemoEngineController.model;

import java.util.concurrent.Future;

public class JobStatus {

    private Future<?>   future = null;
    private String      completeMessage = null;
    private String      mdpJobId = null;
    private boolean     isConfirm = false;

    public boolean isConfirm() {
        return isConfirm;
    }

    public void setConfirm(boolean confirm) {
        isConfirm = confirm;
    }

    public Future<?> getFuture() {
        return future;
    }

    public void setFuture(Future<?> future) {
        this.future = future;
    }

    public String getCompleteMessage() {
        return completeMessage;
    }

    public void setCompleteMessage(String completeMessage) {
        this.completeMessage = completeMessage;
    }

    public String getMdpJobId() {
        return mdpJobId;
    }

    public void setMdpJobId(String mdpJobId) {
        this.mdpJobId = mdpJobId;
    }
}
