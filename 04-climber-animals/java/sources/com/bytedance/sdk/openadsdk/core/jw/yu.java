package com.bytedance.sdk.openadsdk.core.jw;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class yu {
    private static AtomicBoolean xr = new AtomicBoolean(true);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile Map<String, Boolean> f2757ms = new ConcurrentHashMap();

    private yu() {
    }

    private static final class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final com.bytedance.sdk.component.d.ms.xr f2758ms;

        static {
            com.bytedance.sdk.component.d.ms.xr xrVarXr = com.bytedance.sdk.openadsdk.ats.ah.xr("tt_scheme_check_list_cache");
            f2758ms = xrVarXr;
            File fileAh = com.bytedance.sdk.openadsdk.ats.ah.ah("tt_scheme_check_list_cache");
            if (!fileAh.exists() || fileAh.length() <= 0) {
                return;
            }
            xrVarXr.ms(new com.bytedance.sdk.component.d.ms.xr.ms<Map<String, ?>>() { // from class: com.bytedance.sdk.openadsdk.core.jw.yu.ms.1
                @Override // com.bytedance.sdk.component.d.ms.xr.ms
                public void ms(Map<String, ?> map) {
                    Object obj;
                    boolean zContains = ms.f2758ms.contains(".i.tt_ect");
                    com.bytedance.sdk.component.utils.sl.xr("SchemeCacheUtils", "clear old cache! ");
                    if (zContains) {
                        return;
                    }
                    ms.f2758ms.ms();
                    com.bytedance.sdk.component.ab.ms.ms msVar = new com.bytedance.sdk.component.ab.ms.ms();
                    for (String str : map.keySet()) {
                        if (!str.contains("//") && (obj = map.get(str)) != null) {
                            String strValueOf = String.valueOf(msVar.xr(obj));
                            String str2 = (String) msVar.xr(str);
                            if (str2 != null && str2.contains("//")) {
                                try {
                                    ms.f2758ms.ms(yu.ms(Uri.parse(str2)), String.valueOf(new JSONObject(strValueOf).opt(str2)));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public static void ms(String str, Boolean bool) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            string = "";
        } else {
            try {
                string = bool.toString();
            } catch (Throwable unused) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(com.anythink.core.common.e.f.a.d, string);
        jSONObject.put("time", System.currentTimeMillis());
        ms.f2758ms.ms(str, jSONObject.toString());
        xr.set(true);
    }

    public static Map<String, Boolean> ms(long j) {
        try {
            if (xr.get()) {
                synchronized (yu.class) {
                    if (xr.get()) {
                        Map<String, Boolean> mapXr = xr(j);
                        xr.set(false);
                        return mapXr;
                    }
                }
            }
            return new HashMap(f2757ms);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public static Map<String, Boolean> xr(long j) {
        HashMap map = new HashMap();
        try {
            Map<String, ?> all = ms.f2758ms.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String key = entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        ms(key);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(key, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get(com.anythink.core.common.e.f.a.d).toString())));
                    }
                }
                if (f2757ms == null) {
                    f2757ms = new ConcurrentHashMap();
                } else {
                    f2757ms.clear();
                }
                f2757ms.putAll(map);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static Boolean ms(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectXr = xr(str);
            if (jSONObjectXr == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectXr.getLong("time") <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectXr.getString(com.anythink.core.common.e.f.a.d)));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void ms(String str) {
        ms.f2758ms.ms(str);
    }

    private static JSONObject xr(String str) {
        String strXr = ms.f2758ms.xr(str, "");
        if (TextUtils.isEmpty(strXr)) {
            return null;
        }
        try {
            return new JSONObject(strXr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String ms(Uri uri) {
        if (uri == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme()).append("://").append(uri.getHost());
        int port = uri.getPort();
        if (port > 0) {
            sb.append(":").append(port);
        }
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            sb.append(path);
        }
        return sb.toString();
    }
}
