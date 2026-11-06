package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ka implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1727ms;

    public abstract void ms();

    public abstract void xr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1727ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetAh = ah();
        this.f1727ms = valueSetAh;
        return valueSetAh;
    }

    private ValueSet ah() {
        return com.bykv.ms.ms.ms.ms.xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 222101:
                ms();
                break;
            case 222102:
                xr();
                break;
        }
        return null;
    }
}
