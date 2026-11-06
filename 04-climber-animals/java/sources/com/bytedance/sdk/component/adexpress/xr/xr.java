package com.bytedance.sdk.component.adexpress.xr;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ch {
    private ThemeStatusBroadcastReceiver ah;
    private int c;
    private x d;
    private zb ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f998ms;
    private com.bytedance.sdk.component.adexpress.dynamic.ms.ms xr;

    public xr(Context context, zb zbVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.d.x xVar, x xVar2, com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar) {
        this(context, zbVar, themeStatusBroadcastReceiver, z, xVar, xVar2, msVar, null);
    }

    public xr(Context context, zb zbVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.d.x xVar, x xVar2, com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar, com.bytedance.sdk.component.adexpress.dynamic.ms.ms msVar2) {
        this.f998ms = context;
        this.ka = zbVar;
        this.ah = themeStatusBroadcastReceiver;
        this.d = xVar2;
        if (msVar2 != null) {
            this.xr = msVar2;
        } else {
            this.xr = new com.bytedance.sdk.component.adexpress.dynamic.ms.ms(this.f998ms, this.ah, z, xVar, this.ka, msVar);
        }
        this.xr.ms(this.d);
        if (xVar instanceof com.bytedance.sdk.component.adexpress.dynamic.d.ab) {
            this.c = 3;
        } else {
            this.c = 2;
        }
    }

    public void ms(boolean z) {
        this.xr.xr(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public boolean ms(final ch.ms msVar) {
        this.ka.ab().ms(this.c);
        this.xr.ms(new ab() { // from class: com.bytedance.sdk.component.adexpress.xr.xr.1
            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(View view, u uVar) {
                if (msVar.ah()) {
                    return;
                }
                xr.this.ka.ab().ka(xr.this.c);
                xr.this.ka.ab().c(xr.this.c);
                xr.this.ka.ab().zb();
                ub ubVarXr = msVar.xr();
                if (ubVarXr == null) {
                    return;
                }
                ubVarXr.ms(xr.this.xr, uVar);
                msVar.ms(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(int i, String str) {
                xr.this.ka.ab().ms(xr.this.c, i, str, msVar.xr(xr.this));
                if (msVar.xr(xr.this)) {
                    msVar.ms(xr.this);
                    return;
                }
                ub ubVarXr = msVar.xr();
                if (ubVarXr == null) {
                    return;
                }
                ubVarXr.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public void ms() {
        com.bytedance.sdk.component.adexpress.dynamic.ms.ms msVar = this.xr;
        if (msVar != null) {
            msVar.xr();
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.d xr() {
        com.bytedance.sdk.component.adexpress.dynamic.ms.ms msVar = this.xr;
        if (msVar != null) {
            return msVar.c();
        }
        return null;
    }
}
