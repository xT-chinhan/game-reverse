package com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4019ms;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    public abstract String getSubRitType();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f4019ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f4019ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(271006, new ValueSet.ValueGetter<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, String> get() {
                return ms.this.getCustomData();
            }
        });
        xrVarMs.ms(271007, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getSdkName();
            }
        });
        xrVarMs.ms(271008, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getCustomSdkName();
            }
        });
        xrVarMs.ms(271009, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getSlotId();
            }
        });
        xrVarMs.ms(271010, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getLevelTag();
            }
        });
        xrVarMs.ms(271011, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.13
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getEcpm();
            }
        });
        xrVarMs.ms(271012, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.14
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ms.this.getReqBiddingType());
            }
        });
        xrVarMs.ms(271013, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.15
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getErrorMsg();
            }
        });
        xrVarMs.ms(271014, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.16
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getRequestId();
            }
        });
        xrVarMs.ms(271015, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getRitType();
            }
        });
        xrVarMs.ms(271016, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getSegmentId();
            }
        });
        xrVarMs.ms(271017, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getChannel();
            }
        });
        xrVarMs.ms(271018, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getSubChannel();
            }
        });
        xrVarMs.ms(271019, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getAbTestId();
            }
        });
        xrVarMs.ms(271020, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getScenarioId();
            }
        });
        xrVarMs.ms(271051, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ms.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return ms.this.getSubRitType();
            }
        });
        return xrVarMs.xr();
    }
}
