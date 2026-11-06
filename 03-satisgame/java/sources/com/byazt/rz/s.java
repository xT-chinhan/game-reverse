package com.byazt.rz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 8})
public class s<P, R> implements Runnable {
    public s<?, P> l;
    public P n;
    public SoftReference<n<P, R>> q;
    public R qg;
    public int s;
    public s<R, ?> w;

    public interface n<PARAM, RESULT> {
        RESULT n(PARAM param);
    }

    private s(int i, n<P, R> nVar, P p) {
        this.s = i;
        this.q = new SoftReference<>(nVar);
        this.n = p;
    }

    public static <P, R> s<P, R> n(n<P, R> nVar, P p) {
        return new s<>(2, nVar, p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> s<R, NR> n(int i, n<R, NR> nVar) {
        s sVar = (s<R, ?>) new s(i, nVar, null);
        this.w = sVar;
        sVar.l = this;
        return sVar;
    }

    public <NR> s<R, NR> n(n<R, NR> nVar) {
        return n(0, nVar);
    }

    public void n() {
        s<?, P> sVar = this.l;
        if (sVar != null) {
            sVar.n();
        } else {
            run();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        s<?, P> sVar;
        if (this.s == 0 && !oa.qg()) {
            com.byazt.s.fs.n().qg().post(this);
            return;
        }
        if (this.s == 1 && oa.qg()) {
            com.byazt.s.l.n().n(this);
            return;
        }
        if (this.s == 2 && oa.qg()) {
            com.byazt.s.l.n().qg(this);
            return;
        }
        if (this.n == null && (sVar = this.l) != null) {
            this.n = sVar.qg();
        }
        n<P, R> nVar = this.q.get();
        if (nVar == null) {
            return;
        }
        this.qg = nVar.n(this.n);
        s<R, ?> sVar2 = this.w;
        if (sVar2 != null) {
            sVar2.run();
        }
    }

    private R qg() {
        return this.qg;
    }
}
