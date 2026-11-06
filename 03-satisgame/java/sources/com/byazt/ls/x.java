package com.byazt.ls;

import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, 21})
public abstract class x {
    public static final byte[] n = new byte[8];

    @com.byazt.cp.n(n = {0, 1, 32, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    static class n {
        public final ByteBuffer n;
        public final byte[] qg;

        public n(ByteBuffer byteBuffer, byte[] bArr) {
            this.n = byteBuffer;
            this.qg = bArr;
        }
    }

    public static n n(RandomAccessFile randomAccessFile, oa oaVar, rv rvVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int[] iArrQg = qg(randomAccessFile.length() - (oaVar.s - oaVar.qg));
        int i = iArrQg[iArrQg.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferN = rvVar.n(i2);
        byteBufferN.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferN2 = n(byteBufferN, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferN3 = n(byteBufferN, i, i3);
        ByteBuffer byteBufferN4 = n(byteBufferN, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        n(randomAccessFile, oaVar, byteBufferN2, byteBufferWrap, byteBufferN3, byteBufferN4);
        byteBufferN.position(i3 + byteBufferN4.limit());
        byteBufferN.putInt(byteBufferN4.limit() + 64 + 4);
        byteBufferN.flip();
        return new n(byteBufferN, bArr);
    }

    private static void n(RandomAccessFile randomAccessFile, oa oaVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        n(oaVar);
        long j = oaVar.s - oaVar.qg;
        int[] iArrQg = qg(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrN = n(randomAccessFile, oaVar, n, iArrQg, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrN);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            n(byteBuffer3, randomAccessFile.length(), iArrQg.length - 1, n);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            n(byteBuffer4, oaVar.qg, j, oaVar.q);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 32, 1181})
    private static class qg implements tj {
        public final byte[] l;
        public int n;
        public final byte[] q;
        public final ByteBuffer qg;
        public final MessageDigest s;

        private qg(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.q = new byte[32];
            this.l = bArr;
            this.qg = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.s = messageDigest;
            messageDigest.update(bArr);
            this.n = 0;
        }

        @Override // com.byazt.ls.tj
        public void n(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.n);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.s.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.n + iMin;
                this.n = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.s;
                    byte[] bArr = this.q;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.qg.put(this.q);
                    this.s.update(this.l);
                    this.n = 0;
                }
            }
        }

        public void n() throws DigestException {
            if (this.n != 0) {
                throw new IllegalStateException("Buffer is not empty: " + this.n);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void qg() {
            int iPosition = this.qg.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.qg.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    private static void n(tj tjVar, cp cpVar, int i) throws DigestException, IOException {
        long jN = cpVar.n();
        long j = 0;
        while (jN > 0) {
            int iMin = (int) Math.min(jN, i);
            cpVar.n(tjVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jN -= j2;
        }
    }

    private static void n(RandomAccessFile randomAccessFile, oa oaVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        qg qgVar = new qg(bArr, byteBuffer);
        n(qgVar, new d(randomAccessFile.getFD(), 0L, oaVar.qg), 1048576);
        long j = oaVar.q + 16;
        n(qgVar, new d(randomAccessFile.getFD(), oaVar.s, j - oaVar.s), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(n(oaVar.qg));
        byteBufferOrder.flip();
        qgVar.n(byteBufferOrder);
        long j2 = j + 4;
        n(qgVar, new d(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % c.m);
        if (length != 0) {
            qgVar.n(ByteBuffer.allocate(4096 - length));
        }
        qgVar.n();
        qgVar.qg();
    }

    private static byte[] n(RandomAccessFile randomAccessFile, oa oaVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        n(randomAccessFile, oaVar, bArr, n(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferN = n(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferN2 = n(byteBuffer, iArr[length], iArr[i]);
                fs fsVar = new fs(byteBufferN);
                qg qgVar = new qg(bArr, byteBufferN2);
                n(qgVar, fsVar, 4096);
                qgVar.n();
                qgVar.qg();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                qg qgVar2 = new qg(bArr, ByteBuffer.wrap(bArr2));
                qgVar2.n(n(byteBuffer, 0, 4096));
                qgVar2.n();
                return bArr2;
            }
        }
    }

    private static ByteBuffer n(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
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
        n(byteBuffer, 22);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ByteBuffer n(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        n(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        n(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(n(j));
        n(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static int[] qg(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = n(j, c.m) * 32;
            arrayList.add(Long.valueOf(n(j, c.m) * c.m));
        } while (j > c.m);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + n(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void n(oa oaVar) {
        if (oaVar.qg % c.m != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + oaVar.qg);
        }
        if ((oaVar.s - oaVar.qg) % c.m != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (oaVar.s - oaVar.qg));
        }
    }

    private static ByteBuffer n(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void n(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long n(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int n(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
