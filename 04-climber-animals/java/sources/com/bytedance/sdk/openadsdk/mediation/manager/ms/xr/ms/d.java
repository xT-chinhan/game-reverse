package com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends xr implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4015ms;

    public abstract boolean hasDislike();

    public abstract boolean isExpress();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setShakeViewListener(com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.xr xrVar);

    public abstract void setUseCustomVideo(boolean z);

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f4015ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f4015ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(270008, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(d.this.hasDislike());
            }
        });
        xrVarMs.ms(270011, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(d.this.isExpress());
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.xr, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 270009:
                setUseCustomVideo(valueSet.booleanValue(0));
                break;
            case 270010:
                setShakeViewListener(new com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 271048:
                onResume();
                break;
            case 271049:
                onPause();
                break;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
