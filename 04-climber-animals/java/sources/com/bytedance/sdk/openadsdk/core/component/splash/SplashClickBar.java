package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class SplashClickBar extends FrameLayout {
    private boolean ab;
    private int ah;
    private String c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2324ms;
    private SplashClickBarBtn ny;
    private int x;
    private int xr;

    public SplashClickBar(Context context, lm lmVar) {
        super(context);
        ms(context, lmVar);
    }

    public void ms(Context context, lm lmVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), lmVar);
        this.ny = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.ny.setClipChildren(false);
    }

    public void ms(lm lmVar) {
        this.f2324ms = lmVar.ih();
        this.xr = lmVar.j();
        this.ah = lmVar.oh();
        this.d = lmVar.zd();
        this.ka = lmVar.jm();
        this.c = lmVar.bz();
        this.x = lmVar.z();
        this.ab = lmVar.jy();
        SplashClickBarBtn splashClickBarBtn = this.ny;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(lmVar.on());
            this.ny.setDeepShakeValue(lmVar.iw());
            this.ny.setWriggleValue(lmVar.ia());
            this.ny.setTwistConfig(lmVar.ax());
            this.ny.setShakeInteractConf(lmVar.wr());
            this.ny.setTwistInteractConf(lmVar.rg());
            this.ny.setCalculationTwistMethod(lmVar.ec());
            this.ny.setCalculationMethod(lmVar.n());
        }
        this.ny.ms(lmVar.kk());
        if (this.ka == 1 && this.ab) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setBtnLayout(boolean z) {
        int i;
        int iAh;
        int i2 = this.xr + 150;
        if (this.f2324ms <= i2 && this.x != 4) {
            this.f2324ms = i2;
        }
        if (z) {
            i = this.ah;
        } else {
            i = this.d;
        }
        if (i < 0) {
            i = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ny.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.x;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iAh = ul.ah(getContext(), 10.0f);
            } else if (i3 == 7) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iAh = ul.ah(getContext(), 20.0f);
            } else {
                layoutParams.height = ul.ah(re.getContext(), this.xr);
                layoutParams.width = ul.ah(re.getContext(), this.f2324ms);
            }
            i += iAh;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = ul.ah(re.getContext(), i);
        layoutParams.gravity = 81;
        this.ny.setLayoutParams(layoutParams);
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.ms msVar) {
        this.ny.ms(msVar);
    }
}
