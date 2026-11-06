package com.byazt.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.byazt.gc.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 18})
public class l {
    private static String n(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo n(File file) {
        FileInputStream fileInputStream;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        int iQg;
        long j;
        n nVar = null;
        String strN = null;
        nVar = null;
        nVar = null;
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
                            n nVar2 = new n();
                            try {
                                nVar2.n(zipInputStream);
                                do {
                                    iQg = nVar2.qg();
                                    if (iQg == 1) {
                                        throw new s("已达到END_DOCUMENT");
                                    }
                                } while (iQg != 2);
                                int iL = nVar2.l();
                                String strN2 = null;
                                String strN3 = null;
                                for (int i = 0; i != iL; i++) {
                                    if ("versionName".equals(nVar2.n(i))) {
                                        strN3 = n(nVar2, i);
                                    } else if ("versionCode".equals(nVar2.n(i))) {
                                        strN = n(nVar2, i);
                                    } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(nVar2.n(i))) {
                                        strN2 = n(nVar2, i);
                                    }
                                }
                                try {
                                    j = Long.parseLong(strN);
                                } catch (s unused2) {
                                    j = -1;
                                }
                                if (j == -1) {
                                    throw new s("versionCode获取失败: ".concat(String.valueOf(strN)));
                                }
                                PackageInfo packageInfo = new PackageInfo();
                                packageInfo.versionName = strN3;
                                packageInfo.versionCode = (int) j;
                                packageInfo.packageName = strN2;
                                try {
                                    zipInputStream2.closeEntry();
                                } catch (Throwable unused3) {
                                }
                                try {
                                    nVar2.n();
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
                                nVar = nVar2;
                                try {
                                    throw new s("throwable: " + th.getMessage() + th.toString());
                                } catch (Throwable th2) {
                                    if (nVar != null) {
                                        try {
                                            nVar.n();
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
                throw new s("没有找到AndroidManifest.xml entry");
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

    public static PackageInfo n(Context context, File file, int i) {
        if (com.byazt.ta.n.n(C.ENCODING_PCM_MU_LAW) && Build.VERSION.SDK_INT < 26) {
            try {
                return n(file);
            } catch (Throwable th) {
                n("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return qg(context, file, i);
    }

    private static PackageInfo qg(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            n("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            n("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void n(String str, String str2) {
        if (com.byazt.xv.s.x() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException unused) {
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

    public static String n(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            n("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
