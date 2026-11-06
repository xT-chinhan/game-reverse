package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.dutexplorer.tmapcloak;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import java.io.Serializable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ah implements Initializer, Function<SparseArray<Object>, Object> {
    private static AtomicBoolean c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f1956ms;
    private static Boolean xr;
    private final of ah = new of();
    private volatile boolean d = false;
    private AtomicBoolean ka = new AtomicBoolean(false);

    public ah(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (serializable instanceof EventListener) {
            com.bytedance.sdk.openadsdk.core.yu.ms.xr.ms().ms((EventListener) serializable);
        } else if (serializable instanceof Function) {
            com.bytedance.sdk.openadsdk.core.yu.ms.xr.ms().ms(new com.bytedance.sdk.openadsdk.core.f.d(serializable));
        }
    }

    private static void ms(com.bytedance.sdk.openadsdk.core.f.ms msVar, boolean z) {
        if (ms(msVar)) {
            com.bytedance.sdk.openadsdk.tools.xr.ah(1, z ? "1" : "0");
            ms((com.bytedance.sdk.openadsdk.core.f.ka) msVar.ms());
            com.bytedance.sdk.openadsdk.tools.xr.xr(2, msVar.xr());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.xr.ah(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.xr.ah(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.xr.xr(0, g.ah);
        }
    }

    private static void ms(com.bytedance.sdk.openadsdk.core.f.ka kaVar) {
        if (kaVar == null) {
            kaVar = ch.f2037ms;
        }
        if (kaVar != null) {
            com.bytedance.sdk.openadsdk.tools.xr.ah(19, kaVar == ch.f2037ms ? "1" : "0");
            com.bytedance.sdk.openadsdk.tools.xr.ah(7, String.valueOf(kaVar.ms() ? 1 : 0));
            com.bytedance.sdk.openadsdk.ao.xr.ah.ah ahVarX = kaVar.x();
            String strTrim = "";
            com.bytedance.sdk.openadsdk.tools.xr.ah(8, ahVarX != null ? ahVarX.ms() + "," + ahVarX.xr() : "");
            com.bytedance.sdk.openadsdk.tools.xr.ah(9, String.valueOf(kaVar.ah() ? 1 : 0));
            String strNy = kaVar.ny();
            com.bytedance.sdk.openadsdk.tools.xr.ah(10, strNy != null ? strNy.trim() : "");
            com.bytedance.sdk.openadsdk.tools.xr.ah(11, String.valueOf(kaVar.d() ? 1 : 0));
            com.bytedance.sdk.openadsdk.tools.xr.ah(12, String.valueOf(kaVar.ka() ? 1 : 0));
            com.bytedance.sdk.openadsdk.tools.xr.ah(17, String.valueOf(kaVar.xr() ? 1 : 0));
            if (g.xr >= 4600) {
                com.bytedance.sdk.openadsdk.tools.xr.ah(22, String.valueOf(kaVar.c() ? 1 : 0));
            }
            String strCh = kaVar.ch();
            com.bytedance.sdk.openadsdk.tools.xr.ah(18, strCh != null ? strCh.trim() : "");
            try {
                if (kaVar.hi() != null) {
                    strTrim = kaVar.hi().trim();
                }
                com.bytedance.sdk.openadsdk.tools.xr.ah(13, strTrim);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.sl.xr("Get oaid from controller failed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int ah() {
        if (f1956ms == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    f1956ms = 1;
                } catch (Throwable unused) {
                    f1956ms = -1;
                }
            } catch (Throwable unused2) {
                Class.forName("androidx.core.content.FileProvider");
                f1956ms = 2;
            }
        }
        return f1956ms;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d() {
        if (xr == null) {
            try {
                Class.forName("kotlin.Result");
                xr = Boolean.TRUE;
            } catch (Throwable unused) {
                xr = Boolean.FALSE;
            }
        }
        return xr.booleanValue();
    }

    public static boolean ms(com.bytedance.sdk.openadsdk.core.f.ms msVar) {
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = msVar.ny() && com.bytedance.sdk.openadsdk.core.jw.x.ms();
        c = new AtomicBoolean(z);
        return z;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        return this.ah;
    }

    private void ms(final Context context, final ValueSet valueSet, final EventListener eventListener) {
        EventListener eventListener2;
        long jElapsedRealtime;
        String name;
        int priority;
        try {
            final com.bytedance.sdk.openadsdk.core.f.ms msVar = new com.bytedance.sdk.openadsdk.core.f.ms(valueSet);
            re.ms(context);
            try {
                try {
                    jElapsedRealtime = valueSet.longValue(1, SystemClock.elapsedRealtime());
                } catch (Exception unused) {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
                if (jElapsedRealtime == 0) {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
                final long j = jElapsedRealtime;
                final w wVarMs = w.ms("duration");
                Thread threadCurrentThread = Thread.currentThread();
                try {
                    name = valueSet.stringValue(2, threadCurrentThread.getName());
                } catch (Exception unused2) {
                    name = threadCurrentThread.getName();
                }
                final String str = name;
                try {
                    priority = valueSet.intValue(3, threadCurrentThread.getPriority());
                } catch (Exception unused3) {
                    priority = threadCurrentThread.getPriority();
                }
                final int i = priority;
                xr(valueSet);
                ch.ub().zb();
                if (this.d) {
                    ms(eventListener);
                    return;
                }
                ms(msVar, valueSet);
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                ms(valueSet);
                wVarMs.ms("init_thread_cost", SystemClock.elapsedRealtime() - jElapsedRealtime2);
                final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - j;
                wVarMs.xr("sync_cost");
                com.bytedance.sdk.component.ch.hi.xr.sl().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ah.1
                    @Override // java.lang.Runnable
                    public void run() {
                        wVarMs.xr("async_wait_cost");
                        if (ah.this.ms(context, msVar, eventListener, wVarMs)) {
                            wVarMs.xr("async_done_cost");
                            long jElapsedRealtime4 = SystemClock.elapsedRealtime() - j;
                            wVarMs.ms();
                            ah.this.ms(context, jElapsedRealtime3, jElapsedRealtime4, SystemClock.elapsedRealtime() - j, wVarMs, true, msVar, str, i, valueSet);
                        }
                    }
                });
                com.bytedance.sdk.component.ch.ab.ms(-1);
                com.bytedance.sdk.openadsdk.ms.xr.xr.ms();
                com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("init Async") { // from class: com.bytedance.sdk.openadsdk.core.ah.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ah.this.ka.get()) {
                                return;
                            }
                            ah.this.ka.set(true);
                            c.ms();
                            com.bytedance.sdk.openadsdk.core.jw.ch.ah();
                            com.bytedance.sdk.openadsdk.ms.ms.ms.ms(false);
                            com.bytedance.sdk.openadsdk.ms.ah.ah.xr();
                            com.bytedance.sdk.component.panglearmor.ny.ms();
                            com.bytedance.sdk.openadsdk.ub.xr.xr(context);
                            com.bytedance.sdk.openadsdk.ub.xr.ms(context);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.sl.ms("Init sync exception: ".concat(String.valueOf(th)));
                        }
                    }
                });
                nw.f3028ms = true;
            } catch (Throwable th) {
                th = th;
                eventListener2 = eventListener;
                ms(eventListener2, th);
                ms(new com.bytedance.sdk.openadsdk.core.f.ms(valueSet), this.d);
            }
        } catch (Throwable th2) {
            th = th2;
            eventListener2 = eventListener;
            ms(eventListener2, th);
            ms(new com.bytedance.sdk.openadsdk.core.f.ms(valueSet), this.d);
        }
    }

    private void ms(EventListener eventListener, Throwable th) {
        if (eventListener != null) {
            String message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            eventListener.onEvent(1, com.bykv.ms.ms.ms.ms.ms.ms().ms(false).ms(TTAdConstant.INIT_LOCAL_FAIL_CODE).ms(message).xr());
            com.bytedance.sdk.component.utils.sl.ah("TTAdSdk", " init fail, msg = ", message);
        }
        this.d = false;
    }

    private void ms(ValueSet valueSet) {
        try {
            com.bytedance.sdk.openadsdk.core.of.ms.ms();
        } catch (Exception unused) {
        }
    }

    private void ms(EventListener eventListener) {
        com.bytedance.sdk.openadsdk.core.ah.ms.ms();
        if (eventListener != null) {
            eventListener.onEvent(AVMDLDataLoader.KeyIsLiveSetP2pAllow, com.bykv.ms.ms.ms.ms.ms.ms().ms(true).ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(20, com.bytedance.sdk.component.ch.hi.xr.ny()).xr()).xr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(Context context, com.bytedance.sdk.openadsdk.core.f.ms msVar, EventListener eventListener, w wVar) {
        if (this.d) {
            ms(eventListener);
            return false;
        }
        try {
            if (com.bytedance.sdk.openadsdk.core.d.ms.ah()) {
                if (!tmapcloak.loadLibSuccess) {
                    ms(eventListener, new Exception("load maparmor fail"));
                    return false;
                }
                wVar.xr("maparmor_load_cost");
            }
            ms(context, msVar, wVar);
            this.d = true;
            ms(context, msVar);
            wVar.xr("async_init_cost");
            com.bytedance.sdk.component.utils.sl.d("TTAdSdk", "Init done finish: 6923");
            ms(eventListener);
        } catch (Throwable th) {
            ms(eventListener, th);
        }
        ms(msVar, this.d);
        return true;
    }

    private void ms(Context context, com.bytedance.sdk.openadsdk.core.f.ms msVar, w wVar) {
        try {
            if (ms(msVar)) {
                com.bytedance.sdk.openadsdk.core.jw.qv.ms();
                com.bykv.vk.openvk.component.video.api.c.ah.ms();
                com.bytedance.sdk.component.ny.ms.ms();
                com.bytedance.sdk.openadsdk.tools.xr.xr();
            }
        } catch (Throwable unused) {
        }
        wVar.xr("debug_set_cost");
        com.bytedance.sdk.openadsdk.core.multipro.d.ms(context);
        wVar.xr("web_dir_cost");
        com.bytedance.sdk.component.ny.ah.ms.ms((ThreadPoolExecutor) com.bytedance.sdk.component.ch.ab.ms());
        wVar.xr("thread_pool_cost");
        com.bykv.vk.openvk.component.video.api.ah.ms(msVar.hi());
        if (msVar.hi()) {
            com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
            ch.ub().g();
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.xr.xr();
        }
        wVar.xr("multi_cost");
        com.bykv.vk.openvk.component.video.api.ah.ms(context, null);
        com.bykv.vk.openvk.component.video.ms.ms.ms(context);
        wVar.xr("video_config_cost");
        nw.ka();
        wVar.xr("dyna_init_cost");
        com.bytedance.sdk.openadsdk.core.jw.re.ms(context);
        wVar.xr("armor_init_cost");
    }

    private void ms(com.bytedance.sdk.openadsdk.core.f.ms msVar, ValueSet valueSet) {
        xr(msVar, valueSet);
        nw.d();
        com.bytedance.sdk.openadsdk.core.t.xr.xr();
        try {
            com.bytedance.sdk.openadsdk.core.ugeno.ka.ms();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        if (msVar.hi()) {
            com.bytedance.sdk.openadsdk.core.jw.g.ms();
        }
        com.bytedance.sdk.openadsdk.core.ah.ah.ms().ms(msVar.hi());
    }

    private void xr(ValueSet valueSet) {
        try {
            Boolean bool = (Boolean) valueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                g.f2500ms = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private void xr(com.bytedance.sdk.openadsdk.core.f.ms msVar, ValueSet valueSet) {
        if (msVar == null) {
            return;
        }
        String strAh = msVar.ah();
        if (strAh == null || strAh.isEmpty()) {
            strAh = com.bytedance.sdk.openadsdk.core.x.ms.xr(re.getContext());
        }
        ch.ub().ms(new com.bytedance.sdk.openadsdk.core.f.ah(valueSet.objectValue(16, Object.class)));
        ch.ub().d(strAh);
        ch.ub().ah(msVar.xr());
        ch.ub().ah(msVar.d());
        ch.ub().ka(msVar.ka());
        ch.ub().c(msVar.c());
        ch.ub().xr(msVar.ab());
        ch.ub().d(msVar.x());
        ch.ub().ms(msVar.ch());
        ch.ub().ab(msVar.u());
        ch.ub().ms((com.bytedance.sdk.openadsdk.core.f.ka) msVar.ms());
        if (g.xr >= 5500) {
            ch.ub().d(msVar.zb());
            ch.ub().ms(msVar.sl());
        } else {
            ch.ub().d(valueSet.intValue(7));
            ch.ub().ms(valueSet.intValue(8));
        }
        if (ms(msVar)) {
            com.bytedance.sdk.component.utils.sl.xr();
            com.bytedance.sdk.openadsdk.tools.xr.xr();
        }
    }

    private void ms(final Context context, final com.bytedance.sdk.openadsdk.core.f.ms msVar) {
        com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.component.ch.ny("init sync") { // from class: com.bytedance.sdk.openadsdk.core.ah.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ch.ub().ul() != null) {
                        ch.ub().ul().call(20, com.bykv.ms.ms.ms.ms.xr.f12ms, Void.class);
                    } else {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk", "下载SDK 初始化失败 ， bridge = null ！！！");
                    }
                    com.bytedance.sdk.openadsdk.core.g.ch chVarXr = re.xr();
                    if (!chVarXr.fk()) {
                        synchronized (chVarXr) {
                            if (!chVarXr.fk()) {
                                chVarXr.ms();
                            }
                        }
                    }
                    ah.this.ms(msVar.hi(), context, true, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                    com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ah.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ch.ub().cv()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.ub.xr.xr();
                        }
                    }, 120000L);
                    com.bykv.vk.openvk.component.video.api.ah.ms(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
                    com.bytedance.sdk.openadsdk.core.t.xr.ms(context, msVar.hi());
                    com.bytedance.sdk.openadsdk.core.hi.d.ah();
                    jw.ah();
                    com.bykv.vk.openvk.component.video.ms.ms.ms(com.bytedance.sdk.openadsdk.op.ny.ms(0));
                    if (chVarXr.hi()) {
                        final com.bykv.vk.openvk.component.video.api.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.op.ny.ms(1);
                        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.ah.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.sl.xr.xr.ms(context, xrVarMs.d(), 52428800, com.bytedance.sdk.openadsdk.op.ny.xr(), com.bytedance.sdk.openadsdk.op.ny.ah(), ah.ms(msVar), new VideoEventEngineUploader() { // from class: com.bytedance.sdk.openadsdk.core.ah.3.2.1
                                    @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                                    public void onEvent(String str, JSONObject jSONObject) {
                                        c.ms().ms(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    com.bytedance.sdk.openadsdk.core.jw.ch.ub();
                    nw.ms(context);
                    com.bytedance.sdk.component.ch.ab.ms(true);
                    com.bytedance.sdk.component.ch.ab.ms(new com.bytedance.sdk.openadsdk.core.t.xr.ms());
                    com.bytedance.sdk.openadsdk.core.dislike.ms.ms();
                    com.bytedance.sdk.openadsdk.core.jw.ch.ms(context);
                    com.bytedance.sdk.openadsdk.ms.xr.xr.ah(context);
                    com.bytedance.sdk.openadsdk.core.jw.ch.ka(context);
                    com.bytedance.sdk.openadsdk.sl.d.ms(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.y.ms();
                            com.bytedance.sdk.component.utils.u.ms(new com.bytedance.sdk.openadsdk.op.ka());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.jw.zb.ms();
                    com.bytedance.sdk.openadsdk.core.jw.x.ms(msVar);
                    com.bytedance.sdk.openadsdk.core.jw.re.ms();
                    com.bytedance.sdk.openadsdk.core.ul.ms.ms().ms(context);
                    com.bytedance.sdk.openadsdk.core.jw.pc.ms();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.sl.xr("TTAdSdk", "Unexpected asyn init error: ".concat(String.valueOf(th)));
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final boolean z, final Context context, final boolean z2, long j) {
        com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ah.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.utils.sl.d("lqmt", "iB: true, iQ: " + ch.ub().cv());
                com.bytedance.sdk.openadsdk.core.live.xr.ms();
                if (z) {
                    if (com.bytedance.sdk.component.utils.h.ms(context)) {
                        com.bytedance.sdk.openadsdk.core.g.x.ms(re.xr()).ka();
                        com.bytedance.sdk.component.utils.sl.ms("TTAdSdk", "Load setting in main process");
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.g.x.ms(re.xr()).ka();
                }
                if (z2) {
                    com.bytedance.sdk.openadsdk.core.t.xr.d();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Context context, final long j, final long j2, final long j3, final w wVar, final boolean z, final com.bytedance.sdk.openadsdk.core.f.ms msVar, final String str, final int i, final ValueSet valueSet) {
        com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ah.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ah.this.xr(context, j, j2, j3, wVar, z, msVar, str, i, valueSet);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final Context context, final long j, final long j2, final long j3, final w wVar, final boolean z, final com.bytedance.sdk.openadsdk.core.f.ms msVar, final String str, final int i, final ValueSet valueSet) {
        nw.ah();
        if (re.xr().vm()) {
            com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ah.6
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    boolean zY = ch.ub().y();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j);
                    jSONObject.put("is_async", z);
                    jSONObject.put("is_multi_process", msVar.hi());
                    jSONObject.put("is_debug", ah.ms(msVar));
                    jSONObject.put("is_activate_init", zY);
                    jSONObject.put("is_plugin", g.ms());
                    jSONObject.put("has_kotlin", ah.d());
                    jSONObject.put("use_mediation", msVar.u());
                    jSONObject.put("is_androidx", ah.ah());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.yu.xr.xr.ms());
                    jSONObject.put("minSdkVersion", com.bytedance.sdk.openadsdk.core.jw.f.d(context));
                    jSONObject.put("targetSdkVersion", com.bytedance.sdk.openadsdk.core.jw.f.ah(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", g.d());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.jw.g.xr());
                    jSONObject.put("thread_name", str);
                    jSONObject.put("thread_priority", i);
                    jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.d.ms.d());
                    ch.ub().xr(false);
                    Object objObjectValue = valueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j);
                    jSONObject2.put("callback_cost", j2);
                    jSONObject2.put("total_cost", j3);
                    if (objObjectValue != null) {
                        jSONObject2.put("plugin", objObjectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    wVar.ms(jSONObject3, 20L);
                    jSONObject2.put(TrackAction.INIT, jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    if (!msVar.u()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object objInvoke2 = Class.forName("com.qq.e.comm.managers.status.SDKStatus").getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object objInvoke3 = Class.forName("com.kwad.sdk.api.KsAdSDK").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pangle_sdk_init").xr(jSONObject.toString()).ka(new StringBuilder().append(j2).toString());
                }
            }, "pangle_sdk_init");
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        ms(context, valueSet, (EventListener) valueSet.objectValue(15, EventListener.class));
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(isInitSuccess());
            case -999001:
                ms((Context) valueSetXr.objectValue(-998000, Context.class), valueSetXr, new com.bytedance.sdk.openadsdk.core.f.d(valueSetXr.objectValue(15, Object.class)));
                return null;
            case -999000:
                return this.ah;
            default:
                return null;
        }
    }
}
