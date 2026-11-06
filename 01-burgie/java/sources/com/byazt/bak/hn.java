package com.byazt.bak;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1704, 20})
public class hn {
    public static final char[] pr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String pr(File file) {
        return pr(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String pr(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return hw(file, i, j);
                }
            } catch (Throwable th) {
                return "";
            }
        }
        return "";
    }

    public static int pr(String str, File file) {
        return pr(str, file, (hw) null);
    }

    public static int pr(String str, File file, hw hwVar) {
        String strHw;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (hwVar != null) {
                if (hwVar.pr() <= 0) {
                    try {
                        hwVar.hw();
                    } catch (Throwable th) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i = -1;
            long j = -1;
            try {
                pr prVarPr = pr(str);
                if (prVarPr != null) {
                    if (prVarPr.pr > 1) {
                        return 3;
                    }
                    i = prVarPr.hn;
                    j = prVarPr.x;
                }
                pr prVarPr2 = null;
                try {
                    if (hwVar != null) {
                        strHw = pr(hwVar, i, j);
                    } else {
                        strHw = hw(file, i, j);
                    }
                } catch (Throwable th2) {
                    strHw = null;
                }
                if (strHw != null && strHw.length() != 0) {
                    if (prVarPr == null || (prVarPr.pr == 1 && prVarPr.hw == 1)) {
                        if (strHw.equals(str)) {
                            return 0;
                        }
                    } else if (prVarPr.c != null) {
                        try {
                            prVarPr2 = pr(strHw);
                        } catch (Throwable th3) {
                        }
                        if (prVarPr2 != null && prVarPr.hn == prVarPr2.hn && prVarPr.x == prVarPr2.x && prVarPr.c.equals(prVarPr2.c)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable th4) {
                return 4;
            }
        } catch (Throwable th5) {
            return 99;
        }
    }

    private static String hw(File file, int i, long j) throws Exception {
        return pr(new com.byazt.bak.pr(file), i, j);
    }

    private static String pr(hw hwVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jPr = hwVar.pr();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jPr) / 10) {
                j2 = jPr;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            pr(hwVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jPr - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    pr(hwVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                pr(hwVar, messageDigest, bArr, jPr - j2, j2);
            }
            String strPr = pr(messageDigest.digest());
            return (i2 == 1 && j2 == jPr) ? strPr : pr(i2, j2) + ";" + strPr;
        } finally {
            try {
                hwVar.hw();
            } catch (Throwable th) {
            }
        }
    }

    private static void pr(hw hwVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        hwVar.pr(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iPr = hwVar.pr(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iPr <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iPr + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iPr);
            j3 += (long) iPr;
        }
    }

    private static String pr(byte[] bArr) {
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
            char[] cArr2 = pr;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String pr(int i, long j) {
        return "ttmd5:1:1:" + pr(i) + "g" + pr(j);
    }

    private static pr pr(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        pr prVar = new pr();
        prVar.pr = Integer.parseInt(strArrSplit2[1]);
        if (prVar.pr > 1) {
            return prVar;
        }
        prVar.hw = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        prVar.hn = (int) hw(strArrSplit3[0]);
        prVar.x = hw(strArrSplit3[1]);
        prVar.c = strArrSplit[1];
        return prVar;
    }

    private static String pr(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long hw(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable th) {
            throw new RuntimeException("ttmd5 decryptNum error, num = ".concat(String.valueOf(str)));
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1704, 116})
    private static class pr {
        public String c;
        public int hn;
        public int hw;
        public int pr;
        public long x;

        private pr() {
        }
    }
}
