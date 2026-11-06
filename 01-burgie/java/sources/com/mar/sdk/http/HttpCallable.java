package com.mar.sdk.http;

import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public class HttpCallable implements Callable<String> {
    private final HttpRequest httpRequest;

    public HttpCallable(String url, Map<String, String> params, HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.httpRequest.url(url);
        this.httpRequest.params(params);
    }

    public HttpCallable(String url, String header, Map<String, String> params, HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.httpRequest.url(url);
        this.httpRequest.header(header);
        this.httpRequest.params(params);
    }

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        return this.httpRequest.call();
    }
}
