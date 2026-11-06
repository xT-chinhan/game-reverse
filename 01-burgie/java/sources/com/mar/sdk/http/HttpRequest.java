package com.mar.sdk.http;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpRequest {
    String call();

    void execute();

    void header(String str);

    void params(String str);

    void params(Map<String, String> map);

    void setListener(HttpListener httpListener);

    void url(String str);
}
