package com.byazt.pwu;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    /* JADX WARN: Code duplicated, block: B:123:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x012e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x00de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x008d A[Catch: all -> 0x0143, TRY_LEAVE, TryCatch #2 {all -> 0x0143, blocks: (B:38:0x0083, B:40:0x008d, B:93:0x013b, B:94:0x0142), top: B:125:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00b8 A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bd A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c9 A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ce A[Catch: all -> 0x0136, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00da A[Catch: all -> 0x0136, TRY_LEAVE, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ef A[Catch: all -> 0x0136, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x011e A[Catch: all -> 0x0136, TRY_ENTER, TryCatch #14 {all -> 0x0136, blocks: (B:41:0x0092, B:42:0x0095, B:46:0x00a2, B:48:0x00ac, B:50:0x00b8, B:51:0x00bd, B:53:0x00c9, B:54:0x00ce, B:56:0x00da, B:59:0x00e4, B:65:0x00ef, B:87:0x011e, B:88:0x012d, B:89:0x012e, B:90:0x0135), top: B:149:0x0092 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static PackageInfo pr(File file) {
        ?? r1;
        ?? r2;
        ?? r4;
        InputStream inputStream;
        ZipFile zipFile;
        ZipEntry zipEntry;
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        pr prVar;
        int iHw;
        int iC;
        String strPr;
        int i;
        String strPr2;
        long j;
        pr prVar2 = null;
        prVar2 = null;
        String strPr3 = null;
        prVar2 = null;
        prVar2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream2);
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            zipFile = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream2;
                            zipInputStream = zipInputStream2;
                            inputStream = null;
                            break;
                        }
                        if (nextEntry.isDirectory()) {
                            zipInputStream2.closeEntry();
                        } else if (!"AndroidManifest.xml".equals(nextEntry.getName())) {
                            zipInputStream2.closeEntry();
                        } else {
                            zipFile = null;
                            zipEntry = nextEntry;
                            fileInputStream = fileInputStream2;
                            zipInputStream = zipInputStream2;
                            inputStream = zipInputStream2;
                            break;
                        }
                    }
                    if (zipEntry != null) {
                        try {
                            if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                                prVar = new pr();
                                try {
                                    prVar.pr(inputStream);
                                    do {
                                        iHw = prVar.hw();
                                        if (iHw != 1) {
                                            throw new hn("已达到END_DOCUMENT");
                                        }
                                    } while (iHw != 2);
                                    iC = prVar.c();
                                    strPr = null;
                                    strPr2 = null;
                                    for (i = 0; i != iC; i++) {
                                        if ("versionName".equals(prVar.pr(i))) {
                                            strPr2 = pr(prVar, i);
                                        } else if ("versionCode".equals(prVar.pr(i))) {
                                            strPr3 = pr(prVar, i);
                                        } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(prVar.pr(i))) {
                                            strPr = pr(prVar, i);
                                        }
                                    }
                                    try {
                                        j = Long.parseLong(strPr3);
                                    } catch (hn e) {
                                        j = -1;
                                    }
                                    if (j != -1) {
                                        throw new hn("versionCode获取失败: ".concat(String.valueOf(strPr3)));
                                    }
                                    PackageInfo packageInfo = new PackageInfo();
                                    packageInfo.versionName = strPr2;
                                    packageInfo.versionCode = (int) j;
                                    packageInfo.packageName = strPr;
                                    if (zipInputStream != null) {
                                        try {
                                            zipInputStream.closeEntry();
                                        } catch (Throwable th) {
                                        }
                                    }
                                    try {
                                        prVar.pr();
                                    } catch (Throwable th2) {
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (Throwable th4) {
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th5) {
                                        }
                                    }
                                    return packageInfo;
                                } catch (Throwable th6) {
                                    r1 = inputStream;
                                    th = th6;
                                    prVar2 = prVar;
                                    r2 = fileInputStream;
                                    r4 = zipFile;
                                }
                            }
                        } catch (Throwable th7) {
                            r1 = inputStream;
                            th = th7;
                            r2 = fileInputStream;
                            r4 = zipFile;
                        }
                    }
                    throw new hn("没有找到AndroidManifest.xml entry");
                } catch (Throwable th8) {
                    th = th8;
                    r4 = 0;
                    r2 = fileInputStream2;
                    r1 = 0;
                }
            } else {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    ZipEntry zipEntryNextElement = null;
                    while (true) {
                        if (!enumerationEntries.hasMoreElements()) {
                            inputStream = null;
                            zipFile = zipFile2;
                            zipEntry = zipEntryNextElement;
                            zipInputStream = null;
                            fileInputStream = null;
                            break;
                        }
                        zipEntryNextElement = enumerationEntries.nextElement();
                        if (!zipEntryNextElement.isDirectory() && "AndroidManifest.xml".equals(zipEntryNextElement.getName())) {
                            InputStream inputStream2 = zipFile2.getInputStream(zipEntryNextElement);
                            zipFile = zipFile2;
                            zipEntry = zipEntryNextElement;
                            zipInputStream = null;
                            fileInputStream = null;
                            inputStream = inputStream2;
                            break;
                        }
                    }
                    if (zipEntry != null) {
                        if ("AndroidManifest.xml".equals(zipEntry.getName())) {
                            prVar = new pr();
                            prVar.pr(inputStream);
                            do {
                                iHw = prVar.hw();
                                if (iHw != 1) {
                                    throw new hn("已达到END_DOCUMENT");
                                }
                            } while (iHw != 2);
                            iC = prVar.c();
                            strPr = null;
                            strPr2 = null;
                            while (i != iC) {
                                if ("versionName".equals(prVar.pr(i))) {
                                    strPr2 = pr(prVar, i);
                                } else if ("versionCode".equals(prVar.pr(i))) {
                                    strPr3 = pr(prVar, i);
                                } else if (AbsServerManager.PACKAGE_QUERY_BINDER.equals(prVar.pr(i))) {
                                    strPr = pr(prVar, i);
                                }
                            }
                            j = Long.parseLong(strPr3);
                            if (j != -1) {
                                throw new hn("versionCode获取失败: ".concat(String.valueOf(strPr3)));
                            }
                            PackageInfo packageInfo2 = new PackageInfo();
                            packageInfo2.versionName = strPr2;
                            packageInfo2.versionCode = (int) j;
                            packageInfo2.packageName = strPr;
                            if (zipInputStream != null) {
                                zipInputStream.closeEntry();
                            }
                            prVar.pr();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return packageInfo2;
                        }
                    }
                    throw new hn("没有找到AndroidManifest.xml entry");
                } catch (Throwable th9) {
                    th = th9;
                    r2 = 0;
                    r4 = zipFile2;
                    r1 = 0;
                }
            }
        } catch (Throwable th10) {
            th = th10;
            r1 = prVar2;
            r2 = r1;
            r4 = r2;
        }
        try {
            throw new hn("throwable: " + th.getMessage() + th.toString());
        } catch (Throwable th11) {
            if (prVar2 != null) {
                try {
                    prVar2.pr();
                } catch (Throwable th12) {
                }
            }
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (Throwable th13) {
                }
            }
            if (r4 != 0) {
                try {
                    r4.close();
                } catch (Throwable th14) {
                }
            }
            if (r2 != 0) {
                try {
                    r2.close();
                    throw th11;
                } catch (Throwable th15) {
                    throw th11;
                }
            }
            throw th11;
        }
    }

    public static PackageInfo pr(Context context, File file, int i) {
        if (com.byazt.tuy.pr.pr(C.ENCODING_PCM_MU_LAW) && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
            try {
                return pr(file);
            } catch (Throwable th) {
                pr("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return hw(context, file, i);
    }

    private static PackageInfo hw(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            pr("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            pr("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void pr(String str, String str2) {
        if (com.byazt.lj.hn.fw() == null) {
            return;
        }
        try {
            new JSONObject().put("message", str2);
        } catch (JSONException e) {
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

    public static String pr(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo != null && packageInfo.applicationInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadLabel(context.getPackageManager()).toString();
            } catch (OutOfMemoryError e) {
                pr("getPackageInfo::fail_load_label", e.getMessage());
                return null;
            }
        }
        return null;
    }
}
