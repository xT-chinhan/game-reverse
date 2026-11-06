package com.kwad.sdk.utils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes3.dex */
public final class bf {
    public static String hj(String str) {
        try {
            return al.toHexString(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return null;
        }
    }

    public static String ac(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            fileInputStream = new FileInputStream(file);
            try {
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i != -1) {
                            messageDigest.update(bArr, 0, i);
                        } else {
                            String hexString = al.toHexString(messageDigest.digest());
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                            return hexString;
                        }
                        th = th;
                        fileInputStream2 = fileInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
