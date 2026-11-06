package com.byazt.ao;

import com.byazt.dg.qg;
import com.byazt.xx.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 19})
public class n extends com.byazt.eu.n implements com.byazt.eu.n.s {
    public boolean a;
    public final List<C0123n> um;

    @Override // com.byazt.eu.n.s
    public double qg() {
        return 600.0d;
    }

    /* JADX INFO: renamed from: com.byazt.ao.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0123n implements com.byazt.eu.n.qg {
        public int l;
        public String n;
        public double q;
        public double qg;
        public double s;

        @Override // com.byazt.eu.n.qg
        public String n() {
            return this.n;
        }

        @Override // com.byazt.eu.n.qg
        public double qg() {
            return this.qg;
        }

        @Override // com.byazt.eu.n.qg
        public double s() {
            return this.s;
        }

        @Override // com.byazt.eu.n.qg
        public double q() {
            return this.q;
        }

        @Override // com.byazt.eu.n.qg
        public int l() {
            return this.l;
        }
    }

    public n(qg qgVar, double d, double d2) {
        super(qgVar, d, d2);
        this.um = new ArrayList();
        this.a = false;
    }

    @Override // com.byazt.eu.n
    public com.byazt.le.n n(qg qgVar, com.byazt.le.n.InterfaceC0236n interfaceC0236n) {
        return new com.byazt.vb.n(qgVar, interfaceC0236n);
    }

    @Override // com.byazt.eu.n
    public void n(double d, qg.C0152qg c0152qg) {
        double d2 = c0152qg != null ? c0152qg.q : 2800.0d;
        for (int size = this.w.size() - 1; size >= 0; size--) {
            l lVar = this.w.get(size);
            if (lVar != this.sz) {
                lVar.w = (-lVar.fs) + (((this.tj - lVar.sz) / d2) * (this.fs + lVar.fs));
                if (lVar.w - lVar.fs > this.fs || !lVar.oa) {
                    this.w.remove(size);
                }
            }
        }
    }

    @Override // com.byazt.eu.n
    public boolean cp() {
        return !this.a;
    }

    @Override // com.byazt.eu.n
    public void d() {
        this.a = true;
    }

    @Override // com.byazt.eu.n
    public void n(l lVar) {
        C0123n c0123n = new C0123n();
        c0123n.n = (lVar.q >= 0.0d ? "+" : "") + ((long) lVar.q);
        c0123n.qg = lVar.l;
        c0123n.s = lVar.w;
        c0123n.q = this.tj;
        c0123n.l = lVar.q >= 0.0d ? -16725933 : -44462;
        this.um.add(c0123n);
    }

    @Override // com.byazt.eu.n
    public void n(double d) {
        for (int size = this.um.size() - 1; size >= 0; size--) {
            C0123n c0123n = this.um.get(size);
            if (this.tj - c0123n.q >= 600.0d) {
                this.um.remove(size);
            } else {
                c0123n.s -= 0.4d;
            }
        }
    }

    @Override // com.byazt.eu.n
    public void rv() {
        this.um.clear();
    }

    @Override // com.byazt.eu.n.s
    public List<? extends com.byazt.eu.n.qg> n() {
        return this.um;
    }
}
