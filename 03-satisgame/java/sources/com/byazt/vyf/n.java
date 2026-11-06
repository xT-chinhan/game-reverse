package com.byazt.vyf;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.byazt.ehw.DeviceUtils;
import com.byazt.kfh.SSWebView;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.k;
import com.byazt.tk.um;
import com.byazt.uq.cp;
import com.byazt.vf.hu;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 19})
public final class n implements Function<SparseArray<Object>, Object> {
    public static final int VALUE_SET_AD_CONFIG_BUILDER_TIME = 25;
    public static final int VALUE_SET_BOOST_INIT_START_TIME = 27;
    public static final int VALUE_SET_PANGLE_CALL_INIT_TIME = 24;
    public static final int VALUE_SET_PANGLE_INIT_START_TIME = 1;
    public static int n;
    public static Boolean qg;
    public static volatile long sInitSuccessTime;
    public com.byazt.ke.n fs;
    public static final AtomicBoolean s = new AtomicBoolean(false);
    public static AtomicBoolean x = null;
    public final x q = new x();
    public volatile boolean l = false;
    public AtomicBoolean w = new AtomicBoolean(false);

    public n(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (serializable instanceof Function) {
            com.byazt.ph.s.n().n((Function<SparseArray<Object>, Object>) serializable);
        }
    }

    private static void n(com.byazt.zq.n nVar, boolean z) {
        if (n(nVar)) {
            com.byazt.lq.s.s(1, z ? "1" : "0");
            n(nVar.cp());
            com.byazt.lq.s.qg(2, nVar.n());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.init.GlobalInfo");
                com.byazt.lq.s.s(2, "0");
            } catch (Exception unused) {
                com.byazt.lq.s.s(2, "1");
            }
            com.byazt.lq.s.qg(0, tj.w);
        }
    }

    private static void n(com.byazt.zq.q qVar) {
        if (qVar == null || qVar.k()) {
            qVar = s.n;
        }
        com.byazt.lq.s.s(19, qVar.k() ? "1" : "0");
        com.byazt.lq.s.s(7, String.valueOf(qVar.n() ? 1 : 0));
        com.byazt.zq.s sVarQg = qVar.qg();
        String strTrim = "";
        com.byazt.lq.s.s(8, sVarQg != null ? sVarQg.n() + "," + sVarQg.qg() : "");
        com.byazt.lq.s.s(9, String.valueOf(qVar.q() ? 1 : 0));
        String strL = qVar.l();
        com.byazt.lq.s.s(10, strL != null ? strL.trim() : "");
        com.byazt.lq.s.s(11, String.valueOf(qVar.w() ? 1 : 0));
        com.byazt.lq.s.s(12, String.valueOf(qVar.fs() ? 1 : 0));
        com.byazt.lq.s.s(17, String.valueOf(qVar.s() ? 1 : 0));
        com.byazt.lq.s.s(22, String.valueOf(qVar.tj() ? 1 : 0));
        if (tj.l >= 7000) {
            com.byazt.lq.s.s(24, String.valueOf(qVar.oa() ? 1 : 0));
        }
        String strX = qVar.x();
        com.byazt.lq.s.s(18, strX != null ? strX.trim() : "");
        try {
            if (qVar.rv() != null) {
                strTrim = qVar.rv().trim();
            }
            com.byazt.lq.s.s(13, strTrim);
        } catch (Exception unused) {
            k.n("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int x() {
        if (n == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    n = 1;
                } catch (Throwable unused) {
                    n = -1;
                }
            } catch (Throwable unused2) {
                Class.forName("androidx.core.content.FileProvider");
                n = 2;
            }
        }
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fs() {
        if (qg == null) {
            try {
                Class.forName("kotlin.Result");
                qg = Boolean.TRUE;
            } catch (Throwable unused) {
                qg = Boolean.FALSE;
            }
        }
        return qg.booleanValue();
    }

    public static boolean n(com.byazt.zq.n nVar) {
        AtomicBoolean atomicBoolean = x;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = nVar.fs() && com.byazt.ges.q.n();
        x = new AtomicBoolean(z);
        return z;
    }

    public boolean n() {
        return this.l;
    }

    public x qg() {
        return this.q;
    }

    public void n(final Context context, final PluginValueSet pluginValueSet, final com.byazt.gf.qg qgVar) {
        com.byazt.gf.qg qgVar2;
        n nVar;
        long jElapsedRealtime;
        long jLongValue;
        String name;
        int priority;
        try {
            try {
                try {
                    jElapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                    jLongValue = pluginValueSet.longValue(27, 0L);
                } catch (Exception unused) {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    jLongValue = 0;
                }
                final long jElapsedRealtime2 = jElapsedRealtime == 0 ? SystemClock.elapsedRealtime() : jElapsedRealtime;
                final long j = jLongValue <= 0 ? jElapsedRealtime : jLongValue;
                final w wVarN = w.n(MediationConstant.EXTRA_DURATION);
                SparseArray<Object> sparseArray = pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>();
                final com.byazt.zq.n nVar2 = new com.byazt.zq.n(sparseArray);
                rv.n(context);
                Thread threadCurrentThread = Thread.currentThread();
                try {
                    name = pluginValueSet.stringValue(2, threadCurrentThread.getName());
                } catch (Exception unused2) {
                    name = threadCurrentThread.getName();
                }
                final String str = name;
                try {
                    priority = pluginValueSet.intValue(3, threadCurrentThread.getPriority());
                } catch (Exception unused3) {
                    priority = threadCurrentThread.getPriority();
                }
                final int i = priority;
                qg(pluginValueSet);
                if (this.l) {
                    qg(qgVar);
                    n(qgVar);
                    return;
                }
                s.cy().sz();
                n(nVar2, pluginValueSet, sparseArray);
                qg(qgVar);
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                n(pluginValueSet);
                wVarN.n("init_thread_cost", SystemClock.elapsedRealtime() - jElapsedRealtime3);
                long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                this.fs = new com.byazt.ke.n(pluginValueSet);
                wVarN.n("init_autoservice_cost", SystemClock.elapsedRealtime() - jElapsedRealtime4);
                final long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                wVarN.qg("sync_cost");
                try {
                    ((wo) com.byazt.qp.q.n("thread_service")).fs().execute(new Runnable() { // from class: com.byazt.vyf.n.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wVarN.qg("async_wait_cost");
                            if (n.this.n(context, nVar2, qgVar, wVarN)) {
                                wVarN.qg("async_done_cost");
                                long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                wVarN.n();
                                long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                n.this.n(context, jElapsedRealtime5, SystemClock.elapsedRealtime() - j, jElapsedRealtime6, jElapsedRealtime7, wVarN, true, nVar2, str, i, pluginValueSet, rv.qg().pt());
                            }
                        }
                    });
                    com.byazt.na.qg.n();
                    nVar = this;
                    try {
                        com.byazt.qit.l.qg(new com.byazt.qit.x("init Async") { // from class: com.byazt.vyf.n.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (n.this.w.get()) {
                                        return;
                                    }
                                    n.this.w.set(true);
                                    com.byazt.qp.q.n("embed_applog");
                                    com.byazt.yu.n.n();
                                    DeviceUtils.s();
                                    com.byazt.orb.n.n(false);
                                    com.byazt.hnb.n.n(context);
                                    com.byazt.hnb.n.qg();
                                    com.byazt.zk.n.n().registerReceiver(context);
                                    com.byazt.wb.s.x().fs();
                                } catch (Throwable unused4) {
                                }
                            }
                        });
                        sInitSuccessTime = System.currentTimeMillis();
                        l.n = true;
                        return;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    nVar = this;
                }
            } catch (Throwable th3) {
                th = th3;
                nVar = this;
            }
        } catch (Throwable th4) {
            th = th4;
            qgVar2 = qgVar;
            nVar = this;
        }
        qgVar2 = qgVar;
        nVar.n(qgVar2, th);
        n(new com.byazt.zq.n(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>()), nVar.l);
    }

    private void n(com.byazt.gf.qg qgVar, Throwable th) {
        String message = null;
        if (qgVar != null) {
            message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            qgVar.n(1, com.byazt.of.s.n().n(false).n(TTAdConstant.INIT_LOCAL_FAIL_CODE).n(message).qg());
            k.n("TTAdSdk", " init fail, msg = ", message);
        }
        if (tj.l < 7300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("message", message);
                jSONObject.putOpt("is_plugin", Boolean.TRUE);
                jSONObject.putOpt("api", Boolean.TRUE);
                jSONObject.putOpt("install_version", 7814);
                jSONObject.putOpt("code", Integer.valueOf(TTAdConstant.INIT_LOCAL_FAIL_CODE));
                com.byazt.eji.s.n().n("init", jSONObject, th);
            } catch (Throwable unused) {
            }
        }
        this.l = false;
    }

    private void n(PluginValueSet pluginValueSet) {
        try {
            com.byazt.ag.n.n();
        } catch (Exception unused) {
        }
    }

    private void n(com.byazt.gf.qg qgVar) {
        com.byazt.ehw.n.n();
        if (qgVar != null) {
            ThreadPoolExecutor threadPoolExecutorRv = com.byazt.qit.rv.qg.rv();
            com.byazt.of.s sVarN = com.byazt.of.s.n().n(true);
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n().n(20, threadPoolExecutorRv);
            if (tj.l < 7500) {
                qgVarN.n(23, s());
            }
            qgVar.n(AVMDLDataLoader.KeyIsLiveSetP2pAllow, sVarN.n(qgVarN.qg()).qg());
        }
    }

    private void qg(com.byazt.gf.qg qgVar) {
        if (qgVar != null) {
            qgVar.n();
        }
    }

    public Map<String, Object> s() {
        com.byazt.ke.n nVar = this.fs;
        if (nVar == null) {
            return null;
        }
        return nVar.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Context context, com.byazt.zq.n nVar, com.byazt.gf.qg qgVar, w wVar) {
        if (this.l) {
            qg(qgVar);
            n(qgVar);
            return false;
        }
        try {
            if (com.byazt.gv.n.s()) {
                n(qgVar, new Exception("load maparmor fail"));
                return false;
            }
            n(context, nVar, wVar);
            this.l = true;
            qg(nVar);
            n(context, nVar);
            wVar.qg("async_init_cost");
            com.byazt.vf.k kVarS = com.byazt.cl.s.s();
            if (kVarS != null) {
                kVarS.n();
            }
            wVar.qg("armor_load_cost");
            k.qg("TTAdSdk", "Init done finish: 7814");
            n(qgVar);
            n(nVar, this.l);
            return true;
        } catch (Throwable th) {
            n(qgVar, th);
        }
    }

    private void qg(com.byazt.zq.n nVar) {
        if (s.cy().sh()) {
            com.byazt.twu.s.n(nVar);
        }
    }

    private void n(Context context, com.byazt.zq.n nVar, w wVar) {
        try {
            if (n(nVar)) {
                q.n();
                com.byazt.nl.qg.n();
                com.byazt.lq.s.qg();
            }
        } catch (Throwable unused) {
        }
        wVar.qg("debug_set_cost");
        com.byazt.byp.q.n(context);
        wVar.qg("web_dir_cost");
        com.byazt.iza.qg.n(nVar.tj());
        if (nVar.tj()) {
            com.byazt.byp.qg.n(nVar.n());
            s.cy().v();
        } else {
            com.byazt.byp.qg.qg(nVar.n());
        }
        wVar.qg("multi_cost");
        com.byazt.iza.qg.n(context, null);
        com.byazt.lhs.n.n(context);
        wVar.qg("video_config_cost");
        l.s();
        wVar.qg("dyna_init_cost");
        com.byazt.cl.s.q();
        wVar.qg("armor_init_cost");
    }

    private void n(com.byazt.zq.n nVar, PluginValueSet pluginValueSet, SparseArray sparseArray) {
        if (nVar.tj()) {
            com.byazt.ed.qg.n().n(true);
        }
        qg(nVar, pluginValueSet, sparseArray);
        l.qg();
        try {
            com.byazt.ep.l.n();
        } catch (Throwable unused) {
        }
    }

    private void qg(PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                tj.s = bool.booleanValue();
            }
            Boolean bool2 = (Boolean) pluginValueSet.objectValue(26, Boolean.class);
            if (bool2 != null) {
                tj.q = bool2.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private void qg(com.byazt.zq.n nVar, PluginValueSet pluginValueSet, SparseArray sparseArray) {
        if (nVar == null) {
            return;
        }
        String strQg = nVar.qg();
        if (strQg == null || strQg.isEmpty()) {
            strQg = com.byazt.ges.qg.tj();
        }
        s.cy().n((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(16, Function.class));
        s.cy().q(strQg);
        s.cy().s(nVar.n());
        s.cy().s(nVar.s());
        s.cy().l(nVar.q());
        s.cy().w(nVar.l());
        s.cy().qg(nVar.w());
        s.cy().l(nVar.sz());
        s.cy().q(nVar.x());
        s.cy().n(nVar.rv());
        s.cy().fs(nVar.cy());
        s.cy().n(nVar.cp());
        s.cy().q(nVar.oa());
        s.cy().n(nVar.d());
        com.byazt.vf.n nVarQg = com.byazt.qp.q.qg(nVar.n());
        if (nVarQg != null && sparseArray != null) {
            nVarQg.n(sparseArray);
        }
        if (n(nVar)) {
            k.qg();
            com.byazt.lq.s.qg();
            com.byazt.fe.n.n(2);
        }
    }

    private void n(final Context context, final com.byazt.zq.n nVar) {
        com.byazt.qit.l.n(new com.byazt.qit.x("init sync") { // from class: com.byazt.vyf.n.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.iz.rv.q();
                    com.byazt.ivn.w wVarQg = rv.qg();
                    if (!wVarQg.hx()) {
                        synchronized (wVarQg) {
                            if (!wVarQg.hx()) {
                                wVarQg.n();
                            }
                        }
                    }
                    n.this.n(nVar.tj(), true, wVarQg.mt());
                    n.this.n(context);
                    com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.vyf.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (s.cy().lh()) {
                                return;
                            }
                            com.byazt.hnb.n.n(nVar.n());
                        }
                    }, i.l.c);
                    com.byazt.iza.qg.n(com.byazt.mw.s.n().qg().n());
                    com.byazt.iz.qg.l();
                    com.byazt.vzq.s.q();
                    com.byazt.zh.l.n();
                    com.byazt.lhs.n.n(com.byazt.ql.qg.n(0));
                    if (wVarQg.py()) {
                        final com.byazt.ej.n nVarN = com.byazt.ql.qg.n(1);
                        com.byazt.qit.l.qg(new com.byazt.qit.x("preloadTTVideo") { // from class: com.byazt.vyf.n.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.gks.qg.n().n(context, nVarN.n(), 52428800, com.byazt.ql.qg.qg(), com.byazt.ql.qg.s(), n.n(nVar));
                            }
                        });
                    }
                    DeviceUtils.x();
                    l.n(context);
                    com.byazt.yo.qg.n();
                    com.byazt.na.qg.s(context);
                    com.byazt.lew.q.n(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            um.n();
                        } catch (Exception unused) {
                        }
                    }
                    com.byazt.ehw.q.n();
                    com.byazt.ges.q.n(nVar);
                    com.byazt.cl.s.n();
                    com.byazt.xf.n.n().n(context);
                    com.byazt.cd.s.n();
                    com.byazt.yvo.q.n(nVar.n());
                    com.byazt.iu.s.n().qg();
                    com.byazt.cr.n.n(context, nVar.n(), wVarQg);
                    s.cy().s().n(com.byazt.de.l.q);
                    com.byazt.de.l.n(1);
                    com.byazt.ysr.s.n().qg();
                    if (com.byazt.uq.s.n()) {
                        cp.n();
                    }
                    com.byazt.vzq.s.n().x();
                    if (tj.l > 7700 && rv.qg().zk().n()) {
                        com.byazt.qp.q.n().s();
                    }
                    com.byazt.qp.q.n().q();
                } catch (Throwable unused2) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context) {
        final Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext == null) {
            applicationContext = rv.getContext();
        }
        com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
        if (applicationContext == null || !lVar.n() || s.get() || tj.q() || !rv.qg().sn()) {
            return;
        }
        com.byazt.tk.rv.qg().postDelayed(new Runnable() { // from class: com.byazt.vyf.n.4
            @Override // java.lang.Runnable
            public void run() {
                if (!rv.qg().sn() || n.s.get()) {
                    return;
                }
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.byazt.vyf.n.4.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        SSWebView sSWebView;
                        Throwable th;
                        if (rv.qg().sn() && n.s.compareAndSet(false, true)) {
                            try {
                                sSWebView = new SSWebView(applicationContext);
                                try {
                                    sSWebView.destroy();
                                } catch (Throwable th2) {
                                    th = th2;
                                    n.s.set(false);
                                    th.getMessage();
                                    if (sSWebView != null) {
                                        try {
                                            sSWebView.destroy();
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }
                            } catch (Throwable th3) {
                                sSWebView = null;
                                th = th3;
                            }
                        }
                        return false;
                    }
                });
            }
        }, rv.qg().cq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final boolean z, final boolean z2, long j) {
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.vyf.n.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.wq.qg.n().fs();
                if (!z || ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).n()) {
                    com.byazt.ivn.q.n(rv.qg()).s();
                }
                if (z2) {
                    com.byazt.cw.n.n(s.cy().ou()).n(true);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Context context, final long j, final long j2, final long j3, final long j4, final w wVar, final boolean z, final com.byazt.zq.n nVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.byazt.pnm.q qVar) {
        com.byazt.tk.rv.n().postDelayed(new Runnable() { // from class: com.byazt.vyf.n.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.qg(context, j, j2, j3, j4, wVar, z, nVar, str, i, pluginValueSet, qVar);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(final Context context, final long j, final long j2, final long j3, final long j4, final w wVar, final boolean z, final com.byazt.zq.n nVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.byazt.pnm.q qVar) {
        l.n();
        if (rv.qg().ei()) {
            com.byazt.eji.s.n().qg("pangle_sdk_init", String.valueOf(j3), new com.byazt.rs.n() { // from class: com.byazt.vyf.n.7
                /* JADX WARN: Code duplicated, block: B:7:0x00b6  */
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    int iIntValue;
                    boolean zPy = s.cy().py();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                    jSONObject2.put("is_async", z);
                    jSONObject2.put("is_multi_process", nVar.tj());
                    jSONObject2.put("is_debug", n.n(nVar));
                    jSONObject2.put("is_activate_init", zPy);
                    jSONObject2.put("is_plugin", tj.n());
                    jSONObject2.put("has_kotlin", n.fs());
                    jSONObject2.put("use_mediation", nVar.cy());
                    jSONObject2.put("is_androidx", n.x());
                    jSONObject2.put("host_abi", com.byazt.wl.qg.n());
                    jSONObject2.put("minSdkVersion", com.byazt.vgx.w.s(context));
                    jSONObject2.put("targetSdkVersion", com.byazt.vgx.w.qg(context));
                    jSONObject2.put("ttvideo_plugin_config", true);
                    jSONObject2.put("ttvideo_can_use", tj.l());
                    jSONObject2.put("is_keva_init_success", com.byazt.lk.q.n());
                    jSONObject2.put("thread_name", str);
                    hu huVar = (hu) com.byazt.qp.q.n("m_d_s");
                    if (huVar != null) {
                        Object objN = huVar.n(3);
                        if (objN instanceof Integer) {
                            iIntValue = ((Integer) objN).intValue();
                        } else {
                            iIntValue = -1;
                        }
                    } else {
                        iIntValue = -1;
                    }
                    jSONObject2.put("layer_init_type", iIntValue);
                    jSONObject2.put("thread_priority", i);
                    jSONObject2.put("is_boost", com.byazt.gv.n.l());
                    jSONObject2.put("single_arch_sdk", pluginValueSet.booleanValue(26, false) ? 1 : 0);
                    jSONObject2.put("opt_config", String.valueOf(qVar));
                    jSONObject2.put("page_size", com.byazt.ehw.rv.um());
                    jSONObject2.put("j_fun", Function.class.getName());
                    s.cy().qg(false);
                    Object objObjectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("main_cost", j);
                    jSONObject3.put("layer_real_cost_time", j2);
                    jSONObject3.put("callback_cost", j3);
                    jSONObject3.put("total_cost", j4);
                    if (objObjectValue != null) {
                        jSONObject3.put("plugin", objObjectValue);
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    wVar.n(jSONObject4, 20L);
                    jSONObject3.put("init", jSONObject4);
                    jSONObject2.put("cost", jSONObject3);
                    if (!nVar.cy()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject2.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object objInvoke2 = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject2.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object objInvoke3 = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject2.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object objRv = n.this.rv();
                    if (objRv != null) {
                        jSONObject2.put("develop_type", objRv);
                    }
                    return jSONObject2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rv() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        switch (pluginValueSetQg.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(n());
            case -999001:
                n((Context) pluginValueSetQg.objectValue(-998000, Context.class), pluginValueSetQg, new com.byazt.gf.qg((Function) pluginValueSetQg.objectValue(15, Function.class)));
                return null;
            case -999000:
                return this.q;
            default:
                return null;
        }
    }
}
