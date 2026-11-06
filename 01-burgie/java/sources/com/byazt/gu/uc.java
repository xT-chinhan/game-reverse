package com.byazt.gu;

import android.content.Context;
import android.view.View;
import com.byazt.ch.cz;
import com.byazt.mq.g;
import com.byazt.mq.ho;
import com.byazt.mq.m;
import com.byazt.mq.vk;
import com.byazt.mq.zo;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, 5})
public class uc implements vk {
    public AtomicBoolean c = new AtomicBoolean(false);
    public m hn;
    public c hw;
    public Context pr;
    public ScheduledFuture<?> x;

    public uc(Context context, c cVar, zo zoVar, m mVar, com.byazt.fy.hw hwVar) {
        this.pr = context;
        this.hw = cVar;
        this.hn = mVar;
        this.hw.pr(zoVar);
        this.hw.pr(hwVar);
    }

    @Override // com.byazt.mq.vk
    public boolean pr(final vk.pr prVar) {
        int iZo = this.hn.zo();
        if (iZo >= 0) {
            this.x = ((qi) com.byazt.zs.uc.pr("thread_service")).zo().schedule(new pr(1, prVar), iZo, TimeUnit.MILLISECONDS);
            this.hw.pr(new com.byazt.mq.fw() { // from class: com.byazt.gu.uc.1
                @Override // com.byazt.mq.fw
                public void pr(View view, g gVar) {
                    if (prVar.hn()) {
                        return;
                    }
                    cz czVar = new cz();
                    czVar.pr(0);
                    ((hw) uc.this.hn).n().pr(czVar);
                    uc.this.hn.fw().m();
                    ho hoVarHw = prVar.hw();
                    if (hoVarHw != null) {
                        hoVarHw.pr(uc.this.hw, gVar);
                        prVar.pr(true);
                    }
                }

                @Override // com.byazt.mq.fw
                public void pr(int i, String str) {
                    ho hoVarHw;
                    cz czVar = new cz();
                    czVar.pr(i);
                    czVar.pr(str);
                    ((hw) uc.this.hn).n().pr(czVar);
                    if (prVar.hw(uc.this)) {
                        prVar.pr(uc.this);
                    } else {
                        if (prVar.hn() || (hoVarHw = prVar.hw()) == null) {
                            return;
                        }
                        hoVarHw.a_(i);
                    }
                }
            });
        } else {
            pr(prVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        }
        return true;
    }

    @Override // com.byazt.mq.vk
    public void hw(boolean z) {
        c cVar = this.hw;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    private void pr() {
        try {
            ScheduledFuture<?> scheduledFuture = this.x;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.x.cancel(false);
                this.x = null;
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 665, 129})
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
                uc.this.hw.hw(true);
                uc.this.pr(this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(vk.pr prVar, int i) {
        ho hoVarHw;
        if (prVar.hn() || this.c.get()) {
            return;
        }
        pr();
        cz czVar = new cz();
        czVar.pr(i);
        ((hw) this.hn).n().pr(czVar);
        if (prVar.hw(this)) {
            prVar.pr(this);
        } else {
            if (prVar.hn() || (hoVarHw = prVar.hw()) == null) {
                return;
            }
            prVar.pr(true);
            hoVarHw.a_(i);
        }
        this.c.getAndSet(true);
    }
}
