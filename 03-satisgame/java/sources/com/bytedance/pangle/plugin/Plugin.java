package com.bytedance.pangle.plugin;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.gx.d;
import com.byazt.gx.oa;
import com.byazt.gx.qg;
import com.byazt.gx.x;
import com.byazt.ry.rv;
import com.byazt.vx.w;
import com.byazt.zi.l;
import com.byazt.zi.q;
import com.byazt.zi.s;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
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
    public CopyOnWriteArrayList<n> mBindServiceTaskList = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<n> mStartServiceTaskList = new CopyOnWriteArrayList<>();

    public interface n {
        void n(int i) throws RemoteException;
    }

    public JSONObject getJsonConfig() {
        return null;
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
        int iN;
        if (oa.n().l(this.mPkgName, this.mApiVersionCode)) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(rv.q)) {
                    if (str.startsWith(this.mPkgName + "_") && (iN = d.n(str.split("_")[1], -1)) != -1) {
                        this.mInternalPath = rv.q + "/" + str;
                        this.mInternalVersionCode = iN;
                        return;
                    }
                }
            } catch (IOException e) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e);
            }
        }
    }

    public void init() {
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (q.qg(Zeus.getAppApplication())) {
                int iModifyResIfNeed = 0;
                boolean zS = oa.n().qg(this.mPkgName) ? oa.n().s(this.mPkgName) : false;
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, zS)) {
                    iModifyResIfNeed = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(iModifyResIfNeed);
                }
                deleteOtherExpiredVer(iModifyResIfNeed);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                oa.n().n(this.mPkgName);
                oa.n().q(this.mPkgName);
                oa.n().n(this.mPkgName, qg.n(Zeus.getAppApplication()));
                oa.n().n(this.mPkgName, this.mApiVersionCode);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    private void installInternalPlugin() {
        if (q.qg(Zeus.getAppApplication())) {
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
            l.n(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
                @Override // java.lang.Runnable
                public void run() {
                    File file;
                    try {
                        if (Plugin.this.mInternalPath.endsWith(".7z.zip")) {
                            file = new File(s.s(), Plugin.this.mPkgName + ".7z.zip");
                        } else {
                            file = new File(s.s(), Plugin.this.mPkgName + ".apk");
                        }
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                        x.n(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                        if (file.exists()) {
                            new com.byazt.kz.qg(Plugin.this.mPkgName, file).run();
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
        String strN = qg.n(Zeus.getAppApplication());
        if (!TextUtils.isEmpty(strN) && TextUtils.equals(oa.n().w(this.mPkgName), strN)) {
            return i;
        }
        if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
            ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + " " + i);
            return 0;
        }
        ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + " " + i);
        int iN = new com.byazt.ev.s().n(new File(s.qg(this.mPkgName, i)), true, new StringBuilder());
        if (iN == 100 || iN == 200) {
            return i;
        }
        return 0;
    }

    public void setLifeCycle(int i) {
        this.mLifeCycle = i;
        if (i == 3) {
            runServiceTask(this.mBindServiceTaskList, i);
            runServiceTask(this.mStartServiceTaskList, i);
        }
    }

    private void runServiceTask(List<n> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            for (n nVar : list) {
                if (nVar != null) {
                    nVar.n(i);
                }
            }
            list.clear();
        } catch (Exception e) {
            w.n(e);
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
        com.byazt.ry.s sVarN;
        try {
            if (q.qg(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (sVarN = com.byazt.gc.qg.n()) == null || !sVarN.n(this.mPkgName)) {
                return;
            }
            updateToInstalled(sVarN.qg(this.mPkgName));
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG_PPM, "updateInstallStateFromMainProcess error. process = " + q.n(Zeus.getAppApplication()), th);
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
                if (i2 > i && oa.n().q(this.mPkgName, i2) && new File(s.qg(this.mPkgName, i2)).exists()) {
                    i = i2;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i);
        return i;
    }

    public boolean unInstall(int i) {
        if (i == this.mVersionCode) {
            oa.n().x(this.mPkgName);
            return true;
        }
        File[] installFiles = getInstallFiles();
        if (installFiles != null) {
            for (File file : installFiles) {
                if (Integer.parseInt(file.getName().split("-")[1]) == i) {
                    oa.n().n(this.mPkgName, i, false);
                    x.n(file);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkVersionValid(int i, int i2, boolean z) {
        int iL = oa.n().l(this.mPkgName);
        boolean z2 = false;
        if (iL > i2) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(iL), Integer.valueOf(i2)))));
            return false;
        }
        boolean z3 = i >= 0 && i >= this.mMinVersionCode && i <= this.mMaxVersionCode;
        if (z3 && i2 != -1) {
            int iQg = oa.n().qg(this.mPkgName, i);
            int iS = oa.n().s(this.mPkgName, i);
            if (i2 < iQg || i2 > iS) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i2), Integer.valueOf(iQg), Integer.valueOf(iS)))));
                z3 = false;
            }
        }
        if (z3 && z && com.byazt.zi.qg.qg(new File(s.qg(this.mPkgName, i)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    public void deleteIfNeeded() {
        if (q.qg(Zeus.getAppApplication()) && oa.n().rv(this.mPkgName)) {
            oa.n().fs(this.mPkgName);
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = s.n(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    oa.n().n(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                }
                return false;
            }
        });
        x.n(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i) {
        if (q.qg(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = s.n(this.mPkgName);
            }
            final String strConcat = "version-".concat(String.valueOf(i));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !strConcat.equals(file.getName()) && !f.R.equals(file.getName())) {
                        x.n(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            oa.n().n(Plugin.this.mPkgName, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    public void setApiCompatVersion(int i, int i2, int i3) {
        oa.n().n(this.mPkgName, i, i2, i3);
    }

    public boolean isVersionInstalled(int i) {
        return oa.n().q(this.mPkgName, i);
    }

    public boolean install(File file, com.byazt.ezh.l lVar) {
        boolean zN = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str = lVar.n;
            int i = lVar.qg;
            synchronized (this.installLock) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                boolean zCheckValid = checkValid(file, str, i);
                if (zCheckValid) {
                    String str2 = com.byazt.gx.s.n(file)[0];
                    zN = com.byazt.kz.s.n(file, str, i);
                    if (zN) {
                        oa.n().qg(this.mPkgName, str2);
                        oa.n().n(this.mPkgName, i, true);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + ":" + i + " identity=" + str2);
                        x.n(file);
                    }
                }
                synchronized (this) {
                    try {
                        if (zCheckValid) {
                            if (this.mLifeCycle == 3) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin LIFE_LOADED, valid next restart " + str + ":" + i);
                            } else if (zN) {
                                updateToInstalled(i);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str + ":" + i);
                            } else {
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str + ":" + i);
                                x.n(file);
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin delete file by failedCount > 0 " + str + ":" + i);
                            }
                        } else {
                            x.n(file);
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
        return zN;
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
        if (i == this.mVersionCode && oa.n().tj(str).equals(com.byazt.gx.s.n(file)[0])) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + " pluginApk with the same identity has already installed.");
            return false;
        }
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + ":" + i + " true");
        return true;
    }

    public String getNativeLibraryDir() {
        int i = this.mVersionCode;
        if (i > 0) {
            return s.q(this.mPkgName, i);
        }
        return s.n(this.mPkgName);
    }

    public void injectResponse(String str) {
        this.response = str;
    }

    public String getInternalPath() {
        return this.mInternalPath;
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
                if (oa.n().q(this.mPkgName, i)) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList;
    }

    private File[] getInstallFiles() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = s.n(this.mPkgName);
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

    public void addBindServicePluginPendingTask(n nVar) {
        this.mBindServiceTaskList.add(nVar);
    }

    public void addStartServicePluginPendingTask(n nVar) {
        this.mStartServiceTaskList.add(nVar);
    }

    public Object getInitializeLock() {
        return this.initializeLock;
    }
}
