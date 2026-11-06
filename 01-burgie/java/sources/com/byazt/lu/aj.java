package com.byazt.lu;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.f;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.sd.a;
import com.byazt.vkw.g;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 61})
public class aj extends pr {
    public boolean nl;
    public boolean y;

    public aj(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = false;
        this.y = false;
        this.y = com.byazt.nl.hw.pr(ofVar) == 1;
    }

    public static boolean pr(Context context, of ofVar) {
        if (!f.x(ofVar)) {
            return false;
        }
        long jFw = 0;
        if (v.pr(ofVar)) {
            jFw = ((long) v.hw(ofVar)) * 1000;
        } else if (qv.ho(ofVar) != null) {
            jFw = (long) (qv.fw(ofVar) * 1000.0d);
        }
        long jMin = Math.min(jn.pr(), (long) (jFw * (ofVar.bt() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.byazt.nl.hw.pr(ofVar)));
        return com.byazt.eg.hw.pr().pr(context, ofVar, (Map<String, Object>) map) == 0;
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        this.aj = new com.byazt.xt.aj(this.pr, this.hw, z);
        return this.aj;
    }

    @Override // com.byazt.lu.pr, com.byazt.lu.hw
    public void hn() {
        this.pr.hw(true, true);
        this.aj.hn(true);
        this.vk.x(false);
        this.lb.pr(false);
        int iA = ((g) com.byazt.zs.uc.pr("device_info_new")).a();
        com.byazt.hg.aj.pr prVarHw = new com.byazt.hg.aj.pr().uc(-1.0f).c(-1.0f).x(-1.0f).hn(-1.0f).hw(-1L).pr(-1L).x(-1).c(-1).uc(-1024).hn(com.byazt.sd.zo.nt().hw() ? 1 : 2).hw(iA).pr(er.fw(a.getContext())).hw(er.zo(a.getContext()));
        if (this.hw != null && this.hw.rf() == 1 && this.vk != null) {
            prVarHw.pr(this.vk.c() ? this.vk.aj() : (byte) 0);
        }
        prVarHw.pr(com.byazt.ri.c.hw(this.hw));
        com.byazt.pj.pr.pr("click", this.hw, prVarHw.pr(), this.k, true, this.pr.ii(), -1, false, false);
    }

    @Override // com.byazt.lu.pr
    public void pr(int i, int i2, Intent intent) {
        super.pr(i, i2, intent);
        if (i != 1) {
            this.pr.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.pr.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.y && i3 == 1) {
                this.pr.finish();
                return;
            }
            ho.hw("rewardAuthFlag", "verify rew....");
            this.pr.x(0);
            aj(true);
            this.pr.er().postDelayed(new Runnable() { // from class: com.byazt.lu.aj.1
                @Override // java.lang.Runnable
                public void run() {
                    aj.this.aa();
                }
            }, 2000L);
            return;
        }
        this.pr.finish();
    }

    @Override // com.byazt.lu.pr
    public void pr(int i) {
        super.pr(i);
        if (i == 0) {
            aa();
        }
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return false;
    }

    @Override // com.byazt.lu.pr
    public boolean uc() {
        return false;
    }

    @Override // com.byazt.lu.hw
    public void pq() {
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        FrameLayout frameLayout = new FrameLayout(this.pr);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa() {
        if (this.nl) {
            return;
        }
        this.nl = true;
        aj(false);
        this.pr.finish();
    }

    private void aj(final boolean z) {
        if (!(this.aj instanceof com.byazt.xt.aj)) {
            return;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.lu.aj.2
            @Override // java.lang.Runnable
            public void run() {
                if (aj.this.aj == null) {
                    return;
                }
                com.byazt.xt.aj ajVar = (com.byazt.xt.aj) aj.this.aj;
                if (z) {
                    ajVar.hw();
                } else {
                    ajVar.hn();
                }
            }
        });
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return pr(this.hw);
    }

    public static int pr(of ofVar) {
        return 9;
    }
}
