package com.byazt.cd;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1393, 13})
public class hw {
    public static com.byazt.ff.hw pr(com.byazt.ly.hw hwVar) throws com.byazt.ff.pr, IOException {
        Pair<ByteBuffer, Long> pairPr = com.byazt.dk.pr.pr(hwVar);
        if (pairPr == null) {
            throw new com.byazt.ff.pr("ZIP End of Central Directory record not found");
        }
        ByteBuffer byteBuffer = (ByteBuffer) pairPr.first;
        long jLongValue = ((Long) pairPr.second).longValue();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        long jPr = com.byazt.dk.pr.pr(byteBuffer);
        if (jPr > jLongValue) {
            throw new com.byazt.ff.pr("ZIP Central Directory start offset out of range: " + jPr + ". ZIP End of Central Directory offset: " + jLongValue);
        }
        long jHw = com.byazt.dk.pr.hw(byteBuffer);
        long j = jPr + jHw;
        if (j > jLongValue) {
            throw new com.byazt.ff.pr("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j + ", EoCD start: " + jLongValue);
        }
        return new com.byazt.ff.hw(jPr, jHw, com.byazt.dk.pr.hn(byteBuffer), jLongValue, byteBuffer);
    }

    public static pr pr(com.byazt.ly.hw hwVar, com.byazt.ff.hw hwVar2) throws Exception {
        long jPr = hwVar2.pr();
        long jHw = hwVar2.hw() + jPr;
        long jX = hwVar2.x();
        if (jHw != jX) {
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + jHw + ", EoCD start: " + jX);
        }
        if (jPr < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(jPr)));
        }
        ByteBuffer byteBufferPr = hwVar.pr(jPr - 24, 24);
        byteBufferPr.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBufferPr.getLong(8) != 2334950737559900225L || byteBufferPr.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j = byteBufferPr.getLong(0);
        if (j < byteBufferPr.capacity() || j > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j)));
        }
        long j2 = (int) (8 + j);
        long j3 = jPr - j2;
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferPr2 = hwVar.pr(j3, 8);
        byteBufferPr2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = byteBufferPr2.getLong(0);
        if (j4 != j) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j);
        }
        return new pr(j3, hwVar.pr(j3, j2));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1393, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class pr {
        public final com.byazt.ly.hw hw;
        public final long pr;

        public pr(long j, com.byazt.ly.hw hwVar) {
            this.pr = j;
            this.hw = hwVar;
        }

        public long pr() {
            return this.pr;
        }

        public com.byazt.ly.hw hw() {
            return this.hw;
        }
    }
}
