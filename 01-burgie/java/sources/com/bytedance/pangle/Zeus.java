package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ae.g;
import com.byazt.ae.hn;
import com.byazt.ae.hw;
import com.byazt.ae.k;
import com.byazt.ae.m;
import com.byazt.ae.w;
import com.byazt.wo.pr;
import com.byazt.wo.x;
import com.byazt.xid.c;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Zeus {
    public static Application sApplication;
    public static volatile Function sMainService;
    public static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    public static final Object wait = new Object();

    public static Application getAppApplication() {
        if (sApplication == null) {
            hw.pr();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(pr.pr(), "getApplication", new Object[0]);
            } catch (Throwable th) {
            }
        }
        return sApplication;
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable th) {
            }
        }
        sApplication = application;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static void init(Application application) {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_common", "start init");
        w.pr().pr(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.byazt.wee.pr.hw().hn();
    }

    public static boolean waitInit(int i) {
        if (w.pr().hw()) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!w.pr().hw()) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        return w.pr().hw();
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.byazt.bq.pr.pr(application);
    }

    public static void installFromDownloadDir() {
        if (x.hw(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static void triggerBgDexOpt() {
        c.pr();
    }

    public static boolean hasInit() {
        return w.pr().hw();
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        w.pr().pr(zeusPluginStateListener);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        w.pr().hw(zeusPluginStateListener);
    }

    public static void addPluginEventCallback(m mVar) {
        w.pr().pr(mVar);
    }

    public static void removePluginEventCallback(m mVar) {
        w.pr().hw(mVar);
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static Plugin getPlugin(String str, boolean z) {
        return PluginManager.getInstance().getPlugin(str, z);
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginInstalled(String str, boolean z) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str, false);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_plugin_install", TrackAction.START);
        hn hnVarPr = com.byazt.ewn.hw.pr();
        if (hnVarPr != null) {
            try {
                return hnVarPr.pr(str, str2);
            } catch (RemoteException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
                return false;
            }
        }
        return false;
    }

    public static void registerPluginInstallListener(g gVar) {
        try {
            hn hnVarPr = com.byazt.ewn.hw.pr();
            if (hnVarPr != null) {
                hnVarPr.pr(gVar.hashCode(), new com.byazt.qep.hw(gVar));
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public void unregisterPluginInstallListener(g gVar) {
        try {
            hn hnVarPr = com.byazt.ewn.hw.pr();
            if (hnVarPr != null) {
                hnVarPr.pr(gVar.hashCode());
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "unregisterPluginInstallListener error.", e);
        }
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unInstallPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin != null) {
            if (i > 0) {
                plugin.unInstall(i);
            } else {
                com.byazt.gs.m.pr().fw(str);
            }
        }
    }

    public static String getHostAbi() {
        return com.byazt.wo.hw.pr();
    }

    public static int getMaxInstallVer(String str) {
        if (x.hw(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static int getHostAbiBit() {
        return com.byazt.wo.hw.hw();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (plugin = getPlugin(str)) != null && plugin.mResources != null) {
            new com.byazt.zc.pr().pr(plugin.mResources.getAssets(), str2, false);
        }
    }

    public static void setDecodeCallback(k kVar) {
        w.pr().pr(kVar);
    }

    public static void addPackageDexManager(String str, JSONObject jSONObject) {
        Map<String, JSONObject> mapC = w.pr().c();
        if (!TextUtils.isEmpty(str) && jSONObject != null && jSONObject.length() > 0) {
            mapC.put(str, jSONObject);
        }
    }

    public static Function getMainService() {
        return sMainService;
    }

    public static void setMainService(Function function) {
        if (sMainService != null || function == null) {
            return;
        }
        sMainService = function;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 0);
        function.apply(sparseArray);
    }
}
