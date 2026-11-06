package com.byazt.rd;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 896, 8})
public class s {
    public static Map<String, String> n(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL urlS = s(str);
        if (urlS == null) {
            return linkedHashMap;
        }
        try {
            String query = urlS.getQuery();
            if (query == null) {
                return linkedHashMap;
            }
            if (query.contains("url=")) {
                int iIndexOf = query.indexOf("url=");
                linkedHashMap.put(ImagesContract.URL, URLDecoder.decode(query.substring(iIndexOf + 4), "UTF-8"));
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
                            linkedHashMap.put(URLDecoder.decode(str2.substring(0, iIndexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i), "UTF-8"));
                        } else {
                            linkedHashMap.put(strSubstring, strSubstring2);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return linkedHashMap;
    }

    public static String n(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sbAppend = new StringBuilder(qg(str)).append("?");
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                        sbAppend.append(URLEncoder.encode(next.getKey(), "UTF-8") + "=" + URLEncoder.encode(next.getValue(), "UTF-8") + "&");
                    } else {
                        sbAppend.append(key + "=" + value + "&");
                    }
                } else if ("live_short_touch_params".equals(key) || "extra_pangle_scheme_params".equals(key)) {
                    sbAppend.append(URLEncoder.encode(next.getKey(), "UTF-8") + "=" + URLEncoder.encode(next.getValue(), "UTF-8"));
                } else {
                    sbAppend.append(key + "=" + value);
                }
            }
        } catch (Exception unused) {
        }
        return sbAppend.toString();
    }

    public static String qg(String str) {
        return str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
    }

    private static URL s(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL("http" + str.substring(str.indexOf("://")));
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
