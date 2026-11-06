package com.byazt.yhm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.ClickSlideUpShakeView;
import com.byazt.jt.ShakeAnimationView;
import com.byazt.jt.ShakeClickView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 5})
public class uc extends yb<ClickSlideUpShakeView> implements ho {
    public uc(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, com.byazt.rk.vk vkVar, boolean z, int i) {
        super(context, dynamicBaseWidget, fwVar);
        this.hw = context;
        this.x = fwVar;
        this.hn = dynamicBaseWidget;
        pr(vkVar, fwVar, z, i);
    }

    @Override // com.byazt.yhm.yb
    public void x() {
    }

    private void pr(com.byazt.rk.vk vkVar, com.byazt.rk.fw fwVar, boolean z, int i) {
        int iR;
        this.pr = new ClickSlideUpShakeView(this.hw, vkVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.js.zo.pr(this.hw, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.hw;
        if (fwVar.r() > 0) {
            iR = fwVar.r();
        } else {
            iR = com.byazt.dj.x.pr() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.byazt.js.zo.pr(context, iR);
        this.pr.setLayoutParams(layoutParams);
        this.pr.setClipChildren(false);
        this.pr.setSlideText(this.x.o());
        if (this.pr instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.pr).setShakeText(this.x.bm());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.pr).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.pr() { // from class: com.byazt.yhm.uc.1
                    @Override // com.byazt.jt.ShakeAnimationView.pr
                    public void pr(boolean z2) {
                        if (uc.this.hn.getDynamicClickListener() != null) {
                            uc.this.hn.getDynamicClickListener().pr(z2, uc.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.hn.getDynamicClickListener());
            }
        }
    }

    @Override // com.byazt.yhm.ho
    public void c() {
        if (this.pr.getParent() != null) {
            ((ViewGroup) this.pr.getParent()).setVisibility(8);
        }
    }
}
