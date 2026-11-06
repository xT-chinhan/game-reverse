package com.byazt.wt;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public final class b {
    public static AtomicBoolean hw = new AtomicBoolean(true);
    public static volatile Map<String, Boolean> pr = new ConcurrentHashMap();

    private b() {
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS})
    private static final class pr {
        public static final com.byazt.cr.c pr = com.byazt.zs.aj.hw("tt_scheme_check_list_cache");
    }

    public static void pr(String str, Boolean bool) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool == null) {
            string = "";
        } else {
            try {
                string = bool.toString();
            } catch (Throwable th) {
                return;
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.VALUE_FIELD, string);
        jSONObject.put("time", System.currentTimeMillis());
        pr.pr.pr(str, jSONObject.toString());
        hw.set(true);
    }

    public static Map<String, Boolean> pr(long j) {
        try {
            if (hw.get()) {
                synchronized (b.class) {
                    if (hw.get()) {
                        Map<String, Boolean> mapHw = hw(j);
                        hw.set(false);
                        return mapHw;
                    }
                }
            }
            return new HashMap(pr);
        } catch (Throwable th) {
            return new HashMap();
        }
    }

    public static Map<String, Boolean> hw(long j) {
        HashMap map = new HashMap();
        try {
            Map all = pr.pr.getAll();
            if (all != null && !all.isEmpty()) {
                for (Map.Entry entry : all.entrySet()) {
                    JSONObject jSONObject = new JSONObject(entry.getValue().toString());
                    long jCurrentTimeMillis = System.currentTimeMillis() - jSONObject.getLong("time");
                    String str = (String) entry.getKey();
                    if (jCurrentTimeMillis > 259200000) {
                        pr(str);
                    } else if (jCurrentTimeMillis <= j) {
                        map.put(str, Boolean.valueOf(Boolean.parseBoolean(jSONObject.get(Constants.VALUE_FIELD).toString())));
                    }
                }
                if (pr == null) {
                    pr = new ConcurrentHashMap();
                } else {
                    pr.clear();
                }
                pr.putAll(map);
                return map;
            }
            return map;
        } catch (Throwable th) {
        }
    }

    public static Boolean pr(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObjectHw = hw(str);
            if (jSONObjectHw == null) {
                return null;
            }
            if (System.currentTimeMillis() - jSONObjectHw.getLong("time") <= j) {
                return Boolean.valueOf(Boolean.parseBoolean(jSONObjectHw.getString(Constants.VALUE_FIELD)));
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static void pr(String str) {
        pr.pr.pr(str);
    }

    private static JSONObject hw(String str) {
        String strHw = pr.pr.hw(str, "");
        if (TextUtils.isEmpty(strHw)) {
            return null;
        }
        try {
            return new JSONObject(strHw);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String pr(Uri uri) {
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
