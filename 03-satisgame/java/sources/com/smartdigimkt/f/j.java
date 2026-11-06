package com.smartdigimkt.f;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final String a = i.a(new StringBuilder("sdm"), File.separator, "pl");

    public static File a(Context context, String str) {
        File file;
        try {
            try {
                file = new File(context.getFilesDir(), a);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                file = null;
            }
            if (file != null) {
                File file2 = new File(file.getAbsolutePath(), str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                return file2;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    public static void a(Context context, String str, File file) {
        File[] fileArrListFiles;
        try {
            File fileA = a(context, str);
            if (fileA == null || !fileA.isDirectory() || (fileArrListFiles = fileA.listFiles()) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                if (!file2.getName().equals(file.getName())) {
                    file2.delete();
                    file2.getName();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i);
            }
            fileInputStream.close();
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
