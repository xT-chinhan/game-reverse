package com.tapsdk.tapad.internal.runtime.bundle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
public final class BundleFileHeader {
    private static final int HEADER_SIZE = 80;
    private static final int PREFIX_SIZE = 88;

    private BundleFileHeader() {
    }

    public static long readBundleVersionCode(File file) {
        if (file != null && file.isFile() && file.length() >= 88) {
            byte[] bArr = new byte[88];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int i = 0;
                while (i < 88) {
                    try {
                        int i2 = fileInputStream.read(bArr, i, 88 - i);
                        if (i2 < 0) {
                            fileInputStream.close();
                            return -1L;
                        }
                        i += i2;
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                fileInputStream.close();
                if (bArr[0] != 68 || bArr[1] != 82 || bArr[2] != 67 || bArr[3] != 72 || readU16Le(bArr, 4) != 1 || readU16Le(bArr, 6) != 1 || readU32Le(bArr, 76) != file.length() - 80) {
                    return -1L;
                }
                long u64Le = readU64Le(bArr, 80);
                if (u64Le > 0) {
                    return u64Le;
                }
                return -1L;
            } catch (IOException e) {
            }
        }
        return -1L;
    }

    private static int readU16Le(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
    }

    private static long readU32Le(byte[] bArr, int i) {
        return ((((long) bArr[i + 3]) & 255) << 24) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
    }

    private static long readU64Le(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }
}
