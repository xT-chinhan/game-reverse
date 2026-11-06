package com.byazt.ms;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 101})
public class fs {
    public static HttpURLConnection n(String str, Map<String, String> map) {
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
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? n(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> n(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static n n(String str, List<com.byazt.wm.s> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.byazt.wm.s sVar : list) {
                map.put(sVar.n(), sVar.qg());
            }
        }
        HttpURLConnection httpURLConnectionN = n(str, map);
        if (httpURLConnectionN == null || (responseCode = httpURLConnectionN.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapN = n(httpURLConnectionN);
        InputStream inputStream = httpURLConnectionN.getInputStream();
        String contentEncoding = httpURLConnectionN.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new n(inputStream, mapN, responseCode, httpURLConnectionN);
    }

    @com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static class n {
        public InputStream n;
        public HttpURLConnection q;
        public Map<String, String> qg;
        public int s;

        public n(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.n = inputStream;
            this.qg = map;
            this.s = i;
            this.q = httpURLConnection;
        }
    }
}
