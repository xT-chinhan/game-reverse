package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 50})
public abstract class vk extends m {
    public PluginValueSet pr;

    public abstract double j_();

    public abstract int k();

    public abstract com.byazt.pu.pr k_();

    public abstract void pr(com.byazt.rt.hw hwVar);

    public abstract void pr(com.byazt.rt.pr prVar);

    public abstract int w();

    @Override // com.byazt.mr.m
    public PluginValueSet s_() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetC = c();
        this.pr = pluginValueSetC;
        return pluginValueSetC;
    }

    private PluginValueSet c() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr(super.s_());
        prVarPr.pr(160001, new Supplier<Double>() { // from class: com.byazt.mr.vk.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(vk.this.j_());
            }
        });
        prVarPr.pr(160002, new Supplier<com.byazt.pu.pr>() { // from class: com.byazt.mr.vk.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.pu.pr get() {
                return vk.this.k_();
            }
        });
        prVarPr.pr(160003, new Supplier<Integer>() { // from class: com.byazt.mr.vk.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(vk.this.w());
            }
        });
        prVarPr.pr(160004, new Supplier<Integer>() { // from class: com.byazt.mr.vk.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(vk.this.k());
            }
        });
        return prVarPr.hw();
    }

    @Override // com.byazt.mr.m, com.byazt.mr.zo, java.util.function.Function
    /* JADX INFO: renamed from: pr */
    public Object apply(SparseArray<Object> sparseArray) {
        com.byazt.ti.hn hnVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case -99999986:
                return s_().sparseArray();
            case 140111:
                Function function = (Function) pluginValueSetHw.objectValue(0, Function.class);
                if (pluginValueSetHw.intValue(1) == 1) {
                    hnVar = new com.byazt.mt.hw(function);
                } else {
                    hnVar = new com.byazt.ti.hn(function);
                }
                pr(hnVar);
                return null;
            case 160101:
                pr(new com.byazt.rt.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 160102:
                pr(new com.byazt.rt.hw((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
