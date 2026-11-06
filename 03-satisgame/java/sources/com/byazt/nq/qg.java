package com.byazt.nq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1068, 26})
public abstract class qg implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract String l();

    public abstract String n();

    public abstract int q();

    public abstract String qg();

    public abstract String s();

    public PluginValueSet w() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return com.byazt.qvu.n.n(pluginValueSet).qg();
        }
        PluginValueSet pluginValueSetX = x();
        this.n = pluginValueSetX;
        return com.byazt.qvu.n.n(pluginValueSetX).qg();
    }

    private PluginValueSet x() {
        com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
        nVarN.n(271001, new Supplier<String>() { // from class: com.byazt.nq.qg.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return qg.this.n();
            }
        });
        nVarN.n(271002, new Supplier<String>() { // from class: com.byazt.nq.qg.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return qg.this.qg();
            }
        });
        nVarN.n(271003, new Supplier<String>() { // from class: com.byazt.nq.qg.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return qg.this.s();
            }
        });
        nVarN.n(271004, new Supplier<Integer>() { // from class: com.byazt.nq.qg.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(qg.this.q());
            }
        });
        nVarN.n(271005, new Supplier<String>() { // from class: com.byazt.nq.qg.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public String get() {
                return qg.this.l();
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
