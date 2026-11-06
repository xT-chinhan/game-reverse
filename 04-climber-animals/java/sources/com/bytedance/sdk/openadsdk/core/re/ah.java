package com.bytedance.sdk.openadsdk.core.re;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.ny;
import com.bytedance.sdk.openadsdk.core.t.u;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ao<Bitmap> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3296ms;
    private com.bytedance.sdk.openadsdk.core.t.ms.xr xr;

    public void ms(String str) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.ah(str);
    }

    public void ms(int i) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.ms(i);
    }

    public void xr(String str) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.c(str);
    }

    public void ah(String str) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.d(str);
    }

    public void d(String str) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.x(str);
    }

    public ah(boolean z) {
        this.f3296ms = z;
        if (z) {
            this.xr = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr();
        }
    }

    @Override // com.bytedance.sdk.component.c.ao
    @ATSMethod(1)
    public void ms(hi<Bitmap> hiVar) {
        if (!this.f3296ms || this.xr == null) {
            return;
        }
        if (hiVar == null || hiVar.ah() == null) {
            this.xr.xr(202).ab(ny.ms(202));
            u.ms().ms(this.xr);
        }
    }

    @Override // com.bytedance.sdk.component.c.ao
    @ATSMethod(2)
    public void ms(int i, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.t.ms.xr xrVar;
        if (!this.f3296ms || (xrVar = this.xr) == null) {
            return;
        }
        xrVar.xr(201).ab(ny.ms(201));
        u.ms().ms(this.xr);
    }
}
