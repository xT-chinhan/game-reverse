package com.byazt.ba;

import com.byazt.ca.ho;
import com.byazt.la.aj;
import com.byazt.la.fw;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.y;
import com.byazt.zp.m;
import com.byazt.zp.zo;
import com.byazt.zs.uc;
import com.mar.sdk.IAction;
import com.taptap.sdk.db.constant.Common;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 667, 121})
public class x {
    public static volatile boolean pr = false;
    public static final AtomicBoolean hw = new AtomicBoolean(false);
    public static volatile Runnable hn = null;
    public static volatile int x = 0;

    public static JSONObject pr(com.byazt.la.hn hnVar) {
        if (hnVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, hnVar.pr());
            jSONObject.put("subCode", hnVar.hn());
            jSONObject.put("domain", hnVar.hw());
            jSONObject.put("summary", hnVar.x());
            jSONObject.put("stacks", hnVar.c());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static JSONObject pr(aj ajVar) {
        if (ajVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.System.NAME, ajVar.pr());
            jSONObject.put("version", ajVar.hw());
            jSONObject.put("buildTime", ajVar.uc());
            jSONObject.put(IAction.TaskKey.TaskType, ajVar.x());
            jSONObject.put("from", ajVar.c());
            jSONObject.put("deployment", ajVar.hn());
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public static void pr() {
        if (!a.hw().v() || !m.aj("com.byted.csj.ext")) {
            return;
        }
        if (!m.zo("com.byted.csj.ext") && !m.fw("com.byted.csj.ext")) {
            com.byazt.ak.x.fw().vk();
            return;
        }
        if (pr || !hw.compareAndSet(false, true)) {
            return;
        }
        try {
            com.byazt.ak.x.fw().aj();
            final com.byazt.r.hn hnVar = (com.byazt.r.hn) uc.pr("pitaya_new");
            if (hnVar == null) {
                vk();
            } else {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                hnVar.pr(a.getContext(), new hn() { // from class: com.byazt.ba.x.1
                    public long hn = 0;

                    @Override // com.byazt.ba.hn, com.byazt.la.c
                    public void aj() {
                        super.aj();
                        this.hn = System.currentTimeMillis() - jCurrentTimeMillis;
                    }

                    @Override // com.byazt.ba.hn, com.byazt.la.c
                    public void pr(boolean z, com.byazt.la.hn hnVar2, JSONObject jSONObject) {
                        super.pr(z, hnVar2, jSONObject);
                        if (!x.pr) {
                            boolean unused = x.pr = z;
                            x.hw.set(false);
                            com.byazt.xk.hw.pr().pr(this.hn, System.currentTimeMillis() - jCurrentTimeMillis, z, hnVar2, jSONObject, x.x);
                            com.byazt.ak.x.fw().hn(z);
                            if (!z) {
                                x.w();
                                return;
                            }
                            Runnable runnable = x.hn;
                            if (runnable != null) {
                                com.byazt.ca.aj.pr().removeCallbacks(runnable);
                            }
                            Runnable unused2 = x.hn = null;
                            try {
                                x.k();
                            } catch (Exception e) {
                            }
                            hnVar.pr("data_center", new fw() { // from class: com.byazt.ba.x.1.1
                                @Override // com.byazt.la.fw
                                public JSONObject pr(JSONObject jSONObject2) {
                                    int iOptInt;
                                    if (jSONObject2 == null || (iOptInt = jSONObject2.optInt("data_type", -1)) == -1) {
                                        return null;
                                    }
                                    return com.byazt.yl.pr.pr(iOptInt);
                                }
                            });
                        }
                    }
                });
            }
        } catch (Exception e) {
            ho.hw("PitayaUtils", "doPitayaInitTask error:" + e.getMessage());
            com.byazt.xk.hw.pr().pr("pitaya_init", (JSONObject) null, e);
            vk();
        }
    }

    private static void vk() {
        hw.set(false);
        com.byazt.ak.x.fw().hn(false);
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        if (x >= 5) {
            hn = null;
            return;
        }
        Runnable runnable = hn;
        if (runnable == null) {
            runnable = new Runnable() { // from class: com.byazt.ba.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.pr();
                }
            };
            hn = runnable;
        } else {
            com.byazt.ca.aj.pr().removeCallbacks(runnable);
        }
        x++;
        com.byazt.ca.aj.pr().postDelayed(runnable, ((long) x) * 1000);
    }

    public static boolean hw() {
        return pr;
    }

    public static List<? extends com.byazt.ep.hn> hn() {
        return Arrays.asList(com.byazt.ak.x.fw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k() {
        Iterator<? extends com.byazt.ep.hn> it = hn().iterator();
        while (it.hasNext()) {
            it.next().update();
        }
    }

    public static void pr(final String str, final JSONObject jSONObject) {
        final com.byazt.r.hn hnVar;
        if (y.hn() && (hnVar = (com.byazt.r.hn) uc.pr("pitaya_new")) != null) {
            zo.pr(new com.byazt.xlm.fw("csj-pitaya-applog") { // from class: com.byazt.ba.x.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.r.hn hnVar2 = hnVar;
                        String str2 = str;
                        JSONObject jSONObject2 = jSONObject;
                        hnVar2.pr(str2, jSONObject2 != null ? jSONObject2.toString() : null);
                    } catch (Throwable th) {
                        ho.hw("AdLogSwitchUtils", "pitaya onAppLogEvent error:" + th.getMessage());
                    }
                }
            });
        }
    }
}
