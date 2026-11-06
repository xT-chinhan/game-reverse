package com.bytedance.sdk.component.adexpress.xr;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ch {
    private zb ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f994ms;
    private ms xr;

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public void ms() {
    }

    public c(Context context, zb zbVar, ms msVar) {
        this.f994ms = context;
        this.xr = msVar;
        this.ah = zbVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.xr.ch
    public boolean ms(final ch.ms msVar) {
        this.ah.ab().ny();
        this.xr.ms(new ab() { // from class: com.bytedance.sdk.component.adexpress.xr.c.1
            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(View view, u uVar) {
                if (msVar.ah()) {
                    return;
                }
                ub ubVarXr = msVar.xr();
                if (ubVarXr != null) {
                    ubVarXr.ms(c.this.xr, uVar);
                }
                msVar.ms(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.xr.ab
            public void ms(int i, String str) {
                ub ubVarXr = msVar.xr();
                if (ubVarXr != null) {
                    ubVarXr.a_(i);
                }
            }
        });
        return true;
    }

    public void ms(ah ahVar) {
        this.xr.ms(ahVar);
    }
}
