package com.byazt.xt;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.dr.RewardDrawRecyclerView;
import com.byazt.dr.RewardGuideSlideUp;
import com.byazt.hg.of;
import com.byazt.hr.RecyclerView;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 121})
public class x extends hw {
    public float a;
    public boolean cz;
    public boolean g;
    public RewardGuideSlideUp ho;
    public com.byazt.dr.hn lb;
    public RewardDrawRecyclerView nt;
    public boolean ny;
    public float qa;
    public com.byazt.dr.pr yb;

    public x(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
        this.cz = true;
    }

    public void pr(float[] fArr) {
        this.qa = fArr[0];
        this.a = fArr[1];
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.nt = (RewardDrawRecyclerView) this.fw.findViewById(2114387885);
        com.byazt.dr.hn hnVar = new com.byazt.dr.hn(this.hw, 0, false);
        this.lb = hnVar;
        this.nt.setLayoutManager(hnVar);
        com.byazt.dr.pr prVar = new com.byazt.dr.pr(this.hw, this.qa, this.a);
        this.yb = prVar;
        this.nt.setAdapter(prVar);
        if (this.g) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.fw.findViewById(2114387966);
            this.ho = rewardGuideSlideUp;
            rewardGuideSlideUp.pr();
        }
    }

    public RecyclerView hw() {
        return this.nt;
    }

    public com.byazt.dr.pr hn() {
        return this.yb;
    }

    public com.byazt.dr.hn x() {
        return this.lb;
    }

    public void c() {
        if (!this.g || !this.cz) {
            return;
        }
        this.fw.postDelayed(new Runnable() { // from class: com.byazt.xt.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (x.this.g && x.this.cz) {
                    x.this.cz = false;
                    er.pr((View) x.this.ho, 0);
                    x.this.ho.getSlideUpAnimatorSet().start();
                    x.this.ny = true;
                    x.this.fw.postDelayed(new Runnable() { // from class: com.byazt.xt.x.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.uc();
                        }
                    }, 3000L);
                }
            }
        }, 0L);
    }

    public void uc() {
        if (!this.g) {
            return;
        }
        this.cz = false;
        if (this.ny) {
            er.pr((View) this.ho, 8);
            RewardGuideSlideUp rewardGuideSlideUp = this.ho;
            if (rewardGuideSlideUp != null) {
                rewardGuideSlideUp.hw();
            }
            this.ny = false;
        }
    }

    public void pr(boolean z) {
        com.byazt.dr.hn hnVar = this.lb;
        if (hnVar == null) {
            return;
        }
        hnVar.hw(false);
    }

    @Override // com.byazt.xt.hw
    public void vk() {
        super.vk();
        uc();
    }
}
