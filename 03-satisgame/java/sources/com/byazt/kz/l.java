package com.byazt.kz;

import android.text.TextUtils;
import com.byazt.gx.x;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1356, 18})
public class l implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        n(new File(com.byazt.zi.s.qg()));
        String strQ = com.byazt.zi.s.q();
        if (TextUtils.isEmpty(strQ)) {
            return;
        }
        n(new File(strQ));
    }

    private void n(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.byazt.kz.l.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (file2.getName().endsWith(".apk") || x.qg(file2) || file2.getName().endsWith(".7z.zip") || file2.getName().endsWith(".jar") || file2.getName().endsWith(".dex.zip")) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                }
                if ((file2.getAbsolutePath().endsWith(".temp") || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                } else {
                    x.n(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                }
                return false;
            }
        });
    }
}
