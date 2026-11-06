package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.ab;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.zb;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ch f660ms = ch.ms();

    d() {
    }

    boolean ms(String str) {
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
            ch chVar = f660ms;
            chVar.ms(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.ms msVarMs = com.bytedance.pangle.log.ms.ms(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            ms(com.bytedance.pangle.d.xr.x, com.bytedance.pangle.d.xr.ms.g, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean zMs = plugin.isIsDexPlugin() ? com.bytedance.pangle.ah.xr.ms(plugin, sb) : ms(str, plugin, sb);
            if ((plugin instanceof ms) && plugin.isIsDexPlugin()) {
                ((ms) plugin).ms();
            }
            msVarMs.ms("loadPluginInternal:".concat(String.valueOf(zMs)));
            if (zMs) {
                plugin.setLifeCycle(3);
                ms(com.bytedance.pangle.d.xr.ny, com.bytedance.pangle.d.xr.ms.of, plugin.mPkgName, plugin.getVersion(), msVarMs.ms(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                chVar.ms(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:").append(plugin.mPkgName).append(" versionCode:").append(plugin.getVersion()).append("load failed;");
                ms(com.bytedance.pangle.d.xr.ny, com.bytedance.pangle.d.xr.ms.p, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                chVar.ms(ZeusPluginEventCallback.EVENT_FINISH_LOAD, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean ms(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zXr;
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
            final String strXr = com.bytedance.pangle.ka.ah.xr(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strXr + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strXr).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zXr = xr(strXr, plugin, sb);
            try {
                final File file = new File(com.bytedance.pangle.ka.ah.d(plugin.mPkgName, plugin.getVersion()));
                final File fileMs = ms(plugin.mPkgName, plugin.getVersion(), strXr);
                boolean z = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (ny.y()) {
                    packageInfoArr = packageInfoArr2;
                    z = true;
                    com.bytedance.pangle.ms.ms.ms(true, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.d.1
                        @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                        public void ms() throws Exception {
                            d.this.ms(plugin, strXr, file, fileMs, sb);
                        }
                    }, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.d.2
                        @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                        public void ms() throws Throwable {
                            packageInfoArr[0] = d.this.ms(str, plugin, sb, strXr, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    ms(plugin, strXr, file, fileMs, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = ms(str, plugin, sb, strXr, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                ms(plugin, sb, packageInfoArr[0]);
                return z;
            } catch (Throwable th) {
                th = th;
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadPluginInternal stack:" + Arrays.toString(th.getStackTrace()));
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ").append(th.getMessage()).append(";");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zXr) {
                    zb.ms().ms(str, plugin.getVersion(), "load");
                    if (zb.ms().xr(str, plugin.getVersion(), "load") > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zXr = false;
        }
    }

    private boolean xr(String str, Plugin plugin, StringBuilder sb) {
        if (ny.ah() || ny.x() || ny.y()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((zb.ms().ny(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zXr = com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication());
        boolean zAb = zb.ms().ab(plugin.mPkgName, plugin.getVersion());
        if (zXr && zAb) {
            if (!zb.ms().x(plugin.mPkgName, plugin.getVersion())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean zMs = com.bytedance.pangle.util.xr.xr.ms(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                sb.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                zb.ms().d(plugin.mPkgName, plugin.getVersion(), true);
                return zMs;
            }
            sb.append("removeEntry skip 3;");
            return false;
        }
        sb.append("removeEntry skip 4 ").append(zXr).append(" ").append(zAb).append(";");
        return false;
    }

    private void ms(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
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
    public PackageInfo ms(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
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
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.d.3
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
    public void ms(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ms(plugin, str, file, file2);
        sb.append("classLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.bytedance.pangle.ka.ka.ms(new Runnable() { // from class: com.bytedance.pangle.plugin.d.4
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
                ms(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } finally {
            sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(";");
        }
    }

    private void ms(Plugin plugin, String str, File file, File file2) throws Exception {
        if (ms()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            ms(plugin.mClassLoader, str);
        } else {
            if (ny.ah()) {
                String strMs = ab.ms(plugin.mPkgName, plugin.getVersion());
                String[] strArrSplit = strMs.split(":");
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z = !com.bytedance.pangle.c.xr.ms(file2.getAbsolutePath(), strArrSplit);
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + z);
                plugin.mClassLoader = new PluginClassLoader(z ? "" : strMs, file2, file.getAbsolutePath(), null);
                return;
            }
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }

    private File ms(String str, int i, String str2) {
        File file = new File(com.bytedance.pangle.ka.ah.ah(str, i));
        if (ny.ab() && !com.bytedance.pangle.c.xr.ms(file + File.separator + com.bytedance.pangle.c.xr.ms(str2))) {
            file = null;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void ms(Plugin plugin, String str) throws JSONException {
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
            ComponentManager.registerActivity(plugin.mPkgName, ((str3 == null || !str3.contains(j.z)) ? plugin.mPkgName + j.z : "") + ((String) map.get(str2)), str2);
        }
    }

    public static void ms(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(f.z, com.bytedance.pangle.log.xr.ms(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xr.ms(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xr.ms(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xr.xr(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.xr.ms(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.bytedance.pangle.d.xr.ms().ms(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean ms() {
        return ny.y();
    }

    public static boolean ms(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }
}
