package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class zb implements ab<PressInteractView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private PressInteractView f871ms;

    public zb(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f871ms = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 20.0f);
        this.f871ms.setLayoutParams(layoutParams);
        this.f871ms.setGuideText(abVar.am());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f871ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f871ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PressInteractView ah() {
        return this.f871ms;
    }
}
