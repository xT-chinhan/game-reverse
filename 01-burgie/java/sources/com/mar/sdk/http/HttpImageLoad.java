package com.mar.sdk.http;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpImageLoad implements HttpImage {
    private String url;

    @Override // com.mar.sdk.http.HttpImage
    public Bitmap load() {
        return HttpConnect.getBitmap(this.url);
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
