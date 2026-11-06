package com.byazt.nq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1068, 8})
public abstract class s implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract n fs();

    public abstract boolean l();

    public abstract List<n> rv();

    public abstract n tj();

    public abstract List<qg> w();

    public abstract List<n> x();

    public PluginValueSet cp() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetN = n();
        this.n = pluginValueSetN;
        return pluginValueSetN;
    }

    private PluginValueSet n() {
        return com.byazt.qvu.n.n().qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 270001:
                    return Boolean.class.cast(Boolean.valueOf(l()));
                case 270002:
                    return w();
                case 270003:
                    return x();
                case 270004:
                    return fs();
                case 270005:
                    return rv();
                case 270006:
                    return tj();
                default:
                    return null;
            }
        }
        return cp().sparseArray();
    }
}
