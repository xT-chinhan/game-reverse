package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zb extends x implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1755ms;

    public abstract Bitmap ab();

    public abstract void ah();

    public abstract sl ao();

    public abstract ka b();

    public abstract String ch();

    public abstract List<sl> h();

    public abstract int h_();

    public abstract int hi();

    public abstract int i_();

    public abstract String j_();

    public abstract ah le();

    public abstract View ms();

    public abstract ab ms(Activity activity);

    public abstract ab ms(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    public abstract void ms(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.ms msVar2);

    public abstract void ms(Activity activity, com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms msVar);

    public abstract void ms(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar);

    public abstract void ms(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar);

    public abstract void ms(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar);

    public abstract void ms(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar);

    public abstract void ms(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.ao.xr.ms.xr xrVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah ahVar);

    public abstract void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar);

    public abstract void ms(String str);

    public abstract String ny();

    public abstract int qv();

    public abstract void re();

    public abstract sl s_();

    public abstract d t();

    public abstract String t_();

    public abstract Map<String, Object> ub();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d xr();

    public abstract void xr(Activity activity);

    public abstract void xr(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    public abstract int y();

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1755ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetD = d();
        this.f1755ms = valueSetD;
        return valueSetD;
    }

    private ValueSet d() {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(super.values());
        xrVarMs.ms(140001, new ValueSet.ValueGetter<sl>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public sl get() {
                return zb.this.s_();
            }
        });
        xrVarMs.ms(140002, new ValueSet.ValueGetter<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return zb.this.ab();
            }
        });
        xrVarMs.ms(140003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return zb.this.t_();
            }
        });
        xrVarMs.ms(140004, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.13
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return zb.this.ny();
            }
        });
        xrVarMs.ms(140018, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.14
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return zb.this.ch();
            }
        });
        xrVarMs.ms(140005, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.15
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(zb.this.hi());
            }
        });
        xrVarMs.ms(140006, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.16
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(zb.this.h_());
            }
        });
        xrVarMs.ms(140007, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.17
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(zb.this.i_());
            }
        });
        xrVarMs.ms(140008, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.18
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public String get() {
                return zb.this.j_();
            }
        });
        xrVarMs.ms(140009, new ValueSet.ValueGetter<sl>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public sl get() {
                return zb.this.ao();
            }
        });
        xrVarMs.ms(140010, new ValueSet.ValueGetter<List<sl>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public List<sl> get() {
                return zb.this.h();
            }
        });
        xrVarMs.ms(140011, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(zb.this.qv());
            }
        });
        xrVarMs.ms(140012, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(zb.this.y());
            }
        });
        xrVarMs.ms(140013, new ValueSet.ValueGetter<d>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public d get() {
                return zb.this.t();
            }
        });
        xrVarMs.ms(140014, new ValueSet.ValueGetter<ah>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ah get() {
                return zb.this.le();
            }
        });
        xrVarMs.ms(140015, new ValueSet.ValueGetter<ka>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public ka get() {
                return zb.this.b();
            }
        });
        xrVarMs.ms(140016, new ValueSet.ValueGetter<View>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public View get() {
                return zb.this.ms();
            }
        });
        xrVarMs.ms(140017, new ValueSet.ValueGetter<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ao.xr.xr.zb.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter, java.util.function.Supplier
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return zb.this.ub();
            }
        });
        return xrVarMs.xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 140101:
                return (T) ms((Activity) valueSet.objectValue(0, Activity.class));
            case 140102:
                return (T) ms((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
            case 140103:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (View) valueSet.objectValue(1, View.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(2, Bridge.class)));
                break;
            case 140104:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (List) valueSet.objectValue(1, List.class), (List) valueSet.objectValue(2, List.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(3, Bridge.class)));
                break;
            case 140105:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (List) valueSet.objectValue(1, List.class), (List) valueSet.objectValue(2, List.class), (View) valueSet.objectValue(3, View.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(4, Bridge.class)));
                break;
            case 140106:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (List) valueSet.objectValue(1, List.class), (List) valueSet.objectValue(2, List.class), (List) valueSet.objectValue(3, List.class), (View) valueSet.objectValue(4, View.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(5, Bridge.class)));
                break;
            case 140107:
                ms((ViewGroup) valueSet.objectValue(0, ViewGroup.class), (List<View>) valueSet.objectValue(1, List.class), (List<View>) valueSet.objectValue(2, List.class), (List<View>) valueSet.objectValue(3, List.class), (List<View>) valueSet.objectValue(4, List.class), (View) valueSet.objectValue(5, View.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(6, Bridge.class)));
                break;
            case 140108:
                ms(new com.bytedance.sdk.openadsdk.ao.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 140109:
                xr((Activity) valueSet.objectValue(0, Activity.class));
                break;
            case 140110:
                re();
                break;
            case 140111:
                ms(new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ah((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 140112:
                ms((Activity) valueSet.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.y.ms.xr.ms.ms((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 140113:
                xr((TTDislikeDialogAbstract) valueSet.objectValue(0, TTDislikeDialogAbstract.class));
                break;
            case 140114:
                ah();
                break;
            case 140115:
                valueSet.objectValue(0, Activity.class);
                break;
            case 140116:
                return (T) xr();
            case 140117:
                ms((Activity) valueSet.objectValue(0, Activity.class), (ViewGroup) valueSet.objectValue(1, ViewGroup.class), (List<View>) valueSet.objectValue(2, List.class), (List<View>) valueSet.objectValue(3, List.class), (List<View>) valueSet.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms((Bridge) valueSet.objectValue(5, Bridge.class)), new com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.ms((Bridge) valueSet.objectValue(6, Bridge.class)));
                break;
            case 140118:
                ms((String) valueSet.objectValue(0, String.class));
                break;
            case 140119:
                ms(new com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
