package com.byazt.phf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1735, 19})
public final class n {
    public static final LinkedHashMap<String, l> fs = new LinkedHashMap<>();
    public static volatile boolean l = false;
    public static volatile s n = null;
    public static volatile long q = 0;
    public static volatile int qg = 0;
    public static volatile long s = 60000;
    public static volatile boolean w = false;
    public static volatile WeakReference<com.byazt.tbt.q> x;

    public interface s {
        void n(qg qgVar);
    }

    public static void n(s sVar) {
        n = sVar;
    }

    public static void n(int i, long j, boolean z) {
        l = z;
        qg = Math.max(i, 0);
        if (j <= 0) {
            j = 60000;
        }
        s = j;
        if (z) {
            return;
        }
        qg();
        q = 0L;
        x = null;
    }

    public static void n(boolean z) {
        w = z;
    }

    public static boolean n() {
        return w;
    }

    public static boolean n(Map<String, Object> map) {
        return l && map != null && s(map);
    }

    public static String qg(Map<String, Object> map) {
        if (w && map != null && s(map)) {
            Object obj = map.get("get_ads_rit");
            if (obj instanceof String) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public static void n(Map<String, Object> map, Object obj, long j) {
        if (n(map)) {
            try {
                qg(map, obj, j);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean n(int i, long j) {
        if (!l || i <= qg) {
            return false;
        }
        return q <= 0 || j - q >= s;
    }

    public static void n(int i, List<com.byazt.tbt.qg> list, List<com.byazt.tbt.qg> list2, long j) {
        try {
            qg qgVarN = n(qg(i, j), list, list2);
            s sVar = n;
            if (qgVarN == null || sVar == null) {
                return;
            }
            sVar.n(qgVarN);
        } catch (Exception unused) {
        }
    }

    public static void n(Object obj) {
        if (obj instanceof String) {
            try {
                s((String) obj);
            } catch (Exception unused) {
            }
        }
    }

    public static void n(com.byazt.tbt.q qVar) {
        if (!l || qVar == null) {
            return;
        }
        x = new WeakReference<>(qVar);
    }

    public static int n(String str) {
        WeakReference<com.byazt.tbt.q> weakReference = x;
        com.byazt.tbt.q qVar = weakReference == null ? null : weakReference.get();
        if (l && qVar != null && !TextUtils.isEmpty(str)) {
            try {
                return qg(qVar.s(), s(), str);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static boolean qg(String str) {
        WeakReference<com.byazt.tbt.q> weakReference = x;
        com.byazt.tbt.q qVar = weakReference == null ? null : weakReference.get();
        if (l && qVar != null && !TextUtils.isEmpty(str)) {
            try {
                return n(qVar.s(), s(), str);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private static synchronized void qg(Map<String, Object> map, Object obj, long j) {
        if (obj instanceof String) {
            long jN = n(map.get("get_ads_request_ts"), j);
            fs.put((String) obj, new l(q(map), jN, qg(map.get("can_merge_same_rit_request"))));
        }
    }

    private static synchronized void s(String str) {
        fs.remove(str);
    }

    private static synchronized q qg(int i, long j) {
        if (l && i > qg && n(j)) {
            q qVar = new q(new HashMap(fs), i);
            q = j;
            return qVar;
        }
        return null;
    }

    private static synchronized void qg() {
        fs.clear();
    }

    private static synchronized Map<String, l> s() {
        return new HashMap(fs);
    }

    private static qg n(q qVar, List<com.byazt.tbt.qg> list, List<com.byazt.tbt.qg> list2) {
        if (qVar == null) {
            return null;
        }
        C0295n c0295nN = n(list, (Map<String, l>) qVar.n);
        C0295n c0295nN2 = n(list2, (Map<String, l>) qVar.n);
        return new qg(qVar.qg, c0295nN.n, c0295nN.s, c0295nN.q, c0295nN.qg, c0295nN2.n, c0295nN2.qg);
    }

    private static boolean s(Map<String, Object> map) {
        Object obj = map.get("is_get_ads");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static String q(Map<String, Object> map) {
        Object obj = map.get("get_ads_rit");
        if (!(obj instanceof String)) {
            return "unknown";
        }
        String str = (String) obj;
        return !TextUtils.isEmpty(str) ? str : "unknown";
    }

    private static long n(Object obj, long j) {
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    private static boolean qg(Object obj) {
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static boolean n(List<com.byazt.tbt.qg> list, Map<String, l> map, String str) {
        l lVar;
        if (list != null && map != null) {
            Iterator<com.byazt.tbt.qg> it = list.iterator();
            while (it.hasNext()) {
                String strN = n(it.next());
                if (strN != null && (lVar = map.get(strN)) != null && str.equals(lVar.n) && !lVar.s) {
                    return true;
                }
            }
        }
        return false;
    }

    private static C0295n n(List<com.byazt.tbt.qg> list, Map<String, l> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null) {
            return new C0295n(0, linkedHashMap, 0L, 0L);
        }
        Iterator<com.byazt.tbt.qg> it = list.iterator();
        int i = 0;
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            l lVarN = n(it.next(), map);
            if (lVarN != null) {
                i++;
                n((LinkedHashMap<String, Integer>) linkedHashMap, lVarN.n);
                long j3 = lVarN.qg;
                if (j3 > 0) {
                    if (j <= 0 || j3 < j) {
                        j = j3;
                    }
                    if (j3 > j2) {
                        j2 = j3;
                    }
                }
            }
        }
        return new C0295n(i, linkedHashMap, j, j2);
    }

    private static int qg(List<com.byazt.tbt.qg> list, Map<String, l> map, String str) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        Iterator<com.byazt.tbt.qg> it = list.iterator();
        while (it.hasNext()) {
            l lVarN = n(it.next(), map);
            if (lVarN != null && str.equals(lVarN.n)) {
                i++;
            }
        }
        return i;
    }

    private static void n(LinkedHashMap<String, Integer> linkedHashMap, String str) {
        Integer num = linkedHashMap.get(str);
        if (num != null) {
            linkedHashMap.put(str, Integer.valueOf(num.intValue() + 1));
        } else {
            linkedHashMap.put(str, 1);
        }
    }

    private static l n(com.byazt.tbt.qg qgVar, Map<String, l> map) {
        if (map == null) {
            return null;
        }
        try {
            return map.get(n(qgVar));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String n(com.byazt.tbt.qg qgVar) {
        if (qgVar == null || qgVar.n() == null || !(qgVar.n().n() instanceof String)) {
            return null;
        }
        return (String) qgVar.n().n();
    }

    private static boolean n(long j) {
        return q <= 0 || j - q >= s;
    }

    @com.byazt.cp.n(n = {0, 1, 1735, 226})
    public static final class qg {
        public final Map<String, Integer> l;
        public final int n;
        public final long q;
        public final int qg;
        public final long s;
        public final int w;
        public final Map<String, Integer> x;

        private qg(int i, int i2, long j, long j2, Map<String, Integer> map, int i3, Map<String, Integer> map2) {
            this.n = i;
            this.qg = i2;
            this.s = j;
            this.q = j2;
            this.l = Collections.unmodifiableMap(map);
            this.w = i3;
            this.x = Collections.unmodifiableMap(map2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.phf.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1735, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0295n {
        public final int n;
        public final long q;
        public final Map<String, Integer> qg;
        public final long s;

        private C0295n(int i, Map<String, Integer> map, long j, long j2) {
            this.n = i;
            this.qg = map;
            this.s = j;
            this.q = j2;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1735, 1125})
    private static final class q {
        public final Map<String, l> n;
        public final int qg;

        private q(Map<String, l> map, int i) {
            this.n = map;
            this.qg = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1735, 1705})
    private static final class l {
        public final String n;
        public final long qg;
        public final boolean s;

        private l(String str, long j, boolean z) {
            this.n = str;
            this.qg = j;
            this.s = z;
        }
    }
}
