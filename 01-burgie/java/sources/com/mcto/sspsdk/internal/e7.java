package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e7 {
    public static HttpURLConnection a(int i, String str, HashMap map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strC = gj.c(str);
        int iMax = Math.max(i, TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
        try {
            URL url = new URL(strC);
            String str2 = url.getProtocol() + "://" + url.getAuthority();
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection2.setConnectTimeout(iMax);
                httpURLConnection2.setRequestMethod(TapHttp.METHOD_GET);
                httpURLConnection2.setRequestProperty("Accept", "*/*");
                httpURLConnection2.setRequestProperty("User-Agent", y4.r.f());
                httpURLConnection2.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection2.setInstanceFollowRedirects(false);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                if ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) {
                    String headerField = httpURLConnection2.getHeaderField("Location");
                    if (headerField.startsWith("/")) {
                        headerField = str2 + headerField;
                    }
                    return a(5000, headerField, map);
                }
                return httpURLConnection2;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                r9.a("ssp_HttpUtils", "getConnection: ", th);
                return httpURLConnection;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
