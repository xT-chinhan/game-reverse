package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u implements ab<ShakeAnimationView>, ub {
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ch ab;
    private Context ah;
    private String c;
    private DynamicBaseWidget d;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f866ms;
    private boolean x;
    private ShakeAnimationView xr;

    public u(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, String str, com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, boolean z, int i) {
        this.ah = context;
        this.d = dynamicBaseWidget;
        this.ka = abVar;
        this.c = str;
        this.ab = chVar;
        this.x = z;
        this.f866ms = i;
        c();
    }

    private void c() {
        final com.bytedance.sdk.component.adexpress.dynamic.ka.ms dynamicClickListener = this.d.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.ms(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.c)) {
            Context context = this.ah;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.ah.ms.x(context), this.ab, this.x, this.f866ms);
            this.xr = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.xr.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.ah;
            this.xr = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.ah.ms.ab(context2), this.ab, this.x, this.f866ms);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.xr.setGravity(17);
        layoutParams.gravity = 17;
        this.xr.setLayoutParams(layoutParams);
        this.xr.setTranslationY(com.bytedance.sdk.component.adexpress.d.x.ms(this.ah, this.ka.vy()));
        this.xr.setShakeText(this.ka.am());
        this.xr.setClipChildren(false);
        this.xr.setOnShakeViewListener(new ShakeAnimationView.ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.u.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.ms
            public void ms(boolean z) {
                com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = dynamicClickListener;
                if (msVar != null) {
                    msVar.ms(z, u.this);
                }
                u.this.xr.setOnClickListener((View.OnClickListener) dynamicClickListener);
                u.this.xr.performClick();
                if (u.this.ka == null || !u.this.ka.ti()) {
                    return;
                }
                u.this.xr.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.xr.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.xr.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView ah() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ub
    public void ka() {
        if (this.xr.getParent() != null) {
            ((ViewGroup) this.xr.getParent()).setVisibility(8);
        }
    }
}
