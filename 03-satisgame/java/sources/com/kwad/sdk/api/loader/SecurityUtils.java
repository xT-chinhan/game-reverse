package com.kwad.sdk.api.loader;

import com.anythink.core.common.u.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
class SecurityUtils {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    SecurityUtils() {
    }

    static String md5Hex(String str) {
        if (str == null) {
            return "";
        }
        try {
            if (str.length() == 0) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest.length < 1) {
                return null;
            }
            return toHexString(bArrDigest, 0, bArrDigest.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = bArr[i5 + i] & UByte.MAX_VALUE;
            int i7 = i4 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i4] = cArr2[i6 >> 4];
            i4 = i7 + 1;
            cArr[i7] = cArr2[i6 & 15];
        }
        return new String(cArr, 0, i3);
    }

    static String getFileMD5(File file) throws Throwable {
        Throwable th;
        DigestInputStream digestInputStream;
        Exception e;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    for (int i = digestInputStream.read(bArr); i != -1; i = digestInputStream.read(bArr)) {
                    }
                    byte[] bArrDigest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
                    for (byte b : bArrDigest) {
                        int i2 = b & UByte.MAX_VALUE;
                        if (i2 < 16) {
                            sb.append("0");
                        }
                        sb.append(Integer.toHexString(i2));
                    }
                    String string = sb.toString();
                    safetyCloseStream(digestInputStream);
                    return string;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    safetyCloseStream(digestInputStream);
                    return "";
                }
            } catch (Throwable th2) {
                th = th2;
                safetyCloseStream(digestInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            digestInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            digestInputStream = null;
            safetyCloseStream(digestInputStream);
            throw th;
        }
    }

    private static void safetyCloseStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
