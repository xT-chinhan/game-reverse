package com.byazt.asx;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bumptech.glide.load.Key;
import com.byazt.ec.TTEncryptUtils;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1211, 37})
public class pr {
    public static boolean hw = false;
    public static InterfaceC0017pr pr;

    /* JADX INFO: renamed from: com.byazt.asx.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0017pr {
        boolean hn();

        boolean hw();

        boolean pr();
    }

    public static String pr(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || pr == null || hw) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            pr(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            pr(linkedHashMap, linkedList, "device_id");
            pr(linkedHashMap, linkedList, an.ai);
            pr(linkedHashMap, linkedList, an.F);
            pr(linkedHashMap, linkedList, "uuid");
            pr(linkedHashMap, linkedList, "openudid");
            String strPr = pr((List<Pair<String, List<String>>>) linkedList, false, Key.STRING_CHARSET_NAME);
            if (TextUtils.isEmpty(strPr)) {
                return str;
            }
            byte[] bytes = strPr.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (pr.pr()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (pr.hw() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", pr(strEncodeToString, Key.STRING_CHARSET_NAME)));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return pr(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), pr((List<Pair<String, List<String>>>) linkedList2, true, Key.STRING_CHARSET_NAME), uri.getFragment()).toString();
        } catch (Throwable th) {
            return str;
        }
    }

    private static boolean pr(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (!pr.hn()) {
            map.remove(str);
            return true;
        }
        return true;
    }

    public static void pr(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split("&")) {
                        int iIndexOf = str.indexOf("=");
                        if (iIndexOf >= 0) {
                            String strDecode = URLDecoder.decode(str.substring(0, iIndexOf), Key.STRING_CHARSET_NAME);
                            List<String> linkedList = map.get(strDecode);
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            linkedList.add(URLDecoder.decode(str.substring(iIndexOf + 1), Key.STRING_CHARSET_NAME));
                            map.put(strDecode, linkedList);
                        } else {
                            String strDecode2 = URLDecoder.decode(str, Key.STRING_CHARSET_NAME);
                            List<String> linkedList2 = map.get(strDecode2);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            linkedList2.add("");
                            map.put(strDecode2, linkedList2);
                        }
                    }
                }
            } catch (Throwable th) {
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static Uri pr(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String pr(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String strPr = (String) pair.first;
            if (z) {
                strPr = pr((String) pair.first, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strPr2 : list2) {
                    if (z) {
                        strPr2 = strPr2 != null ? pr(strPr2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strPr);
                    sb.append("=");
                    sb.append(strPr2);
                }
            }
        }
        return sb.toString();
    }

    private static String pr(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
