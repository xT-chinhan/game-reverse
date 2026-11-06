package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1749ms;

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar);

    public abstract void ms(Double d);

    public abstract void ms(Double d, String str, String str2);

    public abstract void xr(Double d);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1749ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f1749ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        return com.bykv.ms.ms.ms.ms.xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 210101:
                ms(Double.valueOf(valueSet.doubleValue(0)));
                break;
            case 210102:
                ms(Double.valueOf(valueSet.doubleValue(0)), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 210103:
                xr(Double.valueOf(valueSet.doubleValue(0)));
                break;
            case 210104:
                ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return null;
    }
}
