package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ch extends zb implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1715ms;

    public abstract double k_();

    public abstract void ms(com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.b.ms.xr.ms.xr xrVar);

    public abstract int sl();

    public abstract com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms u();

    public abstract int zb();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb, com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1715ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetD = d();
        this.f1715ms = valueSetD;
        return valueSetD;
    }

    private ValueSet d() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(160001, new ValueSet.ValueGetter<Double>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ch.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(ch.this.k_());
            }
        });
        xrVarMs.ms(160002, new ValueSet.ValueGetter<com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ch.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms get() {
                return ch.this.u();
            }
        });
        xrVarMs.ms(160003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ch.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ch.this.sl());
            }
        });
        xrVarMs.ms(160004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ch.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ch.this.zb());
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb, com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 160101:
                ms(new com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 160102:
                ms(new com.bytedance.sdk.openadsdk.b.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
