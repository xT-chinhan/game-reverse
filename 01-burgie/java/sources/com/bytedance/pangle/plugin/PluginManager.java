package com.bytedance.pangle.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ae.aj;
import com.byazt.ae.w;
import com.byazt.gs.hw;
import com.byazt.gs.m;
import com.byazt.ue.pr;
import com.byazt.ue.x;
import com.byazt.wo.c;
import com.byazt.wo.hn;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PluginManager {
    public static final String TAG = "PluginManager";
    public static volatile PluginManager sInstance;
    public volatile boolean hasInstallFromDownloadDir;
    public volatile boolean mIsParsePluginConfig;
    public volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    public final x pluginLoader = new x();

    public static PluginManager getInstance() {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager();
                }
            }
        }
        return sInstance;
    }

    private PluginManager() {
    }

    public boolean loadPlugin(String str) {
        GlobalParam.getInstance().getReporter().pr("zeus_stage_common", "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.pr(str);
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && hw.pr()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!this.mIsParsePluginConfig) {
            parsePluginConfig();
        }
        Plugin plugin = this.mPlugins.get(str);
        if (z && plugin != null) {
            plugin.init();
            return plugin;
        }
        return plugin;
    }

    public Plugin getPluginOnly(String str) {
        return this.mPlugins.get(str);
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public void registerPlugin(String str) {
        Plugin plugins;
        if (str != null && (plugins = parsePlugins(str)) != null) {
            this.mPlugins.put(plugins.mPkgName, plugins);
        }
    }

    private synchronized void parsePluginConfig() {
        if (this.mIsParsePluginConfig) {
            return;
        }
        ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
        ArrayList arrayList = new ArrayList();
        try {
            try {
                Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
                if (bundle != null) {
                    for (String str : bundle.keySet()) {
                        if (aj.c.startsWith("PANGLE_")) {
                            if (str.startsWith(aj.c) || str.startsWith("ZEUS_PLUGIN_")) {
                                arrayList.add(bundle.getString(str));
                            }
                        } else if (str.startsWith(aj.c)) {
                            arrayList.add(bundle.getString(str));
                        }
                    }
                }
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Plugin plugins = parsePlugins((String) it.next());
                    if (plugins != null) {
                        concurrentHashMap.put(plugins.mPkgName, plugins);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugins.mPkgName);
                    }
                }
                Map<String, JSONObject> mapC = w.pr().c();
                if (mapC != null && mapC.size() > 0) {
                    for (Map.Entry<String, JSONObject> entry : mapC.entrySet()) {
                        String key = entry.getKey();
                        JSONObject value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && value != null) {
                            Plugin plugins2 = parsePlugins(value);
                            concurrentHashMap.put(plugins2.mPkgName, plugins2);
                            ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + plugins2.mPkgName);
                        }
                    }
                }
                this.mPlugins.putAll(concurrentHashMap);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e);
            }
            this.mIsParsePluginConfig = true;
        } catch (Throwable th) {
            this.mIsParsePluginConfig = true;
            throw th;
        }
    }

    private Plugin parsePlugins(String str) {
        if (str == null) {
            return null;
        }
        try {
            return parsePlugins(new JSONObject(str));
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str.trim(), e);
            return null;
        }
    }

    private Plugin parsePlugins(JSONObject jSONObject) throws JSONException {
        Plugin plugin;
        if (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) {
            plugin = new pr(jSONObject);
        } else {
            plugin = new Plugin(jSONObject);
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugin.mPkgName);
        return plugin;
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin != null && plugin.isInstalled() && !new File(hn.hw(plugin.mPkgName, plugin.getVersion())).exists()) {
            unInstallPackage(plugin.mPkgName);
        }
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            m.pr().fw(str);
        }
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new com.byazt.ue.hw(str, file).pr();
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            c.hw(new com.byazt.ue.hw(str, file));
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall, file=".concat(String.valueOf(file)));
        } else {
            ZeusPluginStateListener.postStateChange(str, 7, "asyncInstall apk is null !");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginManager asyncInstall apk is null !");
        }
    }

    public synchronized void installFromDownloadDir() {
        if (this.hasInstallFromDownloadDir) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginManager zeus has been installFromDownloadDir!");
            return;
        }
        if (com.byazt.wo.x.hw(Zeus.getAppApplication())) {
            c.hw(new com.byazt.ue.c());
        }
        this.hasInstallFromDownloadDir = true;
    }
}
