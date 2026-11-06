package com.byazt.fvm;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 29})
public abstract class cp extends fs {
    public PluginValueSet n;

    public abstract com.byazt.nq.q l();

    public abstract int n();

    public abstract void n(Activity activity);

    public abstract void n(Activity activity, Object obj, String str);

    public abstract void n(com.byazt.mi.s sVar);

    public abstract void n(com.byazt.rzx.n nVar);

    public abstract long q();

    public abstract Map<String, Object> qg();

    public abstract int s();

    public PluginValueSet rv() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetW = w();
        this.n = pluginValueSetW;
        return pluginValueSetW;
    }

    private PluginValueSet w() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(130001, new Supplier<Integer>() { // from class: com.byazt.fvm.cp.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(cp.this.n());
            }
        });
        nVarN.n(130002, new Supplier<Map<String, Object>>() { // from class: com.byazt.fvm.cp.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return cp.this.qg();
            }
        });
        nVarN.n(130003, new Supplier<Integer>() { // from class: com.byazt.fvm.cp.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(cp.this.s());
            }
        });
        nVarN.n(130004, new Supplier<Long>() { // from class: com.byazt.fvm.cp.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(cp.this.q());
            }
        });
        return nVarN.qg();
    }

    @Override // com.byazt.fvm.fs, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.rzx.n nVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue == -99999986) {
            return rv().sparseArray();
        }
        if (iIntValue != 130106) {
            switch (iIntValue) {
                case 130101:
                    Function function = (Function) pluginValueSetQg.objectValue(0, Function.class);
                    if (pluginValueSetQg.intValue(1) == 1) {
                        nVar = new com.byazt.pe.qg(function);
                    } else {
                        nVar = new com.byazt.rzx.n(function);
                    }
                    n(nVar);
                    return null;
                case 130102:
                    n(new com.byazt.mi.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 130103:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class));
                    return null;
                case 130104:
                    n((Activity) pluginValueSetQg.objectValue(0, Activity.class), pluginValueSetQg.objectValue(1, Object.class), (String) pluginValueSetQg.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return l();
    }
}
