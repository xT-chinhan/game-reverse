package com.byazt.yhm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.SlideUpView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb<E extends SlideUpView> implements fw<E> {
    public int c;
    public DynamicBaseWidget hn;
    public Context hw;
    public SlideUpView pr;
    public com.byazt.rk.fw x;

    public yb(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, int i) {
        this.c = i;
        this.hw = context;
        this.hn = dynamicBaseWidget;
        this.x = fwVar;
        x();
    }

    public yb(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        this(context, dynamicBaseWidget, fwVar, 0);
    }

    public void x() {
        this.pr = new SlideUpView(this.hw, this.x.qn());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.js.zo.pr(this.hw, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.byazt.js.zo.pr(this.hw, 100 - this.c);
        this.pr.setLayoutParams(layoutParams);
        try {
            this.pr.setGuideText(this.x.o());
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        this.pr.pr();
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        this.pr.hw();
    }

    @Override // com.byazt.yhm.fw
    /* JADX INFO: renamed from: uc, reason: merged with bridge method [inline-methods] */
    public E hn() {
        return (E) this.pr;
    }
}
