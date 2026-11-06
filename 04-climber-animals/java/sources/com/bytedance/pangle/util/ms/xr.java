package com.bytedance.pangle.util.ms;

import android.util.Pair;
import com.bytedance.pangle.util.c;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f701ms = "";

    public static String[] ms(File file) {
        String str;
        String strMs = "";
        try {
            ByteBuffer byteBufferXr = xr(file);
            if (ms(byteBufferXr)) {
                strMs = c.ms(byteBufferXr.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = strMs;
        }
        return new String[]{strMs, f701ms, str};
    }

    private static ByteBuffer xr(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, t.k);
            try {
                Pair<ByteBuffer, Long> pairMs = ms(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) pairMs.first;
                long jLongValue = ((Long) pairMs.second).longValue();
                if (ah.ms(randomAccessFile2, jLongValue)) {
                    throw new Exception("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) ms(randomAccessFile2, ms(byteBuffer, jLongValue)).first;
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

    private static Pair<ByteBuffer, Long> ms(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairMs = ah.ms(randomAccessFile);
        if (pairMs != null) {
            return pairMs;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long ms(ByteBuffer byteBuffer, long j) throws Exception {
        long jMs = ah.ms(byteBuffer);
        if (jMs > j) {
            throw new Exception("ZIP Central Directory offset out of range: " + jMs + ". ZIP End of Central Directory offset: " + j);
        }
        if (ah.xr(byteBuffer) + jMs == j) {
            return jMs;
        }
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    static Pair<ByteBuffer, Long> ms(RandomAccessFile randomAccessFile, long j) throws Exception {
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

    private static boolean ms(ByteBuffer byteBuffer) throws Exception {
        xr(byteBuffer);
        ByteBuffer byteBufferMs = ms(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferMs.hasRemaining()) {
            i++;
            if (byteBufferMs.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            long j = byteBufferMs.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferMs.position() + i2;
            if (i2 > byteBufferMs.remaining()) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferMs.remaining());
            }
            int i3 = byteBufferMs.getInt();
            if (i3 == -262969152) {
                f701ms = "V3";
                return true;
            }
            if (i3 == 1896449818) {
                f701ms = "V2";
                return true;
            }
            byteBufferMs.position(iPosition);
        }
        return false;
    }

    private static void xr(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer ms(ByteBuffer byteBuffer, int i, int i2) {
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
