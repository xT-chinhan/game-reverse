package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1704ms;

    public abstract String ab();

    public abstract String ah();

    public abstract String c();

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public abstract String d();

    public abstract Map<String, String> ka();

    public abstract String ms();

    public abstract String ny();

    public abstract String x();

    public abstract String xr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1704ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetCh = ch();
        this.f1704ms = valueSetCh;
        return valueSetCh;
    }

    private ValueSet ch() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(250001, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.ms();
            }
        });
        xrVarMs.ms(250002, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.xr();
            }
        });
        xrVarMs.ms(250003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.ah();
            }
        });
        xrVarMs.ms(250004, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.d();
            }
        });
        xrVarMs.ms(250006, new ValueSet.ValueGetter<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return ah.this.ka();
            }
        });
        xrVarMs.ms(250005, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.c();
            }
        });
        xrVarMs.ms(250007, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.ab();
            }
        });
        xrVarMs.ms(250008, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.x();
            }
        });
        xrVarMs.ms(250009, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ah.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ah.this.ny();
            }
        });
        return xrVarMs.xr();
    }
}
