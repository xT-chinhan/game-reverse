package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 37})
public abstract class pr implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract String hw();

    public abstract int pr();

    public PluginValueSet hn() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetX = x();
        this.pr = pluginValueSetX;
        return pluginValueSetX;
    }

    private PluginValueSet x() {
        com.byazt.ij.pr prVarPr = com.byazt.ij.pr.pr();
        prVarPr.pr(263001, new Supplier<Object>() { // from class: com.byazt.mr.pr.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pr.this.pr());
            }
        });
        prVarPr.pr(263002, new Supplier<String>() { // from class: com.byazt.mr.pr.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public String get() {
                return pr.this.hw();
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
                return hn().sparseArray();
            default:
                return null;
        }
    }
}
