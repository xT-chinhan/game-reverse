package com.byazt.v;

import com.anythink.china.a.c;
import com.anythink.core.common.q.g;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 984, 8})
public class s {
    public static final char[] n = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String n(File file) {
        return n(file, 9, c.n);
    }

    public static String n(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return qg(file, i, j);
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static int n(String str, File file) {
        return n(str, file, (qg) null);
    }

    public static int n(String str, File file, qg qgVar) {
        int i;
        long j;
        String strQg;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (qgVar != null) {
                if (qgVar.n() <= 0) {
                    try {
                        qgVar.qg();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                n nVarN = n(str);
                if (nVarN == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (nVarN.n > 1) {
                        return 3;
                    }
                    i = nVarN.s;
                    j = nVarN.q;
                }
                n nVarN2 = null;
                try {
                    if (qgVar != null) {
                        strQg = n(qgVar, i, j);
                    } else {
                        strQg = qg(file, i, j);
                    }
                } catch (Throwable unused2) {
                    strQg = null;
                }
                if (strQg != null && strQg.length() != 0) {
                    if (nVarN == null || (nVarN.n == 1 && nVarN.qg == 1)) {
                        if (strQg.equals(str)) {
                            return 0;
                        }
                    } else if (nVarN.l != null) {
                        try {
                            nVarN2 = n(strQg);
                        } catch (Throwable unused3) {
                        }
                        if (nVarN2 != null && nVarN.s == nVarN2.s && nVarN.q == nVarN2.q && nVarN.l.equals(nVarN2.l)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused4) {
                return 4;
            }
        } catch (Throwable unused5) {
            return 99;
        }
    }

    private static String qg(File file, int i, long j) throws Exception {
        return n(new com.byazt.v.n(file), i, j);
    }

    private static String n(qg qgVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance(com.anythink.core.common.u.n.a);
        if (messageDigest == null) {
            return "";
        }
        try {
            long jN = qgVar.n();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jN) / 10) {
                j2 = jN;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            n(qgVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jN - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    n(qgVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                n(qgVar, messageDigest, bArr, jN - j2, j2);
            }
            String strN = n(messageDigest.digest());
            return (i2 == 1 && j2 == jN) ? strN : n(i2, j2) + ";" + strN;
        } finally {
            try {
                qgVar.qg();
            } catch (Throwable unused) {
            }
        }
    }

    private static void n(qg qgVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        qgVar.n(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iN = qgVar.n(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iN <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iN + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iN);
            j3 += (long) iN;
        }
    }

    private static String n(byte[] bArr) {
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
            char[] cArr2 = n;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String n(int i, long j) {
        return "ttmd5:1:1:" + n(i) + g.a + n(j);
    }

    private static n n(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        n nVar = new n();
        nVar.n = Integer.parseInt(strArrSplit2[1]);
        if (nVar.n > 1) {
            return nVar;
        }
        nVar.qg = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split(g.a);
        nVar.s = (int) qg(strArrSplit3[0]);
        nVar.q = qg(strArrSplit3[1]);
        nVar.l = strArrSplit[1];
        return nVar;
    }

    private static String n(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long qg(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable unused) {
            throw new RuntimeException("ttmd5 decryptNum error, num = ".concat(String.valueOf(str)));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 984, 546})
    private static class n {
        public String l;
        public int n;
        public long q;
        public int qg;
        public int s;

        private n() {
        }
    }
}
