package com.byazt.lu;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.er;
import com.byazt.hg.f;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.sd.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SAMPLE_RATE, 5})
public class uc extends pr {
    public com.byazt.az.pr e;
    public com.byazt.pg.hw n;
    public boolean nl;
    public boolean ww;
    public final AtomicBoolean y;

    public uc(TTBaseVideoActivity tTBaseVideoActivity, of ofVar) {
        super(tTBaseVideoActivity, ofVar);
        this.nl = false;
        this.y = new AtomicBoolean(false);
    }

    @Override // com.byazt.lu.hw
    public boolean l() {
        return lv() && ie.pr(this.hw) == 1;
    }

    public static boolean pr(of ofVar) {
        return com.byazt.lpk.pr.pr(ofVar);
    }

    @Override // com.byazt.lu.hw
    public boolean lv() {
        return true;
    }

    @Override // com.byazt.lu.hw
    public boolean od() {
        return jn.hn(this.hw, fw());
    }

    @Override // com.byazt.lu.hw
    public void pq() {
        if (uc()) {
            this.lb.hw(false);
            this.lb.c(false);
            this.aj.uc(8);
            this.aj.c(8);
            this.aj.hn(8);
        } else {
            this.lb.hw(this.hw.zz());
            this.lb.c(true);
            this.aj.uc(0);
            this.aj.c(0);
            this.aj.hn(0);
        }
        this.pr.r();
    }

    @Override // com.byazt.lu.pr
    public View aj() {
        if (this.x != 100.0f) {
            return com.byazt.sdv.c.fo(this.pr);
        }
        if (this.hn == 2) {
            return com.byazt.sdv.c.ho(this.pr);
        }
        return com.byazt.sdv.c.nt(this.pr);
    }

    @Override // com.byazt.lu.pr
    public com.byazt.xt.hw pr(boolean z) {
        if (this.x != 100.0f) {
            this.aj = new com.byazt.xt.fw(this.pr, this.hw, z);
        } else {
            this.aj = new com.byazt.xt.zo(this.pr, this.hw, z);
        }
        return this.aj;
    }

    @Override // com.byazt.lu.pr
    public void yb() {
        super.yb();
        this.aj.hn(0);
    }

    @Override // com.byazt.lu.pr
    public boolean lb() {
        if (this.ww) {
            return true;
        }
        return (com.byazt.eg.hw.pr().hw(this.hw) || f.hn(this.hw)) ? false : true;
    }

    @Override // com.byazt.lu.pr
    public void pr(int i, int i2, Intent intent) {
        super.pr(i, i2, intent);
        if (f.hn(this.hw) || i != 1 || intent == null || intent.getExtras() == null || this.ww) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iEr = (int) (((long) er()) - j);
        this.pr.pr(iEr, false);
        if (j <= 0) {
            aj(true);
            x(0);
            this.ww = true;
            return;
        }
        pr(iEr);
    }

    private void pr(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            if (this.vk != null && this.vk.c()) {
                this.vk.pr("rewardInnerLiveShowTime", jSONObject);
            }
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.lu.pr
    public void hw(boolean z) {
        super.hw(z);
        if (!com.byazt.sd.hw.pr().hw("is_reward_deep_link_to_live", false) || f.hn(this.hw) || z) {
            return;
        }
        a.pr().pr(iy(), new fo.x() { // from class: com.byazt.lu.uc.1
            @Override // com.byazt.sd.fo.x
            public void pr(int i, String str) {
                uc.this.aj(false);
            }

            @Override // com.byazt.sd.fo.x
            public void pr(rc.hn hnVar) {
                if (hnVar.hn == null) {
                    return;
                }
                boolean zPr = hnVar.hn.pr();
                uc.this.aj(zPr);
                if (zPr) {
                    uc.this.pr.x(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            if (this.vk != null) {
                this.vk.pr("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e) {
        }
    }

    private JSONObject iy() {
        JSONObject jSONObject = new JSONObject();
        er erVarA = this.hw.a();
        if (erVarA == null) {
            return jSONObject;
        }
        String strX = erVarA.x();
        if (TextUtils.isEmpty(strX)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strX).optString("token");
            jSONObject.put("req_id", erVarA.uc());
            jSONObject.put("token", strOptString);
            jSONObject.put("action", "query_box");
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    @Override // com.byazt.lu.pr
    public void cz() {
        super.cz();
        aa();
        if (this.vk.c()) {
            return;
        }
        if (com.byazt.eg.hw.pr().hw(this.hw)) {
            cr();
            return;
        }
        if (!f.pr(this.hw) || this.n != null || com.byazt.sd.hw.pr().hw("is_reward_deep_link_to_live", false) || f.c(this.hw) == 1 || this.qa.gz() < ((long) f.fw(this.hw)) * 1000) {
            return;
        }
        this.y.set(true);
        if (this.qa != null && this.qa.hw()) {
            this.pr.qn();
        }
        this.n = new com.byazt.pg.hw(this.pr, this.hw, new com.byazt.pg.hw.pr() { // from class: com.byazt.lu.uc.2
            @Override // com.byazt.pg.hw.pr
            public void pr(Dialog dialog) {
                uc.this.n.dismiss();
                uc.this.pr.of();
                uc.this.y.set(false);
            }

            @Override // com.byazt.pg.hw.pr
            public void hw(Dialog dialog) {
                if (uc.this.e != null) {
                    HashMap map = new HashMap();
                    map.put("is_auto_click", Boolean.TRUE);
                    ((com.byazt.yx.pr) uc.this.e.pr(com.byazt.yx.pr.class)).pr(map);
                    uc.this.e.pr(null, new com.byazt.hg.vk());
                }
            }
        });
        com.byazt.az.pr prVar = new com.byazt.az.pr(this.pr, this.hw, this.k, 7) { // from class: com.byazt.lu.uc.3
            @Override // com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, com.byazt.hg.vk vkVar) {
                super.pr(view, vkVar);
                uc.this.n.dismiss();
            }
        };
        this.e = prVar;
        this.pr.pr((com.byazt.yx.hn) prVar.pr(com.byazt.yx.hn.class));
        this.n.pr(this.e);
        if (!this.pr.isFinishing()) {
            this.n.show();
        }
    }

    @Override // com.byazt.lu.pr
    public boolean ww() {
        return this.y.get();
    }

    private void cr() {
        if (this.nl || this.zo == null) {
            return;
        }
        if (((com.byazt.dl.pr) this.zo.pr(com.byazt.dl.pr.class)).hw().w()) {
            this.nl = true;
            hw(8, 0);
            return;
        }
        if (!f.pr(this.hw)) {
            return;
        }
        int iC = f.c(this.hw);
        if (this.hw.rf() == 2) {
            hw(0, -1);
        }
        if (iC != 3) {
            return;
        }
        long jFw = ((long) f.fw(this.hw)) * 1000;
        if (this.qa.gz() >= jFw) {
            hw(8, 0);
            j();
            this.nl = true;
            return;
        }
        hw(0, (int) ((jFw - this.qa.gz()) / 1000));
    }

    private void hw(int i, int i2) {
        if (this.aj == null || !(this.aj instanceof com.byazt.xt.zo)) {
            return;
        }
        ((com.byazt.xt.zo) this.aj).pr(i, i2);
    }

    private void j() {
        if (this.zo == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.byazt.yx.pr) this.zo.pr(com.byazt.yx.pr.class)).pr(map);
        this.zo.pr(null, new com.byazt.hg.vk());
    }

    public void aa() {
        if (!f.pr(this.hw)) {
            return;
        }
        er erVarA = this.hw.a();
        if (erVarA == null && !com.byazt.eg.hw.pr().hw(this.hw)) {
            return;
        }
        int iEr = er();
        if (erVarA != null) {
            erVarA.pr(iEr);
        }
        x(iEr);
    }

    private void x(int i) {
        if (this.zo != null) {
            ((com.byazt.dl.pr) this.zo.pr(com.byazt.dl.pr.class)).pr(i);
        }
        if (this.fo != null) {
            ((com.byazt.dl.pr) this.fo.pr(com.byazt.dl.pr.class)).pr(i);
        }
        if (this.ny != null) {
            ((com.byazt.dl.pr) this.ny.pr(com.byazt.dl.pr.class)).pr(i);
        }
    }

    @Override // com.byazt.lu.hw
    public boolean mw() {
        return true;
    }

    @Override // com.byazt.lu.pr
    public int y() {
        return hw(this.hw);
    }

    public static int hw(of ofVar) {
        return 2;
    }
}
