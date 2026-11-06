package com.byazt.fh;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 890, 121})
public final class x {
    public static final x pr = new x();
    public Runnable c;
    public boolean fw;
    public volatile boolean uc;
    public long zo;
    public final Map<String, pr> hw = new LinkedHashMap();
    public final c hn = new c();
    public final hw x = new hw(new hw.pr() { // from class: com.byazt.fh.x.1
        @Override // com.byazt.fh.hw.pr
        public void pr(hn hnVar) {
            x.this.hn.pr(hnVar);
        }
    });

    private x() {
    }

    public static x pr() {
        return pr;
    }

    public void pr(final com.byazt.tj.pr prVar) {
        if (prVar == null || TextUtils.isEmpty(prVar.pr())) {
            return;
        }
        com.byazt.kf.hw hwVarUc = com.byazt.kf.x.pr().uc();
        if (!hwVarUc.pr() || !com.byazt.ai.hw.pr(prVar.pr(), hwVarUc.hw())) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hw hwVarUc2 = com.byazt.kf.x.pr().uc();
                if (hwVarUc2.pr() && com.byazt.ai.hw.pr(prVar.pr(), hwVarUc2.hw())) {
                    x.this.pr(hwVarUc2);
                    pr prVarPr = x.this.pr(prVar, hwVarUc2);
                    x.this.x();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    uc ucVarPr = x.this.pr(jCurrentTimeMillis - ((long) hwVarUc2.c()), jCurrentTimeMillis, hwVarUc2, 0, false);
                    prVarPr.uc = ucVarPr.hw() > 0;
                    prVarPr.fw = !prVarPr.uc;
                    prVarPr.hn = ucVarPr.pr();
                    prVarPr.x = ucVarPr.hn();
                    prVarPr.c = ucVarPr.x();
                    prVarPr.vk = jCurrentTimeMillis;
                    prVarPr.hw.put(ucVarPr.pr("PRE_SHOW", prVarPr.uc));
                    prVarPr.hw.length();
                }
            }
        });
    }

    public void pr(final String str) {
        if (TextUtils.isEmpty(str) || !com.byazt.kf.x.pr().uc().pr()) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.3
            @Override // java.lang.Runnable
            public void run() {
                pr prVar;
                com.byazt.kf.hw hwVarUc = com.byazt.kf.x.pr().uc();
                if (hwVarUc.pr() && (prVar = (pr) x.this.hw.get(str)) != null && !prVar.m) {
                    x.this.x();
                    if (prVar.k == null) {
                        x.this.hw(prVar, hwVarUc);
                    }
                }
            }
        });
    }

    public void hw(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hw hwVarUc = com.byazt.kf.x.pr().uc();
                final pr prVar = (pr) x.this.hw.get(str);
                if (prVar == null || prVar.m) {
                    return;
                }
                prVar.m = true;
                x.this.pr(prVar);
                prVar.w = System.currentTimeMillis();
                if (!hwVarUc.pr()) {
                    if (x.this.hw.get(str) == prVar) {
                        x.this.hw.remove(str);
                        x.this.c();
                        return;
                    }
                    return;
                }
                com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj;
                        pr prVar2;
                        try {
                            com.byazt.kf.hw hwVarUc2 = com.byazt.kf.x.pr().uc();
                            if (!hwVarUc2.pr()) {
                                if (obj == prVar2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            if (prVar.hw.length() == 0) {
                                if (obj == prVar2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            x xVar = x.this;
                            pr prVar3 = prVar;
                            xVar.pr(prVar3, hwVarUc2, prVar3.w);
                        } finally {
                            if (x.this.hw.get(str) == prVar) {
                                x.this.hw.remove(str);
                                x.this.c();
                            }
                        }
                    }
                }, Math.max(hwVarUc.fw(), hwVarUc.c()));
            }
        });
    }

    public void hw() {
        com.byazt.kf.hw hwVarUc = com.byazt.kf.x.pr().uc();
        if (!hwVarUc.hn() || !com.byazt.ai.hw.hw("jank_cycle_observe", hwVarUc.hw()) || this.uc || zo.nt().y() || !com.byazt.sf.hw.hw()) {
            return;
        }
        this.uc = true;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hw hwVarUc2 = com.byazt.kf.x.pr().uc();
                if (!hwVarUc2.hn() || !com.byazt.ai.hw.hw("jank_cycle_observe", hwVarUc2.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                    x.this.uc = false;
                    return;
                }
                if (x.this.c == null) {
                    x.this.x();
                    x.this.zo = System.currentTimeMillis();
                    x.this.c = new Runnable() { // from class: com.byazt.fh.x.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (x.this.c != this) {
                                return;
                            }
                            com.byazt.kf.hw hwVarUc3 = com.byazt.kf.x.pr().uc();
                            if (!hwVarUc3.hn() || !com.byazt.ai.hw.hw("jank_cycle_observe", hwVarUc3.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                                x.this.c = null;
                                x.this.uc = false;
                                x.this.c();
                                return;
                            }
                            try {
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                List<hn> listPr = x.this.hn.pr(x.this.zo, jCurrentTimeMillis);
                                x.this.zo = jCurrentTimeMillis;
                                com.byazt.gve.hw.pr(com.byazt.fh.pr.pr(listPr, hwVarUc3.zo(), 0, false, jCurrentTimeMillis).c());
                                listPr.size();
                            } catch (Throwable th) {
                                ho.hw("PerfMonitor_JankMonitor", "jank_cycle_observe err: " + th.getMessage());
                            }
                            if (x.this.c == this) {
                                com.byazt.ai.pr.pr(this, hwVarUc3.x());
                            }
                        }
                    };
                    com.byazt.ai.pr.pr(x.this.c, hwVarUc2.x());
                }
            }
        });
    }

    public void hn() {
        this.uc = false;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.fh.x.6
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.c != null) {
                    com.byazt.ai.pr.hw(x.this.c);
                    x.this.c = null;
                }
                x.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.fw) {
            return;
        }
        this.fw = true;
        this.x.pr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.fw || this.c != null || !this.hw.isEmpty()) {
            return;
        }
        this.fw = false;
        this.x.hw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public pr pr(com.byazt.tj.pr prVar, com.byazt.kf.hw hwVar) {
        pr prVar2 = this.hw.get(prVar.pr());
        if (prVar2 != null) {
            pr(prVar2, hwVar);
            this.hw.remove(prVar.pr());
        }
        hw(hwVar);
        pr prVar3 = new pr(prVar, hwVar);
        this.hw.put(prVar.pr(), prVar3);
        return prVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.kf.hw hwVar) {
        if (this.hw.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAj = hwVar.aj();
        Iterator<Map.Entry<String, pr>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, pr> next = it.next();
            pr value = next.getValue();
            if (jCurrentTimeMillis - value.g > jAj) {
                pr(value, hwVar);
                it.remove();
                next.getKey();
            }
        }
        c();
    }

    private void hw(com.byazt.kf.hw hwVar) {
        int iVk = hwVar.vk();
        while (this.hw.size() >= iVk) {
            Iterator<Map.Entry<String, pr>> it = this.hw.entrySet().iterator();
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, pr> next = it.next();
            pr(next.getValue(), hwVar);
            it.remove();
            next.getKey();
        }
        c();
    }

    private void pr(pr prVar, com.byazt.kf.hw hwVar) {
        JSONArray jSONArray;
        if (prVar == null || prVar.hw.length() == 0) {
            return;
        }
        try {
            pr(prVar);
            pr(prVar, hwVar, prVar.vk);
            jSONArray = new JSONArray();
        } catch (Throwable th) {
            try {
                ho.hw("PerfMonitor_JankMonitor", "flushOldJankSession err: " + th.getMessage());
                jSONArray = new JSONArray();
            } catch (Throwable th2) {
                prVar.hw = new JSONArray();
                throw th2;
            }
        }
        prVar.hw = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(pr prVar, com.byazt.kf.hw hwVar, long j) {
        prVar.hw.put(pr(j, j + ((long) hwVar.c()), hwVar, prVar, true).pr("DESTROY", prVar.uc));
        com.byazt.gve.hw.pr(prVar.pr, prVar.hw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final pr prVar, com.byazt.kf.hw hwVar) {
        final int iUc = hwVar.uc();
        final int iC = hwVar.c();
        prVar.zo = 0;
        prVar.aj = System.currentTimeMillis();
        prVar.vk = prVar.aj;
        prVar.k = new Runnable() { // from class: com.byazt.fh.x.7
            @Override // java.lang.Runnable
            public void run() {
                if (prVar.k != this || prVar.m) {
                    return;
                }
                com.byazt.kf.hw hwVarUc = com.byazt.kf.x.pr().uc();
                if (!hwVarUc.pr()) {
                    x.this.pr(prVar);
                    return;
                }
                prVar.zo++;
                int i = prVar.zo;
                long j = prVar.aj + (((long) i) * ((long) iC));
                uc ucVarPr = x.this.pr(prVar.vk, j, hwVarUc, prVar, true);
                prVar.vk = j;
                boolean z = prVar.uc;
                if (prVar.fw && ucVarPr.hw() > 0) {
                    prVar.hn = ucVarPr.pr();
                    prVar.x = ucVarPr.hn();
                    prVar.c = ucVarPr.x();
                    prVar.uc = true;
                    prVar.fw = false;
                    z = false;
                }
                prVar.hw.put(ucVarPr.pr("SHOW_W".concat(String.valueOf(i)), z));
                if (i >= iUc) {
                    x.this.pr(prVar);
                } else if (prVar.k == this) {
                    com.byazt.ai.pr.pr(this, iC);
                }
            }
        };
        com.byazt.ai.pr.pr(prVar.k, iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(pr prVar) {
        if (prVar.k != null) {
            com.byazt.ai.pr.hw(prVar.k);
            prVar.k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uc pr(long j, long j2, com.byazt.kf.hw hwVar, int i, boolean z) {
        return com.byazt.fh.pr.pr(this.hn.pr(j, j2), hwVar.zo(), i, z, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uc pr(long j, long j2, com.byazt.kf.hw hwVar, pr prVar, boolean z) {
        return com.byazt.fh.pr.pr(this.hn.pr(j, j2), hwVar.zo(), prVar.hn, prVar.x, prVar.c, z, prVar.uc, j2);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 890, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static final class pr {
        public long aj;
        public int c;
        public boolean fw;
        public int hn;
        public Runnable k;
        public boolean m;
        public final com.byazt.tj.pr pr;
        public boolean uc;
        public long vk;
        public long w;
        public int x;
        public int zo;
        public JSONArray hw = new JSONArray();
        public final long g = System.currentTimeMillis();

        public pr(com.byazt.tj.pr prVar, com.byazt.kf.hw hwVar) {
            this.pr = prVar;
        }
    }
}
