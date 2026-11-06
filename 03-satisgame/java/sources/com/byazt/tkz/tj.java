package com.byazt.tkz;

import android.widget.FrameLayout;
import com.byazt.bpa.FullSwiperView;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 403, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends qg {
    public FullSwiperView cy;
    public float k;
    public float sz;

    public tj(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar, boolean z) {
        super(tTBaseVideoActivity, pkVar, z);
    }

    public void n(float[] fArr) {
        this.sz = fArr[0];
        this.k = fArr[1];
    }

    @Override // com.byazt.tkz.qg
    public void n() {
        super.n();
        this.x.setBackgroundColor(0);
        this.cy = new FullSwiperView(this.qg);
    }

    public void n(List<com.byazt.bpa.n> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.cy.n(list).n(this.sz).qg(this.k).n(String.valueOf(com.byazt.vgx.w.cy(this.s))).n();
        this.x.addView(this.cy, new FrameLayout.LayoutParams(-1, -1));
    }

    public void qg() {
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            fullSwiperView.qg();
        }
    }

    public void s() {
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            fullSwiperView.s();
        }
    }

    public void q() {
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            fullSwiperView.q();
        }
    }

    @Override // com.byazt.tkz.qg
    public void tj() {
        super.tj();
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            fullSwiperView.l();
        }
    }

    public int l() {
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void w() {
        FullSwiperView fullSwiperView = this.cy;
        if (fullSwiperView != null) {
            fullSwiperView.x();
        }
    }
}
