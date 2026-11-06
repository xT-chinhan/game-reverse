package com.byazt.ry;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH, 29})
public class cp {
    public static volatile cp n;
    public volatile String fs;
    public boolean qg;
    public final List<ZeusPluginStateListener> s = new CopyOnWriteArrayList();
    public final List<oa> q = new ArrayList();
    public final Handler l = new Handler(Looper.getMainLooper());
    public d w = null;
    public Map<String, JSONObject> x = new ConcurrentHashMap();

    public static cp n() {
        if (n == null) {
            synchronized (cp.class) {
                if (n == null) {
                    n = new cp();
                }
            }
        }
        return n;
    }

    public synchronized void n(Application application) {
        if (this.qg) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        n(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            GlobalParam.getInstance().getReporter().n("zeus_stage_error", "context is null");
            throw new IllegalArgumentException("context must be not null !!!");
        }
        ZeusLogger.setDebug(globalParam.isDebug());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.byazt.zi.l.qg(new Runnable() { // from class: com.byazt.ry.cp.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gx.cp.qg();
            }
        });
        if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.byazt.sw.l.n();
        }
        com.byazt.fw.qg.n().n(new com.byazt.fw.n() { // from class: com.byazt.ry.cp.2
            @Override // com.byazt.fw.n
            public void n(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                com.byazt.is.s.n(str, jSONObject, jSONObject2, jSONObject3);
            }
        });
        if (!globalParam.isCloseFlipped()) {
            qg.n();
        }
        if (com.byazt.gx.rv.cy()) {
            com.byazt.zi.l.n(new Runnable() { // from class: com.byazt.ry.cp.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GlobalParam.getInstance().getReporter().n("zeus_stage_common", "invoke SystemConfig");
                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                    } catch (Throwable th) {
                        GlobalParam.getInstance().getReporter().n("zeus_stage_error", "invoke SystemConfig error : ".concat(String.valueOf(th)));
                    }
                }
            });
        }
        if (com.byazt.gx.rv.sz()) {
            x();
        }
        w();
        ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            Zeus.hookHuaWeiVerifier(application);
        }
        this.qg = true;
        n(3100, 0, null, -1, null);
    }

    public void n(String str) {
        this.fs = str;
    }

    private boolean n(ProviderInfo providerInfo) {
        if (this.fs == null || !this.fs.equals(providerInfo.name)) {
            return !TextUtils.isEmpty(providerInfo.authority) && providerInfo.authority.contains(new StringBuilder().append(Zeus.getAppApplication().getPackageName()).append(".pangle.servermanager.").toString());
        }
        return true;
    }

    private void w() {
        GlobalParam.getInstance().getReporter().n("zeus_stage_plugin", "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (n(providerInfo)) {
                        String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1];
                        ProviderInfo providerInfo2 = Zeus.getServerManagerHashMap().get(str);
                        if ((providerInfo2 == null || !TextUtils.equals(str, "main")) && (providerInfo2 == null || !TextUtils.equals(str, "downloader") || TextUtils.isEmpty(providerInfo2.authority) || !providerInfo2.authority.contains("com.bytedance.sdk.openadsdk.adhost"))) {
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().n("zeus_stage_plugin", "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().n("zeus_stage_plugin", "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean qg() {
        return this.qg;
    }

    public List<ZeusPluginStateListener> s() {
        return this.s;
    }

    public void n(ZeusPluginStateListener zeusPluginStateListener) {
        this.s.add(zeusPluginStateListener);
    }

    public void qg(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.s;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void n(oa oaVar) {
        if (oaVar == null) {
            return;
        }
        synchronized (this.q) {
            this.q.add(oaVar);
        }
    }

    public void qg(oa oaVar) {
        if (oaVar == null) {
            return;
        }
        synchronized (this.q) {
            this.q.remove(oaVar);
        }
    }

    public void n(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : fs()) {
            this.l.post(new Runnable() { // from class: com.byazt.ry.cp.4
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    private void x() {
        try {
            GlobalParam.getInstance().getReporter().n("zeus_stage_common", "invoke disableApiWarning");
            FieldUtils.writeField(com.byazt.zi.n.n(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] fs() {
        Object[] array;
        synchronized (this.q) {
            array = !this.q.isEmpty() ? this.q.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public void n(d dVar) {
        this.w = dVar;
    }

    public d q() {
        return this.w;
    }

    public Map<String, JSONObject> l() {
        return this.x;
    }
}
