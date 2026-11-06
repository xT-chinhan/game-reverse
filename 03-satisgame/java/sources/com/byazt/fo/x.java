package com.byazt.fo;

import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.km.cp;
import com.byazt.km.sz;
import com.byazt.ko.fs;
import com.byazt.yi.rv;
import com.byazt.yi.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1154, 21})
public class x {
    public static n k;
    public static final AtomicLong w = new AtomicLong(1000);
    public long cp;
    public int d;
    public int fs;
    public String l;
    public final fs n;
    public String oa;
    public rv q;
    public final com.byazt.ko.rv qg;
    public long rv = -1;
    public rv s;
    public com.byazt.yi.w sz;
    public volatile boolean tj;
    public long x;

    public x(com.byazt.ko.rv rvVar, fs fsVar) {
        this.qg = rvVar;
        this.n = fsVar;
    }

    public String n() {
        return this.l;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    public synchronized Bundle n(long j, long j2) {
        Bundle bundle;
        if (this.n.w() && s()) {
            long j3 = this.x;
            if (j3 <= 0 || j - j3 <= j2) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putInt("session_no", this.d);
                int i = this.fs + 1;
                this.fs = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", (j - this.x) / 1000);
                bundle.putString("session_start_time", com.byazt.yi.n.qg(this.rv));
                this.x = j;
            }
        } else {
            bundle = null;
        }
        return bundle;
    }

    public boolean qg() {
        return this.tj;
    }

    public boolean s() {
        return qg() && this.cp == 0;
    }

    private synchronized void n(com.byazt.yi.n nVar, ArrayList<com.byazt.yi.n> arrayList, boolean z) {
        long j = nVar instanceof n ? -1L : nVar.qg;
        this.l = UUID.randomUUID().toString();
        w.set(1000L);
        this.rv = j;
        this.tj = z;
        this.cp = 0L;
        this.x = 0L;
        if (cp.qg) {
            cp.n("startSession, " + this.l + ", hadUi:" + z + " data:" + nVar, null);
        }
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String string = new StringBuilder().append(calendar.get(1)).append(calendar.get(2)).append(calendar.get(5)).toString();
            if (TextUtils.isEmpty(this.oa)) {
                this.oa = this.n.s();
                this.d = this.n.q();
            }
            if (!string.equals(this.oa)) {
                this.oa = string;
                this.d = 1;
            } else {
                this.d++;
            }
            this.n.n(string, this.d);
            this.fs = 0;
            this.x = nVar.qg;
        }
        if (j != -1) {
            com.byazt.yi.w wVar = new com.byazt.yi.w(false);
            wVar.q = this.l;
            wVar.s = q();
            wVar.qg = this.rv;
            wVar.sz = this.tj ? false : true;
            wVar.oa = this.qg.s();
            wVar.d = this.qg.qg();
            wVar.w = com.byazt.wv.n.cp();
            wVar.x = com.byazt.wv.n.tj();
            if (this.n.py()) {
                wVar.fs = com.byazt.wv.n.l();
            }
            arrayList.add(wVar);
            this.sz = wVar;
            if (cp.qg) {
                cp.n("gen launch, " + wVar.q + ", hadUi:" + z, null);
            }
        }
    }

    public static boolean n(com.byazt.yi.n nVar) {
        if (nVar instanceof rv) {
            return ((rv) nVar).tj();
        }
        return false;
    }

    public boolean n(com.byazt.yi.n nVar, ArrayList<com.byazt.yi.n> arrayList) {
        boolean z = nVar instanceof rv;
        boolean zN = n(nVar);
        boolean z2 = true;
        if (this.rv == -1) {
            n(nVar, arrayList, n(nVar));
        } else if (!this.tj && zN) {
            n(nVar, arrayList, true);
        } else if (this.cp == 0 || nVar.qg <= this.cp + this.n.wm()) {
            if (this.rv > nVar.qg + i.l.a) {
                n(nVar, arrayList, zN);
            } else {
                z2 = false;
            }
        } else if (!sz.qg() && sz.n()) {
            n(nVar, arrayList, zN);
        }
        if (z) {
            rv rvVar = (rv) nVar;
            if (rvVar.tj()) {
                this.cp = 0L;
                arrayList.add(nVar);
                if (TextUtils.isEmpty(rvVar.oa)) {
                    if (this.q != null && (rvVar.qg - this.q.qg) - this.q.d < 500) {
                        rvVar.oa = this.q.sz;
                    } else if (this.s != null && (rvVar.qg - this.s.qg) - this.s.d < 500) {
                        rvVar.oa = this.s.sz;
                    }
                }
            } else {
                Bundle bundleN = n(nVar.qg, 0L);
                if (bundleN != null) {
                    com.byazt.wv.n.n("play_session", bundleN);
                }
                this.cp = rvVar.qg;
                arrayList.add(nVar);
                if (rvVar.cp()) {
                    this.s = rvVar;
                } else {
                    this.q = rvVar;
                    this.s = null;
                }
            }
        } else if (!(nVar instanceof n)) {
            arrayList.add(nVar);
        }
        qg(nVar);
        return z2;
    }

    public void qg(com.byazt.yi.n nVar) {
        if (nVar != null) {
            if (this.n.py()) {
                nVar.fs = com.byazt.wv.n.l();
            }
            nVar.w = com.byazt.wv.n.cp();
            nVar.x = com.byazt.wv.n.tj();
            nVar.q = this.l;
            nVar.s = q();
        }
    }

    public static long q() {
        return w.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @com.byazt.cp.n(n = {0, 1, 1154, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    static class n extends tj {
        private n() {
        }
    }

    public static n l() {
        if (k == null) {
            k = new n();
        }
        k.qg = System.currentTimeMillis();
        return k;
    }
}
