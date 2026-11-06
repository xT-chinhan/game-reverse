package com.bytedance.sdk.openadsdk.core.t;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class ab implements com.bytedance.sdk.component.x.ms.ms.ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.component.ny.xr f3310ms;

    public ab(com.bytedance.sdk.component.ny.xr xrVar) {
        this.f3310ms = xrVar;
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.ka
    public boolean ms() {
        com.bytedance.sdk.component.ny.xr xrVar = this.f3310ms;
        if (xrVar != null) {
            return xrVar.x();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.ka
    public String xr() {
        com.bytedance.sdk.component.ny.xr xrVar = this.f3310ms;
        return xrVar != null ? xrVar.d() : "";
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.ka
    public int ah() {
        com.bytedance.sdk.component.ny.xr xrVar = this.f3310ms;
        if (xrVar != null) {
            return xrVar.ms();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.ka
    public String d() {
        com.bytedance.sdk.component.ny.xr xrVar = this.f3310ms;
        return xrVar != null ? xrVar.xr() : "";
    }

    @Override // com.bytedance.sdk.component.x.ms.ms.ka
    public Map<String, String> ka() {
        com.bytedance.sdk.component.ny.xr xrVar = this.f3310ms;
        if (xrVar != null) {
            return xrVar.ah();
        }
        return new HashMap();
    }
}
