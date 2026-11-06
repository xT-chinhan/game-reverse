package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class sl implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private PressButtonInteractView f865ms;

    public sl(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f865ms = new PressButtonInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 8388629;
        this.f865ms.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f865ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f865ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PressButtonInteractView ah() {
        return this.f865ms;
    }
}
