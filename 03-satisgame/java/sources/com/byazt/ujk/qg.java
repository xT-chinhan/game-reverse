package com.byazt.ujk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 26})
public class qg {
    public final ByteBuffer l;
    public final long n;
    public final long q;
    public final long qg;
    public final int s;

    public qg(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
        this.n = j;
        this.qg = j2;
        this.s = i;
        this.q = j3;
        this.l = byteBuffer;
    }

    public long n() {
        return this.n;
    }

    public long qg() {
        return this.qg;
    }

    public int s() {
        return this.s;
    }

    public long q() {
        return this.q;
    }

    public ByteBuffer l() {
        return this.l;
    }
}
