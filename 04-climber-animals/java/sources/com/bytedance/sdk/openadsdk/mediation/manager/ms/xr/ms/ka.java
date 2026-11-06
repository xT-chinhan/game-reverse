package com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ka extends xr implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4018ms;

    public abstract void destroy();

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f4018ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f4018ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        return com.bykv.ms.ms.ms.ms.xr.ms(super.values()).xr();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 270007) {
            destroy();
        }
        return (T) super.call(i, valueSet, cls);
    }
}
