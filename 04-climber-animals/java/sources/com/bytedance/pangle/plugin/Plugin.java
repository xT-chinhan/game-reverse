package com.bytedance.pangle.plugin;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.ny;
import com.bytedance.pangle.util.ab;
import com.bytedance.pangle.util.sl;
import com.bytedance.pangle.util.zb;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.umeng.ccg.a;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_LOADING = 4;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    protected int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    protected volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsDexPlugin;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    protected int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    protected volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    final Object installLock = new Object();
    final Object initializeLock = new Object();

    public JSONObject getJsonConfig() {
        return null;
    }

    public Plugin(JSONObject jSONObject) throws JSONException {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mIsDexPlugin = false;
        this.mPkgName = jSONObject.getString("packageName");
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        if (jSONObject.has("isDexPlugin")) {
            this.mIsDexPlugin = jSONObject.getInt("isDexPlugin") == 1;
        }
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString(a.A, "");
        }
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString("appKey", "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        this.mUseMemoryForActivityIntent = jSONObject.optBoolean("useMemoryForActivityIntent", false);
        this.mReInstallInternalPluginByMd5 = jSONObject.optBoolean("reInstallInternalPluginByMd5", false);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sharedHostSo");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.mSharedHostSos.add((String) jSONArrayOptJSONArray.get(i));
            }
        }
        setupInternalPlugin();
    }

    public boolean isIsDexPlugin() {
        return this.mIsDexPlugin;
    }

    private void setupInternalPlugin() {
        int iMs;
        if (zb.ms().c(this.mPkgName, this.mApiVersionCode)) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(ny.d)) {
                    if (str.startsWith(this.mPkgName + "_") && (iMs = sl.ms(str.split("_")[1], -1)) != -1) {
                        this.mInternalPath = ny.d + "/" + str;
                        this.mInternalVersionCode = iMs;
                        return;
                    }
                }
            } catch (IOException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    void init() {
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
                int iModifyResIfNeed = 0;
                boolean zAh = zb.ms().xr(this.mPkgName) ? zb.ms().ah(this.mPkgName) : false;
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, zAh)) {
                    iModifyResIfNeed = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(iModifyResIfNeed);
                }
                deleteOtherExpiredVer(iModifyResIfNeed);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                zb.ms().ms(this.mPkgName);
                zb.ms().d(this.mPkgName);
                zb.ms().ms(this.mPkgName, com.bytedance.pangle.util.xr.ms(Zeus.getAppApplication()));
                zb.ms().ms(this.mPkgName, this.mApiVersionCode);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    private void installInternalPlugin() {
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
            if (this.mReInstallInternalPluginByMd5) {
                if (getVersion() > this.mInternalVersionCode) {
                    return;
                }
            } else if (getVersion() >= this.mInternalVersionCode) {
                return;
            }
            if (TextUtils.isEmpty(this.mInternalPath)) {
                return;
            }
            com.bytedance.pangle.ka.ka.ms(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            file = new File(com.bytedance.pangle.ka.ah.ah(), Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            file = new File(com.bytedance.pangle.ka.ah.ah(), Plugin.this.mPkgName + com.anythink.dlopt.common.a.a.h);
                        }
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        ab.ms(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            new xr(Plugin.this.mPkgName, file).run();
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                        }
                    } catch (Throwable th) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. ", th);
                    }
                }
            });
        }
    }

    private int modifyResIfNeed(int i) {
        String strMs = com.bytedance.pangle.util.xr.ms(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(strMs) && TextUtils.equals(zb.ms().c(this.mPkgName), strMs)) {
            return i;
        }
        if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
            return 0;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
        int iMs = new com.bytedance.pangle.res.ms.ah().ms(new File(com.bytedance.pangle.ka.ah.xr(this.mPkgName, i)), true, new StringBuilder());
        if (iMs == 100 || iMs == 200) {
            return i;
        }
        return 0;
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    protected void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.ah ahVarMs;
        try {
            if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (ahVarMs = com.bytedance.pangle.servermanager.xr.ms()) == null || !ahVarMs.ms(this.mPkgName)) {
                return;
            }
            updateToInstalled(ahVarMs.xr(this.mPkgName));
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + com.bytedance.pangle.ka.d.ms(Zeus.getAppApplication()), th);
        }
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    protected void updateToInstalled(int i) {
        this.mVersionCode = i;
        this.mLifeCycle = 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isLoading() {
        return this.mLifeCycle == 4;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.ka.ah.ms(this.mPkgName);
        }
        File[] fileArrListFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i = -1;
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && zb.ms().d(this.mPkgName, i2) && new File(com.bytedance.pangle.ka.ah.xr(this.mPkgName, i2)).exists()) {
                    i = i2;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        int iKa = zb.ms().ka(this.mPkgName);
        boolean z2 = false;
        if (iKa > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(iKa), Integer.valueOf(i2)))));
            return false;
        }
        boolean z3 = i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode;
        if (z3 && i2 != -1) {
            int iXr = zb.ms().xr(this.mPkgName, i);
            int iAh = zb.ms().ah(this.mPkgName, i);
            if (i2 < iXr || i2 > iAh) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(iXr), Integer.valueOf(iAh)))));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.ka.xr.xr(new File(com.bytedance.pangle.ka.ah.xr(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication()) && zb.ms().ny(this.mPkgName)) {
            zb.ms().x(this.mPkgName);
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.ka.ah.ms(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    zb.ms().xr(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        ab.ms(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.ka.ah.ms(this.mPkgName);
            }
            final String strConcat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !strConcat.equals(file.getName()) && !"data".equals(file.getName())) {
                        ab.ms(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            zb.ms().xr(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        zb.ms().ms(this.mPkgName, i, i2, i3);
    }

    public boolean isVersionInstalled(int i) {
        return zb.ms().d(this.mPkgName, i);
    }

    boolean install(File file, com.bytedance.pangle.ab.ms.ka kaVar) {
        boolean zMs = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = kaVar.f613ms;
            int i = kaVar.xr;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean zCheckValid = checkValid(file, str, i);
                if (zCheckValid) {
                    String str2 = com.bytedance.pangle.util.ah.ms(file)[0];
                    zMs = ah.ms(file, str, i);
                    if (zMs) {
                        zb.ms().xr(this.mPkgName, str2);
                        zb.ms().xr(this.mPkgName, i, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                        ab.ms(file);
                    }
                }
                synchronized (this) {
                    try {
                        if (zCheckValid) {
                            if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                            } else if (zMs) {
                                updateToInstalled(i);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                            } else {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                ab.ms(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                            }
                        } else {
                            ab.ms(file);
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin deleting invalid " + str + ":" + i);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th2);
        }
        return zMs;
    }

    private boolean checkValid(File file, String str, int i) {
        if (!TextUtils.equals(this.mPkgName, str)) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " package name not match !!!");
            return false;
        }
        if (i < this.mMinVersionCode || i > this.mMaxVersionCode) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " " + String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode)));
            return false;
        }
        if (i < this.mVersionCode && isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i), Integer.valueOf(this.mVersionCode)));
            return false;
        }
        if (file == null || !file.exists()) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk not exist.");
            return false;
        }
        if (i == this.mVersionCode && zb.ms().ch(str).equals(com.bytedance.pangle.util.ah.ms(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
        return true;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        if (i > 0) {
            return com.bytedance.pangle.ka.ah.d(this.mPkgName, i);
        }
        return com.bytedance.pangle.ka.ah.ms(this.mPkgName);
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + AbstractJsonLexerKt.END_OBJ;
    }
}
