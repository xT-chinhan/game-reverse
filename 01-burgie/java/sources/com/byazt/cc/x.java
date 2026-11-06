package com.byazt.cc;

import android.content.pm.PackageInfo;
import com.byazt.ewn.AbsServerManager;
import com.byazt.gs.fw;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, 121})
public class x {
    public static c pr(File file) {
        ZipFile zipFile;
        pr prVar;
        PackageInfo packageArchiveInfo;
        int iHw;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                fw.pr((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    fw.pr(zipFile2);
                    return null;
                }
                prVar = new pr();
                try {
                    prVar.pr(zipFile2.getInputStream(entry));
                    do {
                        iHw = prVar.hw();
                        if (iHw == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                prVar.pr();
                            } catch (Throwable th) {
                            }
                            fw.pr(zipFile2);
                            return null;
                        }
                    } while (iHw != 2);
                    int iHn = prVar.hn();
                    String strPr = null;
                    String strPr2 = null;
                    for (int i2 = 0; i2 != iHn; i2++) {
                        if ("versionCode".equals(prVar.pr(i2))) {
                            strPr = pr(prVar, i2);
                        } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(prVar.pr(i2))) {
                            strPr2 = pr(prVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strPr);
                    } catch (Throwable th2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strPr)));
                        try {
                            prVar.pr();
                        } catch (Throwable th3) {
                        }
                        fw.pr(zipFile2);
                        return null;
                    }
                    c cVar = new c(strPr2, i);
                    try {
                        prVar.pr();
                    } catch (Throwable th4) {
                    }
                    fw.pr(zipFile2);
                    return cVar;
                } catch (Throwable th5) {
                    th = th5;
                    Throwable th6 = th;
                    zipFile = zipFile2;
                    th = th6;
                    try {
                        packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                    } catch (Throwable th7) {
                        packageArchiveInfo = null;
                    }
                    try {
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            if (prVar != null) {
                                try {
                                    prVar.pr();
                                } catch (Throwable th8) {
                                }
                            }
                            fw.pr(zipFile);
                            return null;
                        }
                        c cVar2 = new c(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (prVar != null) {
                            try {
                                prVar.pr();
                            } catch (Throwable th9) {
                            }
                        }
                        fw.pr(zipFile);
                        return cVar2;
                    } catch (Throwable th10) {
                        if (prVar != null) {
                            try {
                                prVar.pr();
                            } catch (Throwable th11) {
                            }
                        }
                        fw.pr(zipFile);
                        throw th10;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                prVar = null;
            }
        } catch (Throwable th13) {
            th = th13;
            zipFile = null;
            prVar = null;
        }
    }

    private static String pr(int i) {
        if ((i >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String pr(pr prVar, int i) {
        int iHw = prVar.hw(i);
        int iHn = prVar.hn(i);
        if (iHw == 3) {
            return prVar.x(i);
        }
        if (iHw == 2) {
            return String.format("?%s%08X", pr(iHn), Integer.valueOf(iHn));
        }
        return (iHw < 16 || iHw > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iHn), Integer.valueOf(iHw)) : String.valueOf(iHn);
    }
}
