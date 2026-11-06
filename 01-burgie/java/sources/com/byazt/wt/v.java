package com.byazt.wt;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS})
public class v {
    public static Map<String, String> pr(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL urlHn = hn(str);
        if (urlHn == null) {
            return linkedHashMap;
        }
        try {
            String query = urlHn.getQuery();
            if (query == null) {
                return linkedHashMap;
            }
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                linkedHashMap.put(BreakpointSQLiteKey.URL, URLDecoder.decode(query.substring(iIndexOf + 4), Key.STRING_CHARSET_NAME));
                query = query.substring(0, iIndexOf);
            }
            if (query.length() > 0) {
                for (String str2 : query.split("&")) {
                    int iIndexOf2 = str2.indexOf("=");
                    if (iIndexOf2 > 0 && iIndexOf2 < str2.length() - 1) {
                        String strSubstring = str2.substring(0, iIndexOf2);
                        int i = iIndexOf2 + 1;
                        String strSubstring2 = str2.substring(i);
                        if ("live_short_touch_params".equals(strSubstring) || "extra_pangle_scheme_params".equals(strSubstring)) {
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf2), Key.STRING_CHARSET_NAME), URLDecoder.decode(str2.substring(i), Key.STRING_CHARSET_NAME));
                        } else {
                            linkedHashMap.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return linkedHashMap;
    }

    public static String pr(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sbAppend = new StringBuilder(hw(str)).append("?");
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                        sbAppend.append(URLEncoder.encode(next.getKey(), Key.STRING_CHARSET_NAME) + "=" + URLEncoder.encode(next.getValue(), Key.STRING_CHARSET_NAME) + "&");
                    } else {
                        sbAppend.append(key + "=" + value + "&");
                    }
                } else if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                    sbAppend.append(URLEncoder.encode(next.getKey(), Key.STRING_CHARSET_NAME) + "=" + URLEncoder.encode(next.getValue(), Key.STRING_CHARSET_NAME));
                } else {
                    sbAppend.append(key + "=" + value);
                }
            }
        } catch (Exception e) {
        }
        return sbAppend.toString();
    }

    public static String hw(String str) {
        if (str.contains("?")) {
            return str.substring(0, str.indexOf("?"));
        }
        return str;
    }

    private static URL hn(String str) {
        if (str == null || str.length() == 0 || !str.contains("://")) {
            return null;
        }
        try {
            return new URL("http" + str.substring(str.indexOf("://")));
        } catch (Exception e) {
            return null;
        }
    }
}
