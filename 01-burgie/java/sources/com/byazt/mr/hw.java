package com.byazt.mr;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 13})
public abstract class hw extends zo {
    public PluginValueSet pr;

    public abstract com.byazt.wd.uc a();

    public abstract Map<String, Object> cz();

    public abstract String fo();

    public abstract int lb();

    public abstract View nt();

    public abstract void pr(ViewGroup viewGroup);

    public abstract void pr(ViewGroup viewGroup, Activity activity);

    public abstract void pr(com.byazt.rkl.hn hnVar);

    public abstract void pr(com.byazt.zz.hw hwVar);

    public abstract void pr(com.byazt.zz.pr prVar);

    public abstract void qa();

    public abstract View yb();

    public PluginValueSet zo() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetPr = pr();
        this.pr = pluginValueSetPr;
        return pluginValueSetPr;
    }

    private PluginValueSet pr() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(110001, new Supplier<View>() { // from class: com.byazt.mr.hw.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public View get() {
                return hw.this.nt();
            }
        });
        prVarPr.pr(110003, new Supplier<View>() { // from class: com.byazt.mr.hw.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public View get() {
                return hw.this.yb();
            }
        });
        prVarPr.pr(110004, new Supplier<Integer>() { // from class: com.byazt.mr.hw.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(hw.this.lb());
            }
        });
        prVarPr.pr(110005, new Supplier<Map<String, Object>>() { // from class: com.byazt.mr.hw.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return hw.this.cz();
            }
        });
        return prVarPr.hw();
    }

    @Override // com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return zo().sparseArray();
            case 110101:
                qa();
                return null;
            case 110102:
                pr(new com.byazt.rkl.hn((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 110103:
                pr(new com.byazt.zz.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 110106:
                pr(new com.byazt.zz.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 110108:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                pr((ViewGroup) pluginValueSetHw.objectValue(0, ViewGroup.class), (Activity) pluginValueSetHw.objectValue(1, Activity.class));
                return null;
            case 110110:
                return a();
            default:
                return super.apply(sparseArray);
        }
    }
}
