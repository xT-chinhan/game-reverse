package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.d.ab;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.ah {
    private boolean b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f833ms;
    private int nw;
    private int t;
    boolean xr;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.nw = 0;
        setTag(Integer.valueOf(getClickArea()));
        ny();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().le()) {
            return;
        }
        if (this.ub != null) {
            this.ub.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.xr) {
            layoutParams.leftMargin = this.ny;
        } else {
            layoutParams.leftMargin = this.ny + this.nw;
        }
        if (this.b && this.sl != null) {
            layoutParams.leftMargin = ((this.ny + this.nw) - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah()))) - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d()));
        }
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            layoutParams.topMargin = this.ch - ((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.xr()));
        } else {
            layoutParams.topMargin = this.ch;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        if (ab.xr(this.u.getRenderRequest().c())) {
            return true;
        }
        super.x();
        setPadding((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.xr()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ms()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b && this.sl != null) {
            setMeasuredDimension(this.t + ((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah())) + ((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d())), this.x);
        } else if (this.xr) {
            setMeasuredDimension(this.ab, this.x);
        } else {
            setMeasuredDimension(this.f833ms, this.x);
        }
    }

    private void ny() {
        List<x> listHi = this.zb.hi();
        if (listHi == null || listHi.size() <= 0) {
            return;
        }
        for (x xVar : listHi) {
            if (TextUtils.equals("skip-with-time-skip-btn", xVar.ch().getType())) {
                this.t = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, xVar.x() + (com.bytedance.sdk.component.adexpress.d.ms() ? xVar.zb() : 0));
                this.f833ms = this.ab - this.t;
                break;
            }
        }
        this.nw = this.ab - this.f833ms;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.b != z2) {
            this.b = z2;
            ka();
            return;
        }
        if (z && this.xr != z) {
            this.xr = z;
            ka();
        }
        this.xr = z;
    }
}
