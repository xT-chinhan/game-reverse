package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr extends x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1750ms;

    public abstract int h();

    public abstract void ms(ViewGroup viewGroup);

    public abstract void ms(ViewGroup viewGroup, Activity activity);

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms msVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr xrVar);

    public abstract void qv();

    public abstract Map<String, Object> t();

    public abstract View u();

    public abstract View ub();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.c y();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1750ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f1750ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(110001, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.xr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public View get() {
                return xr.this.u();
            }
        });
        xrVarMs.ms(110003, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.xr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public View get() {
                return xr.this.ub();
            }
        });
        xrVarMs.ms(110004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.xr.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(xr.this.h());
            }
        });
        xrVarMs.ms(110005, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.xr.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return xr.this.t();
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 110101:
                qv();
                break;
            case 110102:
                ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110103:
                ms(new com.bytedance.sdk.openadsdk.d.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110106:
                ms(new com.bytedance.sdk.openadsdk.d.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 110108:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class));
                break;
            case 110109:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (Activity) valueSet.objectValue(1, Activity.class));
                break;
            case 110110:
                return (T) y();
        }
        return (T) super.call(i, valueSet, cls);
    }
}
