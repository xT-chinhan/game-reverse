package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sl implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1732ms;

    public abstract String ah();

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public abstract double d();

    public abstract boolean ka();

    public abstract int ms();

    public abstract int xr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1732ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetC = c();
        this.f1732ms = valueSetC;
        return valueSetC;
    }

    private ValueSet c() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(230002, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.sl.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sl.this.ms());
            }
        });
        xrVarMs.ms(230001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.sl.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sl.this.xr());
            }
        });
        xrVarMs.ms(230003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.sl.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return sl.this.ah();
            }
        });
        xrVarMs.ms(230004, new ValueSet.ValueGetter<Double>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.sl.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(sl.this.d());
            }
        });
        xrVarMs.ms(230005, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.sl.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(sl.this.ka());
            }
        });
        return xrVarMs.xr();
    }
}
