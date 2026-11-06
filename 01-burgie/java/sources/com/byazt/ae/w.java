package com.byazt.ae;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.ewn.MainServerManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 592, 109})
public class w {
    public static volatile w pr;
    public boolean hw;
    public final List<ZeusPluginStateListener> hn = new CopyOnWriteArrayList();
    public final List<m> x = new ArrayList();
    public final Handler c = new Handler(Looper.getMainLooper());
    public k uc = null;
    public Map<String, JSONObject> fw = new ConcurrentHashMap();

    public static w pr() {
        if (pr == null) {
            synchronized (w.class) {
                if (pr == null) {
                    pr = new w();
                }
            }
        }
        return pr;
    }

    public synchronized void pr(Application application) {
        if (this.hw) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        pr(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            GlobalParam.getInstance().getReporter().pr("zeus_stage_error", "context is null");
            throw new IllegalArgumentException("context must be not null !!!");
        }
        ZeusLogger.setDebug(globalParam.isDebug());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.byazt.wo.c.hw(new Runnable() { // from class: com.byazt.ae.w.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gs.w.hw();
            }
        });
        if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.byazt.xid.c.pr();
        }
        com.byazt.yk.hw.pr().pr(new com.byazt.yk.pr() { // from class: com.byazt.ae.w.2
            @Override // com.byazt.yk.pr
            public void pr(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                com.byazt.wp.hn.pr(str, jSONObject, jSONObject2, jSONObject3);
            }
        });
        if (!globalParam.isCloseFlipped()) {
            hw.pr();
        }
        if (com.byazt.gs.aj.nt()) {
            com.byazt.wo.c.pr(new Runnable() { // from class: com.byazt.ae.w.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GlobalParam.getInstance().getReporter().pr("zeus_stage_common", "invoke SystemConfig");
                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                    } catch (Throwable th) {
                        GlobalParam.getInstance().getReporter().pr("zeus_stage_error", "invoke SystemConfig error : ".concat(String.valueOf(th)));
                    }
                }
            });
        }
        if (com.byazt.gs.aj.g()) {
            fw();
        }
        uc();
        ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            Zeus.hookHuaWeiVerifier(application);
        }
        this.hw = true;
        pr(3100, 0, null, -1, null);
    }

    private void uc() {
        String str;
        GlobalParam.getInstance().getReporter().pr("zeus_stage_plugin", TrackAction.START);
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                        if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(":")) {
                            str = providerInfo.processName.split(":")[1];
                        } else {
                            str = "main";
                        }
                        ProviderInfo providerInfo2 = Zeus.getServerManagerHashMap().get(str);
                        if ((providerInfo2 == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) && (providerInfo2 == null || !TextUtils.equals(str, "downloader") || TextUtils.isEmpty(providerInfo2.authority) || !providerInfo2.authority.contains("com.bytedance.sdk.openadsdk.adhost"))) {
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().pr("zeus_stage_plugin", "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().pr("zeus_stage_plugin", "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean hw() {
        return this.hw;
    }

    public List<ZeusPluginStateListener> hn() {
        return this.hn;
    }

    public void pr(ZeusPluginStateListener zeusPluginStateListener) {
        this.hn.add(zeusPluginStateListener);
    }

    public void hw(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.hn;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void pr(m mVar) {
        if (mVar == null) {
            return;
        }
        synchronized (this.x) {
            this.x.add(mVar);
        }
    }

    public void hw(m mVar) {
        if (mVar == null) {
            return;
        }
        synchronized (this.x) {
            this.x.remove(mVar);
        }
    }

    public void pr(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : zo()) {
            this.c.post(new Runnable() { // from class: com.byazt.ae.w.4
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    private void fw() {
        try {
            GlobalParam.getInstance().getReporter().pr("zeus_stage_common", "invoke disableApiWarning");
            FieldUtils.writeField(com.byazt.wo.pr.pr(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] zo() {
        Object[] array;
        synchronized (this.x) {
            if (this.x.isEmpty()) {
                array = null;
            } else {
                array = this.x.toArray();
            }
        }
        if (array == null) {
            return new Object[0];
        }
        return array;
    }

    public void pr(k kVar) {
        this.uc = kVar;
    }

    public k x() {
        return this.uc;
    }

    public Map<String, JSONObject> c() {
        return this.fw;
    }
}
