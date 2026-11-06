package com.mar.sdk.http;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class HttpGetRequest implements HttpRequest {
    private String header;
    private HttpListener listener;
    private Map<String, String> params;
    private String url;

    @Override // com.mar.sdk.http.HttpRequest
    public void url(String url) {
        this.url = url;
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void header(String header) {
        this.header = header;
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(Map<String, String> params) {
        this.params = params;
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void params(String json) {
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void setListener(HttpListener listener) {
        this.listener = listener;
    }

    @Override // com.mar.sdk.http.HttpRequest
    public void execute() throws Throwable {
        final String result;
        if (TextUtils.isEmpty(this.header)) {
            result = HttpConnect.getRequest(this.url, this.params);
        } else {
            result = HttpConnect.getRequest(this.url, this.header, this.params);
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.mar.sdk.http.HttpGetRequest.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(result)) {
                    HttpGetRequest.this.listener.onFail();
                } else {
                    HttpGetRequest.this.listener.onSuccess(result);
                }
            }
        });
    }

    @Override // com.mar.sdk.http.HttpRequest
    public String call() {
        return TextUtils.isEmpty(this.header) ? HttpConnect.getRequest(this.url, this.params) : HttpConnect.getRequest(this.url, this.header, this.params);
    }
}
