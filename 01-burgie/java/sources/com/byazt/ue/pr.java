package com.byazt.ue;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.dea.uc;
import com.byazt.gs.fw;
import com.byazt.gs.m;
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
@com.byazt.vzx.pr(pr = {0, 1, 594, 37})
public class pr extends Plugin {
    public com.byazt.sjd.pr pr;

    public pr(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public void pr(com.byazt.sjd.pr prVar) {
        this.pr = prVar;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public JSONObject getJsonConfig() {
        com.byazt.sjd.pr prVar = this.pr;
        if (prVar == null) {
            return null;
        }
        return prVar.uc();
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
        com.byazt.sjd.pr prVar;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.byazt.wo.x.hw(Zeus.getAppApplication())) {
                deleteIfNeeded();
                String strW = m.pr().w(this.mPkgName);
                if (TextUtils.isEmpty(strW)) {
                    strW = this.mPkgName;
                }
                int iPr = com.byazt.sjd.hw.pr(strW);
                if (iPr != -1) {
                    File[] fileArrVk = com.byazt.wo.hn.vk(strW, iPr);
                    File file = new File(com.byazt.wo.hn.w(strW, iPr));
                    if (fileArrVk == null) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                        if (fileArrVk == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iPr);
                        } else {
                            iPr = 0;
                        }
                        pr(iPr);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        m.pr().pr(this.mPkgName);
                        m.pr().x(this.mPkgName);
                        m.pr().pr(this.mPkgName, com.byazt.gs.hw.pr(Zeus.getAppApplication()));
                        m.pr().pr(this.mPkgName, this.mApiVersionCode);
                    } else {
                        try {
                            if (fileArrVk.length > 0) {
                                this.pr = com.byazt.sjd.hw.pr(file, (List<File>) Arrays.asList(fileArrVk));
                            } else {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins unDexZip fail throw exception");
                            }
                        } catch (Exception e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin initDexPlugins fail throw exception ".concat(String.valueOf(e)));
                            uc.pr(e);
                        }
                        if (fileArrVk == null && fileArrVk.length > 0 && file.isFile() && (prVar = this.pr) != null && prVar.pr()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            updateToInstalled(iPr);
                        } else {
                            iPr = 0;
                        }
                        pr(iPr);
                        ZeusLogger.i(ZeusLogger.TAG_INIT, "DexPlugin initDexPlugins result=".concat(String.valueOf(this)));
                        m.pr().pr(this.mPkgName);
                        m.pr().x(this.mPkgName);
                        m.pr().pr(this.mPkgName, com.byazt.gs.hw.pr(Zeus.getAppApplication()));
                        m.pr().pr(this.mPkgName, this.mApiVersionCode);
                    }
                }
                pr();
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
        }
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public boolean install(File file, com.byazt.cc.c cVar) {
        boolean zPr = false;
        if (cVar != null) {
            try {
                if (cVar.hn != null) {
                    com.byazt.sjd.pr prVar = cVar.hn;
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin thread name=" + Thread.currentThread().getName() + " install dex from config " + prVar);
                    String strHw = prVar.hw();
                    int iHn = prVar.hn();
                    synchronized (this.installLock) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin synchronized begin, packageName=" + strHw + " plugin=" + this);
                        boolean zPr2 = prVar.pr();
                        if (zPr2 && (zPr = com.byazt.sjd.hw.pr(prVar, SystemClock.elapsedRealtime()))) {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin markPluginInstalled, packageName=" + strHw + " version=" + iHn);
                        }
                        synchronized (this) {
                            try {
                                if (zPr2) {
                                    if (this.mLifeCycle != 3) {
                                        if (zPr) {
                                            updateToInstalled(iHn);
                                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALLED_SUCCESS " + strHw + ":" + iHn);
                                        } else {
                                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex INSTALL_FAILED " + strHw + ":" + iHn);
                                        }
                                    } else {
                                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex LIFE_LOADED " + strHw + ":" + this.mVersionCode);
                                    }
                                } else {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPlugin Dex invalid " + strHw + ":" + iHn);
                                }
                                fw.pr(file);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPlugin Dex deleting unDexZip pkgName=" + strHw + " version=" + iHn + " apkFile=" + file);
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
        return zPr;
    }

    @Override // com.bytedance.pangle.plugin.Plugin
    public void deleteIfNeeded() {
        if (com.byazt.wo.x.hw(Zeus.getAppApplication()) && m.pr().aj(this.mPkgName)) {
            m.pr().zo(this.mPkgName);
            String strPr = com.byazt.wo.hn.pr(this.mPkgName);
            fw.pr(strPr);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteIfNeeded " + this.mPkgName + " dir=" + strPr);
            hw();
            hn();
        }
    }

    private void hw() {
        List<String> listM = m.pr().m(this.mPkgName);
        if (listM != null && listM.size() > 0) {
            for (String str : listM) {
                if (!TextUtils.isEmpty(str)) {
                    int iPr = com.byazt.sjd.hw.pr(str);
                    if (iPr != -1) {
                        m.pr().pr(str, iPr, false);
                    }
                    fw.pr(com.byazt.wo.hn.pr(str));
                }
            }
            m.pr().g(this.mPkgName);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteAliasLastTimePackageName list=".concat(String.valueOf(listM)));
        }
    }

    private void hn() {
        String strW = m.pr().w(this.mPkgName);
        if (!TextUtils.isEmpty(strW)) {
            String strPr = com.byazt.wo.hn.pr(strW);
            fw.pr(strPr);
            m.pr().k(this.mPkgName);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "DexPlugin deleteA_PackageName dir=".concat(String.valueOf(strPr)));
        }
    }

    private void pr(int i) {
        if (com.byazt.wo.x.hw(Zeus.getAppApplication())) {
            hw();
            String strW = m.pr().w(this.mPkgName);
            if (!TextUtils.isEmpty(strW)) {
                com.byazt.sjd.hw.pr(strW, i);
            } else {
                com.byazt.sjd.hw.pr(this.mPkgName, i);
            }
        }
    }

    public void pr() {
        String strPr = com.byazt.wo.hn.pr(this.mPkgName);
        if (!TextUtils.isEmpty(strPr)) {
            File[] fileArrListFiles = new File(strPr).listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "DexPlugin clear install file, packageName=" + this.mPkgName + " no children files,need delete dir=" + strPr);
                fw.pr(strPr);
            }
        }
    }
}
