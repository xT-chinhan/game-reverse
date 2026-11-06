package com.byazt.ezh;

import android.content.pm.PackageInfo;
import com.byazt.gc.AbsServerManager;
import com.byazt.gx.x;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 5})
public class q {
    private static String n(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static l n(File file) {
        ZipFile zipFile;
        n nVar;
        PackageInfo packageArchiveInfo;
        int iQg;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                x.n((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    x.n(zipFile2);
                    return null;
                }
                nVar = new n();
                try {
                    nVar.n(zipFile2.getInputStream(entry));
                    do {
                        iQg = nVar.qg();
                        if (iQg == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                nVar.n();
                            } catch (Throwable unused) {
                            }
                            x.n(zipFile2);
                            return null;
                        }
                    } while (iQg != 2);
                    int iS = nVar.s();
                    String strN = null;
                    String strN2 = null;
                    for (int i2 = 0; i2 != iS; i2++) {
                        if ("versionCode".equals(nVar.n(i2))) {
                            strN = n(nVar, i2);
                        } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(nVar.n(i2))) {
                            strN2 = n(nVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strN);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strN)));
                        try {
                            nVar.n();
                        } catch (Throwable unused3) {
                        }
                        x.n(zipFile2);
                        return null;
                    }
                    l lVar = new l(strN2, i);
                    try {
                        nVar.n();
                    } catch (Throwable unused4) {
                    }
                    x.n(zipFile2);
                    return lVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable unused5) {
                        packageArchiveInfo = null;
                    }
                    try {
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            if (nVar != null) {
                                try {
                                    nVar.n();
                                } catch (Throwable unused6) {
                                }
                            }
                            x.n(zipFile);
                            return null;
                        }
                        l lVar2 = new l(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (nVar != null) {
                            try {
                                nVar.n();
                            } catch (Throwable unused7) {
                            }
                        }
                        x.n(zipFile);
                        return lVar2;
                    } catch (Throwable th3) {
                        if (nVar != null) {
                            try {
                                nVar.n();
                            } catch (Throwable unused8) {
                            }
                        }
                        x.n(zipFile);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                nVar = null;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile = null;
            nVar = null;
        }
    }

    private static String n(n nVar, int i) {
        int iQg = nVar.qg(i);
        int iS = nVar.s(i);
        if (iQg == 3) {
            return nVar.q(i);
        }
        if (iQg == 2) {
            return String.format("?%s%08X", n(iS), Integer.valueOf(iS));
        }
        return (iQg < 16 || iQg > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iS), Integer.valueOf(iQg)) : String.valueOf(iS);
    }
}
