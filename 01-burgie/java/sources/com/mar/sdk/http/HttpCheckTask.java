package com.mar.sdk.http;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class HttpCheckTask implements Callable<Boolean> {
    private final HttpOnlineCheck onlineCheck;

    public HttpCheckTask(String url, HttpOnlineCheck onlineCheck) {
        this.onlineCheck = onlineCheck;
        this.onlineCheck.url(url);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        if (this.onlineCheck == null) {
            return false;
        }
        return Boolean.valueOf(this.onlineCheck.executeCheck());
    }
}
