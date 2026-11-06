package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 5})
public abstract class q implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract List<w> n();

    public PluginValueSet qg() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetS = s();
        this.n = pluginValueSetS;
        return pluginValueSetS;
    }

    private PluginValueSet s() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(243001, new Supplier<List<w>>() { // from class: com.byazt.fvm.q.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public List<w> get() {
                return q.this.n();
            }
        });
        return nVarN.qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null && com.byazt.qvu.n.n(sparseArray).qg().intValue(-99999987) == -99999986) {
            return qg().sparseArray();
        }
        return null;
    }
}
