package com.mar.sdk.http;

import com.mar.sdk.log.Log;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTask implements Runnable {
    private final HttpRequest httpRequest;

    public HttpTask(String url, Map<String, String> params, HttpRequest httpRequest, HttpListener listener) {
        this.httpRequest = httpRequest;
        this.httpRequest.url(url);
        this.httpRequest.params(params);
        this.httpRequest.setListener(listener);
    }

    public HttpTask(String url, String header, Map<String, String> params, HttpRequest httpRequest, HttpListener listener) {
        this.httpRequest = httpRequest;
        this.httpRequest.url(url);
        this.httpRequest.header(header);
        this.httpRequest.params(params);
        this.httpRequest.setListener(listener);
    }

    public HttpTask(String url, String header, String json, HttpRequest httpRequest, HttpListener listener) {
        this.httpRequest = httpRequest;
        this.httpRequest.url(url);
        this.httpRequest.header(header);
        this.httpRequest.params(json);
        this.httpRequest.setListener(listener);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.httpRequest == null) {
            Log.d("MARSDK-HttpTask", "http task is null");
        } else {
            this.httpRequest.execute();
        }
    }
}
