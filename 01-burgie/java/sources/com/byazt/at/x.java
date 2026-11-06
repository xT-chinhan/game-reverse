package com.byazt.at;

import com.byazt.dd.nt;
import com.byazt.hy.c;
import com.byazt.vt.uc;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1003, 121})
public class x implements nt {
    public static volatile x hn;
    public static final List<String> pr = Arrays.asList("tap", "longTap", "touchStart", "touchEnd", "slide", "animateState", "Lottie://state");
    public static final Set<String> hw = new HashSet(Collections.singleton("Lottie://state"));
    public final List<hn> x = new CopyOnWriteArrayList();
    public final Map<String, hn> c = new ConcurrentHashMap();
    public final Map<String, com.byazt.mu.pr> uc = new ConcurrentHashMap();
    public final c fw = new c();

    public static x pr() {
        if (hn == null) {
            synchronized (x.class) {
                if (hn == null) {
                    hn = new x();
                }
            }
        }
        return hn;
    }

    private x() {
        pr(new com.byazt.vt.x());
        pr(new com.byazt.vt.hw());
        pr(new uc());
        pr(new com.byazt.vt.c());
        pr(new com.byazt.vt.hn());
        pr(new com.byazt.nh.pr());
        pr(new com.byazt.dh.pr());
    }

    public void pr(hn hnVar) {
        if (hnVar == null) {
            return;
        }
        this.x.add(hnVar);
        for (String str : pr) {
            if (hnVar.hw(str)) {
                this.c.put(str, hnVar);
            }
        }
    }

    @Override // com.byazt.dd.nt
    public boolean pr(String str, String str2) {
        if (str == null && (str2 == null || str2.isEmpty())) {
            return false;
        }
        if (str != null) {
            if (this.c.containsKey(str)) {
                return true;
            }
            Iterator<hn> it = this.x.iterator();
            while (it.hasNext()) {
                if (it.next().hw(str)) {
                    return true;
                }
            }
        }
        if (str2 != null && !str2.isEmpty() && !str2.equals(str)) {
            if (this.c.containsKey(str2)) {
                return true;
            }
            Iterator<hn> it2 = this.x.iterator();
            while (it2.hasNext()) {
                if (it2.next().hw(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.byazt.dd.nt
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String string = UUID.randomUUID().toString();
        hn hnVarHw = hw(str2);
        if (hnVarHw == null) {
            return false;
        }
        Map<String, Object> mapPr = pr(map2, pr(str2, map, map2));
        new StringBuilder("dispatch scenario=").append(str).append(" event=").append(str2).append(" monitor=").append(i).append(" payload=").append(map).append(" context=").append(mapPr);
        return hnVarHw.pr(str, str2, i, map, mapPr, hw(cVar, str2, string, pr(map2), jCurrentTimeMillis));
    }

    private hn hw(String str) {
        hn hnVar = this.c.get(str);
        if (hnVar != null) {
            return hnVar;
        }
        for (hn hnVar2 : this.x) {
            if (hnVar2.hw(str)) {
                this.c.put(str, hnVar2);
                return hnVar2;
            }
        }
        return null;
    }

    @Override // com.byazt.dd.nt
    public void pr(String str, String str2, String str3, Map<String, Object> map, com.byazt.dd.c cVar) {
        hn(str).pr(str2, str3, map, cVar);
    }

    @Override // com.byazt.dd.nt
    public void pr(String str, String str2, Map<String, Object> map) {
        hn hnVarHw = hw(str2);
        if (hnVarHw == null) {
            return;
        }
        List<com.byazt.mu.pr.C0137pr> listPr = pr(x(str), str2);
        if (listPr.isEmpty()) {
            return;
        }
        int iHw = com.byazt.wj.hw.hw();
        if (iHw > 0) {
            com.byazt.wk.pr.pr(com.byazt.wj.hw.hn(), str2, iHw);
        }
        com.byazt.hy.x xVarPr = this.fw.pr(str2);
        com.byazt.ki.hn hnVarPr = pr(str2, (Map<String, Object>) null, map);
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(com.byazt.ki.hn.class.getName(), hnVarPr);
        for (com.byazt.mu.pr.C0137pr c0137pr : listPr) {
            if (xVarPr.pr(c0137pr, map)) {
                String strPr = pr(c0137pr);
                String strPr2 = com.byazt.wj.pr.pr(str, strPr);
                if (strPr2 != null) {
                    com.byazt.wk.pr.pr(com.byazt.wj.hw.x(), com.byazt.wj.hw.hw(), strPr2);
                } else {
                    com.byazt.wj.hw.pr(strPr);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        String strX = c0137pr.x();
                        com.byazt.dd.c cVarHw = c0137pr.hw();
                        if (strX == null || strX.isEmpty()) {
                            strX = "ugen";
                        }
                        hnVarHw.pr(str, str2, c0137pr.hashCode(), c0137pr.pr(), map2, pr(cVarHw, str2, strPr, strX, jCurrentTimeMillis));
                    } catch (Throwable th) {
                        try {
                            th.getMessage();
                        } catch (Throwable th2) {
                            com.byazt.wj.hw.pr();
                            throw th2;
                        }
                    }
                    com.byazt.wj.hw.pr();
                }
            }
        }
    }

    private static List<com.byazt.mu.pr.C0137pr> pr(com.byazt.mu.pr prVar, String str) {
        if (prVar == null) {
            return Collections.emptyList();
        }
        return prVar.pr(str);
    }

    private static com.byazt.ki.hn pr(String str, Map<String, Object> map, Map<String, Object> map2) {
        return new com.byazt.ki.hn(com.byazt.ki.pr.pr(str), str, System.currentTimeMillis(), map, map2);
    }

    private static Map<String, Object> pr(Map<String, Object> map, com.byazt.ki.hn hnVar) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put(com.byazt.ki.hn.class.getName(), hnVar);
        return map2;
    }

    public void pr(String str) {
        for (hn hnVar : this.x) {
            if (hnVar instanceof pr) {
                try {
                    ((pr) hnVar).pr(str);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
        this.uc.remove(str == null ? "" : str);
        com.byazt.wj.pr.pr(str);
    }

    private com.byazt.mu.pr hn(String str) {
        if (str == null) {
            str = "";
        }
        com.byazt.mu.pr prVar = this.uc.get(str);
        if (prVar == null) {
            com.byazt.mu.pr prVar2 = new com.byazt.mu.pr();
            com.byazt.mu.pr prVarPutIfAbsent = this.uc.putIfAbsent(str, prVar2);
            return prVarPutIfAbsent != null ? prVarPutIfAbsent : prVar2;
        }
        return prVar;
    }

    private com.byazt.mu.pr x(String str) {
        Map<String, com.byazt.mu.pr> map = this.uc;
        if (str == null) {
            str = "";
        }
        return map.get(str);
    }

    private static String pr(Map<String, Object> map) {
        Object obj;
        if (map != null && (obj = map.get("framework")) != null) {
            String strValueOf = String.valueOf(obj);
            if (!strValueOf.isEmpty()) {
                return strValueOf;
            }
            return "ugen";
        }
        return "ugen";
    }

    private static String pr(com.byazt.mu.pr.C0137pr c0137pr) {
        com.byazt.ki.hw hwVarHn;
        return (c0137pr == null || (hwVarHn = c0137pr.hn()) == null) ? "" : String.valueOf(hwVarHn.pr());
    }

    private static com.byazt.dd.c pr(final com.byazt.dd.c cVar, final String str, final String str2, final String str3, final long j) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new com.byazt.dd.c() { // from class: com.byazt.at.x.1
            @Override // com.byazt.dd.c
            public void pr() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    com.byazt.wk.pr.pr(str, str2, 1, str3, System.currentTimeMillis() - j);
                }
                com.byazt.dd.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.pr();
                }
            }
        };
    }

    private static com.byazt.dd.c hw(final com.byazt.dd.c cVar, final String str, final String str2, final String str3, final long j) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new com.byazt.dd.c() { // from class: com.byazt.at.x.2
            @Override // com.byazt.dd.c
            public void pr() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    com.byazt.wk.pr.pr(str, str2, 1, str3, System.currentTimeMillis() - j);
                }
                com.byazt.wj.hw.pr(str2);
                try {
                    com.byazt.dd.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.pr();
                    }
                } finally {
                    com.byazt.wj.hw.pr();
                }
            }
        };
    }
}
