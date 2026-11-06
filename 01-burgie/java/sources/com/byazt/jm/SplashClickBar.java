package com.byazt.jm;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 1148})
public class SplashClickBar extends FrameLayout {
    public SplashClickBarBtn aj;
    public int c;
    public boolean fw;
    public int hn;
    public int hw;
    public int pr;
    public String uc;
    public int x;
    public int zo;

    public SplashClickBar(Context context, of ofVar) {
        super(context);
        pr(context, ofVar);
    }

    public void pr(Context context, of ofVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), ofVar);
        this.aj = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.aj.setClipChildren(false);
    }

    public void pr(of ofVar) {
        this.pr = ofVar.vv();
        this.hw = ofVar.yj();
        this.hn = ofVar.tv();
        this.x = ofVar.om();
        this.c = ofVar.lj();
        this.uc = ofVar.h();
        this.zo = ofVar.wm();
        this.fw = ofVar.t();
        SplashClickBarBtn splashClickBarBtn = this.aj;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(ofVar.tm());
            this.aj.setDeepShakeValue(ofVar.fu());
            this.aj.setWriggleValue(ofVar.qz());
            this.aj.setTwistConfig(ofVar.gv());
            this.aj.setShakeInteractConf(ofVar.dj());
            this.aj.setTwistInteractConf(ofVar.yd());
            this.aj.setCalculationTwistMethod(ofVar.kl());
            this.aj.setCalculationMethod(ofVar.gg());
        }
        this.aj.pr(ofVar.jl());
        if (this.c == 1 && this.fw) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setBtnLayout(boolean z) {
        int iHn;
        int i = this.hw + MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
        if (this.pr <= i && this.zo != 4) {
            this.pr = i;
        }
        if (z) {
            iHn = this.hn;
        } else {
            iHn = this.x;
        }
        if (iHn < 0) {
            iHn = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aj.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        switch (this.zo) {
            case 4:
                layoutParams.height = -50;
                layoutParams.width = -50;
                break;
            case 5:
                layoutParams.height = -50;
                layoutParams.width = -50;
                iHn += er.hn(getContext(), 10.0f);
                break;
            case 6:
            default:
                layoutParams.height = er.hn(a.getContext(), this.hw);
                layoutParams.width = er.hn(a.getContext(), this.pr);
                break;
            case 7:
                layoutParams.height = -50;
                layoutParams.width = -50;
                iHn += er.hn(getContext(), 20.0f);
                break;
        }
        layoutParams.bottomMargin = er.hn(a.getContext(), iHn);
        layoutParams.gravity = 81;
        this.aj.setLayoutParams(layoutParams);
    }

    public void pr(com.byazt.az.pr prVar) {
        this.aj.pr(prVar);
    }
}
