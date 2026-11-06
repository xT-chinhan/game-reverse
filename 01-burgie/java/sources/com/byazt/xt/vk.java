package com.byazt.xt;

import android.widget.FrameLayout;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.jw.FullSwiperView;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, 50})
public class vk extends hw {
    public float g;
    public float ho;
    public FullSwiperView nt;

    public vk(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, z);
    }

    public void pr(float[] fArr) {
        this.g = fArr[0];
        this.ho = fArr[1];
    }

    @Override // com.byazt.xt.hw
    public void pr() {
        super.pr();
        this.fw.setBackgroundColor(0);
        this.nt = new FullSwiperView(this.hw);
    }

    public void pr(List<com.byazt.jw.pr> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.nt.pr(list).pr(this.g).hw(this.ho).pr(String.valueOf(ls.m(this.hn))).pr();
        this.fw.addView(this.nt, new FrameLayout.LayoutParams(-1, -1));
    }

    public void hw() {
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            fullSwiperView.hw();
        }
    }

    public void hn() {
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            fullSwiperView.hn();
        }
    }

    public void x() {
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            fullSwiperView.x();
        }
    }

    @Override // com.byazt.xt.hw
    public void vk() {
        super.vk();
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            fullSwiperView.c();
        }
    }

    public int c() {
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void uc() {
        FullSwiperView fullSwiperView = this.nt;
        if (fullSwiperView != null) {
            fullSwiperView.fw();
        }
    }
}
