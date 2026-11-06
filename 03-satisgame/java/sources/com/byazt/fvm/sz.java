package com.byazt.fvm;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 110})
public abstract class sz extends fs {
    public PluginValueSet n;

    public abstract Map<String, Object> fs();

    public abstract void l();

    public abstract View n();

    public abstract x n(Activity activity);

    public abstract void n(int i);

    public abstract void n(Activity activity, com.byazt.lr.n nVar);

    public abstract void n(Dialog dialog, Integer[] numArr);

    public abstract void n(com.byazt.fx.n nVar);

    public abstract void n(com.byazt.fx.qg qgVar);

    public abstract void n(com.byazt.fx.s sVar);

    public abstract void n(com.byazt.mi.s sVar);

    public abstract void n(String str);

    public abstract void n(JSONObject jSONObject);

    public abstract void n(boolean z);

    public abstract void q();

    public abstract int qg();

    public abstract com.byazt.nq.l rv();

    public abstract int s();

    public abstract String tj();

    public abstract q w();

    public abstract void x();

    public PluginValueSet oa() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetCp = cp();
        this.n = pluginValueSetCp;
        return pluginValueSetCp;
    }

    private PluginValueSet cp() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(150001, new Supplier<View>() { // from class: com.byazt.fvm.sz.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public View get() {
                return sz.this.n();
            }
        });
        nVarN.n(150002, new Supplier<Integer>() { // from class: com.byazt.fvm.sz.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sz.this.qg());
            }
        });
        nVarN.n(150003, new Supplier<q>() { // from class: com.byazt.fvm.sz.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public q get() {
                return sz.this.w();
            }
        });
        nVarN.n(150004, new Supplier<Integer>() { // from class: com.byazt.fvm.sz.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(sz.this.s());
            }
        });
        nVarN.n(150005, new Supplier<Map<String, Object>>() { // from class: com.byazt.fvm.sz.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return sz.this.fs();
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 150101:
                    n(new com.byazt.fx.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 150102:
                    n(new com.byazt.fx.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 150103:
                    n(new com.byazt.mi.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 150104:
                    q();
                    return null;
                case 150105:
                    l();
                    return null;
                case 150106:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), new com.byazt.lr.n((Function) pluginValueSetQg.objectValue(1, Function.class)));
                    return null;
                case 150107:
                    Dialog dialog = (Dialog) pluginValueSetQg.objectValue(0, Dialog.class);
                    Integer[] numArr = (Integer[]) pluginValueSetQg.arrayValue(1, Integer.class);
                    if (numArr == null) {
                        numArr = new Integer[0];
                    }
                    n(dialog, numArr);
                    return null;
                case 150108:
                    return n((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                case 150109:
                    pluginValueSetQg.objectValue(0, Activity.class);
                    return null;
                case 150110:
                    n(pluginValueSetQg.intValue(0));
                    return null;
                case 150111:
                    n(new com.byazt.fx.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 150112:
                    n(pluginValueSetQg.booleanValue(0));
                    return null;
                case 150113:
                    return rv();
                case 150114:
                    n((String) pluginValueSetQg.objectValue(0, String.class));
                    return null;
                case 150115:
                    n((JSONObject) pluginValueSetQg.objectValue(0, JSONObject.class));
                    return null;
                case 150116:
                    x();
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return oa().sparseArray();
    }
}
