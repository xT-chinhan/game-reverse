package com.byazt.ch;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 109})
public class w implements fw {
    public qa aj;
    public AtomicInteger c;
    public k fw;
    public AtomicInteger hn;
    public AtomicInteger hw;
    public AtomicInteger pr;
    public float uc;
    public AtomicInteger x;
    public ny zo;

    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith("http")) {
            this.hw.incrementAndGet();
        }
    }

    public int hw() {
        int i = (int) (this.uc * this.hw.get());
        this.pr.set(i);
        return i;
    }

    public boolean hn() {
        return this.pr.get() > 0;
    }

    public void pr(qa qaVar) {
        this.aj = qaVar;
    }

    public void pr(ny nyVar) {
        this.zo = nyVar;
    }

    @Override // com.byazt.ch.fw
    public void pr() {
        this.x.incrementAndGet();
        if (this.x.get() == 1) {
            synchronized (this) {
                this.x.get();
            }
        }
    }

    @Override // com.byazt.ch.fw
    public void pr(com.byazt.ik.hn hnVar, String str) {
        if (this.hn.incrementAndGet() == this.pr.get()) {
            synchronized (this) {
                if (this.hn.get() == this.pr.get()) {
                    if (this.fw != null) {
                        this.hw.get();
                    }
                    if (this.aj != null) {
                        cz czVar = new cz();
                        czVar.pr(0);
                        czVar.pr(hnVar.hw(hnVar));
                    }
                }
            }
        }
    }

    @Override // com.byazt.ch.fw
    public void hw(com.byazt.ik.hn hnVar, String str) {
        int iIncrementAndGet = this.c.incrementAndGet();
        if (iIncrementAndGet > this.hw.get() - this.pr.get()) {
            synchronized (this) {
                if (iIncrementAndGet > this.hw.get() - this.pr.get() && this.aj != null) {
                    cz czVar = new cz();
                    czVar.pr(-3);
                    czVar.pr("image download fail");
                    czVar.pr(hnVar.hw(hnVar));
                }
            }
        }
    }
}
