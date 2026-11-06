package com.byazt.tkz;

import android.view.View;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.byazt.ly.RewardDrawRecyclerView;
import com.byazt.ly.RewardGuideSlideUp;
import com.byazt.prf.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, 5})
public class q extends qg {
    public float a;
    public com.byazt.ly.s cd;
    public RewardDrawRecyclerView cy;
    public com.byazt.ly.n hd;
    public RewardGuideSlideUp k;
    public boolean ou;
    public boolean py;
    public boolean sz;
    public float um;

    public q(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
        this.py = true;
    }

    public void n(float[] fArr) {
        this.um = fArr[0];
        this.a = fArr[1];
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.cy = (RewardDrawRecyclerView) this.x.findViewById(2114387885);
        com.byazt.ly.s sVar = new com.byazt.ly.s(this.qg, 0, false);
        this.cd = sVar;
        this.cy.setLayoutManager(sVar);
        com.byazt.ly.n nVar = new com.byazt.ly.n(this.qg, this.um, this.a);
        this.hd = nVar;
        this.cy.setAdapter(nVar);
        if (this.sz) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.x.findViewById(2114387966);
            this.k = rewardGuideSlideUp;
            rewardGuideSlideUp.n();
        }
    }

    public RecyclerView qg() {
        return this.cy;
    }

    public com.byazt.ly.n s() {
        return this.hd;
    }

    public com.byazt.ly.s q() {
        return this.cd;
    }

    public void l() {
        if (this.sz && this.py) {
            this.x.postDelayed(new Runnable() { // from class: com.byazt.tkz.q.1
                @Override // java.lang.Runnable
                public void run() {
                    if (q.this.sz && q.this.py) {
                        q.this.py = false;
                        com.byazt.okk.s.n((View) q.this.k, 0);
                        q.this.k.getSlideUpAnimatorSet().start();
                        q.this.ou = true;
                        q.this.x.postDelayed(new Runnable() { // from class: com.byazt.tkz.q.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                q.this.w();
                            }
                        }, 3000L);
                    }
                }
            }, 0L);
        }
    }

    public void w() {
        if (this.sz) {
            this.py = false;
            if (this.ou) {
                com.byazt.okk.s.n((View) this.k, 8);
                RewardGuideSlideUp rewardGuideSlideUp = this.k;
                if (rewardGuideSlideUp != null) {
                    rewardGuideSlideUp.qg();
                }
                this.ou = false;
            }
        }
    }

    public void n(boolean z) {
        com.byazt.ly.s sVar = this.cd;
        if (sVar == null) {
            return;
        }
        sVar.qg(false);
    }

    @Override // com.byazt.tkz.qg
    public void tj() {
        super.tj();
        w();
    }
}
