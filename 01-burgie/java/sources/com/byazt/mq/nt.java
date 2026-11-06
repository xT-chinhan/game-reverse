package com.byazt.mq;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 427, 74})
public class nt implements vk {
    public ScheduledFuture<?> c;
    public zo hn;
    public com.byazt.kq.pr hw;
    public Context pr;
    public AtomicBoolean uc = new AtomicBoolean(false);
    public m x;

    public nt(Context context, m mVar, com.byazt.kq.pr prVar, zo zoVar) {
        this.pr = context;
        this.x = mVar;
        this.hn = zoVar;
        this.hw = prVar;
        prVar.pr(this.hn);
    }

    @Override // com.byazt.mq.vk
    public boolean pr(final vk.pr prVar) {
        int iZo = this.x.zo();
        if (iZo < 0) {
            pr(prVar, 107, "time is ".concat(String.valueOf(iZo)));
        } else {
            this.c = com.byazt.js.c.pr(new pr(1, prVar), iZo, TimeUnit.MILLISECONDS);
            this.hw.pr(new fw() { // from class: com.byazt.mq.nt.1
                @Override // com.byazt.mq.fw
                public void pr(View view, g gVar) {
                    ho hoVarHw;
                    nt.this.hw();
                    if (!prVar.hn() && (hoVarHw = prVar.hw()) != null) {
                        hoVarHw.pr(nt.this.hw, gVar);
                        prVar.pr(true);
                    }
                }

                @Override // com.byazt.mq.fw
                public void pr(int i, String str) {
                    nt.this.pr(prVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.byazt.mq.vk
    public void hw(boolean z) {
        this.hw.pr(z);
        hw();
    }

    public com.byazt.kq.pr pr() {
        return this.hw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw() {
        try {
            ScheduledFuture<?> scheduledFuture = this.c;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.c.cancel(false);
                this.c = null;
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 427, 350})
    private class pr implements Runnable {
        public int hn;
        public vk.pr pr;

        public pr(int i, vk.pr prVar) {
            this.hn = i;
            this.pr = prVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hn == 1) {
                nt.this.hw.hw(true);
                nt.this.pr(this.pr, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(vk.pr prVar, int i, String str) {
        ho hoVarHw;
        if (prVar.hn() || this.uc.get()) {
            return;
        }
        hw();
        this.x.fw().pr(i, str);
        if (prVar.hw(this)) {
            prVar.pr(this);
        } else {
            if (prVar.hn() || (hoVarHw = prVar.hw()) == null) {
                return;
            }
            prVar.pr(true);
            hoVarHw.a_(i);
        }
        this.uc.getAndSet(true);
    }
}
