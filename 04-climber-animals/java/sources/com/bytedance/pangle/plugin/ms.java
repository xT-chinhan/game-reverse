package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.zb;
import com.bytedance.sdk.openadsdk.api.ab;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends Plugin {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.pangle.ah.ms f666ms;

    public ms(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void ms(com.bytedance.pangle.ah.ms msVar) {
        this.f666ms = msVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.bytedance.pangle.ah.ms msVar = this.f666ms;
        if (msVar == null) {
            return null;
        }
        return msVar.c();
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public String toString() {
        return "DexPlugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0052 A[Catch: Exception -> 0x005a, all -> 0x00d8, TRY_LEAVE, TryCatch #0 {Exception -> 0x005a, blocks: (B:20:0x0044, B:22:0x0047, B:23:0x0052), top: B:52:0x0044, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x0088 A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0019, B:15:0x002c, B:16:0x002e, B:18:0x0035, B:20:0x0044, B:22:0x0047, B:29:0x0070, B:31:0x0073, B:33:0x0079, B:35:0x007d, B:40:0x0088, B:42:0x008d, B:23:0x0052, B:26:0x005b, B:43:0x00cd, B:45:0x00d4, B:46:0x00d6, B:44:0x00d1), top: B:54:0x0008, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x008c  */
    @Override // com.bytedance.pangle.plugin.Plugin
    void init() {
        boolean z;
        com.bytedance.pangle.ah.ms msVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strHi = zb.ms().hi(this.mPkgName);
                if (TextUtils.isEmpty(strHi)) {
                    strHi = this.mPkgName;
                }
                int iMs = com.bytedance.pangle.ah.xr.ms(strHi);
                if (iMs != -1) {
                    File[] fileArrHi = com.bytedance.pangle.ka.ah.hi(strHi, iMs);
                    File file = new File(com.bytedance.pangle.ka.ah.sl(strHi, iMs));
                    if (fileArrHi != null) {
                        try {
                            if (fileArrHi.length > 0) {
                                this.f666ms = com.bytedance.pangle.ah.xr.ms(file, (List<File>) Arrays.asList(fileArrHi));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            ab.ms(e);
                        }
                        if (fileArrHi == null && fileArrHi.length > 0 && file.isFile() && (msVar = this.f666ms) != null && msVar.ms()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iMs);
                        } else {
                            iMs = 0;
                        }
                        ms(iMs);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        zb.ms().ms(this.mPkgName);
                        zb.ms().d(this.mPkgName);
                        zb.ms().ms(this.mPkgName, com.bytedance.pangle.util.xr.ms(Zeus.getAppApplication()));
                        zb.ms().ms(this.mPkgName, this.mApiVersionCode);
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (fileArrHi == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iMs);
                        } else {
                            iMs = 0;
                        }
                        ms(iMs);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        zb.ms().ms(this.mPkgName);
                        zb.ms().d(this.mPkgName);
                        zb.ms().ms(this.mPkgName, com.bytedance.pangle.util.xr.ms(Zeus.getAppApplication()));
                        zb.ms().ms(this.mPkgName, this.mApiVersionCode);
                    }
                }
                ms();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    boolean install(File file, com.bytedance.pangle.ab.ms.ka kaVar) {
        boolean zMs = false;
        if (kaVar != null) {
            try {
                if (kaVar.ah != null) {
                    com.bytedance.pangle.ah.ms msVar = kaVar.ah;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + msVar);
                    String strXr = msVar.xr();
                    int iAh = msVar.ah();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strXr + " plugin=" + this);
                        boolean zMs2 = msVar.ms();
                        if (zMs2 && (zMs = com.bytedance.pangle.ah.xr.ms(msVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strXr + " version=" + iAh);
                        }
                        synchronized (this) {
                            try {
                                if (zMs2) {
                                    if (this.mLifeCycle == 3) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strXr + ":" + this.mVersionCode);
                                    } else if (zMs) {
                                        updateToInstalled(iAh);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strXr + ":" + iAh);
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strXr + ":" + iAh);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strXr + ":" + iAh);
                                }
                                com.bytedance.pangle.util.ab.ms(file);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strXr + " version=" + iAh + " apkFile=" + file);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "DexPlugin DEX ZIP IMPOSSIBLE!!!", th2);
            }
        }
        return zMs;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    protected void deleteIfNeeded() {
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication()) && zb.ms().ny(this.mPkgName)) {
            zb.ms().x(this.mPkgName);
            String strMs = com.bytedance.pangle.ka.ah.ms(this.mPkgName);
            com.bytedance.pangle.util.ab.ms(strMs);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strMs);
            xr();
            ah();
        }
    }

    private void xr() {
        List<String> listZb = zb.ms().zb(this.mPkgName);
        if (listZb == null || listZb.size() <= 0) {
            return;
        }
        for (String str : listZb) {
            if (!TextUtils.isEmpty(str)) {
                int iMs = com.bytedance.pangle.ah.xr.ms(str);
                if (iMs != -1) {
                    zb.ms().xr(str, iMs, false);
                }
                com.bytedance.pangle.util.ab.ms(com.bytedance.pangle.ka.ah.ms(str));
            }
        }
        zb.ms().u(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listZb)));
    }

    private void ah() {
        String strHi = zb.ms().hi(this.mPkgName);
        if (TextUtils.isEmpty(strHi)) {
            return;
        }
        String strMs = com.bytedance.pangle.ka.ah.ms(strHi);
        com.bytedance.pangle.util.ab.ms(strMs);
        zb.ms().sl(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strMs)));
    }

    private void ms(int i) {
        if (com.bytedance.pangle.ka.d.xr(Zeus.getAppApplication())) {
            xr();
            String strHi = zb.ms().hi(this.mPkgName);
            if (!TextUtils.isEmpty(strHi)) {
                com.bytedance.pangle.ah.xr.ms(strHi, i);
            } else {
                com.bytedance.pangle.ah.xr.ms(this.mPkgName, i);
            }
        }
    }

    public void ms() {
        String strMs = com.bytedance.pangle.ka.ah.ms(this.mPkgName);
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        File[] fileArrListFiles = new File(strMs).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strMs);
            com.bytedance.pangle.util.ab.ms(strMs);
        }
    }
}
