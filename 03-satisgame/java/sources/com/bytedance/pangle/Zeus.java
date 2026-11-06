package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ry.cp;
import com.byazt.ry.d;
import com.byazt.ry.oa;
import com.byazt.ry.qg;
import com.byazt.ry.s;
import com.byazt.ry.sz;
import com.byazt.sw.l;
import com.byazt.zi.n;
import com.byazt.zi.q;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
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
            qg.n();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(n.n(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static void init(Application application) {
        GlobalParam.getInstance().getReporter().n("zeus_stage_common", "start init");
        cp.n().n(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
        com.byazt.p000do.n.qg().s();
    }

    public static boolean waitInit(int i) {
        if (cp.n().qg()) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!cp.n().qg()) {
                try {
                    if (i == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return cp.n().qg();
    }

    public static void hookHuaWeiVerifier(Application application) {
        com.byazt.qd.n.n(application);
    }

    public static void installFromDownloadDir() {
        if (q.qg(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static void triggerBgDexOpt() {
        l.n();
    }

    public static boolean hasInit() {
        return cp.n().qg();
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        cp.n().n(zeusPluginStateListener);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        cp.n().qg(zeusPluginStateListener);
    }

    public static void addPluginEventCallback(oa oaVar) {
        cp.n().n(oaVar);
    }

    public static void removePluginEventCallback(oa oaVar) {
        cp.n().qg(oaVar);
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
        GlobalParam.getInstance().getReporter().n("zeus_stage_plugin_install", "start");
        s sVarN = com.byazt.gc.qg.n();
        if (sVarN == null) {
            return false;
        }
        try {
            return sVarN.n(str, str2);
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e);
            return false;
        }
    }

    public static void registerPluginInstallListener(sz szVar) {
        try {
            s sVarN = com.byazt.gc.qg.n();
            if (sVarN != null) {
                sVarN.n(szVar.hashCode(), new com.byazt.pr.qg(szVar));
            }
        } catch (RemoteException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "registerPluginInstallListener error.", e);
        }
    }

    public void unregisterPluginInstallListener(sz szVar) {
        try {
            s sVarN = com.byazt.gc.qg.n();
            if (sVarN != null) {
                sVarN.n(szVar.hashCode());
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
                com.byazt.gx.oa.n().x(str);
            }
        }
    }

    public static String getHostAbi() {
        return com.byazt.zi.qg.n();
    }

    public static int getMaxInstallVer(String str) {
        if (q.qg(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static int getHostAbiBit() {
        return com.byazt.zi.qg.qg();
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
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || plugin.mResources == null) {
            return;
        }
        new com.byazt.ye.n().n(plugin.mResources.getAssets(), str2, false);
    }

    public static void setDecodeCallback(d dVar) {
        cp.n().n(dVar);
    }

    public static void addPackageDexManager(String str, JSONObject jSONObject) {
        Map<String, JSONObject> mapL = cp.n().l();
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        mapL.put(str, jSONObject);
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
