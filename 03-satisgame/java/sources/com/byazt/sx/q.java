package com.byazt.sx;

import android.os.Handler;
import android.os.Looper;
import com.byazt.pk.l;
import com.byazt.pk.w;
import com.byazt.sbt.d;
import com.byazt.sbt.oa;
import com.byazt.xz.cy;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1418, 5})
public class q implements cy {
    public static final List<String> n = Arrays.asList("tap", "longTap", "touchStart", "touchEnd", "slide", "shake", "twist", "animateState", "Lottie://state", "timer", "tick", "timerState", "stateChange", "videoState", "videoProgress", "adViewVisible", "appLifecycle", "downloadStatus", "webViewLifeCycle", "gameScore", "gameResult");
    public static final Set<String> qg = new HashSet(Collections.singleton("Lottie://state"));
    public static volatile q s;
    public com.byazt.ot.n.qg cp;
    public final List<s> q = new CopyOnWriteArrayList();
    public final Map<String, s> l = new ConcurrentHashMap();
    public final Map<String, com.byazt.fi.n> w = new ConcurrentHashMap();
    public final oa x = new oa();
    public final Map<String, Map<String, Object>> fs = new ConcurrentHashMap();
    public final Map<String, Map<String, Map<String, Object>>> rv = new ConcurrentHashMap();
    public final AtomicBoolean tj = new AtomicBoolean(false);
    public final Handler d = new Handler(Looper.getMainLooper());

    public static q n() {
        if (s == null) {
            synchronized (q.class) {
                if (s == null) {
                    s = new q();
                }
            }
        }
        return s;
    }

    private q() {
        n(new com.byazt.pk.q());
        n(new com.byazt.pk.qg());
        n(new w());
        n(new l());
        n(new com.byazt.pk.s());
        n(new com.byazt.rh.n());
        n(new com.byazt.rh.qg());
        n(new com.byazt.xg.n());
        n(new com.byazt.lj.n());
        n(new com.byazt.on.s(this));
        n(new com.byazt.on.n());
        n(new com.byazt.on.qg());
        n(new com.byazt.lo.n());
        n(new com.byazt.bb.qg());
        n(new com.byazt.bb.n());
        n(new com.byazt.ad.n());
        n(new com.byazt.ok.n());
        n(new com.byazt.mc.n());
        n(new com.byazt.fv.n());
        n(new com.byazt.ah.qg());
        n(new com.byazt.ah.n());
    }

    public void n(s sVar) {
        if (sVar == null) {
            return;
        }
        this.q.add(sVar);
        for (String str : n) {
            if (sVar.qg(str)) {
                this.l.put(str, sVar);
            }
        }
    }

    @Override // com.byazt.xz.cy
    public boolean n(String str, String str2) {
        if (str == null && (str2 == null || str2.isEmpty())) {
            return false;
        }
        if (str != null) {
            if (this.l.containsKey(str)) {
                return true;
            }
            Iterator<s> it = this.q.iterator();
            while (it.hasNext()) {
                if (it.next().qg(str)) {
                    return true;
                }
            }
        }
        if (str2 != null && !str2.isEmpty() && !str2.equals(str)) {
            if (this.l.containsKey(str2)) {
                return true;
            }
            Iterator<s> it2 = this.q.iterator();
            while (it2.hasNext()) {
                if (it2.next().qg(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.byazt.xz.cy
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        s sVarQg = qg(str2);
        if (sVarQg == null) {
            return false;
        }
        Map<String, Object> mapN = n(map2, n(str2, map, map2));
        new StringBuilder("dispatch scenario=").append(str).append(" event=").append(str2).append(" monitor=").append(i).append(" payload=").append(map).append(" context=").append(mapN);
        return sVarQg.n(str, str2, i, map, mapN, lVar);
    }

    private s qg(String str) {
        s sVar = this.l.get(str);
        if (sVar != null) {
            return sVar;
        }
        for (s sVar2 : this.q) {
            if (sVar2.qg(str)) {
                this.l.put(str, sVar2);
                return sVar2;
            }
        }
        return null;
    }

    @Override // com.byazt.xz.cy
    public void n(String str, String str2, String str3, Map<String, Object> map, com.byazt.xz.l lVar) {
        com.byazt.fi.n.C0175n c0175nN = s(str).n(str2, str3, map, lVar);
        qg();
        n(str, str2, c0175nN);
        qg(str, str2, c0175nN);
    }

    private void n(String str, String str2, com.byazt.fi.n.C0175n c0175n) {
        d dVarN;
        com.byazt.xz.l lVarQg;
        if (c0175n == null || !"adViewVisible".equals(str2)) {
            return;
        }
        Map<String, Map<String, Object>> map = this.fs;
        if (str == null) {
            str = "";
        }
        Map<String, Object> map2 = map.get(str);
        if (map2 == null || (dVarN = this.x.n(str2)) == null || !dVarN.n(c0175n, map2) || (lVarQg = c0175n.qg()) == null) {
            return;
        }
        HashMap map3 = new HashMap(map2);
        map3.put(com.byazt.pg.s.class.getName(), n(str2, (Map<String, Object>) null, map2));
        try {
            lVarQg.n(map3);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private void qg(String str, String str2, Map<String, Object> map) {
        Object obj;
        Map<String, Map<String, Object>> mapPutIfAbsent;
        if (!"videoState".equals(str2) || map == null || (obj = map.get(WebLoginFragment.QUERY_KEY_ID)) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (str == null) {
            str = "";
        }
        Map<String, Map<String, Object>> map2 = this.rv.get(str);
        if (map2 == null && (mapPutIfAbsent = this.rv.putIfAbsent(str, (map2 = new HashMap<>()))) != null) {
            map2 = mapPutIfAbsent;
        }
        synchronized (map2) {
            if (!"started".equals(strValueOf)) {
                map2.remove("playing");
                map2.remove("paused");
                map2.remove("finished");
            }
            map2.put(strValueOf, new HashMap(map));
        }
    }

    private void qg(String str, final String str2, final com.byazt.fi.n.C0175n c0175n) {
        final com.byazt.xz.l lVarQg;
        final d dVarN;
        if (c0175n == null || !"videoState".equals(str2)) {
            return;
        }
        Map<String, Map<String, Object>> map = this.rv.get(str == null ? "" : str);
        if (map == null || (lVarQg = c0175n.qg()) == null || (dVarN = this.x.n(str2)) == null) {
            return;
        }
        synchronized (map) {
            if (map.isEmpty()) {
                return;
            }
            final Map<String, Object> map2 = map.get("started");
            final Map<String, Object> map3 = map.get("playing");
            final Map<String, Object> map4 = map.get("paused");
            final Map<String, Object> map5 = map.get("finished");
            if (map2 == null && map3 == null && map4 == null && map5 == null) {
                return;
            }
            if (str == null) {
                str = "";
            }
            final String str3 = str;
            this.d.post(new Runnable() { // from class: com.byazt.sx.q.1
                @Override // java.lang.Runnable
                public void run() {
                    List<com.byazt.fi.n.C0175n> listN;
                    com.byazt.fi.n nVarQ = q.this.q(str3);
                    if (nVarQ == null || (listN = nVarQ.n(str2)) == null || listN.isEmpty() || !listN.contains(c0175n)) {
                        return;
                    }
                    q.this.n((Map<String, Object>) map2, c0175n, dVarN, lVarQg, str2);
                    q.this.n((Map<String, Object>) map3, c0175n, dVarN, lVarQg, str2);
                    q.this.n((Map<String, Object>) map4, c0175n, dVarN, lVarQg, str2);
                    q.this.n((Map<String, Object>) map5, c0175n, dVarN, lVarQg, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Map<String, Object> map, com.byazt.fi.n.C0175n c0175n, d dVar, com.byazt.xz.l lVar, String str) {
        if (map == null || !dVar.n(c0175n, map)) {
            return;
        }
        HashMap map2 = new HashMap(map);
        map2.put(com.byazt.pg.s.class.getName(), n(str, (Map<String, Object>) null, map));
        try {
            lVar.n(map2);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.xz.cy
    public void n(String str, String str2, Map<String, Object> map) {
        s sVarQg = qg(str2);
        if (sVarQg == null) {
            return;
        }
        if ("adViewVisible".equals(str2)) {
            this.fs.put(str == null ? "" : str, map == null ? new HashMap() : new HashMap(map));
        }
        qg(str, str2, map);
        List<com.byazt.fi.n.C0175n> listN = n(q(str), str2);
        if (listN.isEmpty()) {
            return;
        }
        d dVarN = this.x.n(str2);
        com.byazt.pg.s sVarN = n(str2, (Map<String, Object>) null, map);
        HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        map2.put(com.byazt.pg.s.class.getName(), sVarN);
        for (com.byazt.fi.n.C0175n c0175n : listN) {
            if (dVarN.n(c0175n, map)) {
                try {
                    sVarQg.n(str, str2, c0175n.hashCode(), c0175n.n(), map2, c0175n.qg());
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
    }

    private static List<com.byazt.fi.n.C0175n> n(com.byazt.fi.n nVar, String str) {
        if (nVar == null) {
            return Collections.emptyList();
        }
        return nVar.n(str);
    }

    private static com.byazt.pg.s n(String str, Map<String, Object> map, Map<String, Object> map2) {
        return new com.byazt.pg.s(com.byazt.pg.n.n(str), str, System.currentTimeMillis(), map, map2);
    }

    private static Map<String, Object> n(Map<String, Object> map, com.byazt.pg.s sVar) {
        HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put(com.byazt.pg.s.class.getName(), sVar);
        return map2;
    }

    @Override // com.byazt.xz.cy
    public void n(String str, String str2, int i, int i2) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            ((com.byazt.on.s) sVarQg).n(str, i, i2);
        }
    }

    @Override // com.byazt.xz.cy
    public void n(String str, String str2, int i, boolean z) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            ((com.byazt.on.s) sVarQg).n(str, i, z);
        }
    }

    @Override // com.byazt.xz.cy
    public void n(String str, String str2, int i, String str3) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            com.byazt.on.s sVar = (com.byazt.on.s) sVarQg;
            String strW = sVar.w(str, i);
            if (str3 == null) {
                str3 = "";
            }
            if (strW == null) {
                strW = "";
            }
            if (str3.equals(strW)) {
                sVar.qg(str, i);
            }
        }
    }

    @Override // com.byazt.xz.cy
    public void qg(String str, String str2, int i, String str3) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            com.byazt.on.s sVar = (com.byazt.on.s) sVarQg;
            String strW = sVar.w(str, i);
            if (str3 == null) {
                str3 = "";
            }
            if (strW == null) {
                strW = "";
            }
            if (str3.equals(strW)) {
                sVar.l(str, i);
            }
        }
    }

    @Override // com.byazt.xz.cy
    public void s(String str, String str2, int i, String str3) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            com.byazt.on.s sVar = (com.byazt.on.s) sVarQg;
            String strW = sVar.w(str, i);
            if (str3 == null) {
                str3 = "";
            }
            if (strW == null) {
                strW = "";
            }
            if (str3.equals(strW)) {
                sVar.s(str, i);
            }
        }
    }

    @Override // com.byazt.xz.cy
    public void q(String str, String str2, int i, String str3) {
        s sVarQg = qg(str2);
        if (sVarQg instanceof com.byazt.on.s) {
            com.byazt.on.s sVar = (com.byazt.on.s) sVarQg;
            String strW = sVar.w(str, i);
            if (str3 == null) {
                str3 = "";
            }
            if (strW == null) {
                strW = "";
            }
            if (str3.equals(strW)) {
                sVar.q(str, i);
            }
        }
    }

    public void n(String str) {
        for (s sVar : this.q) {
            if (sVar instanceof n) {
                try {
                    ((n) sVar).n(str);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
        this.w.remove(str == null ? "" : str);
        this.fs.remove(str == null ? "" : str);
        Map<String, Map<String, Map<String, Object>>> map = this.rv;
        if (str == null) {
            str = "";
        }
        map.remove(str);
    }

    public void n(String str, int i) {
        for (s sVar : this.q) {
            if (sVar instanceof n) {
                try {
                    ((n) sVar).n(str, i);
                } catch (Throwable th) {
                    th.getMessage();
                }
            }
        }
    }

    private com.byazt.fi.n s(String str) {
        if (str == null) {
            str = "";
        }
        com.byazt.fi.n nVar = this.w.get(str);
        if (nVar != null) {
            return nVar;
        }
        com.byazt.fi.n nVar2 = new com.byazt.fi.n();
        com.byazt.fi.n nVarPutIfAbsent = this.w.putIfAbsent(str, nVar2);
        return nVarPutIfAbsent != null ? nVarPutIfAbsent : nVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.fi.n q(String str) {
        Map<String, com.byazt.fi.n> map = this.w;
        if (str == null) {
            str = "";
        }
        return map.get(str);
    }

    private void qg() {
        if (this.tj.get()) {
            return;
        }
        try {
            com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
            if (nVarS != null && this.tj.compareAndSet(false, true)) {
                com.byazt.ot.n.qg qgVar = new com.byazt.ot.n.qg() { // from class: com.byazt.sx.q.2
                    @Override // com.byazt.ot.n.qg
                    public void q() {
                    }

                    @Override // com.byazt.ot.n.qg
                    public void s() {
                    }

                    @Override // com.byazt.ot.n.qg
                    public void n() {
                        q.this.l("background");
                        q.this.n(false);
                    }

                    @Override // com.byazt.ot.n.qg
                    public void qg() {
                        q.this.l("foreground");
                        q.this.n(true);
                    }
                };
                this.cp = qgVar;
                nVarS.n(qgVar);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        HashMap map = new HashMap();
        map.put(WebLoginFragment.QUERY_KEY_ID, str);
        Iterator<String> it = this.w.keySet().iterator();
        while (it.hasNext()) {
            try {
                n(it.next(), "appLifecycle", map);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z) {
        s sVar = this.l.get("timer");
        if (sVar instanceof com.byazt.on.s) {
            try {
                ((com.byazt.on.s) sVar).n(z);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
