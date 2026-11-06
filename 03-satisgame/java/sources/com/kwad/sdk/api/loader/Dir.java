package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.api.BuildConfig;
import com.kwad.sdk.api.util.ApiExecutorUtils;
import com.kwad.sdk.api.util.ApiSafeRunnable;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
class Dir {
    private static final String DYNAMIC_FILE_NAME;
    private static File baseDir;
    private static String downPath;

    Dir() {
    }

    static {
        DYNAMIC_FILE_NAME = dontUseExtName() ? "dynamic_apk" : "dynamic.apk";
    }

    private static boolean dontUseExtName() {
        return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
    }

    private static File ensureDir(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && BuildConfig.isDevelopEnable.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    private static File baseDir(Context context) {
        if (baseDir == null) {
            baseDir = ensureDir(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return baseDir;
    }

    static File getDownloadFile(Context context, String str) {
        return new File(baseDir(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    static String getApkDir(Context context, String str) {
        return ensureDir(new File(baseDir(context), "apk-" + str)).getPath();
    }

    static File getApkDirFile(Context context, String str) {
        return ensureDir(new File(baseDir(context), "apk-" + str));
    }

    static String getApkFilePath(Context context, String str) {
        return new File(getApkDir(context, str), DYNAMIC_FILE_NAME).getPath();
    }

    static File getApkFile(Context context, String str) {
        return new File(getApkDir(context, str), DYNAMIC_FILE_NAME);
    }

    static String getDexDir(Context context, String str) {
        return ensureDir(new File(getApkDir(context, str), "dex")).getPath();
    }

    static String getNativeLibDir(Context context, String str) {
        return ensureDir(new File(getApkDir(context, str), "libs")).getPath();
    }

    static void deleteFile(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                deleteFile(file2);
            }
        }
        file.delete();
    }

    static void safeDeleteFile(File file) {
        try {
            deleteFile(file);
        } catch (Exception unused) {
        }
    }

    static void maybeAsyncDeleteLowerVersion(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ApiExecutorUtils.submit(new ApiSafeRunnable() { // from class: com.kwad.sdk.api.loader.Dir.1
            @Override // com.kwad.sdk.api.util.ApiSafeRunnable
            public void doTask() {
                try {
                    File[] fileArrListFiles = Dir.getApkDirFile(context, str).getParentFile().listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file : fileArrListFiles) {
                        if (DVersionUtils.isGreaterThan(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            Dir.deleteFile(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
