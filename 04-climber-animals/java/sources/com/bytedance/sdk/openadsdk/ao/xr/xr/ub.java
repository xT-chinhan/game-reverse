package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ub extends x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1744ms;

    public abstract Map<String, Object> ab();

    public abstract int ah();

    public abstract long d();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ka ka();

    public abstract void ms(Activity activity);

    public abstract void ms(Activity activity, TTAdConstant.RitScenes ritScenes, String str);

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr xrVar);

    public abstract int xr();

    public abstract void xr(com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms msVar);

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1744ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f1744ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(120001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ub.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ub.this.xr());
            }
        });
        xrVarMs.ms(120002, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ub.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return ub.this.ab();
            }
        });
        xrVarMs.ms(120003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ub.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(ub.this.ah());
            }
        });
        xrVarMs.ms(120004, new ValueSet.ValueGetter<Long>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.ub.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(ub.this.d());
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 121109) {
            switch (i) {
                case 120101:
                    ms(new com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120102:
                    xr(new com.bytedance.sdk.openadsdk.yu.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120103:
                    ms(new com.bytedance.sdk.openadsdk.yu.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120104:
                    ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                    break;
                case 120105:
                    ms((Activity) valueSet.objectValue(0, Activity.class));
                    break;
                case 120106:
                    ms((Activity) valueSet.objectValue(0, Activity.class), (TTAdConstant.RitScenes) valueSet.objectValue(1, TTAdConstant.RitScenes.class), (String) valueSet.objectValue(2, String.class));
                    break;
            }
            return (T) super.call(i, valueSet, cls);
        }
        return (T) ka();
    }
}
