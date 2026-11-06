package com.smartdigimkt.sdk.api;

import com.smartdigimkt.f.i;

/* JADX INFO: loaded from: classes3.dex */
public class AdError {
    private String code;
    private String message;

    public AdError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public String getCode() {
        return this.code;
    }

    public String getErrorInfo() {
        return i.a(new StringBuilder("{code='").append(this.code).append("', message='"), this.message, "'}");
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return i.a(new StringBuilder("AdError{code='").append(this.code).append("', message='"), this.message, "'}");
    }
}
