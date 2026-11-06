package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import com.anythink.dlopt.common.a.a;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ab;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class xr implements Runnable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private File f667ms;
    private final String xr;

    xr(String str, File file) {
        this.f667ms = file;
        this.xr = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ms();
    }

    private void xr() {
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.f667ms.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                ab.xr(this.f667ms.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.f667ms;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                File fileMs = ms(file2);
                if (fileMs != null && fileMs.exists() && fileMs.isFile()) {
                    this.f667ms = fileMs;
                    ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                    return;
                }
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                com.bytedance.sdk.openadsdk.api.ab.ms(e);
            }
        }
    }

    private File ms(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(a.h)) {
                return file2;
            }
        }
        return file;
    }

    private static void ms(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(f.z, com.bytedance.pangle.log.xr.ms(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xr.ms(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xr.ms(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xr.xr(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.xr.ms(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.bytedance.pangle.d.xr.ms().ms(str, jSONObject, jSONObject3, jSONObject2);
    }

    private com.bytedance.pangle.ab.ms.ka ah() {
        com.bytedance.pangle.ah.ms msVarMs;
        if (this.f667ms == null) {
            return null;
        }
        try {
            File file = new File(this.f667ms.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                ab.ms(file);
                file.mkdirs();
            }
            ab.xr(this.f667ms.getAbsolutePath(), file.getAbsolutePath());
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
            ab.ms(this.f667ms);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.f667ms);
            this.f667ms = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (msVarMs = com.bytedance.pangle.ah.xr.ms(file2, linkedList)) != null) {
                return new com.bytedance.pangle.ab.ms.ka(msVarMs);
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        return null;
    }

    boolean ms() {
        com.bytedance.pangle.ab.ms.ka kaVarMs;
        File file = this.f667ms;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            kaVarMs = ah();
            if (kaVarMs != null) {
                ms(com.bytedance.pangle.d.xr.ab, com.bytedance.pangle.d.xr.ms.y, this.xr, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (ab.xr(this.f667ms)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                xr();
                ms(com.bytedance.pangle.d.xr.ab, com.bytedance.pangle.d.xr.ms.pc, this.xr, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            kaVarMs = com.bytedance.pangle.ab.ms.d.ms(this.f667ms);
        }
        if (kaVarMs == null) {
            ZeusPluginStateListener.postStateChange(this.xr, 7, " read local file package info failed !!! pluginPkg = " + this.xr + " mApkFile.exists = " + this.f667ms.exists());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!! pluginPkg = " + this.xr);
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(kaVarMs.f613ms);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.xr, 7, " plugin == null !!! pluginPkg = " + this.xr);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + kaVarMs.f613ms);
            return false;
        }
        boolean zInstall = plugin.install(this.f667ms, kaVarMs);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(kaVarMs.f613ms, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(kaVarMs.f613ms, 7, "Internal error.");
        }
        return zInstall;
    }
}
