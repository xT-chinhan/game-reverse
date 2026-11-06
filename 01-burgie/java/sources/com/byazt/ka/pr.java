package com.byazt.ka;

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
@com.byazt.vzx.pr(pr = {0, 1, 1547, 37})
public final class pr {
    public static final pr pr = new pr();
    public volatile boolean c;
    public hn hn;
    public final Map<String, C0113pr> hw = new LinkedHashMap();
    public Runnable x;

    private pr() {
    }

    public static pr pr() {
        return pr;
    }

    public void pr(final com.byazt.tj.pr prVar) {
        if (prVar == null || TextUtils.isEmpty(prVar.pr())) {
            return;
        }
        com.byazt.kf.pr prVarFw = x.pr().fw();
        if (!prVarFw.pr() || !com.byazt.ai.hw.pr(prVar.pr(), prVarFw.hw())) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.pr prVarFw2 = x.pr().fw();
                if (prVarFw2.pr() && com.byazt.ai.hw.pr(prVar.pr(), prVarFw2.hw())) {
                    pr.this.pr(prVarFw2);
                    C0113pr c0113prPr = pr.this.pr(prVar, prVarFw2);
                    c0113prPr.hw.pr(System.currentTimeMillis(), 0, false, false);
                    c0113prPr.uc = true;
                    c0113prPr.fw = false;
                    c0113prPr.c = false;
                    c0113prPr.x = 0;
                }
            }
        });
    }

    public void pr(final String str) {
        if (TextUtils.isEmpty(str) || !x.pr().fw().pr()) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.2
            @Override // java.lang.Runnable
            public void run() {
                C0113pr c0113pr;
                com.byazt.kf.pr prVarFw = x.pr().fw();
                if (prVarFw.pr() && (c0113pr = (C0113pr) pr.this.hw.get(str)) != null && !c0113pr.vk) {
                    pr.this.hw(c0113pr);
                    if (c0113pr.aj == null) {
                        pr.this.hw(c0113pr, prVarFw);
                    }
                }
            }
        });
    }

    public void hw(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.pr prVarFw = x.pr().fw();
                final C0113pr c0113pr = (C0113pr) pr.this.hw.get(str);
                if (c0113pr == null || c0113pr.vk) {
                    return;
                }
                c0113pr.vk = true;
                pr.this.hn(c0113pr);
                if (!prVarFw.pr()) {
                    if (pr.this.hw.get(str) == c0113pr) {
                        pr.this.hw.remove(str);
                        return;
                    }
                    return;
                }
                com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj;
                        C0113pr c0113pr2;
                        try {
                            if (!x.pr().fw().pr()) {
                                if (obj == c0113pr2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                            if (!c0113pr.w && (c0113pr.hn.length() != 0 || c0113pr.uc)) {
                                pr.this.pr(c0113pr);
                                c0113pr.w = true;
                                if (obj == c0113pr2) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        } finally {
                            if (pr.this.hw.get(str) == c0113pr) {
                                pr.this.hw.remove(str);
                            }
                        }
                    }
                }, prVarFw.fw());
            }
        });
    }

    public void hw() {
        com.byazt.kf.pr prVarFw = x.pr().fw();
        if (!prVarFw.hn() || !com.byazt.ai.hw.hw("cpu_cycle_observe", prVarFw.hw()) || this.c || zo.nt().y() || !com.byazt.sf.hw.hw()) {
            return;
        }
        this.c = true;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.kf.pr prVarFw2 = x.pr().fw();
                if (!prVarFw2.hn() || !com.byazt.ai.hw.hw("cpu_cycle_observe", prVarFw2.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                    pr.this.c = false;
                    return;
                }
                if (pr.this.x != null) {
                    return;
                }
                pr.this.hn = new hn();
                pr.this.hn.pr(System.currentTimeMillis(), 0, false, false);
                pr.this.x = new Runnable() { // from class: com.byazt.ka.pr.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pr.this.x != this) {
                            return;
                        }
                        com.byazt.kf.pr prVarFw3 = x.pr().fw();
                        if (!prVarFw3.hn() || !com.byazt.ai.hw.hw("cpu_cycle_observe", prVarFw3.hw()) || zo.nt().y() || !com.byazt.sf.hw.hw()) {
                            pr.this.x = null;
                            pr.this.hn = null;
                            pr.this.c = false;
                            return;
                        }
                        try {
                            if (pr.this.hn == null) {
                                pr.this.hn = new hn();
                                pr.this.hn.pr(System.currentTimeMillis(), 0, false, false);
                            }
                            com.byazt.gve.pr.pr(pr.this.hn.pr(System.currentTimeMillis(), 0, false, false).hn());
                        } catch (Throwable th) {
                            ho.hw("PerfMonitor_CpuMonitor", "cpu_cycle_observe err: " + th.getMessage());
                        }
                        if (pr.this.x == this) {
                            com.byazt.ai.pr.pr(this, prVarFw3.x());
                        }
                    }
                };
                com.byazt.ai.pr.pr(pr.this.x, prVarFw2.x());
            }
        });
    }

    public void hn() {
        this.c = false;
        com.byazt.ai.pr.pr(new Runnable() { // from class: com.byazt.ka.pr.5
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.x != null) {
                    com.byazt.ai.pr.hw(pr.this.x);
                    pr.this.x = null;
                }
                pr.this.hn = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0113pr pr(com.byazt.tj.pr prVar, com.byazt.kf.pr prVar2) {
        C0113pr c0113pr = this.hw.get(prVar.pr());
        if (c0113pr != null) {
            pr(c0113pr, prVar2);
            this.hw.remove(prVar.pr());
        }
        hw(prVar2);
        C0113pr c0113pr2 = new C0113pr(prVar, prVar2);
        this.hw.put(prVar.pr(), c0113pr2);
        return c0113pr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.kf.pr prVar) {
        if (this.hw.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jZo = prVar.zo();
        Iterator<Map.Entry<String, C0113pr>> it = this.hw.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0113pr> next = it.next();
            C0113pr value = next.getValue();
            if (jCurrentTimeMillis - value.k > jZo) {
                pr(value, prVar);
                it.remove();
                next.getKey();
            }
        }
    }

    private void hw(com.byazt.kf.pr prVar) {
        int iAj = prVar.aj();
        while (this.hw.size() >= iAj) {
            Iterator<Map.Entry<String, C0113pr>> it = this.hw.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, C0113pr> next = it.next();
                pr(next.getValue(), prVar);
                it.remove();
                next.getKey();
            } else {
                return;
            }
        }
    }

    private void pr(C0113pr c0113pr, com.byazt.kf.pr prVar) {
        JSONArray jSONArray;
        if (c0113pr == null || c0113pr.w) {
            return;
        }
        if (c0113pr.hn.length() == 0 && !c0113pr.uc) {
            return;
        }
        try {
            hn(c0113pr);
            pr(c0113pr);
            c0113pr.w = true;
            jSONArray = new JSONArray();
        } catch (Throwable th) {
            try {
                ho.hw("PerfMonitor_CpuMonitor", "flushOldCpuSession err: " + th.getMessage());
                jSONArray = new JSONArray();
            } catch (Throwable th2) {
                c0113pr.hn = new JSONArray();
                throw th2;
            }
        }
        c0113pr.hn = jSONArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(C0113pr c0113pr) {
        hw(c0113pr);
        c0113pr.hn.put(pr(c0113pr, true).pr("DESTROY", c0113pr.c));
        com.byazt.gve.pr.pr(c0113pr.pr, c0113pr.hn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(C0113pr c0113pr) {
        if (c0113pr == null || !c0113pr.uc || c0113pr.fw) {
            return;
        }
        hw hwVarPr = c0113pr.hw.pr(System.currentTimeMillis(), 0, false, false);
        c0113pr.c = hwVarPr.hw();
        c0113pr.x = hwVarPr.pr();
        c0113pr.hn.put(hwVarPr.pr("PRE_SHOW", c0113pr.c));
        c0113pr.fw = true;
        c0113pr.hn.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final C0113pr c0113pr, com.byazt.kf.pr prVar) {
        final int iUc = prVar.uc();
        final int iC = prVar.c();
        c0113pr.zo = 0;
        c0113pr.aj = new Runnable() { // from class: com.byazt.ka.pr.6
            @Override // java.lang.Runnable
            public void run() {
                if (c0113pr.aj != this || c0113pr.vk) {
                    return;
                }
                if (!x.pr().fw().pr()) {
                    pr.this.hn(c0113pr);
                    return;
                }
                c0113pr.zo++;
                int i = c0113pr.zo;
                c0113pr.hn.put(pr.this.pr(c0113pr, true).pr("SHOW_W".concat(String.valueOf(i)), c0113pr.c));
                if (i >= iUc) {
                    pr.this.hn(c0113pr);
                } else if (c0113pr.aj == this) {
                    com.byazt.ai.pr.pr(this, iC);
                }
            }
        };
        com.byazt.ai.pr.pr(c0113pr.aj, iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(C0113pr c0113pr) {
        if (c0113pr.aj != null) {
            com.byazt.ai.pr.hw(c0113pr.aj);
            c0113pr.aj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hw pr(C0113pr c0113pr, boolean z) {
        return c0113pr.hw.pr(System.currentTimeMillis(), c0113pr.x, z, c0113pr.c);
    }

    /* JADX INFO: renamed from: com.byazt.ka.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1547, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0113pr {
        public Runnable aj;
        public boolean c;
        public boolean fw;
        public final com.byazt.tj.pr pr;
        public boolean uc;
        public boolean vk;
        public boolean w;
        public int x;
        public int zo;
        public final hn hw = new hn();
        public JSONArray hn = new JSONArray();
        public final long k = System.currentTimeMillis();

        public C0113pr(com.byazt.tj.pr prVar, com.byazt.kf.pr prVar2) {
            this.pr = prVar;
        }
    }
}
