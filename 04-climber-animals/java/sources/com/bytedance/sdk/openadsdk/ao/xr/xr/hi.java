package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hi extends x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1722ms;

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.ah ab();

    public abstract long c();

    public abstract Map<String, Object> d();

    public abstract int ka();

    public abstract void ms(Activity activity);

    public abstract void ms(Activity activity, TTAdConstant.RitScenes ritScenes, String str);

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms msVar);

    public abstract int xr();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1722ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f1722ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(130001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.hi.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(hi.this.xr());
            }
        });
        xrVarMs.ms(130002, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.hi.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return hi.this.d();
            }
        });
        xrVarMs.ms(130003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.hi.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(hi.this.ka());
            }
        });
        xrVarMs.ms(130004, new ValueSet.ValueGetter<Long>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.hi.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(hi.this.c());
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 130101:
                ms(new com.bytedance.sdk.openadsdk.re.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 130102:
                ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 130103:
                ms((Activity) valueSet.objectValue(0, Activity.class));
                break;
            case 130104:
                ms((Activity) valueSet.objectValue(0, Activity.class), (TTAdConstant.RitScenes) valueSet.objectValue(1, TTAdConstant.RitScenes.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 130106:
                return (T) ab();
        }
        return (T) super.call(i, valueSet, cls);
    }
}
