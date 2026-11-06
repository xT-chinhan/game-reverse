package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRoot extends DynamicBaseWidgetImp {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public xr f826ms;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        return super.x();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected xr ms(Bitmap bitmap) {
        ms msVar = new ms(bitmap, this.f826ms);
        this.f826ms = msVar;
        return msVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable getDrawable() {
        xr xrVar = new xr();
        this.f826ms = xrVar;
        return xrVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable ms(GradientDrawable.Orientation orientation, int[] iArr) {
        xr xrVar = new xr(orientation, iArr);
        this.f826ms = xrVar;
        return xrVar;
    }
}
