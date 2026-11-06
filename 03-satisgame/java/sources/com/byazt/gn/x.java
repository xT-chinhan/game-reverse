package com.byazt.gn;

import android.content.Context;
import android.view.View;
import com.byazt.udb.k;
import com.byazt.udb.oa;
import com.byazt.udb.sz;
import com.byazt.udb.tj;
import com.byazt.vf.wo;
import com.byazt.vh.py;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 21})
public class x implements tj {
    public AtomicBoolean l = new AtomicBoolean(false);
    public Context n;
    public ScheduledFuture<?> q;
    public w qg;
    public oa s;

    public x(Context context, w wVar, com.byazt.udb.fs fsVar, oa oaVar, com.byazt.li.qg qgVar) {
        this.n = context;
        this.qg = wVar;
        this.s = oaVar;
        this.qg.n(fsVar);
        this.qg.n(qgVar);
    }

    @Override // com.byazt.udb.tj
    public boolean n(final tj.n nVar) {
        int iFs = this.s.fs();
        if (iFs < 0) {
            n(nVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        } else {
            this.q = ((wo) com.byazt.qp.q.n("thread_service")).fs().schedule(new n(1, nVar), iFs, TimeUnit.MILLISECONDS);
            this.qg.n(new com.byazt.udb.x() { // from class: com.byazt.gn.x.1
                @Override // com.byazt.udb.x
                public void n(View view, sz szVar) {
                    if (nVar.s()) {
                        return;
                    }
                    py pyVar = new py();
                    pyVar.n(0);
                    ((s) x.this.s).j().n(pyVar);
                    x.this.s.x().oa();
                    k kVarQg = nVar.qg();
                    if (kVarQg == null) {
                        return;
                    }
                    kVarQg.n(x.this.qg, szVar);
                    nVar.n(true);
                }

                @Override // com.byazt.udb.x
                public void n(int i, String str) {
                    k kVarQg;
                    py pyVar = new py();
                    pyVar.n(i);
                    pyVar.n(str);
                    ((s) x.this.s).j().n(pyVar);
                    if (nVar.qg(x.this)) {
                        nVar.n(x.this);
                    } else {
                        if (nVar.s() || (kVarQg = nVar.qg()) == null) {
                            return;
                        }
                        kVarQg.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.byazt.udb.tj
    public void qg(boolean z) {
        w wVar = this.qg;
        if (wVar != null) {
            wVar.n(z);
        }
    }

    private void n() {
        try {
            ScheduledFuture<?> scheduledFuture = this.q;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.q.cancel(false);
            this.q = null;
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private class n implements Runnable {
        public tj.n n;
        public int s;

        public n(int i, tj.n nVar) {
            this.s = i;
            this.n = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.s == 1) {
                x.this.qg.qg(true);
                x.this.n(this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(tj.n nVar, int i) {
        k kVarQg;
        if (nVar.s() || this.l.get()) {
            return;
        }
        n();
        py pyVar = new py();
        pyVar.n(i);
        ((s) this.s).j().n(pyVar);
        if (nVar.qg(this)) {
            nVar.n(this);
        } else {
            if (nVar.s() || (kVarQg = nVar.qg()) == null) {
                return;
            }
            nVar.n(true);
            kVarQg.a_(i);
        }
        this.l.getAndSet(true);
    }
}
