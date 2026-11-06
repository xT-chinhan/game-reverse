package com.byazt.uk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 20})
public class hn<P, R> implements Runnable {
    public hn<?, P> c;
    public int hn;
    public R hw;
    public P pr;
    public hn<R, ?> uc;
    public SoftReference<pr<P, R>> x;

    public interface pr<PARAM, RESULT> {
        RESULT pr(PARAM param);
    }

    private hn(int i, pr<P, R> prVar, P p) {
        this.hn = i;
        this.x = new SoftReference<>(prVar);
        this.pr = p;
    }

    public static <P, R> hn<P, R> pr(pr<P, R> prVar, P p) {
        return new hn<>(2, prVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> hn<R, NR> pr(int i, pr<R, NR> prVar) {
        hn hnVar = (hn<R, ?>) new hn(i, prVar, null);
        this.uc = hnVar;
        hnVar.c = this;
        return hnVar;
    }

    public <NR> hn<R, NR> pr(pr<R, NR> prVar) {
        return pr(0, prVar);
    }

    public void pr() {
        hn<?, P> hnVar = this.c;
        if (hnVar != null) {
            hnVar.pr();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        hn<?, P> hnVar;
        if (this.hn == 0 && !m.hw()) {
            com.byazt.cvl.zo.pr().hw().post(this);
            return;
        }
        if (this.hn == 1 && m.hw()) {
            com.byazt.cvl.c.pr().pr(this);
            return;
        }
        if (this.hn == 2 && m.hw()) {
            com.byazt.cvl.c.pr().hw(this);
            return;
        }
        if (this.pr == null && (hnVar = this.c) != null) {
            this.pr = hnVar.hw();
        }
        pr<P, R> prVar = this.x.get();
        if (prVar == null) {
            return;
        }
        this.hw = prVar.pr(this.pr);
        hn<R, ?> hnVar2 = this.uc;
        if (hnVar2 != null) {
            hnVar2.run();
        }
    }

    private R hw() {
        return this.hw;
    }
}
