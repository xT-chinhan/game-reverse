package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 250})
public abstract class k implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract boolean c();

    public abstract String hn();

    public abstract int hw();

    public abstract int pr();

    public abstract double x();

    public PluginValueSet uc() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetFw = fw();
        this.pr = pluginValueSetFw;
        return pluginValueSetFw;
    }

    private PluginValueSet fw() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(230002, new Supplier<Integer>() { // from class: com.byazt.mr.k.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.pr());
            }
        });
        prVarPr.pr(230001, new Supplier<Integer>() { // from class: com.byazt.mr.k.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(k.this.hw());
            }
        });
        prVarPr.pr(230003, new Supplier<String>() { // from class: com.byazt.mr.k.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return k.this.hn();
            }
        });
        prVarPr.pr(230004, new Supplier<Double>() { // from class: com.byazt.mr.k.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(k.this.x());
            }
        });
        prVarPr.pr(230005, new Supplier<Boolean>() { // from class: com.byazt.mr.k.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(k.this.c());
            }
        });
        return prVarPr.hw();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        switch (com.byazt.ij.pr.pr(sparseArray).hw().intValue(-99999987)) {
            case -99999986:
                return uc().sparseArray();
            default:
                return null;
        }
    }
}
