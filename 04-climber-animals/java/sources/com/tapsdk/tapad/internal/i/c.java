package com.tapsdk.tapad.internal.i;

import android.net.Uri;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final long a = 209715200;
    private static final String b = "/ad_root";

    private static long a(File file, int i) {
        long jA;
        long j = 0;
        if (i > 3) {
            return 0L;
        }
        File[] fileArrListFiles = file.listFiles();
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "--";
        }
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    jA = file2.length();
                } else {
                    if (file2.isDirectory()) {
                        jA = a(file2, i + 1);
                    }
                }
                j += jA;
            }
        }
        return j;
    }

    public static String a(String str, String str2) {
        if (com.tapsdk.tapad.c.a == null) {
            return "";
        }
        File file = new File(new File(new File(com.tapsdk.tapad.c.a.getCacheDir(), b), str), str2);
        return file.exists() ? Uri.fromFile(file).toString() : "";
    }

    public static String a(byte[] bArr, String str, String str2) throws IOException {
        if (bArr.length > a) {
            throw new IOException("Exceeded max storage space");
        }
        File file = new File(com.tapsdk.tapad.c.a.getCacheDir(), b);
        long length = ((long) bArr.length) + a(file, 0);
        if (length > a) {
            TapADLogger.e("cacheRootDir lack of space:" + (length - a));
            return "";
        }
        File file2 = new File(file, str);
        if (!file2.exists() && !file2.mkdirs()) {
            return "";
        }
        File file3 = new File(file2, str2);
        if (!file2.exists()) {
            file3.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file3);
        try {
            fileOutputStream.write(bArr);
            return Uri.fromFile(file3).toString();
        } finally {
            fileOutputStream.flush();
            fileOutputStream.close();
        }
    }
}
