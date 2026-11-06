package com.tapsdk.tapad.internal.runtime.download;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import com.umeng.analytics.pro.cc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadUtils {
    private static final long APK_SIZE_TOLERANCE_BYTES = 10;
    private static final int APK_VERIFY_TYPE_NOT_VERIFY = 1;

    public static final class ErrorCode {
        public static final int ERROR_FILE_NOT_FOUND = 1004;
        public static final int ERROR_HTTP_ERROR = 1007;
        public static final int ERROR_IO_EXCEPTION = 1006;
        public static final int ERROR_MD5_MISMATCH = 1005;
        public static final int ERROR_NETWORK_UNAVAILABLE = 1001;
        public static final int ERROR_STORAGE_INSUFFICIENT = -504;
        public static final int ERROR_TIMEOUT = 1008;
        public static final int ERROR_UNKNOWN = 1099;
        public static final int SUCCESS = 0;

        private ErrorCode() {
        }
    }

    private DownloadUtils() {
    }

    private static void addLegacyDirectory(List<File> list, File file) {
        if (file != null) {
            list.add(new File(file, "downloads"));
        }
    }

    public static boolean copyFile(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            fileInputStream.close();
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (IOException e) {
            return false;
        }
    }

    private static long difference(long j, long j2) {
        return j >= j2 ? j - j2 : j2 - j;
    }

    private static String digestHex(File file, String str) {
        int i;
        if (file != null && file.isFile()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(str);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                    }
                    StringBuilder sb = new StringBuilder(messageDigest.getDigestLength() * 2);
                    for (byte b : messageDigest.digest()) {
                        sb.append(Character.forDigit((b >>> 4) & 15, 16));
                        sb.append(Character.forDigit(b & cc.m, 16));
                    }
                    String string = sb.toString();
                    fileInputStream.close();
                    return string;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static String extractFileName(String str) {
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf(63);
            if (iIndexOf > 0) {
                str = str.substring(0, iIndexOf);
            }
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf >= 0 && iLastIndexOf < str.length() - 1) {
                return str.substring(iLastIndexOf + 1);
            }
        }
        return "download_" + System.currentTimeMillis();
    }

    public static String generateFileName(String str, String str2, String str3) {
        String strSanitizeFileName = (str == null || str.isEmpty()) ? "unknown" : sanitizeFileName(str);
        if (str2 == null || str2.isEmpty()) {
            str2 = String.valueOf(System.currentTimeMillis());
        }
        return strSanitizeFileName + "_" + str2 + "_" + ((str3 == null || str3.isEmpty()) ? "app" : sanitizeFileName(str3)) + ".apk";
    }

    public static File getDefaultDownloadDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getExternalFilesDir(null);
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null && !externalCacheDir.exists()) {
            externalCacheDir.mkdirs();
        }
        return externalCacheDir;
    }

    public static File[] getLegacyDownloadDirs(Context context) {
        ArrayList arrayList = new ArrayList();
        addLegacyDirectory(arrayList, context.getExternalCacheDir());
        addLegacyDirectory(arrayList, context.getExternalFilesDir(null));
        addLegacyDirectory(arrayList, context.getCacheDir());
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static boolean hasEnoughStorage(File file, long j, long j2) {
        if (file != null && j > 0) {
            try {
                return new StatFs(file.getAbsolutePath()).getAvailableBytes() >= Math.max(0L, j - Math.max(0L, j2));
            } catch (Throwable th) {
            }
        }
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            return false;
        }
    }

    public static String sanitizeFileName(String str) {
        return str == null ? "" : str.replaceAll("[\\\\/:*?\"<>|]", "_");
    }

    public static int validateFile(AndroidDownloadRequest androidDownloadRequest, File file) {
        if (file == null || !file.isFile()) {
            return 1004;
        }
        if (androidDownloadRequest == null || androidDownloadRequest.getApkVerifyType() == 1) {
            return 0;
        }
        long expectedSize = androidDownloadRequest.getExpectedSize();
        if (androidDownloadRequest.getApkVerifyType() >= 0 && expectedSize < 0) {
            return 1004;
        }
        if (expectedSize < 0 || difference(file.length(), expectedSize) < APK_SIZE_TOLERANCE_BYTES) {
            return verifyMd5(file, androidDownloadRequest.getMd5()) ? 0 : 1005;
        }
        return 1004;
    }

    public static boolean verifyMd5(File file, String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        String strDigestHex = digestHex(file, "MD5");
        return strDigestHex != null && strDigestHex.equalsIgnoreCase(str);
    }
}
