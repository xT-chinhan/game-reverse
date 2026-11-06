package com.byazt.ii;

import android.util.Pair;
import com.byazt.gs.uc;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1490, 13})
public class hw {
    public static String pr = "";

    public static String[] pr(File file) {
        String str;
        String strPr = "";
        try {
            ByteBuffer byteBufferHw = hw(file);
            if (pr(byteBufferHw)) {
                strPr = uc.pr(byteBufferHw.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception e) {
            str = strPr;
        }
        return new String[]{strPr, pr, str};
    }

    private static ByteBuffer hw(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                Pair<ByteBuffer, Long> pairPr = pr(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) pairPr.first;
                long jLongValue = ((Long) pairPr.second).longValue();
                if (hn.pr(randomAccessFile2, jLongValue)) {
                    throw new Exception("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) pr(randomAccessFile2, pr(byteBuffer, jLongValue)).first;
                randomAccessFile2.close();
                return byteBuffer2;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Pair<ByteBuffer, Long> pr(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairPr = hn.pr(randomAccessFile);
        if (pairPr == null) {
            throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
        }
        return pairPr;
    }

    private static long pr(ByteBuffer byteBuffer, long j) throws Exception {
        long jPr = hn.pr(byteBuffer);
        if (jPr > j) {
            throw new Exception("ZIP Central Directory offset out of range: " + jPr + ". ZIP End of Central Directory offset: " + j);
        }
        if (hn.hw(byteBuffer) + jPr != j) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        return jPr;
    }

    public static Pair<ByteBuffer, Long> pr(RandomAccessFile randomAccessFile, long j) throws Exception {
        if (j < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    private static boolean pr(ByteBuffer byteBuffer) throws Exception {
        hw(byteBuffer);
        ByteBuffer byteBufferPr = pr(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferPr.hasRemaining()) {
            i++;
            if (byteBufferPr.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            long j = byteBufferPr.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferPr.position() + i2;
            if (i2 > byteBufferPr.remaining()) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferPr.remaining());
            }
            int i3 = byteBufferPr.getInt();
            if (i3 == -262969152) {
                pr = "V3";
                return true;
            }
            if (i3 == 1896449818) {
                pr = "V2";
                return true;
            }
            byteBufferPr.position(iPosition);
        }
        return false;
    }

    private static void hw(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer pr(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }
}
