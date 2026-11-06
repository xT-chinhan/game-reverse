package com.tapsdk.tapad.exceptions;

/* JADX INFO: loaded from: classes2.dex */
public class ClientException extends RuntimeException {
    public long adId;
    public int code;
    public String message;
    public String requestId;

    public ClientException(String str) {
        super(str);
    }

    public ClientException(int i, String str) {
        super(str);
        this.code = i;
        this.message = str;
    }

    public ClientException(int i, String str, String str2, long j) {
        this(i, str);
        this.requestId = str2;
        this.adId = j;
    }
}
