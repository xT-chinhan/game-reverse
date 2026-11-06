package com.smartdigimkt.n;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.smartdigimkt.f.i;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static File a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    public static String b() {
        File fileA;
        if (a() == null) {
            return null;
        }
        Context contextA = a();
        if (contextA == null) {
            fileA = null;
        } else {
            try {
                if (contextA.getPackageManager().checkPermission(com.anythink.china.b.c.b, contextA.getPackageName()) == 0) {
                    long availableBlocks = 0;
                    if ("mounted".equals(Environment.getExternalStorageState())) {
                        try {
                            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                            availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                        } catch (Error unused) {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (availableBlocks <= 104857600 || Build.VERSION.SDK_INT > 28) {
                        fileA = null;
                    } else {
                        StringBuilder sbAppend = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath());
                        String str = File.separator;
                        fileA = a(new File(sbAppend.append(str).append(Environment.DIRECTORY_DOWNLOADS).append(str).append("sdm_myoffer_download").toString()));
                    }
                } else {
                    fileA = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (fileA == null) {
            try {
                File externalFilesDir = a().getExternalFilesDir(null);
                if (externalFilesDir != null && (fileA = a(externalFilesDir)) != null) {
                    fileA = new File(fileA, "sdm_myoffer_download");
                }
            } catch (Throwable unused2) {
            }
        }
        if (fileA == null) {
            fileA = new File(i.a(new StringBuilder().append(a().getFilesDir().getAbsoluteFile()), File.separator, "sdm_myoffer_download"));
        }
        return fileA.getAbsolutePath();
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        String strB = b();
        return i.a(sb, strB != null ? i.a(new StringBuilder().append(strB), File.separator, str) : null, ".apk");
    }

    public static String a(int i, String str) {
        return str + "_" + i;
    }

    public static Context a() {
        try {
            return SDKContext.getInstance().d().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
