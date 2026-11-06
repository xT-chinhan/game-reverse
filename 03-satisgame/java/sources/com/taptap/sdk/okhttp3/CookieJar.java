package com.taptap.sdk.okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: com.taptap.sdk.okhttp3.CookieJar.1
        @Override // com.taptap.sdk.okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        @Override // com.taptap.sdk.okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    };

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
