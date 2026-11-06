package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1728ms;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public abstract int ms();

    public abstract String xr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1728ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetAh = ah();
        this.f1728ms = valueSetAh;
        return valueSetAh;
    }

    private ValueSet ah() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(263001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ms.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ms.this.ms());
            }
        });
        xrVarMs.ms(263002, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ms.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.xr();
            }
        });
        return xrVarMs.xr();
    }
}
