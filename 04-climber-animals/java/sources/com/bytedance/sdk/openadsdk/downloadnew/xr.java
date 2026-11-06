package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static HttpURLConnection ms(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? ms(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> ms(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static ms ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.socialbase.downloader.model.ah ahVar : list) {
                map.put(ahVar.ms(), ahVar.xr());
            }
        }
        HttpURLConnection httpURLConnectionMs = ms(str, map);
        if (httpURLConnectionMs == null || (responseCode = httpURLConnectionMs.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapMs = ms(httpURLConnectionMs);
        InputStream inputStream = httpURLConnectionMs.getInputStream();
        String contentEncoding = httpURLConnectionMs.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(Constants.CP_GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new ms(inputStream, mapMs, responseCode, httpURLConnectionMs);
    }

    public static class ms {
        public int ah;
        public HttpURLConnection d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public InputStream f3915ms;
        public Map<String, String> xr;

        public ms(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.f3915ms = inputStream;
            this.xr = map;
            this.ah = i;
            this.d = httpURLConnection;
        }
    }
}
