package com.byazt.lro;

import android.support.v4.media.session.PlaybackStateCompat;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 62})
public abstract class fw {
    public static final byte[] pr = new byte[8];

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 766})
    static class pr {
        public final byte[] hw;
        public final ByteBuffer pr;

        public pr(ByteBuffer byteBuffer, byte[] bArr) {
            this.pr = byteBuffer;
            this.hw = bArr;
        }
    }

    public static pr pr(RandomAccessFile randomAccessFile, m mVar, aj ajVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int[] iArrHw = hw(randomAccessFile.length() - (mVar.hn - mVar.hw));
        int i = iArrHw[iArrHw.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferPr = ajVar.pr(i2);
        byteBufferPr.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferPr2 = pr(byteBufferPr, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferPr3 = pr(byteBufferPr, i, i3);
        ByteBuffer byteBufferPr4 = pr(byteBufferPr, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        pr(randomAccessFile, mVar, byteBufferPr2, byteBufferWrap, byteBufferPr3, byteBufferPr4);
        byteBufferPr.position(i3 + byteBufferPr4.limit());
        byteBufferPr.putInt(byteBufferPr4.limit() + 64 + 4);
        byteBufferPr.flip();
        return new pr(byteBufferPr, bArr);
    }

    private static void pr(RandomAccessFile randomAccessFile, m mVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        pr(mVar);
        long j = mVar.hn - mVar.hw;
        int[] iArrHw = hw(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrPr = pr(randomAccessFile, mVar, pr, iArrHw, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrPr);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            pr(byteBuffer3, randomAccessFile.length(), iArrHw.length - 1, pr);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            pr(byteBuffer4, mVar.hw, j, mVar.x);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 984})
    private static class hw implements vk {
        public final byte[] c;
        public final MessageDigest hn;
        public final ByteBuffer hw;
        public int pr;
        public final byte[] x;

        private hw(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.x = new byte[32];
            this.c = bArr;
            this.hw = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.hn = messageDigest;
            messageDigest.update(bArr);
            this.pr = 0;
        }

        @Override // com.byazt.lro.vk
        public void pr(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.pr);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.hn.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.pr + iMin;
                this.pr = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.hn;
                    byte[] bArr = this.x;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.hw.put(this.x);
                    this.hn.update(this.c);
                    this.pr = 0;
                }
            }
        }

        public void pr() throws DigestException {
            if (this.pr != 0) {
                throw new IllegalStateException("Buffer is not empty: " + this.pr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hw() {
            int iPosition = this.hw.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.hw.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    private static void pr(vk vkVar, w wVar, int i) throws DigestException, IOException {
        long jPr = wVar.pr();
        long j = 0;
        while (jPr > 0) {
            int iMin = (int) Math.min(jPr, i);
            wVar.pr(vkVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jPr -= j2;
        }
    }

    private static void pr(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        hw hwVar = new hw(bArr, byteBuffer);
        pr(hwVar, new k(randomAccessFile.getFD(), 0L, mVar.hw), 1048576);
        long j = mVar.x + 16;
        pr(hwVar, new k(randomAccessFile.getFD(), mVar.hn, j - mVar.hn), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(pr(mVar.hw));
        byteBufferOrder.flip();
        hwVar.pr(byteBufferOrder);
        long j2 = j + 4;
        pr(hwVar, new k(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        if (length != 0) {
            hwVar.pr(ByteBuffer.allocate(4096 - length));
        }
        hwVar.pr();
        hwVar.hw();
    }

    private static byte[] pr(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        pr(randomAccessFile, mVar, bArr, pr(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferPr = pr(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferPr2 = pr(byteBuffer, iArr[length], iArr[i]);
                zo zoVar = new zo(byteBufferPr);
                hw hwVar = new hw(bArr, byteBufferPr2);
                pr(hwVar, zoVar, 4096);
                hwVar.pr();
                hwVar.hw();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                hw hwVar2 = new hw(bArr, ByteBuffer.wrap(bArr2));
                hwVar2.pr(pr(byteBuffer, 0, 4096));
                hwVar2.pr();
                return bArr2;
            }
        }
    }

    private static ByteBuffer pr(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
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
        pr(byteBuffer, 22);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ByteBuffer pr(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        pr(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        pr(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(pr(j));
        pr(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static int[] hw(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = pr(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * 32;
            arrayList.add(Long.valueOf(pr(j, PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        } while (j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + pr(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void pr(m mVar) {
        if (mVar.hw % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.hw);
        }
        if ((mVar.hn - mVar.hw) % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.hn - mVar.hw));
        }
    }

    private static ByteBuffer pr(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void pr(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long pr(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int pr(long j) {
        int i = (int) j;
        if (i != j) {
            throw new ArithmeticException("integer overflow");
        }
        return i;
    }
}
