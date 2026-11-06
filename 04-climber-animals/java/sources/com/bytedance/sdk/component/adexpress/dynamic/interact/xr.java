package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private CircleLongPressView f868ms;

    public xr(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this.f868ms = new CircleLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 180.0f));
        layoutParams.gravity = 17;
        this.f868ms.setLayoutParams(layoutParams);
        this.f868ms.setGuideText(abVar.am());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f868ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f868ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircleLongPressView ah() {
        return this.f868ms;
    }
}
