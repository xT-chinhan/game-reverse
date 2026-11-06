package com.byazt.gxb;

import com.byazt.si.ae;
import com.byazt.si.cd;
import com.byazt.si.lh;
import com.byazt.si.ln;
import com.byazt.si.um;
import com.byazt.si.v;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 790, 18})
public final class l implements um {
    public com.byazt.si.qg fs;
    public v l;
    public cd n;
    public lh q;
    public ExecutorService qg;
    public ae rv;
    public com.byazt.si.l s;
    public com.byazt.si.q w;
    public ln x;

    private l(n nVar) {
        this.n = nVar.n;
        this.qg = nVar.qg;
        this.s = nVar.s;
        this.q = nVar.q;
        this.l = nVar.l;
        this.w = nVar.w;
        this.fs = nVar.fs;
        this.x = nVar.x;
        this.rv = nVar.rv;
    }

    @Override // com.byazt.si.um
    public cd n() {
        return this.n;
    }

    @Override // com.byazt.si.um
    public ExecutorService qg() {
        return this.qg;
    }

    @Override // com.byazt.si.um
    public com.byazt.si.l q() {
        return this.s;
    }

    @Override // com.byazt.si.um
    public lh l() {
        return this.q;
    }

    @Override // com.byazt.si.um
    public v w() {
        return this.l;
    }

    @Override // com.byazt.si.um
    public com.byazt.si.q x() {
        return this.w;
    }

    @Override // com.byazt.si.um
    public ln fs() {
        return this.x;
    }

    @Override // com.byazt.si.um
    public ae s() {
        return this.rv;
    }

    @Override // com.byazt.si.um
    public com.byazt.si.qg rv() {
        return this.fs;
    }

    public static l tj() {
        return new n().n();
    }

    @com.byazt.cp.n(n = {0, 1, 790, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public com.byazt.si.qg fs;
        public v l;
        public cd n;
        public lh q;
        public ExecutorService qg;
        public ae rv;
        public com.byazt.si.l s;
        public com.byazt.si.q w;
        public ln x;

        public n n(com.byazt.si.qg qgVar) {
            this.fs = qgVar;
            return this;
        }

        public n n(ExecutorService executorService) {
            this.qg = executorService;
            return this;
        }

        public n n(com.byazt.si.l lVar) {
            this.s = lVar;
            return this;
        }

        public l n() {
            return new l(this);
        }
    }
}
