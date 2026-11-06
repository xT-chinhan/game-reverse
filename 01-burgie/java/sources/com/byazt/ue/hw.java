package com.byazt.ue;

import android.os.SystemClock;
import com.byazt.dea.uc;
import com.byazt.gs.fw;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 594, 13})
public class hw implements Runnable {
    public final String hw;
    public File pr;

    public hw(String str, File file) {
        this.pr = file;
        this.hw = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        pr();
    }

    private void hw() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.pr.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                fw.hw(this.pr.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.pr;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File filePr = pr(file2);
                if (filePr != null && filePr.exists() && filePr.isFile()) {
                    this.pr = filePr;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                uc.pr(e);
            }
        }
    }

    private File pr(File file) {
        if (!file.exists() && file.getParent() != null) {
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
        return file;
    }

    private static void pr(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.wp.hn.pr(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.wp.hn.pr(str2));
            jSONObject.putOpt("version_code", com.byazt.wp.hn.pr(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.byazt.wp.hn.hw(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.wp.hn.pr(str3));
        } catch (JSONException e) {
            uc.pr(e);
        }
        com.byazt.yk.hw.pr().pr(str, jSONObject, jSONObject3, jSONObject2);
    }

    private com.byazt.cc.c hn() {
        com.byazt.sjd.pr prVarPr;
        if (this.pr == null) {
            return null;
        }
        try {
            File file = new File(this.pr.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                fw.pr(file);
                file.mkdirs();
            }
            fw.hw(this.pr.getAbsolutePath(), file.getAbsolutePath());
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
            fw.pr(this.pr);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.pr);
            this.pr = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (prVarPr = com.byazt.sjd.hw.pr(file2, linkedList)) != null) {
                return new com.byazt.cc.c(prVarPr);
            }
        } catch (Exception e) {
            uc.pr(e);
        }
        return null;
    }

    public boolean pr() {
        com.byazt.cc.c cVarPr;
        File file = this.pr;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            cVarPr = hn();
            if (cVarPr != null) {
                pr(com.byazt.yk.hw.fw, com.byazt.yk.hw.pr.qa, this.hw, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (fw.hw(this.pr)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                hw();
                pr(com.byazt.yk.hw.fw, com.byazt.yk.hw.pr.n, this.hw, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            cVarPr = com.byazt.cc.x.pr(this.pr);
        }
        if (cVarPr == null) {
            ZeusPluginStateListener.postStateChange(this.hw, 7, " read local file package info failed !!! pluginPkg = " + this.hw + " mApkFile.exists = " + this.pr.exists());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!! pluginPkg = " + this.hw);
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(cVarPr.pr);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.hw, 7, " plugin == null !!! pluginPkg = " + this.hw);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + cVarPr.pr);
            return false;
        }
        boolean zInstall = plugin.install(this.pr, cVarPr);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(cVarPr.pr, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(cVarPr.pr, 7, "Internal error.");
        }
        return zInstall;
    }
}
