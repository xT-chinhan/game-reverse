package com.byazt.iq;

import android.util.Pair;
import com.byazt.gx.w;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1549, 26})
public class qg {
    public static String n = "";

    public static String[] n(File file) {
        String str;
        String strN = "";
        try {
            ByteBuffer byteBufferQg = qg(file);
            if (n(byteBufferQg)) {
                strN = w.n(byteBufferQg.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = strN;
        }
        return new String[]{strN, n, str};
    }

    private static ByteBuffer qg(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                Pair<ByteBuffer, Long> pairN = n(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) pairN.first;
                long jLongValue = ((Long) pairN.second).longValue();
                if (s.n(randomAccessFile2, jLongValue)) {
                    throw new Exception("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) n(randomAccessFile2, n(byteBuffer, jLongValue)).first;
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

    private static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairN = s.n(randomAccessFile);
        if (pairN != null) {
            return pairN;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long n(ByteBuffer byteBuffer, long j) throws Exception {
        long jN = s.n(byteBuffer);
        if (jN > j) {
            throw new Exception("ZIP Central Directory offset out of range: " + jN + ". ZIP End of Central Directory offset: " + j);
        }
        if (s.qg(byteBuffer) + jN == j) {
            return jN;
        }
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    public static Pair<ByteBuffer, Long> n(RandomAccessFile randomAccessFile, long j) throws Exception {
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

    private static boolean n(ByteBuffer byteBuffer) throws Exception {
        qg(byteBuffer);
        ByteBuffer byteBufferN = n(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferN.hasRemaining()) {
            i++;
            if (byteBufferN.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            long j = byteBufferN.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferN.position() + i2;
            if (i2 > byteBufferN.remaining()) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferN.remaining());
            }
            int i3 = byteBufferN.getInt();
            if (i3 == -262969152) {
                n = "V3";
                return true;
            }
            if (i3 == 1896449818) {
                n = "V2";
                return true;
            }
            byteBufferN.position(iPosition);
        }
        return false;
    }

    private static void qg(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer n(ByteBuffer byteBuffer, int i, int i2) {
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
