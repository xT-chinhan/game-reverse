package com.byazt.icw;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 20})
public abstract class hn implements hw {
    public com.byazt.ax.c c;
    public int fw = 0;
    public of hn;
    public of hw;
    public boolean pr;
    public TTBaseVideoActivity uc;
    public com.byazt.ax.hw x;

    public hn(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, com.byazt.ax.hw hwVar, com.byazt.ax.c cVar, boolean z) {
        this.uc = tTBaseVideoActivity;
        this.hw = ofVar;
        this.x = hwVar;
        this.c = cVar;
        this.pr = z;
    }

    @Override // com.byazt.icw.hw
    public void hn(View view) {
        pr(1);
    }

    @Override // com.byazt.icw.hw
    public void pr(View view) {
        pr(2);
    }

    @Override // com.byazt.icw.hw
    public void hw(View view) {
        pr(3);
    }

    @Override // com.byazt.icw.hw
    public void x(View view) {
        pr(4);
    }

    @Override // com.byazt.icw.hw
    public void c(View view) {
        pr(5);
        this.uc.zo(3);
    }

    @Override // com.byazt.icw.hw
    public void uc(View view) {
        pr(6);
    }

    @Override // com.byazt.icw.hw
    public void fw(View view) {
        pr(7);
    }

    public boolean pr() {
        if (lb.m(this.hw) || jn.hw() <= 0) {
            return false;
        }
        int i = this.fw;
        this.fw = i + 1;
        if (i < jn.hw()) {
            return false;
        }
        com.byazt.xk.hw.pr().pr(this.hw, "stats_reward_full_close_force", this.uc.f().pr(new JSONObject()));
        this.uc.finish();
        return true;
    }

    public void pr(int i) {
        this.uc.od();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable th) {
        }
        com.byazt.xk.hw.pr().pr(this.hw, "stats_reward_full_top_handle", jSONObject);
    }

    public void pr(of ofVar) {
        this.hn = ofVar;
    }

    public boolean pr(vk vkVar) {
        of ofVar = this.hn;
        if (ofVar != null) {
            return this.uc.pr(ofVar, vkVar);
        }
        return this.uc.pr(this.hw, vkVar);
    }
}
