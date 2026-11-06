package com.bytedance.pangle.ab.ms;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ab;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private static String ms(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static ka ms(File file) {
        ZipFile zipFile;
        ms msVar;
        int iXr;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                ab.ms((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    ab.ms(zipFile2);
                    return null;
                }
                msVar = new ms();
                try {
                    msVar.ms(zipFile2.getInputStream(entry));
                    do {
                        iXr = msVar.xr();
                        if (iXr == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                msVar.ms();
                            } catch (Throwable unused) {
                            }
                            ab.ms(zipFile2);
                            return null;
                        }
                    } while (iXr != 2);
                    int iAh = msVar.ah();
                    String strMs = null;
                    String strMs2 = null;
                    for (int i2 = 0; i2 != iAh; i2++) {
                        if (TTDownloadField.TT_VERSION_CODE.equals(msVar.ms(i2))) {
                            strMs = ms(msVar, i2);
                        } else if ("package".equals(msVar.ms(i2))) {
                            strMs2 = ms(msVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strMs);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strMs)));
                        try {
                            msVar.ms();
                        } catch (Throwable unused3) {
                        }
                        ab.ms(zipFile2);
                        return null;
                    }
                    ka kaVar = new ka(strMs2, i);
                    try {
                        msVar.ms();
                    } catch (Throwable unused4) {
                    }
                    ab.ms(zipFile2);
                    return kaVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo != null) {
                            return new ka(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        }
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                        return null;
                    } finally {
                        if (msVar != null) {
                            try {
                                msVar.ms();
                            } catch (Throwable unused5) {
                            }
                        }
                        ab.ms(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                msVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            msVar = null;
        }
    }

    private static String ms(ms msVar, int i) {
        int iXr = msVar.xr(i);
        int iAh = msVar.ah(i);
        if (iXr == 3) {
            return msVar.d(i);
        }
        if (iXr == 2) {
            return String.format("?%s%08X", ms(iAh), Integer.valueOf(iAh));
        }
        return (iXr < 16 || iXr > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iAh), Integer.valueOf(iXr)) : String.valueOf(iAh);
    }
}
