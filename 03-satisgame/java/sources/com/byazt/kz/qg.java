package com.byazt.kz;

import android.os.SystemClock;
import com.byazt.gx.x;
import com.byazt.vx.w;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1356, 26})
public class qg implements Runnable {
    public File n;
    public final String qg;

    public qg(String str, File file) {
        this.n = file;
        this.qg = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        n();
    }

    private void qg() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.n.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                File file2 = this.n;
                x.qg(file2.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file3 = this.n;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file3 = fileArrListFiles[0];
                }
                File fileN = n(file3);
                if (fileN != null && fileN.exists() && fileN.isFile()) {
                    file2.delete();
                    this.n = fileN;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                w.n(e);
            }
        }
    }

    private File n(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private static void n(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.is.s.n(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.is.s.n(str2));
            jSONObject.putOpt("version_code", com.byazt.is.s.n(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.byazt.is.s.qg(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.is.s.n(str3));
        } catch (JSONException e) {
            w.n(e);
        }
        com.byazt.fw.qg.n().n(str, jSONObject, jSONObject3, jSONObject2);
    }

    private com.byazt.ezh.l s() {
        com.byazt.kc.n nVarN;
        if (this.n == null) {
            return null;
        }
        try {
            File file = new File(this.n.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                x.n(file);
                file.mkdirs();
            }
            x.qg(this.n.getAbsolutePath(), file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            x.n(this.n);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.n);
            this.n = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (nVarN = com.byazt.kc.qg.n(file2, linkedList)) != null) {
                return new com.byazt.ezh.l(nVarN);
            }
        } catch (Exception e) {
            w.n(e);
        }
        return null;
    }

    public boolean n() {
        com.byazt.ezh.l lVarN;
        File file = this.n;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            lVarN = s();
            if (lVarN != null) {
                n(com.byazt.fw.qg.x, com.byazt.fw.qg.n.um, this.qg, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (x.qg(this.n)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                qg();
                n(com.byazt.fw.qg.x, com.byazt.fw.qg.n.j, this.qg, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            lVarN = com.byazt.ezh.q.n(this.n);
        }
        if (lVarN == null) {
            ZeusPluginStateListener.postStateChange(this.qg, 7, " read local file package info failed !!! pluginPkg = " + this.qg + " mApkFile.exists = " + this.n.exists());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!! pluginPkg = " + this.qg);
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(lVarN.n);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.qg, 7, " plugin == null !!! pluginPkg = " + this.qg);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + lVarN.n);
            return false;
        }
        boolean zInstall = plugin.install(this.n, lVarN);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(lVarN.n, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(lVarN.n, 7, "Internal error.");
        }
        return zInstall;
    }
}
