package com.byazt.kbl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.hh.c;
import com.byazt.nn.fw;
import com.byazt.nn.x;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.qi;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX, 20})
public class hn implements c {
    public com.byazt.vkw.pr aj;
    public volatile Handler fw;
    public g k;
    public volatile com.byazt.av.hn uc;
    public Context vk;
    public k w;
    public com.byazt.hh.hw zo;
    public static final hw pr = new hw();
    public static final long x = System.currentTimeMillis();
    public static long c = 0;
    public volatile int hw = 0;
    public volatile int hn = 0;

    public hn(Context context, com.byazt.hh.hw hwVar, com.byazt.vkw.pr prVar, g gVar) {
        this.vk = context;
        this.zo = hwVar;
        this.aj = prVar;
        this.k = gVar;
        this.w = (k) uc.pr("csj_settings", prVar);
        this.uc = new com.byazt.av.hn(context, hwVar, this, prVar);
        this.uc.x();
    }

    @Override // com.byazt.hh.c
    public Context getContext() {
        return this.vk;
    }

    @Override // com.byazt.hh.c
    public g hw() {
        return this.k;
    }

    @Override // com.byazt.hh.c
    public com.byazt.hh.hw pr() {
        return this.zo;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public boolean hn() {
        return this.hw == 2;
    }

    public void hw(int i) {
        this.hn = i;
    }

    public boolean x() {
        return this.hn == 1;
    }

    @Override // com.byazt.hh.c
    public void pr(boolean z) {
        if (this.zo != null && z) {
            uc();
        }
    }

    public com.byazt.av.hn c() {
        return this.uc;
    }

    public void pr(Handler handler) {
        this.fw = handler;
    }

    @Override // com.byazt.hh.c
    public void pr(com.byazt.hh.pr prVar) {
        fw.pr("report()");
        if (prVar == null) {
            fw.c("error : log config is null");
            return;
        }
        com.byazt.hh.hn hnVarPr = this.zo.pr();
        com.byazt.av.hn hnVar = this.uc;
        if (hnVar != null) {
            hnVar.pr(this.aj);
            pr(hnVarPr, prVar);
            hnVar.pr(prVar, prVar.k() == 4);
        }
    }

    private void pr(final com.byazt.hh.hn hnVar, com.byazt.hh.pr prVar) {
        if (hnVar != null) {
            try {
                if (this.w.zo()) {
                    final long jG = 0;
                    if (prVar != null) {
                        jG = prVar.g();
                    }
                    if (jG == 1) {
                        c = System.currentTimeMillis();
                    }
                    hw hwVar = pr;
                    AtomicLong atomicLongYb = hwVar.yb();
                    com.byazt.nn.c.pr(atomicLongYb, 1, this.w);
                    if (TextUtils.equals("show", x.pr(prVar))) {
                        hwVar.e().incrementAndGet();
                    } else if (TextUtils.equals("click", x.pr(prVar))) {
                        hwVar.ls().incrementAndGet();
                    }
                    if (atomicLongYb.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            ((qi) uc.pr("thread_service")).pr().execute(new Runnable() { // from class: com.byazt.kbl.hn.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    hn.this.pr(hnVar, jG);
                                }
                            });
                        } else {
                            fw.pr("==> monitor upload index1:".concat(String.valueOf(jG)));
                            pr(hnVar, jG);
                        }
                    }
                }
            } catch (Exception e) {
                fw.pr("report", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.hh.hn hnVar, long j) {
        com.byazt.av.hn hnVar2 = this.uc;
        if (hnVar == null || hnVar2 == null) {
            return;
        }
        hw hwVar = pr;
        hnVar.pr(hwVar.pr(j, this.aj));
        hwVar.uc();
    }

    public void uc() {
        com.byazt.hh.hw hwVar = this.zo;
        if (hwVar == null || hwVar.pr() == null) {
            fw.hn("discard flush config is null");
            return;
        }
        fw.hn("flushMemoryAndDB");
        final com.byazt.av.hn hnVar = this.uc;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ((qi) uc.pr("thread_service")).hw().execute(new Runnable() { // from class: com.byazt.kbl.hn.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.av.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(72, "start_child1");
                    }
                }
            });
        } else if (hnVar != null) {
            hnVar.pr(72, "start_child2");
        }
    }
}
