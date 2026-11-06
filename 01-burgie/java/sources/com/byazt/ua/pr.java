package com.byazt.ua;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 37})
public final class pr {
    public static final Map<String, hw<C0204pr>> hn;
    public static volatile long hw;
    public static volatile long pr;
    public static final Map<String, hw<JSONArray>> x;

    static {
        int i = 16;
        float f = 0.75f;
        boolean z = false;
        hn = Collections.synchronizedMap(new LinkedHashMap<String, hw<C0204pr>>(i, f, z) { // from class: com.byazt.ua.pr.1
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, hw<C0204pr>> entry) {
                return size() > 256;
            }
        });
        x = Collections.synchronizedMap(new LinkedHashMap<String, hw<JSONArray>>(i, f, z) { // from class: com.byazt.ua.pr.2
            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, hw<JSONArray>> entry) {
                return size() > 256;
            }
        });
    }

    public static void pr(String str, C0204pr c0204pr) {
        if (str == null || c0204pr == null) {
            return;
        }
        hn.put(str, new hw<>(c0204pr, pr()));
        hw();
    }

    public static C0204pr pr(String str) {
        hw<C0204pr> hwVarRemove;
        if (str == null || (hwVarRemove = hn.remove(str)) == null || pr(hwVarRemove.hw, 300000L)) {
            return null;
        }
        return hwVarRemove.pr;
    }

    public static C0204pr hw(String str) {
        Map<String, hw<C0204pr>> map;
        hw<C0204pr> hwVar;
        if (str == null || (hwVar = (map = hn).get(str)) == null) {
            return null;
        }
        if (pr(hwVar.hw, 300000L)) {
            map.remove(str);
            return null;
        }
        return hwVar.pr;
    }

    public static void pr(String str, JSONArray jSONArray, String str2) {
        if (str == null) {
            return;
        }
        Map<String, hw<C0204pr>> map = hn;
        synchronized (map) {
            hw<C0204pr> hwVar = map.get(str);
            if (hwVar == null) {
                return;
            }
            if (pr(hwVar.hw, 300000L)) {
                map.remove(str);
                return;
            }
            C0204pr c0204pr = hwVar.pr;
            if (c0204pr == null) {
                return;
            }
            c0204pr.c = jSONArray;
            if (TextUtils.isEmpty(str2)) {
                str2 = " ";
            }
            c0204pr.uc = str2;
        }
    }

    public static void pr(String str, JSONArray jSONArray) {
        if (str == null || jSONArray == null) {
            return;
        }
        x.put(str, new hw<>(jSONArray, pr()));
        hn();
    }

    public static JSONArray hn(String str) {
        hw<JSONArray> hwVarRemove;
        if (str == null || (hwVarRemove = x.remove(str)) == null || pr(hwVarRemove.hw, 600000L)) {
            return null;
        }
        return hwVarRemove.pr;
    }

    private static long pr() {
        return System.currentTimeMillis();
    }

    private static boolean pr(long j, long j2) {
        return j2 > 0 && pr() - j >= j2;
    }

    private static void hw() {
        long jPr = pr();
        if (jPr - pr < 30000) {
            return;
        }
        pr = jPr;
        pr(hn, 300000L, jPr);
    }

    private static void hn() {
        long jPr = pr();
        if (jPr - hw < 30000) {
            return;
        }
        hw = jPr;
        pr(x, 600000L, jPr);
    }

    private static <T> void pr(Map<String, hw<T>> map, long j, long j2) {
        if (j <= 0) {
            return;
        }
        synchronized (map) {
            Iterator<Map.Entry<String, hw<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                hw<T> value = it.next().getValue();
                if (value == null || j2 - value.hw >= j) {
                    it.remove();
                }
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static final class hw<T> {
        public final long hw;
        public final T pr;

        public hw(T t, long j) {
            this.pr = t;
            this.hw = j;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ua.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static final class C0204pr {
        public JSONArray c;
        public final String fw;
        public final String hn;
        public final String hw;
        public final String pr;
        public String uc;
        public final Boolean x;

        public C0204pr(String str, String str2, String str3, Boolean bool, JSONArray jSONArray, String str4, String str5) {
            this.pr = TextUtils.isEmpty(str) ? " " : str;
            this.hw = TextUtils.isEmpty(str2) ? " " : str2;
            this.hn = TextUtils.isEmpty(str3) ? " " : str3;
            this.x = bool;
            this.c = jSONArray;
            this.uc = TextUtils.isEmpty(str4) ? " " : str4;
            this.fw = TextUtils.isEmpty(str5) ? " " : str5;
        }
    }
}
