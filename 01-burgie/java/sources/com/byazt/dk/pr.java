package com.byazt.dk;

import android.support.v4.internal.view.SupportMenu;
import android.util.Pair;
import com.byazt.ly.hw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 37})
public abstract class pr {
    public static long pr(ByteBuffer byteBuffer) {
        x(byteBuffer);
        return hw(byteBuffer, byteBuffer.position() + 16);
    }

    public static long hw(ByteBuffer byteBuffer) {
        x(byteBuffer);
        return hw(byteBuffer, byteBuffer.position() + 12);
    }

    public static int hn(ByteBuffer byteBuffer) {
        x(byteBuffer);
        return pr(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> pr(hw hwVar) throws IOException {
        if (hwVar.pr() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairPr = pr(hwVar, 0);
        if (pairPr != null) {
            return pairPr;
        }
        return pr(hwVar, SupportMenu.USER_MASK);
    }

    private static Pair<ByteBuffer, Long> pr(hw hwVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jPr = hwVar.pr();
        if (jPr < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jPr - 22)) + 22;
        long j = jPr - ((long) iMin);
        ByteBuffer byteBufferPr = hwVar.pr(j, iMin);
        byteBufferPr.order(ByteOrder.LITTLE_ENDIAN);
        int iC = c(byteBufferPr);
        if (iC == -1) {
            return null;
        }
        byteBufferPr.position(iC);
        ByteBuffer byteBufferSlice = byteBufferPr.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iC)));
    }

    private static int c(ByteBuffer byteBuffer) {
        x(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, SupportMenu.USER_MASK);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && pr(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static void x(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int pr(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    public static long hw(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }
}
