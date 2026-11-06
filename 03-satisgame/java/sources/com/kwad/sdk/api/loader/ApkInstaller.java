package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
class ApkInstaller {
    ApkInstaller() {
    }

    static boolean installApk(Context context, ClassLoader classLoader, String str, String str2) throws Exception {
        String apkDir = Dir.getApkDir(context, str2);
        deleteFile(new File(apkDir));
        String apkFilePath = Dir.getApkFilePath(context, str2);
        String dexDir = Dir.getDexDir(context, str2);
        String nativeLibDir = Dir.getNativeLibDir(context, str2);
        try {
            safeCopy(context, str, apkFilePath);
            extraSo(context, str, nativeLibDir);
            return ExternalPackage.create(context, classLoader, apkFilePath, dexDir, nativeLibDir).getKsSdk() != null;
        } catch (Exception e) {
            deleteFile(new File(apkFilePath));
            deleteFile(new File(dexDir));
            deleteFile(new File(nativeLibDir));
            deleteFile(new File(apkDir));
            throw e;
        }
    }

    private static void safeCopy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static void copyAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            safeCopy(inputStream, outputStream);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
        }
    }

    private static void safeCopy(Context context, String str, String str2) throws IOException {
        File file = new File(str2);
        if (file.exists()) {
            Dir.safeDeleteFile(file);
        }
        copyAndClose(new FileInputStream(str), new FileOutputStream(file, false));
    }

    private static void deleteFile(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            deleteFile(file2);
        }
    }

    private static void extraSo(Context context, String str, String str2) throws Throwable {
        String str3 = VMRuntimeCompat.is64Bit() ? "lib/arm64-v8a/" : "lib/armeabi-v7a/";
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (!zipEntryNextElement.isDirectory()) {
                        String name = zipEntryNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !name.contains("../") && name.endsWith(".so") && name.startsWith(str3)) {
                            copyAndClose(zipFile2.getInputStream(zipEntryNextElement), new FileOutputStream(new File(str2, name.substring(str3.length()))));
                        }
                    }
                }
                try {
                    zipFile2.close();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
