package com.sms.studentManagement.exception;

import java.time.LocalDateTime;

public class ApiResponse {

    private String message;
    private int status;
    private LocalDateTime timeStamp;


    public ApiResponse() {
    }

    public ApiResponse(String message, int status, LocalDateTime timeStamp) {
        this.message = message;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
