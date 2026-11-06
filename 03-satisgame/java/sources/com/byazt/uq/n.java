package com.byazt.uq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 19})
public final class n {
    public static volatile long n;
    public static final Map<String, qg<C0367n>> qg = Collections.synchronizedMap(new LinkedHashMap<String, qg<C0367n>>(16, 0.75f, false) { // from class: com.byazt.uq.n.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, qg<C0367n>> entry) {
            return size() > 256;
        }
    });

    public static void n(String str, C0367n c0367n) {
        if (str == null || c0367n == null) {
            return;
        }
        qg.put(str, new qg<>(c0367n, n()));
        qg();
    }

    public static C0367n n(String str) {
        qg<C0367n> qgVarRemove;
        if (str == null || (qgVarRemove = qg.remove(str)) == null || n(qgVarRemove.qg, 300000L)) {
            return null;
        }
        return qgVarRemove.n;
    }

    public static C0367n qg(String str) {
        Map<String, qg<C0367n>> map;
        qg<C0367n> qgVar;
        if (str == null || (qgVar = (map = qg).get(str)) == null) {
            return null;
        }
        if (n(qgVar.qg, 300000L)) {
            map.remove(str);
            return null;
        }
        return qgVar.n;
    }

    private static long n() {
        return System.currentTimeMillis();
    }

    private static boolean n(long j, long j2) {
        return j2 > 0 && n() - j >= j2;
    }

    private static void qg() {
        long jN = n();
        if (jN - n < 30000) {
            return;
        }
        n = jN;
        n(qg, 300000L, jN);
    }

    private static <T> void n(Map<String, qg<T>> map, long j, long j2) {
        if (j <= 0) {
            return;
        }
        synchronized (map) {
            Iterator<Map.Entry<String, qg<T>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                qg<T> value = it.next().getValue();
                if (value == null || j2 - value.qg >= j) {
                    it.remove();
                }
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 226})
    private static final class qg<T> {
        public final T n;
        public final long qg;

        public qg(T t, long j) {
            this.n = t;
            this.qg = j;
        }
    }

    /* JADX INFO: renamed from: com.byazt.uq.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static final class C0367n {
        public final String l;
        public final String n;
        public final Boolean q;
        public final String qg;
        public final String s;
        public final int w;

        public C0367n(String str, String str2, String str3, Boolean bool, String str4, int i) {
            this.n = n.s(str);
            this.qg = n.s(str2);
            this.s = n.s(str3);
            this.q = bool;
            this.l = TextUtils.isEmpty(str4) ? " " : str4;
            this.w = i;
        }
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return " ";
        }
        int iIndexOf = str.indexOf(95);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length - 1];
        if (iIndexOf > 0) {
            str.getChars(0, iIndexOf, cArr, 0);
        }
        for (int i = iIndexOf + 1; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '_') {
                cArr[iIndexOf] = cCharAt;
                iIndexOf++;
            }
        }
        return iIndexOf == 0 ? " " : new String(cArr, 0, iIndexOf);
    }
}
