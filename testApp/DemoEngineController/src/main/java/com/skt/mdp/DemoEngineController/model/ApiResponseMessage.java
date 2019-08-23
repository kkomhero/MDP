package com.skt.mdp.DemoEngineController.model;

public class ApiResponseMessage {

    private String servieId;

    // HttpStatus
    private String status;
    // Http Default Message
    private String message;
    // Error Message to USER
    private String errorMessage;
    // Error Code
    private String errorCode;

    private String reusltPath;

    public ApiResponseMessage() {}
 
    public ApiResponseMessage(String servieId, String status, String message, String errorCode, String errorMessage, String resultPath) {
        this.servieId = servieId;
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.reusltPath = resultPath;
    }


    /**
     * @return String return the servieId
     */
    public String getServieId() {
        return servieId;
    }

    /**
     * @param servieId the servieId to set
     */
    public void setServieId(String servieId) {
        this.servieId = servieId;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return String return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return String return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getReusltPath() {
        return reusltPath;
    }

    public void setReusltPath(String reusltPath) {
        this.reusltPath = reusltPath;
    }


}