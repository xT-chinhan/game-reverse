package com.byazt.xm;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 8})
public class s implements com.byazt.fb.l {
    public com.byazt.np.fs n;
    public n q;
    public com.byazt.pch.n qg;
    public com.byazt.ap.q s;

    public s(Context context, com.byazt.pch.n nVar, com.byazt.ap.q qVar) {
        this.qg = nVar;
        if (nVar != null) {
            this.n = new com.byazt.np.fs(context);
            this.s = qVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        this.n.n(new com.byazt.qn.qg(8, this.qg.lh(), this.qg.an()), new com.byazt.pf.qg() { // from class: com.byazt.xm.s.1
            @Override // com.byazt.pf.qg
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || s.this.s == null) {
                    return;
                }
                s.this.s.n(nVar.n, nVar.qg);
            }

            @Override // com.byazt.pf.qg
            public void n() {
                if (s.this.s != null) {
                    if (s.this.q == null) {
                        s.this.q = new n(s.this.n);
                    }
                    s.this.s.n(s.this.q);
                }
            }

            @Override // com.byazt.pf.qg
            public void qg() {
                if (s.this.s != null) {
                    s.this.s.n();
                    if (s.this.q == null) {
                        s.this.q = new n(s.this.n);
                    }
                    s.this.s.qg(s.this.q);
                }
            }
        });
    }
}
