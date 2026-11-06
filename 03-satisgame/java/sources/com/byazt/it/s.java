package com.byazt.it;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gp.fs;
import com.byazt.gp.tj;
import com.byazt.rb.l;
import com.byazt.vf.oj;
import com.byazt.vgx.w;
import com.byazt.vy.d;
import com.byazt.vy.hu;
import com.byazt.zo.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 879, 8})
public class s {
    public static volatile boolean q = false;
    public static long qg = 0;
    public static boolean s = false;
    public static long w;
    public static long x;
    public static Runnable n = new Runnable() { // from class: com.byazt.it.s.3
        @Override // java.lang.Runnable
        public void run() {
            com.byazt.rb.qg.n("TMe", "--==-- queueSize: " + ((ThreadPoolExecutor) l.w()).getQueue().size());
            l.n(s.n, 5000L);
        }
    };
    public static final ComponentCallbacks l = new ComponentCallbacks() { // from class: com.byazt.it.s.4
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            com.byazt.ra.n.n().qg();
        }
    };

    public interface qg {
        public static final String n = hu.n() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static long n() {
        return qg;
    }

    public static boolean qg() {
        return s;
    }

    public static boolean s() {
        return q;
    }

    private static void oa() {
        com.byazt.vv.n nVarAe;
        if (!s || (nVarAe = com.byazt.qt.n.d().ae()) == null) {
            return;
        }
        nVarAe.n();
        com.byazt.qt.n.d().n((com.byazt.vv.n) null);
    }

    private static void n(boolean z) {
        s = z;
        oa();
    }

    public static void n(com.byazt.jp.n nVar, Context context, JSONObject jSONObject) {
        n(context);
        x.n(jSONObject, "s-init_context");
        n(nVar, jSONObject);
        x.n(jSONObject, "s-global_info_end");
        qg(context, jSONObject);
    }

    private static void qg(final Context context, final JSONObject jSONObject) {
        com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "msdk_init v1.............");
        n(true);
        qg = SystemClock.elapsedRealtime();
        k();
        q.n(context.getApplicationContext());
        x.n(jSONObject, "s-prepare");
        n(jSONObject);
        x.n(jSONObject, "s-local_cfg");
        if (com.byazt.qt.qg.n().s()) {
            l.n(new Runnable() { // from class: com.byazt.it.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.s(context, jSONObject);
                    x.n(jSONObject, "s-adlog2");
                    tj.n(com.byazt.qt.qg.getContext());
                }
            });
        } else {
            s(context, jSONObject);
        }
        q = true;
        x.n(jSONObject, "s-adlog");
        com.byazt.qt.qg.n().n(true, jSONObject, new com.byazt.ti.qg() { // from class: com.byazt.it.s.2
            @Override // com.byazt.ti.qg
            public void n() {
                com.byazt.qt.qg.n().n((com.byazt.ti.qg) null);
                if (s.hd()) {
                    fs.n().qg();
                }
                l.q(new Runnable() { // from class: com.byazt.it.s.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tj.n(com.byazt.qt.qg.getContext());
                        s.qg(context, s.qg);
                        s.sz();
                    }
                });
                s.cd();
            }
        });
        qg(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Context context, JSONObject jSONObject) {
        com.byazt.cw.n.n(com.byazt.qt.n.d().oa());
        tj.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Context context, long j) {
        if (!q.n()) {
            com.byazt.rb.qg.n("TMe", "-----==---- 延时上报sdk_init");
            q.n(j);
        } else {
            com.byazt.rb.qg.n("TMe", "-----==---- 正常上报sdk_init");
            q.qg(j);
        }
    }

    private static void n(com.byazt.jp.n nVar, JSONObject jSONObject) {
        com.byazt.qt.n.d().n(nVar.sz());
        com.byazt.qt.n.d().n(System.currentTimeMillis());
        x.n(jSONObject, "s-global_info_1");
        com.byazt.qt.n.d().s(nVar.n());
        com.byazt.qt.n.d().w(nVar.qg());
        com.byazt.qt.n.d().s(nVar.k());
        com.byazt.qt.n.d().l(nVar.w().s());
        com.byazt.qt.n.d().w(nVar.w().q());
        com.byazt.qt.n.d().n(nVar.w().qg());
        com.byazt.qt.n.d().n(nVar.w().l());
        com.byazt.qt.n.d().n(nVar.w().w());
        com.byazt.qt.n.d().q(nVar.w().n());
        com.byazt.qt.n.d().q(nVar.q());
        com.byazt.qt.n.d().qg(nVar.l());
        com.byazt.qt.n.d().l(nVar.w().x());
        com.byazt.qt.n.d().n(nVar.w().fs());
        com.byazt.qt.n.d().n(nVar.rv(), true);
        com.byazt.qt.n.d().x(nVar.w().rv());
        com.byazt.qt.n.d().qg(nVar.tj());
        com.byazt.qt.n.d().s(nVar.oa());
        com.byazt.qt.n.d().x(nVar.cp());
        x.n(jSONObject, "s-global_info_2");
        com.byazt.qt.n.d().n(nVar.d());
        x.n(jSONObject, "s-global_info_3");
        com.byazt.qt.n.d().fs(nVar.x().qg());
        com.byazt.qt.n.d().fs(nVar.x().n());
        com.byazt.qt.n.d().rv(nVar.x().s());
        com.byazt.qt.n.d().tj(nVar.x().q());
        if (nVar.oa() != null) {
            try {
                com.byazt.qt.n.d().n((List<String>) nVar.oa().get(MediationConstant.GM_EXTRA_KEY_PRIME_RIT_LIST));
            } catch (Throwable unused) {
            }
        }
        if (nVar.fs() != null) {
            com.byazt.qt.n.d().qg(nVar.fs().n());
        }
    }

    public static void n(SparseArray<Object> sparseArray) {
        for (com.byazt.ju.q qVar : com.byazt.ya.qg.n().s()) {
            if (qVar != null) {
                try {
                    qVar.n(com.byazt.qt.n.d().ou(), sparseArray);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String q() {
        try {
            com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(MediationConstant.ADN_PANGLE);
            return qVarN != null ? qVarN.s() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void n(Context context) {
        if (context != null) {
            com.byazt.qt.qg.n(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sz() {
        Application applicationN = ((oj) com.byazt.qp.q.n("system_context")).n();
        if (applicationN == null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "lowMemoryListener注册失败, app = null");
            return;
        }
        com.byazt.rb.qg.n(MediationConstant.TAG, "lowMemoryListener注册成功");
        ComponentCallbacks componentCallbacks = l;
        applicationN.unregisterComponentCallbacks(componentCallbacks);
        applicationN.registerComponentCallbacks(componentCallbacks);
    }

    private static void k() {
        com.byazt.rb.qg.n(MediationConstant.TAG, "AppStateListener开始注册");
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        if (nVarS != null) {
            com.byazt.rb.qg.n(MediationConstant.TAG, "AppStateListener注册成功");
            w = SystemClock.elapsedRealtime();
            nVarS.n(new com.byazt.ot.n.qg() { // from class: com.byazt.it.s.5
                @Override // com.byazt.ot.n.qg
                public void q() {
                }

                @Override // com.byazt.ot.n.qg
                public void s() {
                }

                @Override // com.byazt.ot.n.qg
                public void qg() {
                    int iL = com.byazt.gv.n.l();
                    com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- AppStateListener on foreground, ".concat(String.valueOf(iL)));
                    long unused = s.w = SystemClock.elapsedRealtime();
                    if (s.hd()) {
                        fs.n().s();
                    }
                    if (iL != 2) {
                        com.byazt.mv.n.s();
                    }
                }

                @Override // com.byazt.ot.n.qg
                public void n() {
                    if (s.hd()) {
                        fs.n().q();
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    long j = com.byazt.gv.n.l() != 2 ? s.w > 0 ? jElapsedRealtime - s.w : 0L : 0L;
                    com.byazt.gp.s.qg(j);
                    com.byazt.qt.n.d().qg(j);
                    com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- AppStateListener on background: " + j + ", " + com.byazt.gv.n.l());
                    if (jElapsedRealtime - s.x < 3000) {
                        com.byazt.rb.qg.qg(MediationConstant.TAG, "badkground too frequently ms: " + (jElapsedRealtime - s.x));
                        return;
                    }
                    if (tj.qg()) {
                        long unused = s.x = jElapsedRealtime;
                        if (!com.byazt.xc.qg.n()) {
                            s.cy();
                        } else {
                            tj.q();
                        }
                    }
                }
            });
        }
        if (com.byazt.qt.n.d().sz()) {
            try {
                w.n(com.byazt.qt.qg.getContext(), new n(), new IntentFilter("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver"), qg.n, null, 4);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cy() {
        if (com.byazt.qt.qg.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(hu.n());
                intent.setAction("com.bytedance.msdk.sdkinit.EventMultiFlushReceiver");
                intent.putExtra("b_msg_id", 1);
                com.byazt.qt.qg.getContext().sendBroadcast(intent, qg.n);
            } catch (Throwable unused) {
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 879, 546})
    private static class n extends BroadcastReceiver {
        private n() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || com.byazt.vyf.s.cy().lh()) {
                return;
            }
            com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- event multi receiver");
            if (intent.getIntExtra("b_msg_id", -1) == 1) {
                try {
                    if (com.byazt.xc.qg.n()) {
                        tj.q();
                    } else {
                        com.byazt.rb.qg.n(MediationConstant.TAG, "--==-- event multi receiver not in main proc");
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void n(JSONObject jSONObject) {
        try {
            com.byazt.qt.qg.n().n(true, jSONObject);
        } catch (Throwable th) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "InitHelper-->initSetting->loadData Exception=" + th.toString());
        }
    }

    private static void qg(JSONObject jSONObject) {
        com.byazt.ng.q.n(com.byazt.qt.qg.n()).n(0, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hd() {
        return !TextUtils.isEmpty(com.byazt.ng.qg.n().n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cd() {
        if (com.byazt.qt.qg.n().u()) {
            um();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.it.s.6
                @Override // java.lang.Runnable
                public void run() {
                    s.um();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void um() {
        if (com.byazt.qt.qg.n().wo()) {
            Map<String, String> mapSh = com.byazt.qt.qg.n().sh();
            com.byazt.gp.s.n((com.byazt.sg.s) null, (com.byazt.qn.qg) null, d.n(), 1);
            com.byazt.gp.s.n(d.n(mapSh));
        }
    }
}
