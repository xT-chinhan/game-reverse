package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ab implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1703ms;

    public abstract boolean ah();

    public abstract void ms();

    public abstract void ms(com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar);

    public abstract void ms(String str);

    public abstract void xr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1703ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetD = d();
        this.f1703ms = valueSetD;
        return valueSetD;
    }

    private ValueSet d() {
        return com.bykv.ms.ms.ms.ms.xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 240101:
                ms();
                return null;
            case 240102:
                ms(new com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            case 240103:
                ms((String) valueSet.objectValue(0, String.class));
                return null;
            case 240104:
                xr();
                return null;
            case 240105:
                return (T) Boolean.class.cast(Boolean.valueOf(ah()));
            default:
                return null;
        }
    }
}
