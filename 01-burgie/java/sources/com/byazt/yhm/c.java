package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.ClickSlideUpView;
import com.byazt.jt.ClickSlideUpView2;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends yb<ClickSlideUpView> {
    public c(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        super(context, dynamicBaseWidget, fwVar);
        pr(fwVar);
    }

    private void pr(com.byazt.rk.fw fwVar) {
        this.pr = new ClickSlideUpView2(this.hw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.pr.setLayoutParams(layoutParams);
        if (this.pr instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.pr).setButtonText(this.x.o());
        }
    }

    @Override // com.byazt.yhm.yb
    public void x() {
    }

    @Override // com.byazt.yhm.yb, com.byazt.yhm.fw
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.yhm.yb, com.byazt.yhm.fw
    public void hw() {
        this.pr.hw();
    }
}
