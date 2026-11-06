package com.byazt.udb;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1064, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements tj {
    public ScheduledFuture<?> l;
    public Context n;
    public oa q;
    public com.byazt.gjp.n qg;
    public fs s;
    public AtomicBoolean w = new AtomicBoolean(false);

    public cy(Context context, oa oaVar, com.byazt.gjp.n nVar, fs fsVar) {
        this.n = context;
        this.q = oaVar;
        this.s = fsVar;
        this.qg = nVar;
        nVar.n(this.s);
    }

    @Override // com.byazt.udb.tj
    public boolean n(final tj.n nVar) {
        int iFs = this.q.fs();
        if (iFs < 0) {
            n(nVar, 107, "time is ".concat(String.valueOf(iFs)));
        } else {
            this.l = com.byazt.cq.l.n(new n(1, nVar), iFs, TimeUnit.MILLISECONDS);
            this.qg.n(new x() { // from class: com.byazt.udb.cy.1
                @Override // com.byazt.udb.x
                public void n(View view, sz szVar) {
                    k kVarQg;
                    cy.this.qg();
                    if (nVar.s() || (kVarQg = nVar.qg()) == null) {
                        return;
                    }
                    kVarQg.n(cy.this.qg, szVar);
                    nVar.n(true);
                }

                @Override // com.byazt.udb.x
                public void n(int i, String str) {
                    cy.this.n(nVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.byazt.udb.tj
    public void qg(boolean z) {
        this.qg.n(z);
        qg();
    }

    public com.byazt.gjp.n n() {
        return this.qg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg() {
        try {
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.l.cancel(false);
            this.l = null;
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1064, 1086})
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
                cy.this.qg.qg(true);
                cy.this.n(this.n, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(tj.n nVar, int i, String str) {
        k kVarQg;
        if (nVar.s() || this.w.get()) {
            return;
        }
        qg();
        this.q.x().n(i, str);
        if (nVar.qg(this)) {
            nVar.n(this);
        } else {
            if (nVar.s() || (kVarQg = nVar.qg()) == null) {
                return;
            }
            nVar.n(true);
            kVarQg.a_(i);
        }
        this.w.getAndSet(true);
    }
}
