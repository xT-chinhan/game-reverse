package com.ss.android.ms;

import com.anythink.basead.f.g;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final char[] f4544ms = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ms(File file) {
        return ms(file, 9, 8192L);
    }

    public static String ms(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return xr(file, i, j);
                }
            } catch (Throwable th) {
                sl.ms(th);
            }
        }
        return "";
    }

    public static int ms(String str, File file) {
        return ms(str, file, (xr) null);
    }

    public static int ms(String str, File file, xr xrVar) {
        int i;
        long j;
        String strXr;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (xrVar != null) {
                if (xrVar.ms() <= 0) {
                    try {
                        xrVar.xr();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                ms msVarMs = ms(str);
                if (msVarMs == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (msVarMs.f4545ms > 1) {
                        return 3;
                    }
                    i = msVarMs.ah;
                    j = msVarMs.d;
                }
                ms msVarMs2 = null;
                try {
                    if (xrVar != null) {
                        strXr = ms(xrVar, i, j);
                    } else {
                        strXr = xr(file, i, j);
                    }
                } catch (Throwable th) {
                    sl.ms(th);
                    strXr = null;
                }
                if (strXr != null && strXr.length() != 0) {
                    if (msVarMs == null || (msVarMs.f4545ms == 1 && msVarMs.xr == 1)) {
                        if (strXr.equals(str)) {
                            return 0;
                        }
                    } else if (msVarMs.ka != null) {
                        try {
                            msVarMs2 = ms(strXr);
                        } catch (Throwable unused2) {
                        }
                        if (msVarMs2 != null && msVarMs.ah == msVarMs2.ah && msVarMs.d == msVarMs2.d && msVarMs.ka.equals(msVarMs2.ka)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    private static String xr(File file, int i, long j) throws Exception {
        return ms(new com.ss.android.ms.ms(file), i, j);
    }

    private static String ms(xr xrVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jMs = xrVar.ms();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jMs) / 10) {
                j2 = jMs;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            ms(xrVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jMs - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    ms(xrVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                ms(xrVar, messageDigest, bArr, jMs - j2, j2);
            }
            String strMs = ms(messageDigest.digest());
            return (i2 == 1 && j2 == jMs) ? strMs : ms(i2, j2) + ";" + strMs;
        } finally {
            try {
                xrVar.xr();
            } catch (Throwable unused) {
            }
        }
    }

    private static void ms(xr xrVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        xrVar.ms(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iMs = xrVar.ms(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iMs <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iMs + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iMs);
            j3 += (long) iMs;
        }
    }

    private static String ms(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & UByte.MAX_VALUE;
            int i5 = i2 + 1;
            char[] cArr2 = f4544ms;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String ms(int i, long j) {
        return "ttmd5:1:1:" + ms(i) + g.i + ms(j);
    }

    private static ms ms(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        ms msVar = new ms();
        msVar.f4545ms = Integer.parseInt(strArrSplit2[1]);
        if (msVar.f4545ms > 1) {
            return msVar;
        }
        msVar.xr = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split(g.i);
        msVar.ah = (int) xr(strArrSplit3[0]);
        msVar.d = xr(strArrSplit3[1]);
        msVar.ka = strArrSplit[1];
        return msVar;
    }

    private static String ms(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long xr(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable unused) {
            throw new RuntimeException("ttmd5 decryptNum error, num = ".concat(String.valueOf(str)));
        }
    }

    private static class ms {
        private int ah;
        private long d;
        private String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f4545ms;
        private int xr;

        private ms() {
        }
    }
}
