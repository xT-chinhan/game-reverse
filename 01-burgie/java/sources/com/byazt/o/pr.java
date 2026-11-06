package com.byazt.o;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.umeng.analytics.pro.cc;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1257, 37})
public final class pr {
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private pr() {
    }

    private static MessageDigest pr() {
        try {
            return MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static boolean pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String pr(File file) throws Throwable {
        Throwable th;
        DigestInputStream digestInputStream;
        try {
            digestInputStream = new DigestInputStream(new FileInputStream(file), pr());
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
                    } catch (Exception e) {
                    }
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    e.getMessage();
                    if (digestInputStream != null) {
                        try {
                            digestInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (digestInputStream != null) {
                    try {
                        digestInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
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

    public static String pr(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigestPr = pr();
        if (messageDigestPr == null || TextUtils.isEmpty(str)) {
            return "";
        }
        byte[] bytes = str.getBytes(Charset.forName(Key.STRING_CHARSET_NAME));
        synchronized (pr.class) {
            bArrDigest = messageDigestPr.digest(bytes);
        }
        return pr(bArrDigest);
    }

    public static String pr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = pr;
            cArr[i] = cArr2[(b & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b & cc.m];
        }
        return new String(cArr);
    }
}
