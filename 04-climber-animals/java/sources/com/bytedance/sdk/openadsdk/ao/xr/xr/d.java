package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1720ms;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public abstract List<c> ms();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1720ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetXr = xr();
        this.f1720ms = valueSetXr;
        return valueSetXr;
    }

    private ValueSet xr() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(243001, new ValueSet.ValueGetter<List<c>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.d.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public List<c> get() {
                return d.this.ms();
            }
        });
        return xrVarMs.xr();
    }
}
