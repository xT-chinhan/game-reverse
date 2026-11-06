package com.byazt.has;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.gct.e;
import com.byazt.gct.oj;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.byazt.tk.k;
import com.byazt.vf.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends n {
    public boolean lh;
    public boolean ln;

    public static int n(pk pkVar) {
        return 9;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return false;
    }

    @Override // com.byazt.has.qg
    public void dn() {
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return false;
    }

    @Override // com.byazt.has.n
    public boolean w() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return false;
    }

    public rv(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = false;
        this.lh = false;
        this.lh = com.byazt.xd.qg.n(pkVar) == 1;
    }

    public static boolean n(Context context, pk pkVar) {
        long jX;
        if (!e.q(pkVar)) {
            return false;
        }
        if (oj.n(pkVar)) {
            jX = ((long) oj.qg(pkVar)) * 1000;
        } else {
            jX = ta.k(pkVar) != null ? (long) (ta.x(pkVar) * 1000.0d) : 0L;
        }
        long jMin = Math.min(cx.n(), (long) (jX * (pkVar.gr() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.byazt.xd.qg.n(pkVar)));
        return com.byazt.wq.qg.n().n(context, pkVar, (Map<String, Object>) map) == 0;
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        this.rv = new com.byazt.tkz.rv(this.n, this.qg, z);
        return this.rv;
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public void s() {
        this.n.s(true, true);
        this.rv.s(true);
        this.tj.q(false);
        this.cd.n(false);
        int iA = ((oa) com.byazt.qp.q.n("device_info_new")).a();
        com.byazt.gct.rv.n nVarQg = new com.byazt.gct.rv.n().w(-1.0f).l(-1.0f).q(-1.0f).s(-1.0f).qg(-1L).n(-1L).q(-1).l(-1).w(-1024).s(com.byazt.vyf.s.cy().qg() ? 1 : 2).qg(iA).n(com.byazt.okk.s.x(com.byazt.nf.rv.getContext())).qg(com.byazt.okk.s.fs(com.byazt.nf.rv.getContext()));
        if (this.qg != null && this.qg.ys() == 1 && this.tj != null) {
            nVarQg.n(this.tj.l() ? this.tj.rv() : (byte) 0);
        }
        nVarQg.n(com.byazt.oh.l.qg(this.qg));
        com.byazt.hm.n.n("click", this.qg, nVarQg.n(), this.d, true, this.n.pk(), -1, false, false);
    }

    @Override // com.byazt.has.n
    public void n(int i, int i2, Intent intent) {
        super.n(i, i2, intent);
        if (i != 1) {
            this.n.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.n.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.lh && i3 == 1) {
                this.n.finish();
                return;
            }
            k.qg("rewardAuthFlag", "verify rew....");
            this.n.q(0);
            tj(true);
            this.n.fi().postDelayed(new Runnable() { // from class: com.byazt.has.rv.1
                @Override // java.lang.Runnable
                public void run() {
                    rv.this.vb();
                }
            }, 2000L);
            return;
        }
        this.n.finish();
    }

    @Override // com.byazt.has.n
    public void n(int i) {
        super.n(i);
        if (i == 0) {
            vb();
        }
    }

    @Override // com.byazt.has.n
    public View rv() {
        FrameLayout frameLayout = new FrameLayout(this.n);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        if (this.ln) {
            return;
        }
        this.ln = true;
        tj(false);
        this.n.finish();
    }

    private void tj(final boolean z) {
        if (this.rv instanceof com.byazt.tkz.rv) {
            com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.has.rv.2
                @Override // java.lang.Runnable
                public void run() {
                    if (rv.this.rv == null) {
                        return;
                    }
                    com.byazt.tkz.rv rvVar = (com.byazt.tkz.rv) rv.this.rv;
                    if (z) {
                        rvVar.qg();
                    } else {
                        rvVar.s();
                    }
                }
            });
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return n(this.qg);
    }
}
