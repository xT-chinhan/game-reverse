package com.byazt.nl;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1690, 19})
public final class n {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private n() {
    }

    private static MessageDigest n() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String n(File file) throws Throwable {
        Throwable th;
        DigestInputStream digestInputStream;
        try {
            digestInputStream = new DigestInputStream(new FileInputStream(file), n());
            try {
                try {
                    while (digestInputStream.read(new byte[8192]) != -1) {
                    }
                    byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(String.format("%02x", Byte.valueOf(b)));
                    }
                    String string = sb.toString();
                    try {
                        digestInputStream.close();
                    } catch (Exception unused) {
                    }
                    return string;
                } catch (Exception e) {
                    e = e;
                    e.getMessage();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (digestInputStream != null) {
                    try {
                        digestInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            digestInputStream = null;
            if (digestInputStream != null) {
                digestInputStream.close();
            }
            throw th;
        }
    }

    public static String n(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigestN = n();
        if (messageDigestN == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        synchronized (n.class) {
            bArrDigest = messageDigestN.digest(bytes);
        }
        return n(bArrDigest);
    }

    public static String n(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = n;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }
}
