package com.bytedance.pangle.plugin;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import com.byazt.ae.aj;
import com.byazt.dea.uc;
import com.byazt.gs.fw;
import com.byazt.gs.hw;
import com.byazt.gs.k;
import com.byazt.gs.m;
import com.byazt.wo.c;
import com.byazt.wo.hn;
import com.byazt.wo.x;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
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
    public static final String TAG = "Plugin";
    public volatile Function mApiBridge;
    public int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    public volatile boolean mInitialized;
    public String mInternalPath;
    public int mInternalVersionCode;
    public boolean mIsDexPlugin;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    public String mPackageDir;
    public String mPkgName;
    public volatile Function mPluginBridge;
    public final boolean mReInstallInternalPluginByMd5;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    public final boolean mUseMemoryForActivityIntent;
    public int mVersionCode;
    public String response;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    public volatile int mLifeCycle = 1;
    public final List<String> mSharedHostSos = new ArrayList();
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();
    public CopyOnWriteArrayList<pr> mBindServiceTaskList = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<pr> mStartServiceTaskList = new CopyOnWriteArrayList<>();

    public interface pr {
        void pr(int i) throws RemoteException;
    }

    public Plugin(JSONObject jSONObject) throws JSONException {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mIsDexPlugin = false;
        this.mPkgName = jSONObject.getString(BillingClientConstants.PACKAGE_NAME);
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt("apiVersionCode");
        if (jSONObject.has("isDexPlugin")) {
            this.mIsDexPlugin = jSONObject.getInt("isDexPlugin") == 1;
        }
        String signature = GlobalParam.getInstance().getSignature(this.mPkgName);
        this.mSignature = signature;
        if (TextUtils.isEmpty(signature)) {
            this.mSignature = jSONObject.optString("signature", "");
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
        int iPr;
        if (m.pr().c(this.mPkgName, this.mApiVersionCode)) {
            return;
        }
        if (!TextUtils.isEmpty(this.mInternalPath) && this.mInternalVersionCode != -1) {
            return;
        }
        try {
            for (String str : Zeus.getAppApplication().getAssets().list(aj.x)) {
                if (str.startsWith(this.mPkgName + "_") && (iPr = k.pr(str.split("_")[1], -1)) != -1) {
                    this.mInternalPath = aj.x + "/" + str;
                    this.mInternalVersionCode = iPr;
                    return;
                }
            }
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
        }
    }

    public void init() {
        boolean zHn;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (x.hw(Zeus.getAppApplication())) {
                int iModifyResIfNeed = 0;
                if (!m.pr().hw(this.mPkgName)) {
                    zHn = false;
                } else {
                    zHn = m.pr().hn(this.mPkgName);
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, zHn)) {
                    iModifyResIfNeed = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(iModifyResIfNeed);
                }
                deleteOtherExpiredVer(iModifyResIfNeed);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                m.pr().pr(this.mPkgName);
                m.pr().x(this.mPkgName);
                m.pr().pr(this.mPkgName, hw.pr(Zeus.getAppApplication()));
                m.pr().pr(this.mPkgName, this.mApiVersionCode);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    private void installInternalPlugin() {
        if (x.hw(Zeus.getAppApplication())) {
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
            c.pr(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            file = new File(hn.hn(), Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            file = new File(hn.hn(), Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        fw.pr(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            new com.byazt.ue.hw(Plugin.this.mPkgName, file).run();
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
        String strPr = hw.pr(Zeus.getAppApplication());
        if (TextUtils.isEmpty(strPr) || !TextUtils.equals(m.pr().uc(this.mPkgName), strPr)) {
            if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
                return 0;
            }
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
            int iPr = new com.byazt.ph.hn().pr(new File(hn.hw(this.mPkgName, i)), true, new StringBuilder());
            if (iPr == 100 || iPr == 200) {
                return i;
            }
            return 0;
        }
        return i;
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
        if (i == 3) {
            runServiceTask(this.mBindServiceTaskList, i);
            runServiceTask(this.mStartServiceTaskList, i);
        }
    }

    private void runServiceTask(List<pr> list, int i) {
        if (list != null && !list.isEmpty()) {
            try {
                for (pr prVar : list) {
                    if (prVar != null) {
                        prVar.pr(i);
                    }
                }
                list.clear();
            } catch (Exception e) {
                uc.pr(e);
            }
        }
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

    public void updateInstallStateFromMainProcess() {
        com.byazt.ae.hn hnVarPr;
        try {
            if (!x.hw(Zeus.getAppApplication()) && this.mLifeCycle < 2 && (hnVarPr = com.byazt.ewn.hw.pr()) != null && hnVarPr.pr(this.mPkgName)) {
                updateToInstalled(hnVarPr.hw(this.mPkgName));
            }
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + x.pr(Zeus.getAppApplication()), th);
        }
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public void updateToInstalled(int i) {
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
        File[] installFiles = getInstallFiles();
        int i = -1;
        if (installFiles != null) {
            for (File file : installFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && m.pr().x(this.mPkgName, i2) && new File(hn.hw(this.mPkgName, i2)).exists()) {
                    i = i2;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    public boolean unInstall(int i) {
        if (i == this.mVersionCode) {
            m.pr().fw(this.mPkgName);
            return true;
        }
        File[] installFiles = getInstallFiles();
        if (installFiles != null) {
            for (File file : installFiles) {
                if (Integer.parseInt(file.getName().split("-")[1]) == i) {
                    m.pr().pr(this.mPkgName, i, false);
                    fw.pr(file);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        boolean z2;
        int iC = m.pr().c(this.mPkgName);
        boolean z3 = false;
        if (iC > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(iC), Integer.valueOf(i2)))));
            return false;
        }
        if (i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && i2 != -1) {
            int iHw = m.pr().hw(this.mPkgName, i);
            int iHn = m.pr().hn(this.mPkgName, i);
            if (i2 < iHw || i2 > iHn) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(iHw), Integer.valueOf(iHn)))));
                z2 = false;
            }
        }
        if (z2 && z && com.byazt.wo.hw.hw(new File(hn.hw(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
        } else {
            z3 = z2;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z3);
        return z3;
    }

    public void deleteIfNeeded() {
        if (x.hw(Zeus.getAppApplication()) && m.pr().aj(this.mPkgName)) {
            m.pr().zo(this.mPkgName);
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = hn.pr(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    m.pr().pr(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        fw.pr(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (x.hw(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = hn.pr(this.mPkgName);
            }
            final String strConcat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !strConcat.equals(file.getName()) && !"data".equals(file.getName())) {
                        fw.pr(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            m.pr().pr(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        m.pr().pr(this.mPkgName, i, i2, i3);
    }

    public boolean isVersionInstalled(int i) {
        return m.pr().x(this.mPkgName, i);
    }

    public boolean install(File file, com.byazt.cc.c cVar) {
        boolean zPr = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = cVar.pr;
            int i = cVar.hw;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean zCheckValid = checkValid(file, str, i);
                if (zCheckValid) {
                    String str2 = com.byazt.gs.hn.pr(file)[0];
                    zPr = com.byazt.ue.hn.pr(file, str, i);
                    if (zPr) {
                        m.pr().hw(this.mPkgName, str2);
                        m.pr().pr(this.mPkgName, i, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                        fw.pr(file);
                    }
                }
                synchronized (this) {
                    try {
                        if (zCheckValid) {
                            if (this.mLifeCycle != 3) {
                                if (zPr) {
                                    updateToInstalled(i);
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                                } else {
                                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                    fw.pr(file);
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                                }
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                            }
                        } else {
                            fw.pr(file);
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
        return zPr;
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
        if (i == this.mVersionCode && m.pr().vk(str).equals(com.byazt.gs.hn.pr(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
        return true;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        if (i > 0) {
            return hn.x(this.mPkgName, i);
        }
        return hn.pr(this.mPkgName);
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public String getInternalPath() {
        return this.mInternalPath;
    }

    public JSONObject getJsonConfig() {
        return null;
    }

    public Function getApiBridge() {
        return this.mApiBridge;
    }

    public void setApiBridge(Function function) {
        this.mApiBridge = function;
    }

    public Function getPluginBridge() {
        return this.mPluginBridge;
    }

    public void setPluginBridge(Function function) {
        this.mPluginBridge = function;
    }

    public List<Integer> getInstalledVersionCodes() {
        File[] installFiles = getInstallFiles();
        ArrayList arrayList = new ArrayList();
        if (installFiles != null) {
            for (File file : installFiles) {
                int i = Integer.parseInt(file.getName().split("-")[1]);
                if (m.pr().x(this.mPkgName, i)) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    private File[] getInstallFiles() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = hn.pr(this.mPkgName);
        }
        return new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + AbstractJsonLexerKt.END_OBJ;
    }

    public void addBindServicePluginPendingTask(pr prVar) {
        this.mBindServiceTaskList.add(prVar);
    }

    public void addStartServicePluginPendingTask(pr prVar) {
        this.mStartServiceTaskList.add(prVar);
    }

    public Object getInitializeLock() {
        return this.initializeLock;
    }
}
