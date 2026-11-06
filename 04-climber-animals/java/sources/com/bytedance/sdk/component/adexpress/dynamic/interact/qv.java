package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* JADX INFO: loaded from: classes2.dex */
public class qv implements ab<DynamicUnlockView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final DynamicUnlockView f864ms;

    public qv(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        int iXn;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.f864ms = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (abVar.xn() > 0) {
            iXn = abVar.xn();
        } else {
            iXn = com.bytedance.sdk.component.adexpress.d.ms() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, iXn);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(abVar.am());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        DynamicUnlockView dynamicUnlockView = this.f864ms;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.ms();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        DynamicUnlockView dynamicUnlockView = this.f864ms;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.xr();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView ah() {
        return this.f864ms;
    }
}
