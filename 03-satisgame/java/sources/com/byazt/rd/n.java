package com.byazt.rd;

import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.eau.l;
import com.byazt.qp.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 896, 19})
public final class n {
    public static AtomicBoolean qg = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> n = new ConcurrentHashMap();

    private n() {
    }

    /* JADX INFO: renamed from: com.byazt.rd.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 896, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0321n {
        public static final l n = x.qg("tt_scheme_check_list_cache");
    }

    public static void n(String str, Boolean bool) {
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
        jSONObject.put(e.a.d, string);
        jSONObject.put("time", System.currentTimeMillis());
        C0321n.n.n(str, jSONObject.toString());
        qg.set(true);
    }

    public static Map<String, Boolean> n(long j) {
        try {
            if (qg.get()) {
                synchronized (n.class) {
                    if (qg.get()) {
                        Map<String, Boolean> mapQg = qg(j);
                        qg.set(false);
                        return mapQg;
                    }
                }
            }
            return new HashMap(n);
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public static Map<String, Boolean> qg(long j) {
        HashMap map = new HashMap();
        try {
            Map all = C0321n.n.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String str = (String) entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        n(str);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get(e.a.d).toString())));
                    }
                }
                if (n == null) {
                    n = new ConcurrentHashMap();
                } else {
                    n.clear();
                }
                n.putAll(map);
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public static Boolean n(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectQg = qg(str);
            if (jSONObjectQg == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectQg.getLong("time") <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectQg.getString(e.a.d)));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void n(String str) {
        C0321n.n.n(str);
    }

    private static JSONObject qg(String str) {
        String strQg = C0321n.n.qg(str, "");
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        try {
            return new JSONObject(strQg);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String n(Uri uri) {
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
