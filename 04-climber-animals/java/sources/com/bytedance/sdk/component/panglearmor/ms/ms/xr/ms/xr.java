package com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static ah ms(com.bytedance.sdk.component.panglearmor.ms.xr.xr xrVar, com.bytedance.sdk.component.panglearmor.ms.ms.ah.xr xrVar2, int i) throws Exception {
        try {
            com.bytedance.sdk.component.panglearmor.ms.ms.ms.xr.ms msVarMs = com.bytedance.sdk.component.panglearmor.ms.ms.ms.xr.ms(xrVar, xrVar2);
            long jMs = msVarMs.ms();
            com.bytedance.sdk.component.panglearmor.ms.xr.xr xrVarXr = msVarMs.xr();
            ByteBuffer byteBufferMs = xrVarXr.ms(0L, (int) xrVarXr.ms());
            byteBufferMs.order(ByteOrder.LITTLE_ENDIAN);
            return new ah(ms(byteBufferMs, i), jMs, xrVar2.ms(), xrVar2.d(), xrVar2.ka());
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static ByteBuffer ms(ByteBuffer byteBuffer, int i) throws Exception {
        ms(byteBuffer);
        ByteBuffer byteBufferMs = ms(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferMs.hasRemaining()) {
            i2++;
            if (byteBufferMs.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j = byteBufferMs.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferMs.position() + i3;
            if (i3 > byteBufferMs.remaining()) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferMs.remaining());
            }
            if (byteBufferMs.getInt() == i) {
                return xr(byteBufferMs, i3 - 4);
            }
            byteBufferMs.position(iPosition);
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    public static void ms(ByteBuffer byteBuffer) {
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

    private static ByteBuffer xr(ByteBuffer byteBuffer, int i) {
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

    public static ByteBuffer xr(ByteBuffer byteBuffer) throws Exception {
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
        return xr(byteBuffer, i);
    }

    public static byte[] ah(ByteBuffer byteBuffer) throws Exception {
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
