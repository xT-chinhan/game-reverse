package com.byazt.ynv;

import android.text.TextUtils;
import com.byazt.md.q;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, 19})
public final class n {
    public static final n n = new n();
    public volatile boolean l;
    public Runnable q;
    public s s;
    public final Map<String, C0404n> qg = new LinkedHashMap();
    public volatile int w = -1;

    private n() {
    }

    public static n n() {
        return n;
    }

    public int qg() {
        if (!s(q.n().x())) {
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
        com.byazt.md.n nVarX = q.n().x();
        if (nVarX.n() && com.byazt.fho.qg.n(nVar.n(), nVarX.qg())) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.1
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.md.n nVarX2 = q.n().x();
                    if (nVarX2.n() && com.byazt.fho.qg.n(nVar.n(), nVarX2.qg())) {
                        n.this.n(nVarX2);
                        C0404n c0404nN = n.this.n(nVar, nVarX2);
                        c0404nN.qg.n(System.currentTimeMillis(), 0, false, false);
                        c0404nN.w = true;
                        c0404nN.x = false;
                        c0404nN.l = false;
                        c0404nN.q = 0;
                    }
                }
            });
        }
    }

    public void n(final String str) {
        if (!TextUtils.isEmpty(str) && q.n().x().n()) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.2
                @Override // java.lang.Runnable
                public void run() {
                    C0404n c0404n;
                    com.byazt.md.n nVarX = q.n().x();
                    if (!nVarX.n() || (c0404n = (C0404n) n.this.qg.get(str)) == null || c0404n.tj) {
                        return;
                    }
                    n.this.qg(c0404n);
                    if (c0404n.rv == null) {
                        n.this.qg(c0404n, nVarX);
                    }
                }
            });
        }
    }

    public void qg(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.n nVarX = q.n().x();
                final C0404n c0404n = (C0404n) n.this.qg.get(str);
                if (c0404n == null || c0404n.tj) {
                    return;
                }
                c0404n.tj = true;
                n.this.s(c0404n);
                if (!nVarX.n()) {
                    if (n.this.qg.get(str) == c0404n) {
                        n.this.qg.remove(str);
                        return;
                    }
                    return;
                }
                com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj;
                        C0404n c0404n2;
                        try {
                            if (!q.n().x().n()) {
                                if (obj == c0404n2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            if (!c0404n.cp && (c0404n.s.length() != 0 || c0404n.w)) {
                                n.this.n(c0404n);
                                c0404n.cp = true;
                                if (obj == c0404n2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } finally {
                            if (n.this.qg.get(str) == c0404n) {
                                n.this.qg.remove(str);
                            }
                        }
                    }
                }, nVarX.fs());
            }
        });
    }

    public void s() {
        com.byazt.md.n nVarX = q.n().x();
        boolean zQg = com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX.qg());
        boolean zQg2 = com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX.s());
        if (this.l || !com.byazt.fho.qg.n(nVarX.q(), zQg, zQg2)) {
            return;
        }
        this.l = true;
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.n nVarX2 = q.n().x();
                if (!com.byazt.fho.qg.n(nVarX2.q(), com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX2.qg()), com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX2.s()))) {
                    n.this.l = false;
                    return;
                }
                if (n.this.q != null) {
                    return;
                }
                n.this.s = new s();
                n.this.s.n(System.currentTimeMillis(), 0, false, false);
                n.this.q = new Runnable() { // from class: com.byazt.ynv.n.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (n.this.q == this && n.this.l) {
                            com.byazt.md.n nVarX3 = q.n().x();
                            boolean zQg3 = com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX3.qg());
                            if (!com.byazt.fho.qg.n(nVarX3.q(), zQg3, com.byazt.fho.qg.qg("cpu_cycle_observe", nVarX3.s()))) {
                                n.this.q = null;
                                n.this.s = null;
                                n.this.l = false;
                                return;
                            }
                            try {
                                if (n.this.s == null) {
                                    n.this.s = new s();
                                    n.this.s.n(System.currentTimeMillis(), 0, false, false);
                                }
                                qg qgVarN = n.this.s.n(System.currentTimeMillis(), 0, false, false);
                                n.this.n(qgVarN);
                                if (zQg3 && qgVarN.qg()) {
                                    com.byazt.br.n.n(qgVarN.s());
                                }
                            } catch (Throwable th) {
                                k.qg("PerfMonitor_CpuMonitor", "cpu_cycle_observe err: " + th.getMessage());
                            }
                            if (n.this.q == this) {
                                com.byazt.fho.n.n(this, nVarX3.l());
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
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.ynv.n.5
            @Override // java.lang.Runnable
            public void run() {
                if (n.this.q != null) {
                    com.byazt.fho.n.qg(n.this.q);
                    n.this.q = null;
                }
                n.this.s = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0404n n(com.byazt.gd.n nVar, com.byazt.md.n nVar2) {
        C0404n c0404n = this.qg.get(nVar.n());
        if (c0404n != null) {
            n(c0404n, nVar2);
            this.qg.remove(nVar.n());
        }
        qg(nVar2);
        C0404n c0404n2 = new C0404n(nVar, nVar2);
        this.qg.put(nVar.n(), c0404n2);
        return c0404n2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.md.n nVar) {
        if (this.qg.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jRv = nVar.rv();
        Iterator<Map.Entry<String, C0404n>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0404n> next = it.next();
            C0404n value = next.getValue();
            if (jCurrentTimeMillis - value.d > jRv) {
                n(value, nVar);
                it.remove();
                next.getKey();
            }
        }
    }

    private void qg(com.byazt.md.n nVar) {
        int iTj = nVar.tj();
        while (this.qg.size() >= iTj) {
            Iterator<Map.Entry<String, C0404n>> it = this.qg.entrySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            Map.Entry<String, C0404n> next = it.next();
            n(next.getValue(), nVar);
            it.remove();
            next.getKey();
        }
    }

    private void n(C0404n c0404n, com.byazt.md.n nVar) {
        JSONArray jSONArray;
        if (c0404n == null || c0404n.cp) {
            return;
        }
        if (c0404n.s.length() != 0 || c0404n.w) {
            try {
                s(c0404n);
                n(c0404n);
                c0404n.cp = true;
                jSONArray = new JSONArray();
            } catch (Throwable th) {
                try {
                    k.qg("PerfMonitor_CpuMonitor", "flushOldCpuSession err: " + th.getMessage());
                    jSONArray = new JSONArray();
                } catch (Throwable th2) {
                    c0404n.s = new JSONArray();
                    throw th2;
                }
            }
            c0404n.s = jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(C0404n c0404n) {
        qg(c0404n);
        c0404n.s.put(n(c0404n, true).n("DESTROY", c0404n.l));
        com.byazt.br.n.n(c0404n.n, c0404n.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(C0404n c0404n) {
        if (c0404n == null || !c0404n.w || c0404n.x) {
            return;
        }
        qg qgVarN = c0404n.qg.n(System.currentTimeMillis(), 0, false, false);
        c0404n.l = qgVarN.qg();
        c0404n.q = qgVarN.n();
        c0404n.s.put(qgVarN.n("PRE_SHOW", c0404n.l));
        c0404n.x = true;
        c0404n.s.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final C0404n c0404n, com.byazt.md.n nVar) {
        final int iX = nVar.x();
        final int iW = nVar.w();
        c0404n.fs = 0;
        c0404n.rv = new Runnable() { // from class: com.byazt.ynv.n.6
            @Override // java.lang.Runnable
            public void run() {
                if (c0404n.rv != this || c0404n.tj) {
                    return;
                }
                if (!q.n().x().n()) {
                    n.this.s(c0404n);
                    return;
                }
                c0404n.fs++;
                int i = c0404n.fs;
                c0404n.s.put(n.this.n(c0404n, true).n("SHOW_W".concat(String.valueOf(i)), c0404n.l));
                if (i >= iX) {
                    n.this.s(c0404n);
                } else if (c0404n.rv == this) {
                    com.byazt.fho.n.n(this, iW);
                }
            }
        };
        com.byazt.fho.n.n(c0404n.rv, iW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(C0404n c0404n) {
        if (c0404n.rv != null) {
            com.byazt.fho.n.qg(c0404n.rv);
            c0404n.rv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qg n(C0404n c0404n, boolean z) {
        return c0404n.qg.n(System.currentTimeMillis(), c0404n.q, z, c0404n.l);
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

    private static boolean s(com.byazt.md.n nVar) {
        return nVar != null && nVar.n() && nVar.q() && (com.byazt.fho.qg.qg("cpu_cycle_observe", nVar.qg()) || com.byazt.fho.qg.qg("cpu_cycle_observe", nVar.s()));
    }

    /* JADX INFO: renamed from: com.byazt.ynv.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0404n {
        public boolean cp;
        public int fs;
        public boolean l;
        public final com.byazt.gd.n n;
        public int q;
        public Runnable rv;
        public boolean tj;
        public boolean w;
        public boolean x;
        public final s qg = new s();
        public JSONArray s = new JSONArray();
        public final long d = System.currentTimeMillis();

        public C0404n(com.byazt.gd.n nVar, com.byazt.md.n nVar2) {
            this.n = nVar;
        }
    }
}
