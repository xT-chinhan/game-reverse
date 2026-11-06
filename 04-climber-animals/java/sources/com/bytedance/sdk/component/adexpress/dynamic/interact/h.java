package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: loaded from: classes2.dex */
public class h<E extends SlideUpView> implements ab<E> {
    protected DynamicBaseWidget ah;
    protected com.bytedance.sdk.component.adexpress.dynamic.ah.ab d;
    protected int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected SlideUpView f851ms;
    protected Context xr;

    public h(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, int i) {
        this.ka = i;
        this.xr = context;
        this.ah = dynamicBaseWidget;
        this.d = abVar;
        d();
    }

    public h(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        this(context, dynamicBaseWidget, abVar, 0);
    }

    protected void d() {
        this.f851ms = new SlideUpView(this.xr, this.d.e());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.xr, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.xr, 100 - this.ka);
        this.f851ms.setLayoutParams(layoutParams);
        try {
            this.f851ms.setGuideText(this.d.am());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.f851ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.f851ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public E ah() {
        return (E) this.f851ms;
    }
}
