package com.byazt.suf;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.fvm.x;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 797, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract q cp();

    public abstract boolean d();

    public abstract String fs();

    public abstract String l();

    public abstract s n(Activity activity);

    public abstract s n(Activity activity, Map<String, Object> map);

    public abstract String n();

    public abstract void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.he.q qVar);

    public abstract void n(Activity activity, com.byazt.lr.n nVar);

    public abstract void n(Dialog dialog, Integer[] numArr);

    public abstract com.byazt.fvm.q oa();

    public abstract String q();

    public abstract x qg(Activity activity);

    public abstract x qg(Dialog dialog, Integer[] numArr);

    public abstract String qg();

    public abstract int rv();

    public abstract String s();

    public abstract int tj();

    public abstract double w();

    public abstract List<String> x();

    public PluginValueSet sz() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetK = k();
        this.n = pluginValueSetK;
        return pluginValueSetK;
    }

    private PluginValueSet k() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(268101, new Supplier<q>() { // from class: com.byazt.suf.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public q get() {
                return n.this.cp();
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 268001:
                    return n();
                case 268002:
                    return qg();
                case 268003:
                    return s();
                case 268004:
                    return q();
                case 268005:
                    return l();
                case 268006:
                    return Double.class.cast(Double.valueOf(w()));
                case 268007:
                    return x();
                case 268008:
                    return fs();
                case 268009:
                    return Integer.class.cast(Integer.valueOf(rv()));
                case 268010:
                    return Integer.class.cast(Integer.valueOf(tj()));
                case 268011:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), (ViewGroup) pluginValueSetQg.objectValue(1, ViewGroup.class), (List) pluginValueSetQg.objectValue(2, List.class), (List) pluginValueSetQg.objectValue(3, List.class), (List) pluginValueSetQg.objectValue(4, List.class), new com.byazt.he.q((Function) pluginValueSetQg.objectValue(5, Function.class)));
                    return null;
                case 268012:
                    return Boolean.class.cast(Boolean.valueOf(d()));
                default:
                    switch (iIntValue) {
                        case 268016:
                            n((Activity) pluginValueSetQg.objectValue(0, Activity.class), new com.byazt.lr.n((Function) pluginValueSetQg.objectValue(1, Function.class)));
                            return null;
                        case 268017:
                            n((Dialog) pluginValueSetQg.objectValue(0, Dialog.class), (Integer[]) pluginValueSetQg.arrayValue(1, Integer.class));
                            return null;
                        case 268018:
                            return qg((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                        case 268019:
                            return qg((Dialog) pluginValueSetQg.objectValue(0, Dialog.class), (Integer[]) pluginValueSetQg.arrayValue(1, Integer.class));
                        case 268020:
                            return oa();
                        default:
                            switch (iIntValue) {
                                case 268102:
                                    return n((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                                case 268103:
                                    return n((Activity) pluginValueSetQg.objectValue(0, Activity.class), (Map<String, Object>) pluginValueSetQg.objectValue(1, Map.class));
                                default:
                                    return null;
                            }
                    }
            }
        }
        return sz().sparseArray();
    }
}
