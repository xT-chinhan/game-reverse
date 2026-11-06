package com.bytedance.sdk.component.ah.xr.ms.xr;

import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ms implements t {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final re f1130ms;

    public ms(re reVar) {
        this.f1130ms = reVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t
    public cv ms(t.ms msVar) throws IOException {
        com.bytedance.sdk.component.ah.xr.ms.ah.ab abVar = (com.bytedance.sdk.component.ah.xr.ms.ah.ab) msVar;
        yu yuVarMs = abVar.ms();
        if (yuVarMs != null && yuVarMs.c != null) {
            yuVarMs.c.xr();
        }
        ab abVarC = abVar.c();
        com.bytedance.sdk.component.ah.xr.ms.ah.ah ahVarMs = abVarC.ms(this.f1130ms, msVar, !yuVarMs.xr().equals("GET"));
        ah ahVarXr = abVarC.xr();
        if (yuVarMs != null && yuVarMs.c != null) {
            yuVarMs.c.ah();
        }
        return abVar.ms(yuVarMs, abVarC, ahVarMs, ahVarXr);
    }
}
