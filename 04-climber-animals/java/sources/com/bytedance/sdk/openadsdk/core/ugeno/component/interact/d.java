package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    c ah;
    ah d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    lm f3451ms;
    ka xr;

    public d(lm lmVar, boolean z, ms msVar) {
        this.f3451ms = lmVar;
        this.d = new ah(this.f3451ms);
        this.xr = new ka(this.f3451ms, z, msVar, this.d);
        this.ah = new c(this.f3451ms, z, msVar, this.d);
    }

    private boolean ms(boolean z) {
        int iX = f.x(this.f3451ms);
        if (iX == 5 || iX == 9) {
            return true;
        }
        if (iX == 3 || iX == 4) {
            return z;
        }
        return iX == 7 || iX == 8;
    }

    public void ms(ViewGroup viewGroup, View view) {
        xr(viewGroup, view);
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout)) {
            if (this.xr.ah()) {
                int iAh = op.c(this.f3451ms).ah();
                boolean z = iAh == 0 || iAh == 2;
                if (ms(true)) {
                    this.d.ms(this.xr.ms(), z);
                    ka kaVar = this.xr;
                    if (z) {
                        view = viewGroup;
                    }
                    kaVar.ms(viewGroup, view, true);
                    return;
                }
                return;
            }
            if (this.ah.ah()) {
                int iXr = op.ka(this.f3451ms).xr();
                boolean z2 = iXr == 0 || iXr == 2;
                if (ms(false)) {
                    this.d.ms(this.ah.ms(), z2);
                    c cVar = this.ah;
                    if (z2) {
                        view = viewGroup;
                    }
                    cVar.ms(viewGroup, view, iXr != 2);
                }
            }
        }
    }

    private void xr(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_pfwv".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                    this.xr.d();
                    this.ah.d();
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_pfwv".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                    this.xr.d();
                    this.ah.d();
                }
            }
        }
    }

    public ab ms() {
        if (this.xr.ah()) {
            return this.xr.xr();
        }
        if (this.ah.ah()) {
            return this.ah.xr();
        }
        return new ab() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.d.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void ms(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ab
            public void xr() {
            }
        };
    }

    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.ms(xrVar);
        }
        ka kaVar = this.xr;
        if (kaVar != null) {
            kaVar.ms(xrVar);
        }
    }

    public void xr() {
        this.xr.d();
        this.ah.d();
    }
}
