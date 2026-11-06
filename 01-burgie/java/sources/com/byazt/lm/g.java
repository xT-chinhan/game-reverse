package com.byazt.lm;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.vzx.pr(pr = {0, 1, 572, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public static HttpURLConnection pr(String str, Map<String, String> map) {
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
                if ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) {
                    return pr(httpURLConnection2.getHeaderField("Location"), map);
                }
                return httpURLConnection2;
            } catch (Exception e) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception e2) {
        }
    }

    public static Map<String, String> pr(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i = 0; i < size; i++) {
            map.put(httpURLConnection.getHeaderFieldKey(i), httpURLConnection.getHeaderField(i));
        }
        return map;
    }

    public static pr pr(String str, List<com.byazt.auw.hn> list) throws IOException {
        int responseCode;
        HashMap map = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (com.byazt.auw.hn hnVar : list) {
                map.put(hnVar.pr(), hnVar.hw());
            }
        }
        HttpURLConnection httpURLConnectionPr = pr(str, map);
        if (httpURLConnectionPr == null || (responseCode = httpURLConnectionPr.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> mapPr = pr(httpURLConnectionPr);
        InputStream inputStream = httpURLConnectionPr.getInputStream();
        String contentEncoding = httpURLConnectionPr.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains(Constants.CP_GZIP)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new pr(inputStream, mapPr, responseCode, httpURLConnectionPr);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS})
    public static class pr {
        public int hn;
        public Map<String, String> hw;
        public InputStream pr;
        public HttpURLConnection x;

        public pr(InputStream inputStream, Map<String, String> map, int i, HttpURLConnection httpURLConnection) {
            this.pr = inputStream;
            this.hw = map;
            this.hn = i;
            this.x = httpURLConnection;
        }
    }
}
