package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.hi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ch f630ms;
    private boolean xr;
    private final List<ZeusPluginStateListener> ah = new CopyOnWriteArrayList();
    private final List<ZeusPluginEventCallback> d = new ArrayList();
    private final Handler ka = new Handler(Looper.getMainLooper());
    private ZeusPluginDecodeCallback c = null;
    private Map<String, JSONObject> ab = new ConcurrentHashMap();

    public static ch ms() {
        if (f630ms == null) {
            synchronized (ch.class) {
                if (f630ms == null) {
                    f630ms = new ch();
                }
            }
        }
        return f630ms;
    }

    synchronized void ms(Application application) {
        if (this.xr) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        ms(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application == null) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
            throw new IllegalArgumentException("context must be not null !!!");
        }
        ZeusLogger.setDebug(globalParam.isDebug());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
        com.bytedance.pangle.ka.ka.xr(new Runnable() { // from class: com.bytedance.pangle.ch.1
            @Override // java.lang.Runnable
            public void run() {
                hi.xr();
            }
        });
        if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
            com.bytedance.pangle.c.c.ms();
        }
        com.bytedance.pangle.d.xr.ms().ms(new com.bytedance.pangle.d.ms() { // from class: com.bytedance.pangle.ch.2
            @Override // com.bytedance.pangle.d.ms
            public void ms(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                com.bytedance.pangle.log.xr.ms(str, jSONObject, jSONObject2, jSONObject3);
            }
        });
        if (!globalParam.isCloseFlipped()) {
            xr.ms();
        }
        if (com.bytedance.pangle.util.ny.h()) {
            com.bytedance.pangle.ka.ka.ms(new Runnable() { // from class: com.bytedance.pangle.ch.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                        MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                    } catch (Throwable th) {
                        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th)));
                    }
                }
            });
        }
        if (com.bytedance.pangle.util.ny.ub()) {
            ab();
        }
        c();
        ContentProviderManager.getInstance().initSystemContentProviderInfo();
        if (!globalParam.closeHookHuaweiOnInit()) {
            Zeus.hookHuaWeiVerifier(application);
        }
        this.xr = true;
        ms(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
    }

    private void c() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && packageInfo.providers != null) {
                for (ProviderInfo providerInfo : packageInfo.providers) {
                    if (!TextUtils.isEmpty(providerInfo.authority) && providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                        String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1];
                        if (Zeus.getServerManagerHashMap().get(str) == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                            Zeus.getServerManagerHashMap().put(str, providerInfo);
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    public boolean xr() {
        return this.xr;
    }

    public List<ZeusPluginStateListener> ah() {
        return this.ah;
    }

    public void ms(ZeusPluginStateListener zeusPluginStateListener) {
        this.ah.add(zeusPluginStateListener);
    }

    public void xr(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.ah;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void ms(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.d) {
            this.d.add(zeusPluginEventCallback);
        }
    }

    public void xr(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.d) {
            this.d.remove(zeusPluginEventCallback);
        }
    }

    public void ms(final int i, final int i2, final String str, final int i3, final Throwable th) {
        for (final Object obj : x()) {
            this.ka.post(new Runnable() { // from class: com.bytedance.pangle.ch.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private void ab() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.ka.ms.ms(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    private Object[] x() {
        Object[] array;
        synchronized (this.d) {
            array = !this.d.isEmpty() ? this.d.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public void ms(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.c = zeusPluginDecodeCallback;
    }

    public ZeusPluginDecodeCallback d() {
        return this.c;
    }

    public Map<String, JSONObject> ka() {
        return this.ab;
    }
}
