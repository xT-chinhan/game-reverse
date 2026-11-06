package com.byazt.jvf;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 905, 26})
public class qg {
    public static s n(com.byazt.iip.qg qgVar, com.byazt.ujk.qg qgVar2, int i) throws Exception {
        try {
            com.byazt.kdu.qg.n nVarN = com.byazt.kdu.qg.n(qgVar, qgVar2);
            long jN = nVarN.n();
            com.byazt.iip.qg qgVarQg = nVarN.qg();
            ByteBuffer byteBufferN = qgVarQg.n(0L, (int) qgVarQg.n());
            byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
            return new s(n(byteBufferN, i), jN, qgVar2.n(), qgVar2.q(), qgVar2.l());
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static ByteBuffer n(ByteBuffer byteBuffer, int i) throws Exception {
        n(byteBuffer);
        ByteBuffer byteBufferN = n(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferN.hasRemaining()) {
            i2++;
            if (byteBufferN.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j = byteBufferN.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferN.position() + i3;
            if (i3 > byteBufferN.remaining()) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferN.remaining());
            }
            if (byteBufferN.getInt() == i) {
                return qg(byteBufferN, i3 - 4);
            }
            byteBufferN.position(iPosition);
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    public static void n(ByteBuffer byteBuffer) {
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

    private static ByteBuffer qg(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static ByteBuffer qg(ByteBuffer byteBuffer) throws Exception {
        if (byteBuffer.remaining() < 4) {
            throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new Exception("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return qg(byteBuffer, i);
    }

    public static byte[] s(ByteBuffer byteBuffer) throws Exception {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new Exception("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new Exception("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }
}
