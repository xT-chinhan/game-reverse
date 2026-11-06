package com.byazt.ee;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, 121})
public abstract class x<P, R> extends com.byazt.ee.hw<P, R> {
    public uc hn;
    public pr hw;
    public boolean pr = true;

    public interface hw {
        x pr();
    }

    interface pr {
        void pr(Object obj);

        void pr(Throwable th);
    }

    public abstract void pr(P p, uc ucVar) throws Exception;

    public abstract void x();

    @Override // com.byazt.ee.hw
    public /* bridge */ /* synthetic */ String pr() {
        return super.pr();
    }

    public final void pr(R r) {
        if (fw()) {
            this.hw.pr(r);
            c();
        }
    }

    public final void pr(Throwable th) {
        if (fw()) {
            this.hw.pr(th);
            c();
        }
    }

    public final void hn() {
        pr((Throwable) null);
    }

    public void c() {
        this.pr = false;
        this.hn = null;
    }

    public void pr(P p, uc ucVar, pr prVar) throws Exception {
        this.hn = ucVar;
        this.hw = prVar;
        pr(p, ucVar);
    }

    public void uc() {
        x();
        c();
    }

    private boolean fw() {
        if (!this.pr) {
            aj.pr(new IllegalStateException("Jsb async call already finished: " + pr() + ", hashcode: " + hashCode()));
            return false;
        }
        return true;
    }
}
