package com.byazt.ib;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.kf.x;
import com.byazt.sd.zo;
import com.mar.sdk.MARCode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1213, 37})
public final class pr {
    public static final pr pr = new pr();
    public hn hn;
    public Runnable x;
    public final Map<String, C0092pr> hw = new LinkedHashMap();
    public volatile boolean c = false;

    private pr() {
    }

    public static pr pr() {
        return pr;
    }

    public void pr(final com.byazt.tj.pr prVar) {
        if (prVar == null || TextUtils.isEmpty(prVar.pr())) {
            return;
        }
        com.byazt.kf.hn hnVarC = x.pr().c();
        if (!hnVarC.pr() || !com.byazt.ai.hw.pr(prVar.pr(), hnVarC.hw())) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hn hnVarC2 = x.pr().c();
                if (hnVarC2.pr() && com.byazt.ai.hw.pr(prVar.pr(), hnVarC2.hw())) {
                    pr.this.pr(hnVarC2);
                    C0092pr c0092prPr = pr.this.pr(prVar, hnVarC2);
                    c0092prPr.hn.put(c0092prPr.hw.pr(System.currentTimeMillis()).pr("PRE_SHOW"));
                    c0092prPr.hn.length();
                }
            }
        });
    }

    public void pr(final String str) {
        if (TextUtils.isEmpty(str) || !x.pr().c().pr()) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.2
            @Override // java.lang.Runnable
            public void run() {
                C0092pr c0092pr;
                com.byazt.kf.hn hnVarC = x.pr().c();
                if (hnVarC.pr() && (c0092pr = (C0092pr) pr.this.hw.get(str)) != null && !c0092pr.uc && c0092pr.c == null) {
                    pr.this.pr(c0092pr, hnVarC);
                }
            }
        });
    }

    public void hw(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hn hnVarC = x.pr().c();
                final C0092pr c0092pr = (C0092pr) pr.this.hw.get(str);
                if (c0092pr == null || c0092pr.uc) {
                    return;
                }
                c0092pr.uc = true;
                pr.this.hw(c0092pr);
                if (!hnVarC.pr()) {
                    if (pr.this.hw.get(str) == c0092pr) {
                        pr.this.hw.remove(str);
                    }
                } else {
                    int iFw = x.pr().c().fw();
                    c0092pr.hn.length();
                    com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (x.pr().c().pr()) {
                                    if (c0092pr.hn.length() != 0) {
                                        c0092pr.hn.put(c0092pr.hw.pr(System.currentTimeMillis()).pr("DESTROY"));
                                        c0092pr.hn.length();
                                        com.byazt.gve.hn.pr(c0092pr.pr, c0092pr.hn);
                                        c0092pr.hn.length();
                                        if (pr.this.hw.get(str) != c0092pr) {
                                            pr.this.hw.size();
                                            return;
                                        }
                                    } else if (pr.this.hw.get(str) != c0092pr) {
                                        pr.this.hw.size();
                                        return;
                                    }
                                } else if (pr.this.hw.get(str) != c0092pr) {
                                    pr.this.hw.size();
                                    return;
                                }
                                pr.this.hw.remove(str);
                                pr.this.hw.size();
                            } catch (Throwable th) {
                                if (pr.this.hw.get(str) == c0092pr) {
                                    pr.this.hw.remove(str);
                                    pr.this.hw.size();
                                } else {
                                    pr.this.hw.size();
                                }
                                throw th;
                            }
                        }
                    }, iFw);
                }
            }
        });
    }

    public void hw() {
        com.byazt.kf.hn hnVarC = x.pr().c();
        if (!hnVarC.hn() || !com.byazt.ai.hw.hw("mem_cycle_observe", hnVarC.hw()) || this.c || zo.nt().y() || !com.byazt.sf.hw.hw()) {
            return;
        }
        this.c = true;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.hn hnVarC2 = x.pr().c();
                if (!hnVarC2.hn() || !com.byazt.ai.hw.hw("mem_cycle_observe", hnVarC2.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                    pr.this.c = false;
                    return;
                }
                if (pr.this.x == null) {
                    if (pr.this.hn == null) {
                        pr.this.hn = new hn();
                    }
                    int iX = hnVarC2.x();
                    pr.this.x = new Runnable() { // from class: com.byazt.ib.pr.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (pr.this.x != this) {
                                return;
                            }
                            com.byazt.kf.hn hnVarC3 = x.pr().c();
                            if (!hnVarC3.hn() || !com.byazt.ai.hw.hw("mem_cycle_observe", hnVarC3.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                                pr.this.x = null;
                                pr.this.c = false;
                                return;
                            }
                            try {
                                com.byazt.gve.hn.pr(pr.this.hn.pr(System.currentTimeMillis()).hw());
                            } catch (Throwable th) {
                                ho.hw("PerfMonitor_MemoryMonitor", "mem_cycle_observe sample err: " + th.getMessage());
                            }
                            if (pr.this.x == this) {
                                com.byazt.ai.pr.pr(this, hnVarC3.x());
                            }
                        }
                    };
                    com.byazt.ai.pr.pr(pr.this.x, iX);
                }
            }
        });
    }

    public void hn() {
        this.c = false;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ib.pr.5
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.x != null) {
                    com.byazt.ai.pr.hw(pr.this.x);
                    pr.this.x = null;
                }
            }
        });
    }

    private void pr(C0092pr c0092pr) {
        JSONArray jSONArray;
        if (c0092pr == null || c0092pr.hn.length() == 0) {
            return;
        }
        try {
            hw(c0092pr);
            c0092pr.hn.put(c0092pr.hw.pr(System.currentTimeMillis()).pr("DESTROY"));
            c0092pr.hn.length();
            com.byazt.gve.hn.pr(c0092pr.pr, c0092pr.hn);
            c0092pr.hn.length();
            jSONArray = new JSONArray();
        } catch (Throwable th) {
            try {
                ho.hw("PerfMonitor_MemoryMonitor", "flushOldSession err: " + th.getMessage());
                jSONArray = new JSONArray();
            } catch (Throwable th2) {
                c0092pr.hn = new JSONArray();
                throw th2;
            }
        }
        c0092pr.hn = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0092pr pr(com.byazt.tj.pr prVar, com.byazt.kf.hn hnVar) {
        C0092pr c0092pr = this.hw.get(prVar.pr());
        if (c0092pr != null) {
            pr(c0092pr);
            this.hw.remove(prVar.pr());
        }
        hw(hnVar);
        C0092pr c0092pr2 = new C0092pr(prVar, hnVar);
        this.hw.put(prVar.pr(), c0092pr2);
        return c0092pr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.kf.hn hnVar) {
        if (this.hw.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jZo = hnVar.zo();
        Iterator<Map.Entry<String, C0092pr>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0092pr> next = it.next();
            C0092pr value = next.getValue();
            if (jCurrentTimeMillis - value.fw > jZo) {
                pr(value);
                it.remove();
                next.getKey();
            }
        }
    }

    private void hw(com.byazt.kf.hn hnVar) {
        int iAj = hnVar.aj();
        while (this.hw.size() >= iAj) {
            Iterator<Map.Entry<String, C0092pr>> it = this.hw.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, C0092pr> next = it.next();
                pr(next.getValue());
                it.remove();
                next.getKey();
                this.hw.size();
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final C0092pr c0092pr, com.byazt.kf.hn hnVar) {
        final int iUc = hnVar.uc();
        final int iC = hnVar.c();
        c0092pr.x = 0;
        c0092pr.c = new Runnable() { // from class: com.byazt.ib.pr.6
            @Override // java.lang.Runnable
            public void run() {
                if (c0092pr.c != this || c0092pr.uc) {
                    return;
                }
                if (!x.pr().c().pr()) {
                    pr.this.hw(c0092pr);
                    return;
                }
                c0092pr.x++;
                int i = c0092pr.x;
                c0092pr.hn.put(c0092pr.hw.pr(System.currentTimeMillis()).pr("SHOW_W".concat(String.valueOf(i))));
                c0092pr.hn.length();
                if (i >= iUc) {
                    pr.this.hw(c0092pr);
                } else if (c0092pr.c == this) {
                    com.byazt.ai.pr.pr(this, iC);
                }
            }
        };
        com.byazt.ai.pr.pr(c0092pr.c, iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(C0092pr c0092pr) {
        if (c0092pr.c != null) {
            com.byazt.ai.pr.hw(c0092pr.c);
            c0092pr.c = null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.ib.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1213, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0092pr {
        public Runnable c;
        public final com.byazt.tj.pr pr;
        public boolean uc;
        public int x;
        public final hn hw = new hn();
        public JSONArray hn = new JSONArray();
        public final long fw = System.currentTimeMillis();

        public C0092pr(com.byazt.tj.pr prVar, com.byazt.kf.hn hnVar) {
            this.pr = prVar;
        }
    }
}
