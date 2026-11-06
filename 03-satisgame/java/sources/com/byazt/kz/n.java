package com.byazt.kz;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gx.oa;
import com.byazt.gx.x;
import com.byazt.vx.w;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1356, 19})
public class n extends Plugin {
    public com.byazt.kc.n n;

    public n(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void n(com.byazt.kc.n nVar) {
        this.n = nVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.byazt.kc.n nVar = this.n;
        if (nVar == null) {
            return null;
        }
        return nVar.w();
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
    public void init() {
        boolean z;
        com.byazt.kc.n nVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.byazt.zi.q.qg(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strCp = oa.n().cp(this.mPkgName);
                if (TextUtils.isEmpty(strCp)) {
                    strCp = this.mPkgName;
                }
                int iN = com.byazt.kc.qg.n(strCp);
                if (iN != -1) {
                    File[] fileArrTj = com.byazt.zi.s.tj(strCp, iN);
                    File file = new File(com.byazt.zi.s.cp(strCp, iN));
                    if (fileArrTj != null) {
                        try {
                            if (fileArrTj.length > 0) {
                                this.n = com.byazt.kc.qg.n(file, (List<File>) Arrays.asList(fileArrTj));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            w.n(e);
                        }
                        if (fileArrTj == null && fileArrTj.length > 0 && file.isFile() && (nVar = this.n) != null && nVar.n()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iN);
                        } else {
                            iN = 0;
                        }
                        n(iN);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        oa.n().n(this.mPkgName);
                        oa.n().q(this.mPkgName);
                        oa.n().n(this.mPkgName, com.byazt.gx.qg.n(Zeus.getAppApplication()));
                        oa.n().n(this.mPkgName, this.mApiVersionCode);
                    } else {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (fileArrTj == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iN);
                        } else {
                            iN = 0;
                        }
                        n(iN);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        oa.n().n(this.mPkgName);
                        oa.n().q(this.mPkgName);
                        oa.n().n(this.mPkgName, com.byazt.gx.qg.n(Zeus.getAppApplication()));
                        oa.n().n(this.mPkgName, this.mApiVersionCode);
                    }
                }
                n();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.byazt.ezh.l lVar) {
        boolean zN = false;
        if (lVar != null) {
            try {
                if (lVar.s != null) {
                    com.byazt.kc.n nVar = lVar.s;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + nVar);
                    String strQg = nVar.qg();
                    int iS = nVar.s();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strQg + " plugin=" + this);
                        boolean zN2 = nVar.n();
                        if (zN2 && (zN = com.byazt.kc.qg.n(nVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strQg + " version=" + iS);
                        }
                        synchronized (this) {
                            try {
                                if (zN2) {
                                    if (this.mLifeCycle == 3) {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strQg + ":" + this.mVersionCode);
                                    } else if (zN) {
                                        updateToInstalled(iS);
                                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strQg + ":" + iS);
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strQg + ":" + iS);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strQg + ":" + iS);
                                }
                                x.n(file);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strQg + " version=" + iS + " apkFile=" + file);
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
        return zN;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.byazt.zi.q.qg(Zeus.getAppApplication()) && oa.n().rv(this.mPkgName)) {
            oa.n().fs(this.mPkgName);
            String strN = com.byazt.zi.s.n(this.mPkgName);
            x.n(strN);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strN);
            qg();
            s();
        }
    }

    private void qg() {
        List<String> listOa = oa.n().oa(this.mPkgName);
        if (listOa == null || listOa.size() <= 0) {
            return;
        }
        for (String str : listOa) {
            if (!TextUtils.isEmpty(str)) {
                int iN = com.byazt.kc.qg.n(str);
                if (iN != -1) {
                    oa.n().n(str, iN, false);
                }
                x.n(com.byazt.zi.s.n(str));
            }
        }
        oa.n().sz(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listOa)));
    }

    private void s() {
        String strCp = oa.n().cp(this.mPkgName);
        if (TextUtils.isEmpty(strCp)) {
            return;
        }
        String strN = com.byazt.zi.s.n(strCp);
        x.n(strN);
        oa.n().d(this.mPkgName);
        ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strN)));
    }

    private void n(int i) {
        if (com.byazt.zi.q.qg(Zeus.getAppApplication())) {
            qg();
            String strCp = oa.n().cp(this.mPkgName);
            if (!TextUtils.isEmpty(strCp)) {
                com.byazt.kc.qg.n(strCp, i);
            } else {
                com.byazt.kc.qg.n(this.mPkgName, i);
            }
        }
    }

    public void n() {
        String strN = com.byazt.zi.s.n(this.mPkgName);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        File[] fileArrListFiles = new File(strN).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strN);
            x.n(strN);
        }
    }
}
