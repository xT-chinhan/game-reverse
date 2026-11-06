package com.byazt.gox;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ec.g;
import com.byazt.ec.w;
import com.byazt.kg.aj;
import com.byazt.kg.vk;
import com.byazt.xa.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 62})
public class fw {
    public static pr ho;
    public static final AtomicLong uc = new AtomicLong(1000);
    public long aj = -1;
    public String c;
    public long fw;
    public com.byazt.kg.uc g;
    public aj hn;
    public final com.byazt.xa.aj hw;
    public int k;
    public String m;
    public final zo pr;
    public volatile boolean vk;
    public long w;
    public aj x;
    public int zo;

    public fw(com.byazt.xa.aj ajVar, zo zoVar) {
        this.hw = ajVar;
        this.pr = zoVar;
    }

    public String pr() {
        return this.c;
    }

    public synchronized Bundle pr(long j, long j2) {
        Bundle bundle;
        bundle = null;
        if (this.pr.uc() && hn()) {
            long j3 = this.fw;
            if (j3 > 0 && j - j3 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.k);
                int i = this.zo + 1;
                this.zo = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.fw) / 1000);
                bundle.putString(u.a, com.byazt.kg.pr.hw(this.aj));
                this.fw = j;
            }
        }
        return bundle;
    }

    public boolean hw() {
        return this.vk;
    }

    public boolean hn() {
        return hw() && this.w == 0;
    }

    private synchronized void pr(com.byazt.kg.pr prVar, ArrayList<com.byazt.kg.pr> arrayList, boolean z) {
        long j = prVar instanceof pr ? -1L : prVar.hw;
        this.c = UUID.randomUUID().toString();
        uc.set(1000L);
        this.aj = j;
        this.vk = z;
        this.w = 0L;
        this.fw = 0L;
        if (w.hw) {
            w.pr("startSession, " + this.c + ", hadUi:" + z + " data:" + prVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.m)) {
                this.m = this.pr.hn();
                this.k = this.pr.x();
            }
            if (!string.equals(this.m)) {
                this.m = string;
                this.k = 1;
            } else {
                this.k++;
            }
            this.pr.pr(string, this.k);
            this.zo = 0;
            this.fw = prVar.hw;
        }
        if (j != -1) {
            com.byazt.kg.uc ucVar = new com.byazt.kg.uc(false);
            ucVar.x = this.c;
            ucVar.hn = x();
            ucVar.hw = this.aj;
            ucVar.g = this.vk ? false : true;
            ucVar.m = this.hw.hn();
            ucVar.k = this.hw.hw();
            ucVar.uc = com.byazt.zrg.pr.w();
            ucVar.fw = com.byazt.zrg.pr.vk();
            if (this.pr.cz()) {
                ucVar.zo = com.byazt.zrg.pr.c();
            }
            arrayList.add(ucVar);
            this.g = ucVar;
            if (w.hw) {
                w.pr("gen launch, " + ucVar.x + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean pr(com.byazt.kg.pr prVar) {
        if (prVar instanceof aj) {
            return ((aj) prVar).vk();
        }
        return false;
    }

    public boolean pr(com.byazt.kg.pr prVar, ArrayList<com.byazt.kg.pr> arrayList) {
        boolean z = prVar instanceof aj;
        boolean zPr = pr(prVar);
        boolean z2 = true;
        if (this.aj == -1) {
            pr(prVar, arrayList, pr(prVar));
        } else if (!this.vk && zPr) {
            pr(prVar, arrayList, true);
        } else if (this.w == 0 || prVar.hw <= this.w + this.pr.fo()) {
            if (this.aj > prVar.hw + 7200000) {
                pr(prVar, arrayList, zPr);
            } else {
                z2 = false;
            }
        } else if (!g.hw() && g.pr()) {
            pr(prVar, arrayList, zPr);
        }
        if (z) {
            aj ajVar = (aj) prVar;
            if (ajVar.vk()) {
                this.w = 0L;
                arrayList.add(prVar);
                if (TextUtils.isEmpty(ajVar.m)) {
                    if (this.x != null && (ajVar.hw - this.x.hw) - this.x.k < 500) {
                        ajVar.m = this.x.g;
                    } else if (this.hn != null && (ajVar.hw - this.hn.hw) - this.hn.k < 500) {
                        ajVar.m = this.hn.g;
                    }
                }
            } else {
                Bundle bundlePr = pr(prVar.hw, 0L);
                if (bundlePr != null) {
                    com.byazt.zrg.pr.pr("play_session", bundlePr);
                }
                this.w = ajVar.hw;
                arrayList.add(prVar);
                if (ajVar.w()) {
                    this.hn = ajVar;
                } else {
                    this.x = ajVar;
                    this.hn = null;
                }
            }
        } else if (!(prVar instanceof pr)) {
            arrayList.add(prVar);
        }
        hw(prVar);
        return z2;
    }

    public void hw(com.byazt.kg.pr prVar) {
        if (prVar != null) {
            if (this.pr.cz()) {
                prVar.zo = com.byazt.zrg.pr.c();
            }
            prVar.uc = com.byazt.zrg.pr.w();
            prVar.fw = com.byazt.zrg.pr.vk();
            prVar.x = this.c;
            prVar.hn = x();
        }
    }

    public static long x() {
        return uc.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 766})
    static class pr extends vk {
        private pr() {
        }
    }

    public static pr c() {
        if (ho == null) {
            ho = new pr();
        }
        ho.hw = System.currentTimeMillis();
        return ho;
    }
}
