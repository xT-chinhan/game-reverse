package com.tapsdk.tapad.internal.tracker.experiment.i;

import com.tapsdk.tapad.internal.tracker.experiment.entities.ExpTrackMessage;
import com.tapsdk.tapad.internal.tracker.experiment.h.d;
import com.tapsdk.tapad.internal.tracker.experiment.h.e;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class c implements a {
    public static final int a = 10;
    public static final int b = 10000;
    static final Map<String, Map<String, AtomicInteger>> c;
    static final Map<String, List<String>> d;

    static {
        HashMap map = new HashMap();
        c = map;
        HashMap map2 = new HashMap();
        d = map2;
        map.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.l, new HashMap());
        map.put(com.tapsdk.tapad.internal.tracker.experiment.h.a.i, new HashMap());
        map.put(d.g, new HashMap());
        map.put("internal_web_view_exception", new HashMap());
        map.put(e.n, new HashMap());
        map2.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.l, Arrays.asList("track_id", "code"));
        map2.put(com.tapsdk.tapad.internal.tracker.experiment.h.a.i, Arrays.asList("space_id", "code"));
        map2.put(d.g, Arrays.asList("space_id", "track_id", "code"));
        map2.put("internal_web_view_exception", Arrays.asList("track_id"));
        map2.put(e.n, Arrays.asList("space_id", "url"));
    }

    private String a(Map<String, String> map) {
        String str;
        String str2 = map.get("category");
        if (str2 != null && str2.length() != 0) {
            Map<String, List<String>> map2 = d;
            if (map2.containsKey(str2)) {
                List<String> list = map2.get(str2);
                StringBuilder sb = new StringBuilder();
                if (list == null) {
                    return "";
                }
                for (int i = 0; i < list.size(); i++) {
                    String str3 = list.get(i);
                    if (str3 == null || str3.length() == 0 || !map.containsKey(str3) || (str = map.get(str3)) == null || str.length() == 0) {
                        return "";
                    }
                    if (sb.length() == 0) {
                        sb.append(str);
                    } else {
                        sb.append("_").append(str);
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }

    private Map<String, AtomicInteger> a(String str) {
        Map<String, Map<String, AtomicInteger>> map = c;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return null;
    }

    private int b(Map<String, String> map) {
        int i;
        if (!map.containsKey("sample_ratio")) {
            return 10;
        }
        try {
            String str = map.get("sample_ratio");
            if (str == null || str.length() <= 0 || (i = Integer.parseInt(str)) < 0 || i > 100) {
                return 10;
            }
            return i;
        } catch (Throwable unused) {
            return 10;
        }
    }

    @Override // com.tapsdk.tapad.internal.tracker.experiment.i.a
    public boolean a(ExpTrackMessage expTrackMessage) {
        Map<String, String> map = expTrackMessage.logContentsMap;
        if (map == null) {
            return false;
        }
        Map<String, AtomicInteger> mapA = a(map.containsKey("category") ? map.get("category") : "");
        if (mapA == null) {
            return false;
        }
        String strA = a(map);
        int iB = b(map);
        if (iB == 0) {
            return false;
        }
        if (mapA.size() > 10000) {
            mapA.clear();
        }
        if (strA.length() > 0 && !mapA.containsKey(strA)) {
            mapA.put(strA, new AtomicInteger(1));
            return true;
        }
        AtomicInteger atomicInteger = mapA.get(strA);
        if (iB > 100) {
            return false;
        }
        int i = 100 / iB;
        if (atomicInteger == null) {
            return false;
        }
        int iIncrementAndGet = atomicInteger.incrementAndGet();
        if (i == 0) {
            return false;
        }
        return 1 == i || iIncrementAndGet % i == 1;
    }
}
