package com.byazt.uvh;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 576, 5})
public final class q {
    public static final q n = new q();
    public long fs;
    public Runnable l;
    public volatile boolean w;
    public volatile boolean x;
    public final Map<String, n> qg = new LinkedHashMap();
    public final l s = new l();
    public final qg q = new qg(new qg.n() { // from class: com.byazt.uvh.q.1
        @Override // com.byazt.uvh.qg.n
        public void n(s sVar) {
            q.this.s.n(sVar);
        }
    });
    public volatile int rv = -1;

    private q() {
    }

    public static q n() {
        return n;
    }

    public int qg() {
        if (!s(com.byazt.md.q.n().w())) {
            x();
            return -1;
        }
        int i = this.rv;
        if (i < 0) {
            return -1;
        }
        return i;
    }

    public void n(final com.byazt.gd.n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.n())) {
            return;
        }
        com.byazt.md.qg qgVarW = com.byazt.md.q.n().w();
        if (qgVarW.n() && com.byazt.fho.qg.n(nVar.n(), qgVarW.qg())) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.md.qg qgVarW2 = com.byazt.md.q.n().w();
                    if (qgVarW2.n() && com.byazt.fho.qg.n(nVar.n(), qgVarW2.qg())) {
                        q.this.n(qgVarW2);
                        n nVarN = q.this.n(nVar, qgVarW2);
                        q.this.l();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        w wVarN = q.this.n(jCurrentTimeMillis - ((long) qgVarW2.w()), jCurrentTimeMillis, qgVarW2, 0, false);
                        nVarN.w = wVarN.qg() > 0;
                        nVarN.x = !nVarN.w;
                        nVarN.s = wVarN.n();
                        nVarN.q = wVarN.s();
                        nVarN.l = wVarN.q();
                        nVarN.tj = jCurrentTimeMillis;
                        nVarN.qg.put(wVarN.n("PRE_SHOW", nVarN.w));
                        nVarN.qg.length();
                    }
                }
            });
        }
    }

    public void n(final String str) {
        if (!TextUtils.isEmpty(str) && com.byazt.md.q.n().w().n()) {
            com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.3
                @Override // java.lang.Runnable
                public void run() {
                    n nVar;
                    com.byazt.md.qg qgVarW = com.byazt.md.q.n().w();
                    if (!qgVarW.n() || (nVar = (n) q.this.qg.get(str)) == null || nVar.oa) {
                        return;
                    }
                    q.this.l();
                    if (nVar.d == null) {
                        q.this.qg(nVar, qgVarW);
                    }
                }
            });
        }
    }

    public void qg(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.qg qgVarW = com.byazt.md.q.n().w();
                final n nVar = (n) q.this.qg.get(str);
                if (nVar == null || nVar.oa) {
                    return;
                }
                nVar.oa = true;
                q.this.n(nVar);
                nVar.cp = System.currentTimeMillis();
                if (!qgVarW.n()) {
                    if (q.this.qg.get(str) == nVar) {
                        q.this.qg.remove(str);
                        q.this.w();
                        return;
                    }
                    return;
                }
                com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj;
                        n nVar2;
                        try {
                            com.byazt.md.qg qgVarW2 = com.byazt.md.q.n().w();
                            if (!qgVarW2.n()) {
                                if (obj == nVar2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            if (nVar.qg.length() == 0) {
                                if (obj == nVar2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            q qVar = q.this;
                            n nVar3 = nVar;
                            qVar.n(nVar3, qgVarW2, nVar3.cp);
                        } finally {
                            if (q.this.qg.get(str) == nVar) {
                                q.this.qg.remove(str);
                                q.this.w();
                            }
                        }
                    }
                }, Math.max(qgVarW.fs(), qgVarW.w()));
            }
        });
    }

    public void s() {
        com.byazt.md.qg qgVarW = com.byazt.md.q.n().w();
        boolean zQg = com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW.qg());
        boolean zQg2 = com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW.s());
        if (this.w || !com.byazt.fho.qg.n(qgVarW.q(), zQg, zQg2)) {
            return;
        }
        this.w = true;
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.md.qg qgVarW2 = com.byazt.md.q.n().w();
                if (!com.byazt.fho.qg.n(qgVarW2.q(), com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW2.qg()), com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW2.s()))) {
                    q.this.w = false;
                    return;
                }
                if (q.this.l != null) {
                    return;
                }
                q.this.l();
                q.this.fs = System.currentTimeMillis();
                q.this.l = new Runnable() { // from class: com.byazt.uvh.q.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (q.this.l == this && q.this.w) {
                            com.byazt.md.qg qgVarW3 = com.byazt.md.q.n().w();
                            boolean zQg3 = com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW3.qg());
                            if (!com.byazt.fho.qg.n(qgVarW3.q(), zQg3, com.byazt.fho.qg.qg("jank_cycle_observe", qgVarW3.s()))) {
                                q.this.l = null;
                                q.this.w = false;
                                q.this.w();
                                return;
                            }
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                List<s> listN = q.this.s.n(q.this.fs, jCurrentTimeMillis);
                                q.this.fs = jCurrentTimeMillis;
                                w wVarN = com.byazt.uvh.n.n(listN, qgVarW3.rv(), 0, false, jCurrentTimeMillis);
                                q.this.n(wVarN);
                                if (zQg3 && wVarN.qg() > 0) {
                                    com.byazt.br.qg.n(wVarN.l());
                                    listN.size();
                                } else {
                                    listN.size();
                                }
                            } catch (Throwable th) {
                                k.qg("PerfMonitor_JankMonitor", "jank_cycle_observe err: " + th.getMessage());
                            }
                            if (q.this.l == this) {
                                com.byazt.fho.n.n(this, qgVarW3.l());
                            }
                        }
                    }
                };
                com.byazt.fho.n.n(q.this.l);
            }
        });
    }

    public void q() {
        this.w = false;
        com.byazt.fho.n.n(new Runnable() { // from class: com.byazt.uvh.q.6
            @Override // java.lang.Runnable
            public void run() {
                if (q.this.l != null) {
                    com.byazt.fho.n.qg(q.this.l);
                    q.this.l = null;
                }
                q.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.x) {
            return;
        }
        this.x = true;
        this.q.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.x && this.l == null && this.qg.isEmpty()) {
            this.x = false;
            this.q.qg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n n(com.byazt.gd.n nVar, com.byazt.md.qg qgVar) {
        n nVar2 = this.qg.get(nVar.n());
        if (nVar2 != null) {
            n(nVar2, qgVar);
            this.qg.remove(nVar.n());
        }
        qg(qgVar);
        n nVar3 = new n(nVar, qgVar);
        this.qg.put(nVar.n(), nVar3);
        return nVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.md.qg qgVar) {
        if (this.qg.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jTj = qgVar.tj();
        Iterator<Map.Entry<String, n>> it = this.qg.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, n> next = it.next();
            n value = next.getValue();
            if (jCurrentTimeMillis - value.sz > jTj) {
                n(value, qgVar);
                it.remove();
                next.getKey();
            }
        }
        w();
    }

    private void qg(com.byazt.md.qg qgVar) {
        int iCp = qgVar.cp();
        while (this.qg.size() >= iCp) {
            Iterator<Map.Entry<String, n>> it = this.qg.entrySet().iterator();
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, n> next = it.next();
            n(next.getValue(), qgVar);
            it.remove();
            next.getKey();
        }
        w();
    }

    private void n(n nVar, com.byazt.md.qg qgVar) {
        JSONArray jSONArray;
        if (nVar == null || nVar.qg.length() == 0) {
            return;
        }
        try {
            n(nVar);
            n(nVar, qgVar, nVar.tj);
            jSONArray = new JSONArray();
        } catch (Throwable th) {
            try {
                k.qg("PerfMonitor_JankMonitor", "flushOldJankSession err: " + th.getMessage());
                jSONArray = new JSONArray();
            } catch (Throwable th2) {
                nVar.qg = new JSONArray();
                throw th2;
            }
        }
        nVar.qg = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(n nVar, com.byazt.md.qg qgVar, long j) {
        nVar.qg.put(n(j, j + ((long) qgVar.w()), qgVar, nVar, true).n("DESTROY", nVar.w));
        com.byazt.br.qg.n(nVar.n, nVar.qg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final n nVar, com.byazt.md.qg qgVar) {
        final int iX = qgVar.x();
        final int iW = qgVar.w();
        nVar.fs = 0;
        nVar.rv = System.currentTimeMillis();
        nVar.tj = nVar.rv;
        nVar.d = new Runnable() { // from class: com.byazt.uvh.q.7
            @Override // java.lang.Runnable
            public void run() {
                if (nVar.d != this || nVar.oa) {
                    return;
                }
                com.byazt.md.qg qgVarW = com.byazt.md.q.n().w();
                if (!qgVarW.n()) {
                    q.this.n(nVar);
                    return;
                }
                nVar.fs++;
                int i = nVar.fs;
                long j = nVar.rv + (((long) i) * ((long) iW));
                w wVarN = q.this.n(nVar.tj, j, qgVarW, nVar, true);
                nVar.tj = j;
                boolean z = nVar.w;
                if (nVar.x && wVarN.qg() > 0) {
                    nVar.s = wVarN.n();
                    nVar.q = wVarN.s();
                    nVar.l = wVarN.q();
                    nVar.w = true;
                    nVar.x = false;
                    z = false;
                }
                nVar.qg.put(wVarN.n("SHOW_W".concat(String.valueOf(i)), z));
                if (i >= iX) {
                    q.this.n(nVar);
                } else if (nVar.d == this) {
                    com.byazt.fho.n.n(this, iW);
                }
            }
        };
        com.byazt.fho.n.n(nVar.d, iW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(n nVar) {
        if (nVar.d != null) {
            com.byazt.fho.n.qg(nVar.d);
            nVar.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w n(long j, long j2, com.byazt.md.qg qgVar, int i, boolean z) {
        return com.byazt.uvh.n.n(this.s.n(j, j2), qgVar.rv(), i, z, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public w n(long j, long j2, com.byazt.md.qg qgVar, n nVar, boolean z) {
        return com.byazt.uvh.n.n(this.s.n(j, j2), qgVar.rv(), nVar.s, nVar.q, nVar.l, z, nVar.w, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(w wVar) {
        if (wVar == null || wVar.qg() <= 0) {
            return;
        }
        this.rv = wVar.s();
    }

    private void x() {
        this.rv = -1;
    }

    private static boolean s(com.byazt.md.qg qgVar) {
        return qgVar != null && qgVar.n() && qgVar.q() && (com.byazt.fho.qg.qg("jank_cycle_observe", qgVar.qg()) || com.byazt.fho.qg.qg("jank_cycle_observe", qgVar.s()));
    }

    @com.byazt.cp.n(n = {0, 1, 576, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static final class n {
        public long cp;
        public Runnable d;
        public int fs;
        public int l;
        public final com.byazt.gd.n n;
        public boolean oa;
        public int q;
        public long rv;
        public int s;
        public long tj;
        public boolean w;
        public boolean x;
        public JSONArray qg = new JSONArray();
        public final long sz = System.currentTimeMillis();

        public n(com.byazt.gd.n nVar, com.byazt.md.qg qgVar) {
            this.n = nVar;
        }
    }
}
