package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 113})
public abstract class d implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract boolean l();

    public abstract int n();

    public abstract double q();

    public abstract int qg();

    public abstract String s();

    public PluginValueSet w() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetX = x();
        this.n = pluginValueSetX;
        return pluginValueSetX;
    }

    private PluginValueSet x() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(230002, new Supplier<Integer>() { // from class: com.byazt.fvm.d.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(d.this.n());
            }
        });
        nVarN.n(230001, new Supplier<Integer>() { // from class: com.byazt.fvm.d.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(d.this.qg());
            }
        });
        nVarN.n(230003, new Supplier<String>() { // from class: com.byazt.fvm.d.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return d.this.s();
            }
        });
        nVarN.n(230004, new Supplier<Double>() { // from class: com.byazt.fvm.d.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(d.this.q());
            }
        });
        nVarN.n(230005, new Supplier<Boolean>() { // from class: com.byazt.fvm.d.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(d.this.l());
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && com.byazt.qvu.n.n(sparseArray).qg().intValue(-99999987) == -99999986) {
            return w().sparseArray();
        }
        return null;
    }
}
