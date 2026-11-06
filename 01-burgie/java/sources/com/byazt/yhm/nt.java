package com.byazt.yhm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.SlideRightView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 74})
public class nt implements fw {
    public DynamicBaseWidget hn;
    public Context hw;
    public SlideRightView pr;
    public com.byazt.rk.fw x;

    public nt(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar) {
        this.hw = context;
        this.hn = dynamicBaseWidget;
        this.x = fwVar;
        x();
    }

    private void x() {
        this.pr = new SlideRightView(this.hw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.byazt.js.zo.pr(this.hw, 120.0f));
        layoutParams.gravity = 17;
        this.pr.setLayoutParams(layoutParams);
        this.pr.setClipChildren(false);
        this.pr.setGuideText(this.x.o());
        DynamicBaseWidget dynamicBaseWidget = this.hn;
        if (dynamicBaseWidget != null) {
            this.pr.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        SlideRightView slideRightView = this.pr;
        if (slideRightView != null) {
            slideRightView.pr();
        }
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        SlideRightView slideRightView = this.pr;
        if (slideRightView != null) {
            slideRightView.hw();
        }
    }

    @Override // com.byazt.yhm.fw
    public ViewGroup hn() {
        return this.pr;
    }
}
