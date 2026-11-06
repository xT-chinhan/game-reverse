package com.bytedance.pangle.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.ny;
import com.bytedance.pangle.util.zb;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PluginManager {
    private static final String TAG = "PluginManager";
    private static volatile PluginManager sInstance;
    private volatile boolean hasInstallFromDownloadDir;
    private volatile boolean mIsParsePluginConfig;
    private volatile Map<String, Plugin> mPlugins = new ConcurrentHashMap();
    private final d pluginLoader = new d();

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
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "start load plugin:".concat(String.valueOf(str)));
        return this.pluginLoader.ms(str);
    }

    public Plugin getPlugin(String str, boolean z) {
        if (!Zeus.hasInit() && com.bytedance.pangle.util.xr.ms()) {
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
        }
        return plugin;
    }

    public Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    private synchronized void parsePluginConfig() {
        Plugin plugin;
        Plugin plugin2;
        try {
            if (this.mIsParsePluginConfig) {
                return;
            }
            ZeusLogger.v(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson");
            ArrayList<String> arrayList = new ArrayList();
            try {
                Bundle bundle = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 128).applicationInfo.metaData;
                try {
                    for (String str : bundle.keySet()) {
                        if (ny.ka.startsWith("PANGLE_")) {
                            if (str.startsWith(ny.ka) || str.startsWith("ZEUS_PLUGIN_")) {
                                arrayList.add(bundle.getString(str));
                            }
                        } else if (str.startsWith(ny.ka)) {
                            arrayList.add(bundle.getString(str));
                        }
                    }
                    try {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (String str2 : arrayList) {
                            try {
                                JSONObject jSONObject = new JSONObject(str2);
                                if (jSONObject.has("isDexPlugin") && jSONObject.optInt("isDexPlugin") == 1) {
                                    plugin2 = new ms(jSONObject);
                                } else {
                                    plugin2 = new Plugin(jSONObject);
                                }
                                concurrentHashMap.put(plugin2.mPkgName, plugin2);
                                ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson. find " + plugin2.mPkgName);
                            } catch (JSONException e) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed. " + str2.trim(), e);
                            }
                        }
                        Map<String, JSONObject> mapKa = ch.ms().ka();
                        if (mapKa != null && mapKa.size() > 0) {
                            for (Map.Entry<String, JSONObject> entry : mapKa.entrySet()) {
                                String key = entry.getKey();
                                JSONObject value = entry.getValue();
                                if (!TextUtils.isEmpty(key) && value != null) {
                                    if (value.has("isDexPlugin") && value.optInt("isDexPlugin") == 1) {
                                        plugin = new ms(value);
                                    } else {
                                        plugin = new Plugin(value);
                                    }
                                    concurrentHashMap.put(plugin.mPkgName, plugin);
                                    ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager getPluginsJson. find " + plugin.mPkgName);
                                }
                            }
                        }
                        this.mPlugins = concurrentHashMap;
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson success");
                    } catch (Exception e2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e2);
                    }
                    this.mIsParsePluginConfig = true;
                } catch (Exception e3) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager iterator metaData failed.", e3);
                }
            } catch (Exception e4) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "PluginManager parsePluginsJson failed.", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean checkPluginInstalled(String str) {
        Plugin plugin = getPlugin(str);
        ensurePluginFileExist(plugin);
        boolean z = plugin != null && plugin.isInstalled();
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager checkPluginInstalled, " + str + " = " + z);
        return z;
    }

    private void ensurePluginFileExist(Plugin plugin) {
        if (plugin == null || !plugin.isInstalled() || new File(com.bytedance.pangle.ka.ah.xr(plugin.mPkgName, plugin.getVersion())).exists()) {
            return;
        }
        unInstallPackage(plugin.mPkgName);
    }

    public boolean isLoaded(String str) {
        Plugin plugin = getPlugin(str);
        return plugin != null && plugin.isLoaded();
    }

    public void unInstallPackage(String str) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager unInstallPackage, ".concat(String.valueOf(str)));
        if (getPlugin(str) != null) {
            zb.ms().ab(str);
        }
    }

    public void setAllowDownloadPlugin(String str, int i, boolean z) {
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager setAllowDownloadPlugin, " + str + " " + i + " " + z);
        if (getPlugin(str) != null) {
            zb.ms().ms(str, i, !z);
        }
    }

    public void tryOfflineInternalPlugin(String str, int i) {
        Plugin plugin = getPlugin(str);
        if (plugin == null || plugin.getInternalVersionCode() != i) {
            return;
        }
        ZeusLogger.d(ZeusLogger.TAG_PPM, "PluginManager offlineInternalPlugin, pkgName:" + str + " pluginVer:" + i + " apiVer:" + plugin.getApiVersionCode());
        zb.ms().ka(str, plugin.getApiVersionCode());
    }

    public boolean syncInstall(String str, File file) {
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginManager syncInstall, file=".concat(String.valueOf(file)));
        return new xr(str, file).ms();
    }

    public void asyncInstall(String str, File file) {
        if (file != null) {
            com.bytedance.pangle.ka.ka.xr(new xr(str, file));
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
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
            com.bytedance.pangle.ka.ka.xr(new ka());
        }
        this.hasInstallFromDownloadDir = true;
    }
}
