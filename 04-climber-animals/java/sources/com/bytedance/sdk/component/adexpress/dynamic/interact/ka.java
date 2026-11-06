package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends h<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    protected void d() {
    }

    public ka(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        super(context, dynamicBaseWidget, abVar);
        ms(abVar);
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f851ms = new ClickSlideUpView2(this.xr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.f851ms.setLayoutParams(layoutParams);
        if (this.f851ms instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.f851ms).setButtonText(this.d.am());
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
