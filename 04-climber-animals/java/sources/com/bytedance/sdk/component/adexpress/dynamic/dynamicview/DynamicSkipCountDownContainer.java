package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f829ms;
    private int t;
    private int xr;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        ny();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.xr()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ms()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.ny;
        layoutParams.topMargin = this.ch;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.t == 0) {
            setMeasuredDimension(this.xr, this.x);
        } else {
            setMeasuredDimension(this.f829ms, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.t = i;
    }

    private void ny() {
        List<x> listHi = this.zb.hi();
        if (listHi == null || listHi.size() <= 0) {
            return;
        }
        for (x xVar : listHi) {
            if (xVar.ch().ms() == 21) {
                this.f829ms = (int) (this.ab - com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, xVar.x()));
            }
            if (xVar.ch().ms() == 20) {
                this.xr = (int) (this.ab - com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, xVar.x()));
            }
        }
    }
}
