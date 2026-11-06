package com.mar.sdk.http;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpOnlineCheck implements HttpCheck {
    private String url;

    @Override // com.mar.sdk.http.HttpCheck
    public boolean executeCheck() {
        return HttpConnect.check(this.url);
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void url(String url) {
        this.url = url;
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void header(String header) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(Map<String, String> params) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(String json) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void setListener(HttpListener listener) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void execute() {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public String call() {
        return null;
    }
}
