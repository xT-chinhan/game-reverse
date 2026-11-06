package com.bytedance.pangle.plugin;

import android.text.TextUtils;
import com.anythink.dlopt.common.a.a;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ab;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
class ka implements Runnable {
    ka() {
    }

    @Override // java.lang.Runnable
    public void run() {
        ms(new File(com.bytedance.pangle.ka.ah.xr()));
        String strD = com.bytedance.pangle.ka.ah.d();
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        ms(new File(strD));
    }

    private void ms(File file) {
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusScanRunnable listPluginDownloadDir, dir = ".concat(String.valueOf(file)));
        file.listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.ka.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                if (file2 == null) {
                    return false;
                }
                if (file2.getName().endsWith(a.h) || ab.xr(file2) || file2.getName().endsWith(".7z.zip") || file2.getName().endsWith(".jar") || file2.getName().endsWith(".dex.zip")) {
                    PluginManager.getInstance().asyncInstall(null, file2);
                    return true;
                }
                if ((file2.getAbsolutePath().endsWith(a.f) || file2.getAbsolutePath().endsWith(".tp")) && System.currentTimeMillis() - file2.lastModified() < 259200000) {
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir find : ".concat(String.valueOf(file2)));
                } else {
                    ab.ms(file2);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusScanRunnable installPluginDir deleted : ".concat(String.valueOf(file2)));
                }
                return false;
            }
        });
    }
}
