package com.byazt.sd;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.SparseArray;
import com.byazt.fj.SSWebView;
import com.byazt.mg.PluginConstants;
import com.byazt.vkw.qi;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, 20})
public final class hn implements Function<SparseArray<Object>, Object> {
    public static final int VALUE_SET_AD_CONFIG_BUILDER_TIME = 25;
    public static final int VALUE_SET_BOOST_INIT_START_TIME = 27;
    public static final int VALUE_SET_PANGLE_CALL_INIT_TIME = 24;
    public static final int VALUE_SET_PANGLE_INIT_START_TIME = 1;
    public static volatile long sInitSuccessTime;
    public com.byazt.eh.pr aj;
    public static int pr = 0;
    public static Boolean hw = null;
    public static final AtomicBoolean hn = new AtomicBoolean(false);
    public static AtomicBoolean zo = null;
    public final ve x = new ve();
    public volatile boolean c = false;
    public AtomicBoolean uc = new AtomicBoolean(false);
    public final AtomicBoolean fw = new AtomicBoolean(false);

    public hn(Bundle bundle) {
        if (bundle != null && bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
            if (serializable instanceof Function) {
                com.byazt.gc.hn.pr().pr((Function<SparseArray<Object>, Object>) serializable);
            }
        }
    }

    private static void pr(com.byazt.qe.pr prVar, boolean z) {
        if (!pr(prVar)) {
            return;
        }
        com.byazt.hs.hn.hn(1, z ? "1" : "0");
        pr(prVar.w());
        com.byazt.hs.hn.hw(2, prVar.pr());
        try {
            Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
            com.byazt.hs.hn.hn(2, "0");
        } catch (Exception e) {
            com.byazt.hs.hn.hn(2, "1");
        }
        com.byazt.hs.hn.hw(0, iu.c);
    }

    private static void pr(com.byazt.qe.x xVar) {
        if (xVar == null || xVar.m()) {
            xVar = zo.pr;
        }
        com.byazt.hs.hn.hn(19, xVar.m() ? "1" : "0");
        com.byazt.hs.hn.hn(7, String.valueOf(xVar.pr() ? 1 : 0));
        com.byazt.qe.hn hnVarAj = xVar.aj();
        String strTrim = "";
        com.byazt.hs.hn.hn(8, hnVarAj != null ? hnVarAj.pr() + "," + hnVarAj.hw() : "");
        com.byazt.hs.hn.hn(9, String.valueOf(xVar.hn() ? 1 : 0));
        String strVk = xVar.vk();
        com.byazt.hs.hn.hn(10, strVk != null ? strVk.trim() : "");
        com.byazt.hs.hn.hn(11, String.valueOf(xVar.x() ? 1 : 0));
        com.byazt.hs.hn.hn(12, String.valueOf(xVar.c() ? 1 : 0));
        com.byazt.hs.hn.hn(17, String.valueOf(xVar.hw() ? 1 : 0));
        com.byazt.hs.hn.hn(22, String.valueOf(xVar.uc() ? 1 : 0));
        if (iu.x >= 7000) {
            com.byazt.hs.hn.hn(24, String.valueOf(xVar.zo() ? 1 : 0));
        }
        String strW = xVar.w();
        com.byazt.hs.hn.hn(18, strW != null ? strW.trim() : "");
        try {
            if (xVar.k() != null) {
                strTrim = xVar.k().trim();
            }
            com.byazt.hs.hn.hn(13, strTrim);
        } catch (Exception e) {
            com.byazt.ca.ho.pr("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int uc() {
        if (pr == 0) {
            try {
                Class.forName("androidx.core.content.FileProvider");
                pr = 1;
            } catch (Throwable th) {
                try {
                    Class.forName("android.support.v4.content.FileProvider");
                    pr = 2;
                } catch (Throwable th2) {
                    pr = -1;
                }
            }
        }
        return pr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean fw() {
        if (hw == null) {
            try {
                Class.forName("kotlin.Result");
                hw = Boolean.TRUE;
            } catch (Throwable th) {
                hw = Boolean.FALSE;
            }
        }
        return hw.booleanValue();
    }

    public static boolean pr(com.byazt.qe.pr prVar) {
        AtomicBoolean atomicBoolean = zo;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = prVar.zo() && com.byazt.wt.fw.pr();
        zo = new AtomicBoolean(z);
        return z;
    }

    public boolean pr() {
        return this.c;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0111  */
    /* JADX WARN: Code duplicated, block: B:50:0x0116  */
    public void pr(final Context context, final PluginValueSet pluginValueSet, final com.byazt.ofr.hn hnVar) {
        hn hnVar2;
        long jElapsedRealtime;
        long jLongValue;
        SparseArray<Object> sparseArray;
        String name;
        int priority;
        try {
            try {
                jElapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                jLongValue = pluginValueSet.longValue(27, 0L);
            } catch (Exception e) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                jLongValue = 0;
            }
            final long jElapsedRealtime2 = jElapsedRealtime == 0 ? SystemClock.elapsedRealtime() : jElapsedRealtime;
            final long j = jLongValue <= 0 ? jElapsedRealtime : jLongValue;
            final ny nyVarPr = ny.pr("duration");
            final com.byazt.qe.pr prVar = new com.byazt.qe.pr(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>());
            a.pr(context);
            Thread threadCurrentThread = Thread.currentThread();
            try {
                name = pluginValueSet.stringValue(2, threadCurrentThread.getName());
            } catch (Exception e2) {
                name = threadCurrentThread.getName();
            }
            try {
                priority = pluginValueSet.intValue(3, threadCurrentThread.getPriority());
            } catch (Exception e3) {
                priority = threadCurrentThread.getPriority();
            }
            hw(pluginValueSet);
            if (this.c) {
                pr(hnVar);
                return;
            }
            zo.nt().g();
            pr(prVar, pluginValueSet);
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            pr(pluginValueSet);
            nyVarPr.pr("init_thread_cost", SystemClock.elapsedRealtime() - jElapsedRealtime3);
            long jElapsedRealtime4 = SystemClock.elapsedRealtime();
            this.aj = new com.byazt.eh.pr(pluginValueSet);
            nyVarPr.pr("init_autoservice_cost", SystemClock.elapsedRealtime() - jElapsedRealtime4);
            final long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
            nyVarPr.hw("sync_cost");
            final String str = name;
            final int i = priority;
            try {
                ((qi) com.byazt.zs.uc.pr("thread_service")).zo().execute(new Runnable() { // from class: com.byazt.sd.hn.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nyVarPr.hw("async_wait_cost");
                        if (hn.this.pr(context, prVar, hnVar, nyVarPr)) {
                            nyVarPr.hw("async_done_cost");
                            long jElapsedRealtime6 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                            nyVarPr.pr();
                            long jElapsedRealtime7 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                            hn.this.pr(context, jElapsedRealtime5, SystemClock.elapsedRealtime() - j, jElapsedRealtime6, jElapsedRealtime7, nyVarPr, true, prVar, str, i, pluginValueSet, a.hw().ug());
                        }
                    }
                });
                com.byazt.z.hw.pr();
                hnVar2 = this;
                try {
                    com.byazt.xlm.c.hw(new com.byazt.xlm.fw("init Async") { // from class: com.byazt.sd.hn.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (!hn.this.uc.get()) {
                                    hn.this.uc.set(true);
                                    com.byazt.zs.uc.pr("embed_applog");
                                    uc.pr();
                                    DeviceUtils.hn();
                                    com.byazt.qv.pr.pr(false);
                                    com.byazt.igw.hw.pr(context);
                                    com.byazt.igw.hw.hw();
                                    com.byazt.sq.pr.pr().registerReceiver(context);
                                    com.byazt.mk.hn.fw().zo();
                                }
                            } catch (Throwable th) {
                            }
                        }
                    });
                    sInitSuccessTime = System.currentTimeMillis();
                    lb.pr = true;
                } catch (Throwable th) {
                    th = th;
                    hnVar2.pr(hnVar, th);
                    if (pluginValueSet != null) {
                        sparseArray = pluginValueSet.sparseArray();
                    } else {
                        sparseArray = new SparseArray<>();
                    }
                    pr(new com.byazt.qe.pr(sparseArray), hnVar2.c);
                }
            } catch (Throwable th2) {
                th = th2;
                hnVar2 = this;
            }
        } catch (Throwable th3) {
            th = th3;
            hnVar2 = this;
            hnVar2.pr(hnVar, th);
            if (pluginValueSet != null) {
                sparseArray = pluginValueSet.sparseArray();
            } else {
                sparseArray = new SparseArray<>();
            }
            pr(new com.byazt.qe.pr(sparseArray), hnVar2.c);
        }
    }

    private void pr(com.byazt.ofr.hn hnVar, Throwable th) {
        String message = null;
        if (hnVar != null) {
            message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            hnVar.pr(1, com.byazt.xi.hn.pr().pr(false).pr(TTAdConstant.INIT_LOCAL_FAIL_CODE).pr(message).hw());
            com.byazt.ca.ho.pr("TTAdSdk", " init fail, msg = ", message);
        }
        if (iu.x < 7300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("message", message);
                jSONObject.putOpt("is_plugin", Boolean.TRUE);
                jSONObject.putOpt("api", Boolean.TRUE);
                jSONObject.putOpt("install_version", 7714);
                jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(TTAdConstant.INIT_LOCAL_FAIL_CODE));
                com.byazt.xk.hw.pr().pr(TrackAction.INIT, jSONObject, th);
            } catch (Throwable th2) {
            }
        }
        this.c = false;
    }

    private void pr(PluginValueSet pluginValueSet) {
        try {
            com.byazt.jp.pr.pr();
        } catch (Exception e) {
        }
    }

    private void pr(com.byazt.ofr.hn hnVar) {
        zo();
        com.byazt.mp.pr.pr();
        if (hnVar != null) {
            ThreadPoolExecutor threadPoolExecutorAj = com.byazt.xlm.aj.hw.aj();
            com.byazt.xi.hn hnVarPr = com.byazt.xi.hn.pr().pr(true);
            com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr().pr(20, threadPoolExecutorAj);
            if (iu.x < 7500) {
                hwVarPr.pr(23, hw());
            }
            hnVar.pr(AVMDLDataLoader.KeyIsLiveSetP2pAllow, hnVarPr.pr(hwVarPr.hw()).hw());
        }
    }

    public Map<String, Object> hw() {
        com.byazt.eh.pr prVar = this.aj;
        if (prVar == null) {
            return null;
        }
        return prVar.pr();
    }

    private void zo() {
        if (!this.fw.compareAndSet(false, true)) {
            return;
        }
        com.byazt.zs.uc.pr().hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(Context context, com.byazt.qe.pr prVar, com.byazt.ofr.hn hnVar, ny nyVar) {
        if (this.c) {
            pr(hnVar);
            return false;
        }
        try {
            if (com.byazt.iq.pr.hn()) {
                pr(hnVar, new Exception("load maparmor fail"));
                return false;
            }
            pr(context, prVar, nyVar);
            this.c = true;
            hw(prVar);
            pr(context, prVar);
            nyVar.hw("async_init_cost");
            com.byazt.vkw.nt ntVarHn = com.byazt.wt.rc.hn();
            if (ntVarHn != null) {
                ntVarHn.pr();
            }
            nyVar.hw("armor_load_cost");
            com.byazt.ca.ho.hw("TTAdSdk", "Init done finish: 7714");
            pr(hnVar);
            pr(prVar, this.c);
            return true;
        } catch (Throwable th) {
            pr(hnVar, th);
        }
    }

    private void hw(com.byazt.qe.pr prVar) {
        if (!zo.nt().i()) {
            return;
        }
        com.byazt.pr.hw.pr(prVar);
    }

    private void pr(Context context, com.byazt.qe.pr prVar, ny nyVar) {
        try {
            if (pr(prVar)) {
                com.byazt.wt.lb.pr();
                com.byazt.o.hw.pr();
                com.byazt.hs.hn.hw();
            }
        } catch (Throwable th) {
        }
        nyVar.hw("debug_set_cost");
        com.byazt.iy.x.pr(context);
        nyVar.hw("web_dir_cost");
        com.byazt.ry.pr.pr((ThreadPoolExecutor) com.byazt.xlm.c.pr());
        nyVar.hw("thread_pool_cost");
        com.byazt.y.hw.pr(prVar.vk());
        if (prVar.vk()) {
            com.byazt.iy.hw.pr(prVar.pr());
            zo.nt().ww();
        } else {
            com.byazt.iy.hw.hw(prVar.pr());
        }
        nyVar.hw("multi_cost");
        com.byazt.y.hw.pr(context, null);
        com.byazt.s.pr.pr(context);
        nyVar.hw("video_config_cost");
        lb.c();
        nyVar.hw("dyna_init_cost");
        com.byazt.wt.rc.x();
        nyVar.hw("armor_init_cost");
    }

    private void pr(com.byazt.qe.pr prVar, PluginValueSet pluginValueSet) {
        hw(prVar, pluginValueSet);
        lb.x();
        try {
            com.byazt.ea.c.pr();
        } catch (Throwable th) {
        }
        if (prVar.vk()) {
            com.byazt.wt.y.pr();
        }
        com.byazt.mp.hn.pr().pr(prVar.vk());
    }

    private void hw(PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                iu.hn = bool.booleanValue();
            }
        } catch (Exception e) {
        }
    }

    private void hw(com.byazt.qe.pr prVar, PluginValueSet pluginValueSet) {
        if (prVar == null) {
            return;
        }
        String strHw = prVar.hw();
        if (strHw == null || strHw.isEmpty()) {
            strHw = com.byazt.hb.pr.vk();
        }
        zo.nt().pr((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(16, Function.class));
        zo.nt().x(strHw);
        zo.nt().hn(prVar.pr());
        zo.nt().hn(prVar.hn());
        zo.nt().c(prVar.x());
        zo.nt().uc(prVar.c());
        zo.nt().hw(prVar.uc());
        zo.nt().c(prVar.g());
        zo.nt().x(prVar.fw());
        zo.nt().pr(prVar.aj());
        zo.nt().uc(prVar.nt());
        zo.nt().pr(prVar.w());
        zo.nt().x(prVar.m());
        zo.nt().pr(prVar.k());
        if (pr(prVar)) {
            com.byazt.ca.ho.hw();
            com.byazt.hs.hn.hw();
            com.byazt.p000do.pr.pr(2);
        }
    }

    private void pr(final Context context, final com.byazt.qe.pr prVar) {
        com.byazt.xlm.c.pr(new com.byazt.xlm.fw("init sync") { // from class: com.byazt.sd.hn.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.byazt.jx.aj.x();
                    com.byazt.is.w wVarHw = a.hw();
                    if (!wVarHw.ja()) {
                        synchronized (wVarHw) {
                            if (!wVarHw.ja()) {
                                wVarHw.pr();
                            }
                        }
                    }
                    hn.this.pr(prVar.vk(), true, wVarHw.yn());
                    hn.this.pr(context);
                    com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.hn.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (zo.nt().y()) {
                                return;
                            }
                            com.byazt.igw.hw.pr(prVar.pr());
                        }
                    }, 120000L);
                    com.byazt.y.hw.pr(com.byazt.pk.uc.pr().hw().pr());
                    com.byazt.jx.hw.c();
                    y.x();
                    com.byazt.da.c.pr();
                    com.byazt.s.pr.pr(com.byazt.zp.w.pr(0));
                    if (wVarHw.cz()) {
                        final com.byazt.ihe.pr prVarPr = com.byazt.zp.w.pr(1);
                        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("preloadTTVideo") { // from class: com.byazt.sd.hn.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.byazt.it.hw.pr().pr(context, prVarPr.pr(), 52428800, com.byazt.zp.w.hw(), com.byazt.zp.w.hn(), hn.pr(prVar));
                            }
                        });
                    }
                    DeviceUtils.fw();
                    lb.pr(context);
                    com.byazt.pw.hw.pr();
                    com.byazt.z.hw.hn(context);
                    com.byazt.mv.x.pr(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.byazt.ca.qa.pr();
                        } catch (Exception e) {
                        }
                    }
                    com.byazt.wt.k.pr();
                    com.byazt.wt.fw.pr(prVar);
                    com.byazt.wt.rc.pr();
                    com.byazt.vq.pr.pr().pr(context);
                    com.byazt.wt.e.pr();
                    com.byazt.mn.x.pr(prVar.pr());
                    com.byazt.hb.c.pr().hw();
                    com.byazt.hn.pr.pr(context, prVar.pr(), wVarHw);
                    zo.nt().hn().pr(com.byazt.qd.c.x);
                    com.byazt.qd.c.pr(1);
                    com.byazt.ir.hn.pr().hw();
                } catch (Throwable th) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Context context) {
        final Context context2;
        if (context == null) {
            context2 = null;
        } else {
            context2 = context.getApplicationContext();
        }
        if (context2 == null) {
            context2 = a.getContext();
        }
        com.byazt.vkw.c cVar = (com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process");
        if (context2 == null || !cVar.pr() || hn.get() || iu.hn() || !a.hw().hp()) {
            return;
        }
        com.byazt.ca.aj.hw().postDelayed(new Runnable() { // from class: com.byazt.sd.hn.4
            @Override // java.lang.Runnable
            public void run() {
                if (!a.hw().hp() || hn.hn.get()) {
                    return;
                }
                Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.byazt.sd.hn.4.1
                    @Override // android.os.MessageQueue.IdleHandler
                    public boolean queueIdle() {
                        SSWebView sSWebView;
                        Throwable th;
                        if (!a.hw().hp() || !hn.hn.compareAndSet(false, true)) {
                            return false;
                        }
                        try {
                            sSWebView = new SSWebView(context2);
                            try {
                                sSWebView.destroy();
                            } catch (Throwable th2) {
                                th = th2;
                                hn.hn.set(false);
                                th.getMessage();
                                if (sSWebView != null) {
                                    try {
                                        sSWebView.destroy();
                                    } catch (Throwable th3) {
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            sSWebView = null;
                            th = th4;
                        }
                        return false;
                    }
                });
            }
        }, a.hw().ke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final boolean z, final boolean z2, long j) {
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.hn.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.eg.hw.pr().zo();
                if (!z || ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).pr()) {
                    com.byazt.is.zo.pr(a.hw()).x();
                }
                if (z2) {
                    com.byazt.lg.pr.pr(zo.nt().ny()).pr(true);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final Context context, final long j, final long j2, final long j3, final long j4, final ny nyVar, final boolean z, final com.byazt.qe.pr prVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.byazt.is.fw fwVar) {
        com.byazt.ca.aj.pr().postDelayed(new Runnable() { // from class: com.byazt.sd.hn.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hn.this.hw(context, j, j2, j3, j4, nyVar, z, prVar, str, i, pluginValueSet, fwVar);
                } catch (Throwable th) {
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final Context context, final long j, final long j2, final long j3, final long j4, final ny nyVar, final boolean z, final com.byazt.qe.pr prVar, final String str, final int i, final PluginValueSet pluginValueSet, final com.byazt.is.fw fwVar) {
        lb.hn();
        if (a.hw().na()) {
            com.byazt.xk.hw.pr().hw("pangle_sdk_init", String.valueOf(j3), new com.byazt.ttf.pr() { // from class: com.byazt.sd.hn.7
                /* JADX WARN: Code duplicated, block: B:7:0x00b7  */
                /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r2v29, types: [java.lang.Throwable] */
                /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Throwable] */
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    int iIntValue;
                    boolean zCz = zo.nt().cz();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("duration", j);
                    jSONObject2.put("is_async", z);
                    jSONObject2.put("is_multi_process", prVar.vk());
                    jSONObject2.put("is_debug", hn.pr(prVar));
                    jSONObject2.put("is_activate_init", zCz);
                    jSONObject2.put("is_plugin", iu.pr());
                    jSONObject2.put("has_kotlin", hn.fw());
                    jSONObject2.put("use_mediation", prVar.nt());
                    jSONObject2.put("is_androidx", hn.uc());
                    jSONObject2.put("host_abi", com.byazt.sp.hw.pr());
                    jSONObject2.put("minSdkVersion", ls.hn(context));
                    jSONObject2.put("targetSdkVersion", ls.hw(context));
                    jSONObject2.put("ttvideo_plugin_config", true);
                    jSONObject2.put("ttvideo_can_use", iu.x());
                    jSONObject2.put("is_keva_init_success", com.byazt.wt.y.hw());
                    jSONObject2.put(Constants.THREAD_NAME_FIELD, str);
                    com.byazt.vkw.rc rcVar = (com.byazt.vkw.rc) com.byazt.zs.uc.pr("m_d_s");
                    if (rcVar != null) {
                        Object objPr = rcVar.pr(3);
                        if (objPr instanceof Integer) {
                            iIntValue = ((Integer) objPr).intValue();
                        } else {
                            iIntValue = -1;
                        }
                    } else {
                        iIntValue = -1;
                    }
                    jSONObject2.put("layer_init_type", iIntValue);
                    jSONObject2.put("thread_priority", i);
                    jSONObject2.put("is_boost", com.byazt.iq.pr.c());
                    jSONObject2.put("single_arch_sdk", pluginValueSet.booleanValue(26, false) ? 1 : 0);
                    jSONObject2.put("opt_config", String.valueOf(fwVar));
                    jSONObject2.put("page_size", com.byazt.wt.z.qa());
                    jSONObject2.put("j_fun", Function.class.getName());
                    zo.nt().hw(false);
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
                    nyVar.pr(jSONObject4, 20L);
                    jSONObject3.put(TrackAction.INIT, jSONObject4);
                    jSONObject2.put("cost", jSONObject3);
                    if (!prVar.nt()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject2.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable th) {
                        }
                        try {
                            Object objInvoke2 = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject2.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable th2) {
                        }
                        try {
                            Object objInvoke3 = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject2.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable th3) {
                        }
                    }
                    Object objAj = hn.this.aj();
                    if (objAj != null) {
                        jSONObject2.put("develop_type", objAj);
                    }
                    return jSONObject2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aj() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable th) {
                return "unity_pure";
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
            switch (pluginValueSetHw.intValue(-99999987)) {
                case -999002:
                    return Boolean.valueOf(pr());
                case -999001:
                    pr((Context) pluginValueSetHw.objectValue(-998000, Context.class), pluginValueSetHw, new com.byazt.ofr.hn((Function) pluginValueSetHw.objectValue(15, Function.class)));
                    return null;
                case -999000:
                    return this.x;
                default:
                    return null;
            }
        }
        return null;
    }
}
