package com.byazt.asa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, 19})
public class n implements com.byazt.vr.qg {
    public com.byazt.vr.w l;
    public int n;
    public com.byazt.vr.w q;
    public com.byazt.vr.w qg;
    public com.byazt.vr.w s;
    public com.byazt.vr.s w;

    private n() {
        this.n = -1;
    }

    @Override // com.byazt.vr.qg
    public com.byazt.vr.s n() {
        return this.w;
    }

    @Override // com.byazt.vr.qg
    public com.byazt.vr.w qg() {
        return this.qg;
    }

    @Override // com.byazt.vr.qg
    public com.byazt.vr.w s() {
        return this.s;
    }

    @Override // com.byazt.vr.qg
    public com.byazt.vr.w q() {
        return this.q;
    }

    @Override // com.byazt.vr.qg
    public com.byazt.vr.w l() {
        return this.l;
    }

    @Override // com.byazt.vr.qg
    public int w() {
        return this.n;
    }

    /* JADX INFO: renamed from: com.byazt.asa.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0129n {
        public com.byazt.vr.s l;
        public com.byazt.vr.w n;
        public com.byazt.vr.w q;
        public com.byazt.vr.w qg;
        public com.byazt.vr.w s;
        public final AtomicBoolean w = new AtomicBoolean(false);
        public int x = 5000;
        public int fs = 10;
        public int rv = -1;
        public int tj = -1;

        public C0129n n(com.byazt.vr.s sVar) {
            this.l = sVar;
            return this;
        }

        public C0129n n(int i) {
            this.tj = i;
            return this;
        }

        public n n() {
            n nVar = new n();
            nVar.qg = this.n;
            nVar.s = this.qg;
            nVar.q = this.s;
            nVar.l = this.q;
            nVar.w = this.l;
            nVar.n = this.tj;
            return nVar;
        }
    }
}
