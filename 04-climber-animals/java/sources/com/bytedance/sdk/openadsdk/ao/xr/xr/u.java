package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1738ms;

    public abstract d ah();

    public abstract void c();

    public abstract void ch();

    public abstract int d();

    public abstract void ka();

    public abstract View ms();

    public abstract ab ms(Activity activity);

    public abstract void ms(int i);

    public abstract void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar);

    public abstract void ms(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah ahVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.ms msVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr xrVar);

    public abstract void ms(String str);

    public abstract void ms(JSONObject jSONObject);

    public abstract void ms(boolean z);

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d ny();

    public abstract Map<String, Object> x();

    public abstract int xr();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1738ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetAb = ab();
        this.f1738ms = valueSetAb;
        return valueSetAb;
    }

    private ValueSet ab() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(150001, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.u.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public View get() {
                return u.this.ms();
            }
        });
        xrVarMs.ms(150002, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.u.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.xr());
            }
        });
        xrVarMs.ms(150003, new ValueSet.ValueGetter<d>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.u.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public d get() {
                return u.this.ah();
            }
        });
        xrVarMs.ms(150004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.u.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(u.this.d());
            }
        });
        xrVarMs.ms(150005, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.u.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return u.this.x();
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 150101:
                ms(new com.bytedance.sdk.openadsdk.w.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150102:
                ms(new com.bytedance.sdk.openadsdk.w.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150103:
                ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150104:
                ka();
                break;
            case 150105:
                c();
                break;
            case 150106:
                ms((Activity) valueSet.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 150107:
                ms((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
                break;
            case 150108:
                return (T) ms((Activity) valueSet.objectValue(0, Activity.class));
            case 150109:
                valueSet.objectValue(0, Activity.class);
                break;
            case 150110:
                ms(valueSet.intValue(0));
                break;
            case 150111:
                ms(new com.bytedance.sdk.openadsdk.w.ms.xr.ms.ah((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 150112:
                ms(valueSet.booleanValue(0));
                break;
            case 150113:
                return (T) ny();
            case 150114:
                ms((String) valueSet.objectValue(0, String.class));
                break;
            case 150115:
                ms((JSONObject) valueSet.objectValue(0, JSONObject.class));
                break;
            case 150116:
                ch();
                break;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
