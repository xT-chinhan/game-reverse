package com.ss.android.socialbase.appdownloader.c.ms;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ka {
    private static String ms(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo ms(File file) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        int iXr;
        long j;
        ms msVar = null;
        String strMs = null;
        msVar = null;
        msVar = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                while (true) {
                    nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream = null;
                        break;
                    }
                    if (nextEntry.isDirectory()) {
                        try {
                            zipInputStream2.closeEntry();
                        } catch (Throwable unused) {
                        }
                    } else {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipInputStream = zipInputStream2;
                            break;
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                if (nextEntry != null) {
                    try {
                        if ("AndroidManifest.xml".equals(nextEntry.getName())) {
                            ms msVar2 = new ms();
                            try {
                                msVar2.ms(zipInputStream);
                                do {
                                    iXr = msVar2.xr();
                                    if (iXr == 1) {
                                        throw new ah("已达到END_DOCUMENT");
                                    }
                                } while (iXr != 2);
                                int iKa = msVar2.ka();
                                String strMs2 = null;
                                String strMs3 = null;
                                for (int i = 0; i != iKa; i++) {
                                    if (TTDownloadField.TT_VERSION_NAME.equals(msVar2.ms(i))) {
                                        strMs3 = ms(msVar2, i);
                                    } else if (TTDownloadField.TT_VERSION_CODE.equals(msVar2.ms(i))) {
                                        strMs = ms(msVar2, i);
                                    } else if ("package".equals(msVar2.ms(i))) {
                                        strMs2 = ms(msVar2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(strMs);
                                } catch (ah unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new ah("versionCode获取失败: ".concat(String.valueOf(strMs)));
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = strMs3;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = strMs2;
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    msVar2.ms();
                                } catch (Throwable unused4) {
                                }
                                if (zipInputStream != null) {
                                    try {
                                        zipInputStream.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused6) {
                                }
                                return packageInfo;
                            } catch (Throwable th) {
                                th = th;
                                msVar = msVar2;
                                try {
                                    throw new ah("throwable: " + th.getMessage() + th.toString());
                                } catch (Throwable th2) {
                                    if (msVar != null) {
                                        try {
                                            msVar.ms();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.close();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                            throw th2;
                                        } catch (Throwable unused9) {
                                            throw th2;
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                throw new ah("没有找到AndroidManifest.xml entry");
            } catch (Throwable th4) {
                th = th4;
                zipInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            zipInputStream = null;
        }
    }

    public static PackageInfo ms(Context context, File file, int i) {
        com.ss.android.socialbase.downloader.ny.ms.ms(C.ENCODING_PCM_MU_LAW);
        return xr(context, file, i);
    }

    private static PackageInfo xr(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            ms("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            ms("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void ms(String str, String str2) {
        if (com.ss.android.socialbase.downloader.downloader.ah.ab() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
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

    public static String ms(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            ms("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
