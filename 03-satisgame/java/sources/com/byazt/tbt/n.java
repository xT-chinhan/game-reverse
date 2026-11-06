package com.byazt.tbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 19})
public final class n {
    public final boolean n;

    public n(C0349n c0349n) {
        this.n = c0349n.n;
    }

    /* JADX INFO: renamed from: com.byazt.tbt.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1089, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static final class C0349n {
        public boolean n;

        public C0349n n() {
            this.n = true;
            return this;
        }

        public n qg() {
            return new n(this);
        }
    }
}
