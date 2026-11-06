package com.byazt.tw;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.byazt.km.TTEncryptUtils;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1494, 19})
public class n {
    public static InterfaceC0357n n = null;
    public static boolean qg = false;

    /* JADX INFO: renamed from: com.byazt.tw.n$n, reason: collision with other inner class name */
    public interface InterfaceC0357n {
        boolean n();

        boolean qg();

        boolean s();
    }

    public static String n(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || n == null || qg) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            n(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            n(linkedHashMap, linkedList, TapEventParamConstants.PARAM_DEVICE_ID);
            n(linkedHashMap, linkedList, "device_type");
            n(linkedHashMap, linkedList, "device_brand");
            n(linkedHashMap, linkedList, "uuid");
            n(linkedHashMap, linkedList, "openudid");
            String strN = n((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strN)) {
                return str;
            }
            byte[] bytes = strN.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (n.n()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (n.qg() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", n(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return n(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), n((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private static boolean n(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (n.s()) {
            return true;
        }
        map.remove(str);
        return true;
    }

    public static void n(Uri uri, Map<String, List<String>> map) throws IOException {
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
                            String strDecode = URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8");
                            List<String> linkedList = map.get(strDecode);
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            linkedList.add(URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                            map.put(strDecode, linkedList);
                        } else {
                            String strDecode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> linkedList2 = map.get(strDecode2);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            linkedList2.add("");
                            map.put(strDecode2, linkedList2);
                        }
                    }
                }
            } catch (Throwable unused) {
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static Uri n(String str, String str2, int i, String str3, String str4, String str5) {
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

    private static String n(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String strN = (String) pair.first;
            if (z) {
                strN = n((String) pair.first, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strN2 : list2) {
                    if (z) {
                        strN2 = strN2 != null ? n(strN2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(strN);
                    sb.append("=");
                    sb.append(strN2);
                }
            }
        }
        return sb.toString();
    }

    private static String n(String str, String str2) {
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
