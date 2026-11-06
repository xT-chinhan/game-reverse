package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 121})
public abstract class x implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract List<uc> pr();

    public PluginValueSet hw() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetHn = hn();
        this.pr = pluginValueSetHn;
        return pluginValueSetHn;
    }

    private PluginValueSet hn() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(243001, new Supplier<List<uc>>() { // from class: com.byazt.mr.x.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public List<uc> get() {
                return x.this.pr();
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
                return hw().sparseArray();
            default:
                return null;
        }
    }
}
