package com.byazt.sl;

import com.byazt.ld.lb;
import com.byazt.ld.nl;
import com.byazt.ld.qa;
import com.byazt.ld.s;
import com.byazt.ld.ww;
import com.byazt.ld.y;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 4, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c implements qa {
    public s aj;
    public ww c;
    public nl fw;
    public com.byazt.ld.c hn;
    public ExecutorService hw;
    public lb pr;
    public com.byazt.ld.x uc;
    public y x;
    public com.byazt.ld.hw zo;

    private c(pr prVar) {
        this.pr = prVar.pr;
        this.hw = prVar.hw;
        this.hn = prVar.hn;
        this.x = prVar.x;
        this.c = prVar.c;
        this.uc = prVar.uc;
        this.zo = prVar.zo;
        this.fw = prVar.fw;
        this.aj = prVar.aj;
    }

    @Override // com.byazt.ld.qa
    public lb pr() {
        return this.pr;
    }

    @Override // com.byazt.ld.qa
    public ExecutorService hw() {
        return this.hw;
    }

    @Override // com.byazt.ld.qa
    public com.byazt.ld.c x() {
        return this.hn;
    }

    @Override // com.byazt.ld.qa
    public y c() {
        return this.x;
    }

    @Override // com.byazt.ld.qa
    public ww uc() {
        return this.c;
    }

    @Override // com.byazt.ld.qa
    public com.byazt.ld.x fw() {
        return this.uc;
    }

    @Override // com.byazt.ld.qa
    public nl zo() {
        return this.fw;
    }

    @Override // com.byazt.ld.qa
    public s hn() {
        return this.aj;
    }

    @Override // com.byazt.ld.qa
    public com.byazt.ld.hw aj() {
        return this.zo;
    }

    public static c vk() {
        return new pr().pr();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 4, 169})
    public static class pr {
        public s aj;
        public ww c;
        public nl fw;
        public com.byazt.ld.c hn;
        public ExecutorService hw;
        public lb pr;
        public com.byazt.ld.x uc;
        public y x;
        public com.byazt.ld.hw zo;

        public pr pr(com.byazt.ld.hw hwVar) {
            this.zo = hwVar;
            return this;
        }

        public pr pr(ExecutorService executorService) {
            this.hw = executorService;
            return this;
        }

        public pr pr(com.byazt.ld.c cVar) {
            this.hn = cVar;
            return this;
        }

        public c pr() {
            return new c(this);
        }
    }
}
