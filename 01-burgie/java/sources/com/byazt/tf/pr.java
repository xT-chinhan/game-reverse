package com.byazt.tf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1049, 37})
public final class pr {
    public static volatile int hw;
    public static volatile hn pr;
    public static volatile WeakReference<com.byazt.nzn.x> uc;
    public static volatile long x;
    public static volatile long hn = 60000;
    public static volatile boolean c = false;
    public static final LinkedHashMap<String, c> fw = new LinkedHashMap<>();

    public interface hn {
        void pr(hw hwVar);
    }

    public static void pr(hn hnVar) {
        pr = hnVar;
    }

    public static void pr(int i, long j, boolean z) {
        c = z;
        hw = Math.max(i, 0);
        if (j <= 0) {
            j = 60000;
        }
        hn = j;
        if (!z) {
            pr();
            x = 0L;
            uc = null;
        }
    }

    public static boolean pr(Map<String, Object> map) {
        return c && map != null && hw(map);
    }

    public static void pr(Map<String, Object> map, Object obj, long j) {
        if (!pr(map)) {
            return;
        }
        try {
            hw(map, obj, j);
        } catch (Exception e) {
        }
    }

    public static boolean pr(int i, long j) {
        if (!c || i <= hw) {
            return false;
        }
        return x <= 0 || j - x >= hn;
    }

    public static void pr(int i, List<com.byazt.nzn.hw> list, List<com.byazt.nzn.hw> list2, long j) {
        try {
            hw hwVarPr = pr(hw(i, j), list, list2);
            hn hnVar = pr;
            if (hwVarPr != null && hnVar != null) {
                hnVar.pr(hwVarPr);
            }
        } catch (Exception e) {
        }
    }

    public static void pr(Object obj) {
        if (!(obj instanceof String)) {
            return;
        }
        try {
            hn((String) obj);
        } catch (Exception e) {
        }
    }

    public static void pr(com.byazt.nzn.x xVar) {
        if (!c || xVar == null) {
            return;
        }
        uc = new WeakReference<>(xVar);
    }

    public static int pr(String str) {
        WeakReference<com.byazt.nzn.x> weakReference = uc;
        com.byazt.nzn.x xVar = weakReference == null ? null : weakReference.get();
        if (!c || xVar == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return hw(xVar.hn(), hw(), str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean hw(String str) {
        WeakReference<com.byazt.nzn.x> weakReference = uc;
        com.byazt.nzn.x xVar = weakReference == null ? null : weakReference.get();
        if (!c || xVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return pr(xVar.hn(), hw(), str);
        } catch (Exception e) {
            return false;
        }
    }

    private static synchronized void hw(Map<String, Object> map, Object obj, long j) {
        if (obj instanceof String) {
            long jPr = pr(map.get("get_ads_request_ts"), j);
            fw.put((String) obj, new c(hn(map), jPr, hw(map.get("can_merge_same_rit_request"))));
        }
    }

    private static synchronized void hn(String str) {
        fw.remove(str);
    }

    private static synchronized x hw(int i, long j) {
        if (c && i > hw && pr(j)) {
            x xVar = new x(new HashMap(fw), i);
            x = j;
            return xVar;
        }
        return null;
    }

    private static synchronized void pr() {
        fw.clear();
    }

    private static synchronized Map<String, c> hw() {
        return new HashMap(fw);
    }

    private static hw pr(x xVar, List<com.byazt.nzn.hw> list, List<com.byazt.nzn.hw> list2) {
        if (xVar == null) {
            return null;
        }
        C0196pr c0196prPr = pr(list, (Map<String, c>) xVar.pr);
        C0196pr c0196prPr2 = pr(list2, (Map<String, c>) xVar.pr);
        return new hw(xVar.hw, c0196prPr.pr, c0196prPr.hn, c0196prPr.x, c0196prPr.hw, c0196prPr2.pr, c0196prPr2.hw);
    }

    private static boolean hw(Map<String, Object> map) {
        Object obj = map.get("is_get_ads");
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static String hn(Map<String, Object> map) {
        Object obj = map.get("get_ads_rit");
        if (!(obj instanceof String)) {
            return "unknown";
        }
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "unknown";
    }

    private static long pr(Object obj, long j) {
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return j;
    }

    private static boolean hw(Object obj) {
        return (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
    }

    private static boolean pr(List<com.byazt.nzn.hw> list, Map<String, c> map, String str) {
        c cVar;
        if (list == null || map == null) {
            return false;
        }
        Iterator<com.byazt.nzn.hw> it = list.iterator();
        while (it.hasNext()) {
            String strPr = pr(it.next());
            if (strPr != null && (cVar = map.get(strPr)) != null && str.equals(cVar.pr) && !cVar.hn) {
                return true;
            }
        }
        return false;
    }

    private static C0196pr pr(List<com.byazt.nzn.hw> list, Map<String, c> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list == null) {
            return new C0196pr(0, linkedHashMap, 0L, 0L);
        }
        Iterator<com.byazt.nzn.hw> it = list.iterator();
        int i = 0;
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            c cVarPr = pr(it.next(), map);
            if (cVarPr != null) {
                i++;
                pr((LinkedHashMap<String, Integer>) linkedHashMap, cVarPr.pr);
                long j3 = cVarPr.hw;
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
        return new C0196pr(i, linkedHashMap, j, j2);
    }

    private static int hw(List<com.byazt.nzn.hw> list, Map<String, c> map, String str) {
        int i = 0;
        if (list == null) {
            return 0;
        }
        Iterator<com.byazt.nzn.hw> it = list.iterator();
        while (it.hasNext()) {
            c cVarPr = pr(it.next(), map);
            if (cVarPr != null && str.equals(cVarPr.pr)) {
                i++;
            }
        }
        return i;
    }

    private static void pr(LinkedHashMap<String, Integer> linkedHashMap, String str) {
        Integer num = linkedHashMap.get(str);
        if (num != null) {
            linkedHashMap.put(str, Integer.valueOf(num.intValue() + 1));
        } else {
            linkedHashMap.put(str, 1);
        }
    }

    private static c pr(com.byazt.nzn.hw hwVar, Map<String, c> map) {
        if (map == null) {
            return null;
        }
        try {
            return map.get(pr(hwVar));
        } catch (Exception e) {
            return null;
        }
    }

    private static String pr(com.byazt.nzn.hw hwVar) {
        if (hwVar == null || hwVar.pr() == null || !(hwVar.pr().pr() instanceof String)) {
            return null;
        }
        return (String) hwVar.pr().pr();
    }

    private static boolean pr(long j) {
        return x <= 0 || j - x >= hn;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1049, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    public static final class hw {
        public final Map<String, Integer> c;
        public final Map<String, Integer> fw;
        public final long hn;
        public final int hw;
        public final int pr;
        public final int uc;
        public final long x;

        private hw(int i, int i2, long j, long j2, Map<String, Integer> map, int i3, Map<String, Integer> map2) {
            this.pr = i;
            this.hw = i2;
            this.hn = j;
            this.x = j2;
            this.c = Collections.unmodifiableMap(map);
            this.uc = i3;
            this.fw = Collections.unmodifiableMap(map2);
        }
    }

    /* JADX INFO: renamed from: com.byazt.tf.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1049, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0196pr {
        public final long hn;
        public final Map<String, Integer> hw;
        public final int pr;
        public final long x;

        private C0196pr(int i, Map<String, Integer> map, long j, long j2) {
            this.pr = i;
            this.hw = map;
            this.hn = j;
            this.x = j2;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1049, 100})
    private static final class x {
        public final int hw;
        public final Map<String, c> pr;

        private x(Map<String, c> map, int i) {
            this.pr = map;
            this.hw = i;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1049, 103})
    private static final class c {
        public final boolean hn;
        public final long hw;
        public final String pr;

        private c(String str, long j, boolean z) {
            this.pr = str;
            this.hw = j;
            this.hn = z;
        }
    }
}
