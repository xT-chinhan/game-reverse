package com.byazt.hi;

import android.content.Context;
import android.widget.FrameLayout;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 1254})
public class SplashClickBar extends FrameLayout {
    public int fs;
    public int l;
    public int n;
    public int q;
    public int qg;
    public SplashClickBarBtn rv;
    public int s;
    public String w;
    public boolean x;

    public SplashClickBar(Context context, pk pkVar) {
        super(context);
        n(context, pkVar);
    }

    public void n(Context context, pk pkVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), pkVar);
        this.rv = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.rv.setClipChildren(false);
    }

    public void n(pk pkVar) {
        this.n = pkVar.oo();
        this.qg = pkVar.di();
        this.s = pkVar.wf();
        this.q = pkVar.lr();
        this.l = pkVar.of();
        this.w = pkVar.dz();
        this.fs = pkVar.rm();
        this.x = pkVar.c();
        SplashClickBarBtn splashClickBarBtn = this.rv;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(pkVar.mp());
            this.rv.setDeepShakeValue(pkVar.im());
            this.rv.setWriggleValue(pkVar.eu());
            this.rv.setTwistConfig(pkVar.kv());
            this.rv.setShakeInteractConf(pkVar.rk());
            this.rv.setTwistInteractConf(pkVar.bs());
            this.rv.setCalculationTwistMethod(pkVar.on());
            this.rv.setCalculationMethod(pkVar.qd());
        }
        this.rv.n(pkVar.br());
        if (this.l == 1 && this.x) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setBtnLayout(boolean z) {
        int i;
        int iS;
        int i2 = this.qg + 150;
        if (this.n <= i2 && this.fs != 4) {
            this.n = i2;
        }
        if (z) {
            i = this.s;
        } else {
            i = this.q;
        }
        if (i < 0) {
            i = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rv.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i3 = this.fs;
        if (i3 != 4) {
            if (i3 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iS = com.byazt.okk.s.s(getContext(), 10.0f);
            } else if (i3 == 7) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                iS = com.byazt.okk.s.s(getContext(), 20.0f);
            } else {
                layoutParams.height = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), this.qg);
                layoutParams.width = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), this.n);
            }
            i += iS;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i);
        layoutParams.gravity = 81;
        this.rv.setLayoutParams(layoutParams);
    }

    public void n(com.byazt.ys.n nVar) {
        this.rv.n(nVar);
    }
}
