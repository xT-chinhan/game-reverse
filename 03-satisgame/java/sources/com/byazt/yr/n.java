package com.byazt.yr;

import android.text.TextUtils;
import com.byazt.md.q;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1087, 19})
public final class n {
    public static final n n = new n();
    public Runnable q;
    public s s;
    public final Map<String, C0405n> qg = new LinkedHashMap();
    public volatile boolean l = false;
    public volatile int w = -1;

    private n() {
    }

    public static n n() {
        return n;
    }

    public int qg() {
        if (!s(q.n().l())) {
            l();
            return -1;
        }
        int i = this.w;
        if (i < 0) {
            return -1;
        }
        return i;
    }

    public void n(final com.byazt.gd.n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.n())) {
            return;
        }
        com.byazt.md.s sVarL = q.n().l();
        if (sVarL.n() && com.byazt.fho.qg.n(nVar.n(), sVarL.qg())) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.md.s sVarL2 = q.n().l();
                    if (sVarL2.n() && com.byazt.fho.qg.n(nVar.n(), sVarL2.qg())) {
                        n.this.n(sVarL2);
                        C0405n c0405nN = n.this.n(nVar, sVarL2);
                        c0405nN.s.put(c0405nN.qg.n(System.currentTimeMillis()).n("PRE_SHOW"));
                        c0405nN.s.length();
                    }
                }
            });
        }
    }

    public void n(final String str) {
        if (!TextUtils.isEmpty(str) && q.n().l().n()) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.2
                @Override // java.lang.Runnable
                public void run() {
                    C0405n c0405n;
                    com.byazt.md.s sVarL = q.n().l();
                    if (sVarL.n() && (c0405n = (C0405n) n.this.qg.get(str)) != null && !c0405n.w && c0405n.l == null) {
                        n.this.n(c0405n, sVarL);
                    }
                }
            });
        }
    }

    public void qg(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.s sVarL = q.n().l();
                final C0405n c0405n = (C0405n) n.this.qg.get(str);
                if (c0405n == null || c0405n.w) {
                    return;
                }
                c0405n.w = true;
                n.this.qg(c0405n);
                if (!sVarL.n()) {
                    if (n.this.qg.get(str) == c0405n) {
                        n.this.qg.remove(str);
                    }
                } else {
                    int iFs = q.n().l().fs();
                    c0405n.s.length();
                    com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!q.n().l().n()) {
                                    if (n.this.qg.get(str) != c0405n) {
                                        n.this.qg.size();
                                        return;
                                    } else {
                                        n.this.qg.remove(str);
                                        n.this.qg.size();
                                        return;
                                    }
                                }
                                if (c0405n.s.length() == 0) {
                                    if (n.this.qg.get(str) != c0405n) {
                                        n.this.qg.size();
                                        return;
                                    } else {
                                        n.this.qg.remove(str);
                                        n.this.qg.size();
                                        return;
                                    }
                                }
                                c0405n.s.put(c0405n.qg.n(System.currentTimeMillis()).n("DESTROY"));
                                c0405n.s.length();
                                com.byazt.br.s.n(c0405n.n, c0405n.s);
                                c0405n.s.length();
                                if (n.this.qg.get(str) != c0405n) {
                                    n.this.qg.size();
                                } else {
                                    n.this.qg.remove(str);
                                    n.this.qg.size();
                                }
                            } catch (Throwable th) {
                                if (n.this.qg.get(str) == c0405n) {
                                    n.this.qg.remove(str);
                                    n.this.qg.size();
                                } else {
                                    n.this.qg.size();
                                }
                                throw th;
                            }
                        }
                    }, iFs);
                }
            }
        });
    }

    public void s() {
        com.byazt.md.s sVarL = q.n().l();
        boolean zQg = com.byazt.fho.qg.qg("mem_cycle_observe", sVarL.qg());
        boolean zQg2 = com.byazt.fho.qg.qg("mem_cycle_observe", sVarL.s());
        if (this.l || !com.byazt.fho.qg.n(sVarL.q(), zQg, zQg2)) {
            return;
        }
        this.l = true;
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.s sVarL2 = q.n().l();
                if (!com.byazt.fho.qg.n(sVarL2.q(), com.byazt.fho.qg.qg("mem_cycle_observe", sVarL2.qg()), com.byazt.fho.qg.qg("mem_cycle_observe", sVarL2.s()))) {
                    n.this.l = false;
                    return;
                }
                if (n.this.q != null) {
                    return;
                }
                if (n.this.s == null) {
                    n.this.s = new s();
                }
                n.this.q = new Runnable() { // from class: com.byazt.yr.n.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.q == this && n.this.l) {
                            com.byazt.md.s sVarL3 = q.n().l();
                            boolean zQg3 = com.byazt.fho.qg.qg("mem_cycle_observe", sVarL3.qg());
                            if (!com.byazt.fho.qg.n(sVarL3.q(), zQg3, com.byazt.fho.qg.qg("mem_cycle_observe", sVarL3.s()))) {
                                n.this.q = null;
                                n.this.l = false;
                                return;
                            }
                            try {
                                qg qgVarN = n.this.s.n(System.currentTimeMillis());
                                n.this.n(qgVarN);
                                if (zQg3) {
                                    com.byazt.br.s.n(qgVarN.q());
                                }
                            } catch (Throwable th) {
                                k.qg("PerfMonitor_MemoryMonitor", "mem_cycle_observe sample err: " + th.getMessage());
                            }
                            if (n.this.q == this) {
                                com.byazt.fho.n.n(this, sVarL3.l());
                            }
                        }
                    }
                };
                com.byazt.fho.n.n(n.this.q);
            }
        });
    }

    public void q() {
        this.l = false;
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.yr.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.q != null) {
                    com.byazt.fho.n.qg(n.this.q);
                    n.this.q = null;
                }
            }
        });
    }

    private void n(C0405n c0405n) {
        JSONArray jSONArray;
        if (c0405n == null || c0405n.s.length() == 0) {
            return;
        }
        try {
            qg(c0405n);
            c0405n.s.put(c0405n.qg.n(System.currentTimeMillis()).n("DESTROY"));
            c0405n.s.length();
            com.byazt.br.s.n(c0405n.n, c0405n.s);
            c0405n.s.length();
            jSONArray = new JSONArray();
        } catch (Throwable th) {
            try {
                k.qg("PerfMonitor_MemoryMonitor", "flushOldSession err: " + th.getMessage());
                jSONArray = new JSONArray();
            } catch (Throwable th2) {
                c0405n.s = new JSONArray();
                throw th2;
            }
        }
        c0405n.s = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0405n n(com.byazt.gd.n nVar, com.byazt.md.s sVar) {
        C0405n c0405n = this.qg.get(nVar.n());
        if (c0405n != null) {
            n(c0405n);
            this.qg.remove(nVar.n());
        }
        qg(sVar);
        C0405n c0405n2 = new C0405n(nVar, sVar);
        this.qg.put(nVar.n(), c0405n2);
        return c0405n2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.md.s sVar) {
        if (this.qg.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jRv = sVar.rv();
        Iterator<Map.Entry<String, C0405n>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0405n> next = it.next();
            C0405n value = next.getValue();
            if (jCurrentTimeMillis - value.x > jRv) {
                n(value);
                it.remove();
                next.getKey();
            }
        }
    }

    private void qg(com.byazt.md.s sVar) {
        int iTj = sVar.tj();
        while (this.qg.size() >= iTj) {
            Iterator<Map.Entry<String, C0405n>> it = this.qg.entrySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            Map.Entry<String, C0405n> next = it.next();
            n(next.getValue());
            it.remove();
            next.getKey();
            this.qg.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final C0405n c0405n, com.byazt.md.s sVar) {
        final int iX = sVar.x();
        final int iW = sVar.w();
        c0405n.q = 0;
        c0405n.l = new Runnable() { // from class: com.byazt.yr.n.6
            @Override // java.lang.Runnable
            public void run() {
                if (c0405n.l == this && !c0405n.w) {
                    if (!q.n().l().n()) {
                        n.this.qg(c0405n);
                        return;
                    }
                    c0405n.q++;
                    int i = c0405n.q;
                    c0405n.s.put(c0405n.qg.n(System.currentTimeMillis()).n("SHOW_W".concat(String.valueOf(i))));
                    c0405n.s.length();
                    if (i >= iX) {
                        n.this.qg(c0405n);
                    } else if (c0405n.l == this) {
                        com.byazt.fho.n.n(this, iW);
                    }
                }
            }
        };
        com.byazt.fho.n.n(c0405n.l, iW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(C0405n c0405n) {
        if (c0405n.l != null) {
            com.byazt.fho.n.qg(c0405n.l);
            c0405n.l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(qg qgVar) {
        if (qgVar == null || !qgVar.qg()) {
            return;
        }
        this.w = qgVar.n();
    }

    private void l() {
        this.w = -1;
    }

    private static boolean s(com.byazt.md.s sVar) {
        return sVar != null && sVar.n() && sVar.q() && (com.byazt.fho.qg.qg("mem_cycle_observe", sVar.qg()) || com.byazt.fho.qg.qg("mem_cycle_observe", sVar.s()));
    }

    /* JADX INFO: renamed from: com.byazt.yr.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1087, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0405n {
        public Runnable l;
        public final com.byazt.gd.n n;
        public int q;
        public boolean w;
        public final s qg = new s();
        public JSONArray s = new JSONArray();
        public final long x = System.currentTimeMillis();

        public C0405n(com.byazt.gd.n nVar, com.byazt.md.s sVar) {
            this.n = nVar;
        }
    }
}
