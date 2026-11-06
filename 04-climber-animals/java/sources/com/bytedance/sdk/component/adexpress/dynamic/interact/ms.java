package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private BluePressInteractView f853ms;

    public ms(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        double dZf = abVar.zf();
        dZf = dZf == 0.0d ? 1.0d : dZf;
        double dRt = abVar.rt();
        double d = dRt != 0.0d ? dRt : 1.0d;
        int dynamicWidth = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dZf);
        int dynamicWidth2 = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d);
        this.f853ms = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, abVar.qk() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, abVar.vm() - 3);
        this.f853ms.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f853ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f853ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public ViewGroup ah() {
        return this.f853ms;
    }
}
