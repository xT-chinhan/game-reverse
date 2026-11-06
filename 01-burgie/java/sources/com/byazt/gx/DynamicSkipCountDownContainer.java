package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.widget.FrameLayout;
import com.byazt.rk.zo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2385})
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.byazt.imd.hn {
    public int a;
    public int hw;
    public int pr;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        aj();
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(getBackgroundDrawable());
        }
        setPadding((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hw()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.pr()));
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.aj;
        layoutParams.topMargin = this.vk;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == 0) {
            setMeasuredDimension(this.hw, this.zo);
        } else {
            setMeasuredDimension(this.pr, this.zo);
        }
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.a = i;
    }

    private void aj() {
        List<zo> listW = this.m.w();
        if (listW == null || listW.size() <= 0) {
            return;
        }
        for (zo zoVar : listW) {
            if (zoVar.vk().pr() == 21) {
                this.pr = (int) (this.fw - com.byazt.js.zo.pr(this.w, zoVar.zo()));
            }
            if (zoVar.vk().pr() == 20) {
                this.hw = (int) (this.fw - com.byazt.js.zo.pr(this.w, zoVar.zo()));
            }
        }
    }
}
