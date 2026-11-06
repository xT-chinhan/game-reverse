package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract int n();

    public abstract String qg();

    public PluginValueSet s() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetQ = q();
        this.n = pluginValueSetQ;
        return pluginValueSetQ;
    }

    private PluginValueSet q() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(263001, new Supplier<Object>() { // from class: com.byazt.fvm.n.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(n.this.n());
            }
        });
        nVarN.n(263002, new Supplier<String>() { // from class: com.byazt.fvm.n.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return n.this.qg();
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && com.byazt.qvu.n.n(sparseArray).qg().intValue(-99999987) == -99999986) {
            return s().sparseArray();
        }
        return null;
    }
}
