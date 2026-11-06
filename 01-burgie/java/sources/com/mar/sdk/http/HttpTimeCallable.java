package com.mar.sdk.http;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTimeCallable implements Callable<Long> {
    private final HttpTime httpTime;

    public HttpTimeCallable(HttpTime httpTime) {
        this.httpTime = httpTime;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Long call() throws Exception {
        return Long.valueOf(this.httpTime.time());
    }
}
