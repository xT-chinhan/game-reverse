package com.tapsdk.tapad.internal.network.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tapsdk.tapad.model.entities.DynamicHeader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static Random a = new Random();

    public static Pair<Integer, String> a(com.tapsdk.tapad.internal.network.b.a aVar) {
        JSONObject jSONObject;
        String message;
        int i;
        int i2 = -1;
        try {
            jSONObject = new JSONObject(aVar.c);
            message = "";
            if (jSONObject.has("data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                i2 = jSONObject2.has("code") ? jSONObject2.getInt("code") : -1;
                message = jSONObject2.has("error_description") ? jSONObject2.getString("error_description") : "";
                if (message.length() == 0 && jSONObject2.has("msg")) {
                    message = jSONObject2.getString("msg");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            jSONObject = null;
            message = !TextUtils.isEmpty(aVar.getMessage()) ? aVar.getMessage() : e.getMessage();
        }
        if (jSONObject == null && (i = aVar.a) >= 400) {
            return new Pair<>(Integer.valueOf(i), aVar.c);
        }
        int i3 = aVar.a;
        if (i3 >= 400 && i2 == 0) {
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i2), message);
    }

    public static String a(String str, String str2, String str3) {
        try {
            return new Uri.Builder().scheme(str).authority(str2).path(str3).build().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, Map<String, Object> map) {
        Uri uri = Uri.parse(str);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder builderBuildUpon = Uri.parse(str2).buildUpon();
        for (String str3 : queryParameterNames) {
            if (map.containsKey(str3)) {
                builderBuildUpon.appendQueryParameter(str3, String.valueOf(map.get(str3)));
                map.remove(str3);
            } else {
                builderBuildUpon.appendQueryParameter(str3, uri.getQueryParameter(str3));
            }
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return builderBuildUpon.build().toString();
    }

    public static String a(String str, Map<String, String> map) {
        String str2;
        if (map == null || map.size() == 0) {
            return str;
        }
        Map<String, Object> mapA = a(str);
        Uri.Builder builderClearQuery = Uri.parse(str).buildUpon().clearQuery();
        for (Map.Entry<String, Object> entry : mapA.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!map.containsKey(key) || (str2 = map.get(key)) == null || str2.length() <= 0) {
                builderClearQuery.appendQueryParameter(key, String.valueOf(value));
            } else {
                builderClearQuery.appendQueryParameter(key, str2);
                map.remove(key);
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            String key2 = entry2.getKey();
            String value2 = entry2.getValue();
            if (key2 != null && key2.length() > 0 && value2 != null && value2.length() > 0) {
                builderClearQuery.appendQueryParameter(key2, value2);
            }
        }
        return builderClearQuery.build().toString();
    }

    public static String a(String str, boolean z, boolean z2, boolean z3) throws URISyntaxException {
        URI uri = new URI(str);
        return new URI(uri.getScheme(), uri.getAuthority(), z ? null : uri.getPath(), z2 ? null : uri.getQuery(), z3 ? null : uri.getFragment()).toString();
    }

    public static Map<String, Object> a(String str) {
        HashMap map = new HashMap();
        Uri uri = Uri.parse(str);
        for (String str2 : uri.getQueryParameterNames()) {
            String queryParameter = uri.getQueryParameter(str2);
            if (str2 != null && str2.length() > 0 && queryParameter != null && queryParameter.length() > 0) {
                map.put(str2, queryParameter);
            }
        }
        return map;
    }

    public static Map<String, String> a(List<DynamicHeader> list) {
        String string;
        String str;
        HashMap map = new HashMap();
        if (list == null) {
            return map;
        }
        for (int i = 0; i < list.size(); i++) {
            DynamicHeader dynamicHeader = list.get(i);
            int i2 = dynamicHeader.c;
            if (i2 == 0) {
                str = dynamicHeader.a;
                StringBuilder sb = new StringBuilder();
                List<String> list2 = dynamicHeader.b;
                if (list2 != null) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        String str2 = list2.get(i3);
                        if (str2 != null && str2.length() > 0) {
                            if (sb.length() > 0) {
                                sb.append(";");
                            }
                            sb.append(str2);
                        }
                    }
                }
                string = sb.toString();
            } else if (i2 == 1) {
                List<String> list3 = dynamicHeader.b;
                int iNextInt = (list3 == null || list3.size() <= 0) ? Integer.MAX_VALUE : new Random().nextInt(dynamicHeader.b.size());
                String str3 = dynamicHeader.a;
                List<String> list4 = dynamicHeader.b;
                if (list4 == null || list4.size() <= iNextInt || dynamicHeader.b.get(iNextInt) == null || dynamicHeader.b.get(iNextInt).length() <= 0) {
                    str = str3;
                    string = "";
                } else {
                    string = dynamicHeader.b.get(iNextInt);
                    str = str3;
                }
            } else {
                string = "";
                str = string;
            }
            if (str != null && str.length() > 0 && string != null && string.length() > 0) {
                map.put(str, string);
            }
        }
        return map;
    }

    public static String b(String str) {
        try {
            URL url = new URL(str);
            if (url.getRef() != null) {
                return url.getRef();
            }
        } catch (MalformedURLException unused) {
        }
        return "";
    }

    public static String b(String str, Map<String, Object> map) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return builderBuildUpon.build().toString();
    }

    public static String c(String str, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return str;
        }
        Map<String, Object> mapA = a(str);
        Uri.Builder builderClearQuery = Uri.parse(str).buildUpon().clearQuery();
        for (Map.Entry<String, Object> entry : mapA.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            builderClearQuery.appendQueryParameter(key, ((value instanceof String) && map.containsKey(String.valueOf(value))) ? map.get(value) : String.valueOf(value));
        }
        return builderClearQuery.build().toString();
    }

    public static boolean c(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("https");
    }

    public static String d(String str, Map<String, Object> map) {
        Uri uri = Uri.parse(str);
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (map == null || map.size() == 0) {
            return str;
        }
        Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
        for (String str2 : queryParameterNames) {
            if (map.containsKey(str2)) {
                builderClearQuery.appendQueryParameter(str2, String.valueOf(map.get(str2)));
                map.remove(str2);
            } else {
                builderClearQuery.appendQueryParameter(str2, uri.getQueryParameter(str2));
            }
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            builderClearQuery.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return builderClearQuery.build().toString();
    }
}
