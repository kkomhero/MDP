package com.skt.mdp.FacePostExecutorSim.model;

import java.util.HashMap;
import java.util.concurrent.Future;

public class JobStatus {

    private Future<?>   future = null;
    private String      completeMessage = null;
    private String      mdpJobId = null;
    private boolean     isConfirm = false;
    private HashMap<String,String>  resultMap = new HashMap<>();

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

    public HashMap<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(HashMap<String, String> resultMap) {
        this.resultMap = resultMap;
    }
}
