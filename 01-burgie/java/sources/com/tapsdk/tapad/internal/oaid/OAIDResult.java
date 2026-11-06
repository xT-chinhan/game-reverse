package com.tapsdk.tapad.internal.oaid;

import com.tapsdk.tapad.internal.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class OAIDResult {
    private String message;
    private int responseCode;

    public static class Builder {
        int responseCode = -1;
        String message = Constants.OAIDErrorMessage.UNKNOWN;

        public OAIDResult build() {
            return new OAIDResult(this);
        }

        public Builder withMessage(String str) {
            this.message = str;
            return this;
        }

        public Builder withResponseCode(int i) {
            this.responseCode = i;
            return this;
        }
    }

    public String getMessage() {
        return this.message;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResponseCode(int i) {
        this.responseCode = i;
    }

    private OAIDResult(Builder builder) {
        this.responseCode = builder.responseCode;
        this.message = builder.message;
    }
}
