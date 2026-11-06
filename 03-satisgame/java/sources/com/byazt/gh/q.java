package com.byazt.gh;

import com.anythink.core.e.b;
import com.byazt.rr.rv;
import com.byazt.rr.x;
import com.byazt.tk.k;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 758, 5})
public class q {
    public static volatile boolean n = false;
    public static final AtomicBoolean qg = new AtomicBoolean(false);
    public static volatile Runnable s = null;
    public static volatile int q = 0;

    public static JSONObject n(com.byazt.rr.s sVar) {
        if (sVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", sVar.n());
            jSONObject.put("subCode", sVar.s());
            jSONObject.put(b.a.G, sVar.qg());
            jSONObject.put("summary", sVar.q());
            jSONObject.put("stacks", sVar.l());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject n(rv rvVar) {
        if (rvVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapEventParamConstants.PARAM_NAME, rvVar.n());
            jSONObject.put("version", rvVar.qg());
            jSONObject.put("buildTime", rvVar.w());
            jSONObject.put("taskType", rvVar.q());
            jSONObject.put("from", rvVar.l());
            jSONObject.put("deployment", rvVar.s());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void n() {
        if (com.byazt.nf.rv.qg().oj() && com.byazt.wl.l.tj("com.byted.csj.ext")) {
            if (!com.byazt.wl.l.rv("com.byted.csj.ext") && !com.byazt.wl.l.x("com.byted.csj.ext")) {
                com.byazt.vhv.q.x().tj();
                return;
            }
            if (!n && qg.compareAndSet(false, true)) {
                try {
                    com.byazt.vhv.q.x().rv();
                    final com.byazt.ek.s sVar = (com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new");
                    if (sVar == null) {
                        tj();
                    } else {
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        sVar.n(com.byazt.nf.rv.getContext(), new s() { // from class: com.byazt.gh.q.1
                            public long s = 0;

                            @Override // com.byazt.gh.s, com.byazt.rr.l
                            public void rv() {
                                super.rv();
                                this.s = System.currentTimeMillis() - jCurrentTimeMillis;
                            }

                            @Override // com.byazt.gh.s, com.byazt.rr.l
                            public void n(boolean z, com.byazt.rr.s sVar2, JSONObject jSONObject) {
                                super.n(z, sVar2, jSONObject);
                                if (q.n) {
                                    return;
                                }
                                boolean unused = q.n = z;
                                q.qg.set(false);
                                com.byazt.eji.s.n().n(this.s, System.currentTimeMillis() - jCurrentTimeMillis, z, sVar2, jSONObject, q.q);
                                com.byazt.vhv.q.x().s(z);
                                if (!z) {
                                    q.cp();
                                    return;
                                }
                                Runnable runnable = q.s;
                                if (runnable != null) {
                                    com.byazt.tk.rv.n().removeCallbacks(runnable);
                                }
                                Runnable unused2 = q.s = null;
                                try {
                                    q.d();
                                } catch (Exception unused3) {
                                }
                                sVar.n("data_center", new x() { // from class: com.byazt.gh.q.1.1
                                    @Override // com.byazt.rr.x
                                    public JSONObject n(JSONObject jSONObject2) {
                                        int iOptInt;
                                        if (jSONObject2 == null || (iOptInt = jSONObject2.optInt("data_type", -1)) == -1) {
                                            return null;
                                        }
                                        return com.byazt.kld.n.n(iOptInt);
                                    }
                                });
                            }
                        });
                    }
                } catch (Exception e) {
                    k.qg("PitayaUtils", "doPitayaInitTask error:" + e.getMessage());
                    com.byazt.eji.s.n().n("pitaya_init", (JSONObject) null, e);
                    tj();
                }
            }
        }
    }

    private static void tj() {
        qg.set(false);
        com.byazt.vhv.q.x().s(false);
        cp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cp() {
        if (q >= 5) {
            s = null;
            return;
        }
        Runnable runnable = s;
        if (runnable == null) {
            runnable = new Runnable() { // from class: com.byazt.gh.q.2
                @Override // java.lang.Runnable
                public void run() {
                    q.n();
                }
            };
            s = runnable;
        } else {
            com.byazt.tk.rv.n().removeCallbacks(runnable);
        }
        q++;
        com.byazt.tk.rv.n().postDelayed(runnable, ((long) q) * 1000);
    }

    public static boolean qg() {
        return n;
    }

    public static List<? extends com.byazt.qg.s> s() {
        return Arrays.asList(com.byazt.vhv.q.x(), com.byazt.wlo.n.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        Iterator<? extends com.byazt.qg.s> it = s().iterator();
        while (it.hasNext()) {
            it.next().update();
        }
    }

    public static void n(final String str, final JSONObject jSONObject) {
        final com.byazt.ek.s sVar;
        if (com.byazt.vzq.s.s() && (sVar = (com.byazt.ek.s) com.byazt.qp.q.n("pitaya_new")) != null) {
            com.byazt.ag.qg.n(new com.byazt.qit.x("csj-pitaya-applog") { // from class: com.byazt.gh.q.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.ek.s sVar2 = sVar;
                        String str2 = str;
                        JSONObject jSONObject2 = jSONObject;
                        sVar2.n(str2, jSONObject2 != null ? jSONObject2.toString() : null);
                    } catch (Throwable th) {
                        k.qg("AdLogSwitchUtils", "pitaya onAppLogEvent error:" + th.getMessage());
                    }
                }
            });
        }
    }
}
