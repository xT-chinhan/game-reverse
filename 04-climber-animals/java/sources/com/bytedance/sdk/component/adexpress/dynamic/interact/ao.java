package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements ab {
    private DynamicBaseWidget ah;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ab d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SlideRightView f848ms;
    private Context xr;

    public ao(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.xr = context;
        this.ah = dynamicBaseWidget;
        this.d = abVar;
        d();
    }

    private void d() {
        this.f848ms = new SlideRightView(this.xr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.xr, 120.0f));
        layoutParams.gravity = 17;
        this.f848ms.setLayoutParams(layoutParams);
        this.f848ms.setClipChildren(false);
        this.f848ms.setGuideText(this.d.am());
        DynamicBaseWidget dynamicBaseWidget = this.ah;
        if (dynamicBaseWidget != null) {
            this.f848ms.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        SlideRightView slideRightView = this.f848ms;
        if (slideRightView != null) {
            slideRightView.ms();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        SlideRightView slideRightView = this.f848ms;
        if (slideRightView != null) {
            slideRightView.xr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public ViewGroup ah() {
        return this.f848ms;
    }
}
