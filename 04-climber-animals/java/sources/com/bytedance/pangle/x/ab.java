package com.bytedance.pangle.x;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
abstract class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final byte[] f715ms = new byte[8];

    static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final ByteBuffer f716ms;
        public final byte[] xr;

        ms(ByteBuffer byteBuffer, byte[] bArr) {
            this.f716ms = byteBuffer;
            this.xr = bArr;
        }
    }

    static ms ms(RandomAccessFile randomAccessFile, zb zbVar, ny nyVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int[] iArrXr = xr(randomAccessFile.length() - (zbVar.ah - zbVar.xr));
        int i = iArrXr[iArrXr.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferMs = nyVar.ms(i2);
        byteBufferMs.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferMs2 = ms(byteBufferMs, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferMs3 = ms(byteBufferMs, i, i3);
        ByteBuffer byteBufferMs4 = ms(byteBufferMs, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        ms(randomAccessFile, zbVar, byteBufferMs2, byteBufferWrap, byteBufferMs3, byteBufferMs4);
        byteBufferMs.position(i3 + byteBufferMs4.limit());
        byteBufferMs.putInt(byteBufferMs4.limit() + 64 + 4);
        byteBufferMs.flip();
        return new ms(byteBufferMs, bArr);
    }

    private static void ms(RandomAccessFile randomAccessFile, zb zbVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        ms(zbVar);
        long j = zbVar.ah - zbVar.xr;
        int[] iArrXr = xr(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrMs = ms(randomAccessFile, zbVar, f715ms, iArrXr, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrMs);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            ms(byteBuffer3, randomAccessFile.length(), iArrXr.length - 1, f715ms);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            ms(byteBuffer4, zbVar.xr, j, zbVar.d);
        }
    }

    private static class xr implements ch {
        private final MessageDigest ah;
        private final byte[] d;
        private final byte[] ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f717ms;
        private final ByteBuffer xr;

        private xr(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.d = new byte[32];
            this.ka = bArr;
            this.xr = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.ah = messageDigest;
            messageDigest.update(bArr);
            this.f717ms = 0;
        }

        @Override // com.bytedance.pangle.x.ch
        public void ms(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.f717ms);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.ah.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.f717ms + iMin;
                this.f717ms = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.ah;
                    byte[] bArr = this.d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.xr.put(this.d);
                    this.ah.update(this.ka);
                    this.f717ms = 0;
                }
            }
        }

        public void ms() throws DigestException {
            if (this.f717ms != 0) {
                throw new IllegalStateException("Buffer is not empty: " + this.f717ms);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xr() {
            int iPosition = this.xr.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.xr.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    private static void ms(ch chVar, hi hiVar, int i) throws DigestException, IOException {
        long jMs = hiVar.ms();
        long j = 0;
        while (jMs > 0) {
            int iMin = (int) Math.min(jMs, i);
            hiVar.ms(chVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jMs -= j2;
        }
    }

    private static void ms(RandomAccessFile randomAccessFile, zb zbVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        xr xrVar = new xr(bArr, byteBuffer);
        ms(xrVar, new sl(randomAccessFile.getFD(), 0L, zbVar.xr), 1048576);
        long j = zbVar.d + 16;
        ms(xrVar, new sl(randomAccessFile.getFD(), zbVar.ah, j - zbVar.ah), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(ms(zbVar.xr));
        byteBufferOrder.flip();
        xrVar.ms(byteBufferOrder);
        long j2 = j + 4;
        ms(xrVar, new sl(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            xrVar.ms(ByteBuffer.allocate(4096 - length));
        }
        xrVar.ms();
        xrVar.xr();
    }

    private static byte[] ms(RandomAccessFile randomAccessFile, zb zbVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        ms(randomAccessFile, zbVar, bArr, ms(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferMs = ms(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferMs2 = ms(byteBuffer, iArr[length], iArr[i]);
                x xVar = new x(byteBufferMs);
                xr xrVar = new xr(bArr, byteBufferMs2);
                ms(xrVar, xVar, 4096);
                xrVar.ms();
                xrVar.xr();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                xr xrVar2 = new xr(bArr, ByteBuffer.wrap(bArr2));
                xrVar2.ms(ms(byteBuffer, 0, 4096));
                xrVar2.ms();
                return bArr2;
            }
        }
    }

    private static ByteBuffer ms(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException("salt is not 8 bytes long");
        }
        byteBuffer.put("TrueBrew".getBytes());
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 7);
        byteBuffer.putShort((short) 1);
        byteBuffer.putShort((short) 1);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putLong(j);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 0);
        byteBuffer.put(bArr);
        ms(byteBuffer, 22);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ByteBuffer ms(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        ms(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        ms(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(ms(j));
        ms(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static int[] xr(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = ms(j, 4096L) * 32;
            arrayList.add(Long.valueOf(ms(j, 4096L) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + ms(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void ms(zb zbVar) {
        if (zbVar.xr % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + zbVar.xr);
        }
        if ((zbVar.ah - zbVar.xr) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (zbVar.ah - zbVar.xr));
        }
    }

    private static ByteBuffer ms(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void ms(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long ms(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int ms(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
