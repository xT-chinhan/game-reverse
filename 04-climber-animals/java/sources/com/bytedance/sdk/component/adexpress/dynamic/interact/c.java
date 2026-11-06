package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;

/* JADX INFO: loaded from: classes2.dex */
public class c extends h<ClickSlideUpShakeView> implements ub {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.h
    protected void d() {
    }

    public c(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, boolean z, int i) {
        super(context, dynamicBaseWidget, abVar);
        this.xr = context;
        this.d = abVar;
        this.ah = dynamicBaseWidget;
        ms(chVar, abVar, z, i);
    }

    private void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, boolean z, int i) {
        int iXn;
        this.f851ms = new ClickSlideUpShakeView(this.xr, chVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.xr, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.xr;
        if (abVar.xn() > 0) {
            iXn = abVar.xn();
        } else {
            iXn = com.bytedance.sdk.component.adexpress.d.ms() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, iXn);
        this.f851ms.setLayoutParams(layoutParams);
        this.f851ms.setClipChildren(false);
        this.f851ms.setSlideText(this.d.am());
        if (this.f851ms instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.f851ms).setShakeText(this.d.tz());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.f851ms).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.c.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.ms
                    public void ms(boolean z2) {
                        if (c.this.ah.getDynamicClickListener() != null) {
                            c.this.ah.getDynamicClickListener().ms(z2, c.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.ah.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ub
    public void ka() {
        if (this.f851ms.getParent() != null) {
            ((ViewGroup) this.f851ms.getParent()).setVisibility(8);
        }
    }
}
