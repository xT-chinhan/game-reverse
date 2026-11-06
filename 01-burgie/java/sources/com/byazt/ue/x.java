package com.byazt.ue;

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
import com.byazt.ae.w;
import com.byazt.dea.uc;
import com.byazt.gs.aj;
import com.byazt.gs.m;
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
import com.taptap.sdk.update.download.DownloadTask;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 594, 121})
public class x {
    public static final w pr = w.pr();

    public boolean pr(String str) {
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
            w wVar = pr;
            wVar.pr(DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.byazt.wp.hw hwVarPr = com.byazt.wp.hw.pr(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            pr(com.byazt.yk.hw.zo, com.byazt.yk.hw.pr.nl, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean zPr = plugin.isIsDexPlugin() ? com.byazt.sjd.hw.pr(plugin, sb) : pr(str, plugin, sb);
            if ((plugin instanceof pr) && plugin.isIsDexPlugin()) {
                ((pr) plugin).pr();
            }
            hwVarPr.pr("loadPluginInternal:".concat(String.valueOf(zPr)));
            if (zPr) {
                plugin.setLifeCycle(3);
                pr(com.byazt.yk.hw.aj, com.byazt.yk.hw.pr.y, plugin.mPkgName, plugin.getVersion(), hwVarPr.pr(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                wVar.pr(2100, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:").append(plugin.mPkgName).append(" versionCode:").append(plugin.getVersion()).append("load failed;");
                pr(com.byazt.yk.hw.aj, com.byazt.yk.hw.pr.ww, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                wVar.pr(2100, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean pr(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zHw;
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
            final String strHw = com.byazt.wo.hn.hw(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strHw + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strHw).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zHw = hw(strHw, plugin, sb);
            try {
                final File file = new File(com.byazt.wo.hn.x(plugin.mPkgName, plugin.getVersion()));
                final File filePr = pr(plugin.mPkgName, plugin.getVersion(), strHw);
                boolean z = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (aj.lb()) {
                    packageInfoArr = packageInfoArr2;
                    z = true;
                    com.byazt.hae.pr.pr(true, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.x.1
                        @Override // com.byazt.hae.pr.InterfaceC0082pr
                        public void pr() throws Exception {
                            x.this.pr(plugin, strHw, file, filePr, sb);
                        }
                    }, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.x.2
                        @Override // com.byazt.hae.pr.InterfaceC0082pr
                        public void pr() throws Throwable {
                            packageInfoArr[0] = x.this.pr(str, plugin, sb, strHw, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    pr(plugin, strHw, file, filePr, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = pr(str, plugin, sb, strHw, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                pr(plugin, sb, packageInfoArr[0]);
                return z;
            } catch (Throwable th) {
                th = th;
                String stackTraceString = Log.getStackTraceString(th);
                GlobalParam.getInstance().getReporter().pr("zeus_stage_error", "loadPluginInternal stack:".concat(String.valueOf(stackTraceString)));
                GlobalParam.getInstance().getReporter().pr("zeus_stage_error", "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ").append(th.getMessage()).append(";").append(stackTraceString);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zHw) {
                    m.pr().pr(str, plugin.getVersion(), "load");
                    if (m.pr().hw(str, plugin.getVersion(), "load") > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zHw = false;
        }
    }

    private boolean hw(String str, Plugin plugin, StringBuilder sb) {
        if (aj.fw() || aj.lb()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((m.pr().zo(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zHw = com.byazt.wo.x.hw(Zeus.getAppApplication());
        boolean zUc = m.pr().uc(plugin.mPkgName, plugin.getVersion());
        if (!zHw || !zUc) {
            sb.append("removeEntry skip 4 ").append(zHw).append(" ").append(zUc).append(";");
            return false;
        }
        if (!m.pr().fw(plugin.mPkgName, plugin.getVersion())) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean zPr = com.byazt.au.hw.pr(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
            sb.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            m.pr().hn(plugin.mPkgName, plugin.getVersion(), true);
            return zPr;
        }
        sb.append("removeEntry skip 3;");
        return false;
    }

    private void pr(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
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
    public PackageInfo pr(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
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
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.byazt.ue.x.3
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        });
        sb.append("makeResources cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        pr(plugin, str, file, file2);
        sb.append("classLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.byazt.wo.c.pr(new Runnable() { // from class: com.byazt.ue.x.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        plugin.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable th) {
                    }
                }
            });
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                pr(plugin, str2);
            }
        } catch (ClassNotFoundException e) {
        } finally {
            sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
        }
    }

    private void pr(Plugin plugin, String str, File file, File file2) throws Exception {
        if (pr()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            synchronized (plugin.getInitializeLock()) {
                pr(plugin.mClassLoader, str);
            }
            return;
        }
        plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
    }

    private File pr(String str, int i, String str2) {
        File file = new File(com.byazt.wo.hn.hn(str, i));
        if (aj.uc() && !com.byazt.xid.hw.pr(file + File.separator + com.byazt.xid.hw.pr(str2))) {
            file = null;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void pr(Plugin plugin, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (!TextUtils.isEmpty(str)) {
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
                ComponentManager.registerActivity(plugin.mPkgName, ((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "") + ((String) map.get(str2)), str2);
            }
        }
    }

    public static void pr(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.wp.hn.pr(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.wp.hn.pr(str2));
            jSONObject.putOpt("version_code", com.byazt.wp.hn.pr(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.byazt.wp.hn.hw(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.wp.hn.pr(str3));
        } catch (JSONException e) {
            uc.pr(e);
        }
        com.byazt.yk.hw.pr().pr(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean pr() {
        return aj.lb();
    }

    public static boolean pr(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                uc.pr(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }

    public static PluginClassLoader pr(Plugin plugin, String str, StringBuilder sb) {
        try {
            File file = new File(com.byazt.wo.hn.hn(str, plugin.getVersion()));
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
