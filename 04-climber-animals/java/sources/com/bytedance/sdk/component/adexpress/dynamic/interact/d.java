package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;

/* JADX INFO: loaded from: classes2.dex */
public class d extends h<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    protected void d() {
    }

    public d(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        super(context, dynamicBaseWidget, abVar);
        ms(abVar);
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f851ms = new ClickSlideUpView(this.xr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.xr, abVar.xn());
        this.f851ms.setLayoutParams(layoutParams);
        this.f851ms.setSlideText(this.d.am());
        if (this.f851ms instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.f851ms).setButtonText(this.d.ch());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h, com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f851ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h, com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f851ms.xr();
    }
}
