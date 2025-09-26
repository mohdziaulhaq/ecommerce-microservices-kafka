package org.ecom.commonutils.internal.apis.domain;

import org.springframework.http.HttpStatus;

public class ApiResponseMessage {
    private String message;
    private boolean success;
    private HttpStatus status;

    public ApiResponseMessage(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ApiResponseMessage() {
    }

    public static ApiResponseMessageBuilder builder() {
        return new ApiResponseMessageBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public static class ApiResponseMessageBuilder {
        private String message;
        private boolean success;
        private HttpStatus status;

        ApiResponseMessageBuilder() {
        }

        public ApiResponseMessageBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiResponseMessageBuilder success(boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseMessageBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponseMessage build() {
            return new ApiResponseMessage(this.message, this.success, this.status);
        }

        public String toString() {
            return "ApiResponseMessage.ApiResponseMessageBuilder(message=" + this.message + ", success=" + this.success + ", status=" + this.status + ")";
        }
    }
}
