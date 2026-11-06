package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* JADX INFO: loaded from: classes2.dex */
public class hi implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private HandLongPressView f852ms;

    public hi(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f852ms = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f));
        layoutParams.gravity = 17;
        this.f852ms.setLayoutParams(layoutParams);
        this.f852ms.setGuideText(abVar.am());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f852ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f852ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public ViewGroup ah() {
        return this.f852ms;
    }
}
