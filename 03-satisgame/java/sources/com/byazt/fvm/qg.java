package com.byazt.fvm;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 26})
public abstract class qg extends fs {
    public PluginValueSet n;

    public abstract com.byazt.nq.x fs();

    public abstract int l();

    public abstract void n(ViewGroup viewGroup);

    public abstract void n(ViewGroup viewGroup, Activity activity);

    public abstract void n(com.byazt.cne.n nVar);

    public abstract void n(com.byazt.cne.qg qgVar);

    public abstract void n(com.byazt.mi.s sVar);

    public abstract View q();

    public abstract String qg();

    public abstract View s();

    public abstract Map<String, Object> w();

    public abstract void x();

    public PluginValueSet n() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetRv = rv();
        this.n = pluginValueSetRv;
        return pluginValueSetRv;
    }

    private PluginValueSet rv() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(110001, new Supplier<View>() { // from class: com.byazt.fvm.qg.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public View get() {
                return qg.this.s();
            }
        });
        nVarN.n(110003, new Supplier<View>() { // from class: com.byazt.fvm.qg.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public View get() {
                return qg.this.q();
            }
        });
        nVarN.n(110004, new Supplier<Integer>() { // from class: com.byazt.fvm.qg.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qg.this.l());
            }
        });
        nVarN.n(110005, new Supplier<Map<String, Object>>() { // from class: com.byazt.fvm.qg.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return qg.this.w();
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
        pluginValueSetQg.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return n().sparseArray();
            case 110101:
                x();
                return null;
            case 110102:
                n(new com.byazt.mi.s((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            case 110103:
                n(new com.byazt.cne.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            case 110106:
                n(new com.byazt.cne.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            case 110108:
                n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                n((ViewGroup) pluginValueSetQg.objectValue(0, ViewGroup.class), (Activity) pluginValueSetQg.objectValue(1, Activity.class));
                return null;
            case 110110:
                return fs();
            default:
                return super.apply(sparseArray);
        }
    }
}
