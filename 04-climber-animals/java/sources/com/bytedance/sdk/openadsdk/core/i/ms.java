package com.bytedance.sdk.openadsdk.core.i;

import com.bytedance.sdk.openadsdk.core.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    Boolean f2666ms = null;
    Boolean xr = null;
    Boolean ah = null;

    public boolean ms() {
        if (this.f2666ms == null) {
            com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
            this.f2666ms = Boolean.valueOf(kaVarAo == null || kaVarAo.ah());
        }
        return this.f2666ms.booleanValue();
    }

    public boolean xr() {
        if (this.xr == null) {
            com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
            this.xr = Boolean.valueOf(kaVarAo == null || kaVarAo.d());
        }
        return this.xr.booleanValue();
    }

    public boolean ah() {
        if (this.ah == null) {
            com.bytedance.sdk.openadsdk.core.f.ka kaVarAo = ch.ub().ao();
            this.ah = Boolean.valueOf(kaVarAo == null || kaVarAo.ms());
        }
        return this.ah.booleanValue();
    }
}
