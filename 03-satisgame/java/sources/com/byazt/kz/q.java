package com.byazt.kz;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.d.i;
import com.byazt.gx.oa;
import com.byazt.gx.rv;
import com.byazt.ry.cp;
import com.byazt.vx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1356, 5})
public class q {
    public static final cp n = cp.n();

    public boolean n(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        }
        if (plugin.isLoading()) {
            return false;
        }
        if (plugin.isLoaded()) {
            return true;
        }
        synchronized (plugin) {
            if (plugin.isLoaded()) {
                return true;
            }
            plugin.setLifeCycle(4);
            cp cpVar = n;
            cpVar.n(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.byazt.is.qg qgVarN = com.byazt.is.qg.n(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            n(com.byazt.fw.qg.fs, com.byazt.fw.qg.n.ln, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean zN = plugin.isIsDexPlugin() ? com.byazt.kc.qg.n(plugin, sb) : n(str, plugin, sb);
            if ((plugin instanceof n) && plugin.isIsDexPlugin()) {
                ((n) plugin).n();
            }
            qgVarN.n("loadPluginInternal:".concat(String.valueOf(zN)));
            if (zN) {
                plugin.setLifeCycle(3);
                n(com.byazt.fw.qg.rv, com.byazt.fw.qg.n.lh, plugin.mPkgName, plugin.getVersion(), qgVarN.n(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                cpVar.n(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:").append(plugin.mPkgName).append(" versionCode:").append(plugin.getVersion()).append("load failed;");
                n(com.byazt.fw.qg.rv, com.byazt.fw.qg.n.v, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                cpVar.n(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean n(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zQg;
        final PackageInfo[] packageInfoArr;
        try {
            if (plugin == null) {
                sb.append("loadPluginInternal, plugin == null;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!");
                return false;
            }
            final String strQg = com.byazt.zi.s.qg(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strQg + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strQg).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zQg = qg(strQg, plugin, sb);
            try {
                final File file = new File(com.byazt.zi.s.q(plugin.mPkgName, plugin.getVersion()));
                final File fileN = n(plugin.mPkgName, plugin.getVersion(), strQg);
                boolean z = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (rv.cd()) {
                    packageInfoArr = packageInfoArr2;
                    z = true;
                    com.byazt.qb.n.n(true, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.q.1
                        @Override // com.byazt.qb.n.InterfaceC0309n
                        public void n() throws Exception {
                            q.this.n(plugin, strQg, file, fileN, sb);
                        }
                    }, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.q.2
                        @Override // com.byazt.qb.n.InterfaceC0309n
                        public void n() throws Throwable {
                            packageInfoArr[0] = q.this.n(str, plugin, sb, strQg, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    n(plugin, strQg, file, fileN, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = n(str, plugin, sb, strQg, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                n(plugin, sb, packageInfoArr[0]);
                return z;
            } catch (Throwable th) {
                th = th;
                String stackTraceString = Log.getStackTraceString(th);
                GlobalParam.getInstance().getReporter().n("zeus_stage_error", "loadPluginInternal stack:".concat(String.valueOf(stackTraceString)));
                GlobalParam.getInstance().getReporter().n("zeus_stage_error", "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ").append(th.getMessage()).append(";").append(stackTraceString);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zQg) {
                    oa.n().n(str, plugin.getVersion(), "load");
                    if (oa.n().qg(str, plugin.getVersion(), "load") > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zQg = false;
        }
    }

    private boolean qg(String str, Plugin plugin, StringBuilder sb) {
        if (rv.x() || rv.cd()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((oa.n().fs(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zQg = com.byazt.zi.q.qg(Zeus.getAppApplication());
        boolean zW = oa.n().w(plugin.mPkgName, plugin.getVersion());
        if (zQg && zW) {
            if (!oa.n().x(plugin.mPkgName, plugin.getVersion())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean zN = com.byazt.jh.qg.n(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                sb.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                oa.n().s(plugin.mPkgName, plugin.getVersion(), true);
                return zN;
            }
            sb.append("removeEntry skip 3;");
            return false;
        }
        sb.append("removeEntry skip 4 ").append(zQg).append(" ").append(zW).append(";");
        return false;
    }

    private void n(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (TextUtils.isEmpty(activityInfo.processName) || !activityInfo.processName.contains(":")) {
                    activityInfo.processName = "main";
                } else {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (TextUtils.isEmpty(serviceInfo.processName) || !serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = "main";
                } else {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (TextUtils.isEmpty(activityInfo2.processName) || !activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = "main";
                } else {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) {
                    providerInfo.processName = "main";
                } else {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (plugin.pluginProvider != null && plugin.pluginProvider.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            plugin.mApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo n(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        plugin.mHostApplicationInfoHookSomeField = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.byazt.kz.q.3
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }
        });
        sb.append("makeResources cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        n(plugin, str, file, file2);
        sb.append("classLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.byazt.zi.l.n(new Runnable() { // from class: com.byazt.kz.q.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        plugin.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                n(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } finally {
            sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
        }
    }

    private void n(Plugin plugin, String str, File file, File file2) throws Exception {
        if (n()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            synchronized (plugin.getInitializeLock()) {
                n(plugin.mClassLoader, str);
            }
            return;
        }
        plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
    }

    private File n(String str, int i, String str2) {
        File file = new File(com.byazt.zi.s.s(str, i));
        if (rv.w() && !com.byazt.sw.qg.n(file + File.separator + com.byazt.sw.qg.n(str2))) {
            file = null;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void n(Plugin plugin, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject2.getString(next));
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("forceMappings");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                int iOptInt = jSONObject2.optInt("minApi", 0);
                int iOptInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= iOptInt2 && apiVersionCode >= iOptInt && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map.put(next2, jSONObjectOptJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            ComponentManager.registerActivity(plugin.mPkgName, ((str3 == null || !str3.contains(i.E)) ? plugin.mPkgName + i.E : "") + ((String) map.get(str2)), str2);
        }
    }

    public static void n(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.is.s.n(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.is.s.n(str2));
            jSONObject.putOpt("version_code", com.byazt.is.s.n(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.byazt.is.s.qg(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.is.s.n(str3));
        } catch (JSONException e) {
            w.n(e);
        }
        com.byazt.fw.qg.n().n(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean n() {
        return rv.cd();
    }

    public static boolean n(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                w.n(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }

    public static PluginClassLoader n(Plugin plugin, String str, StringBuilder sb) {
        try {
            File file = new File(com.byazt.zi.s.s(str, plugin.getVersion()));
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("makeDexPluginClassLoader dalvikCacheDir: " + file.getAbsolutePath());
            long jCurrentTimeMillis = System.currentTimeMillis();
            plugin.mClassLoader = new PluginClassLoader("", file, "", null);
            sb.append("makeDexPluginClassLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
            return plugin.mClassLoader;
        } catch (Throwable th) {
            sb.append("makeDexPluginClassLoader fail:  " + th.getMessage());
            return null;
        }
    }
}
