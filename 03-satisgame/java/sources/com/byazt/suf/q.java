package com.byazt.suf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 797, 5})
public abstract class q implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract String fs();

    public abstract Map<String, String> l();

    public abstract String n();

    public abstract String q();

    public abstract String qg();

    public abstract String rv();

    public abstract long s();

    public abstract Map<String, Object> tj();

    public abstract String w();

    public abstract String x();

    public PluginValueSet cp() {
        return com.byazt.qvu.n.n().qg();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            PluginValueSet pluginValueSet = this.n;
            if (pluginValueSet != null) {
                return pluginValueSet.sparseArray();
            }
            PluginValueSet pluginValueSetCp = cp();
            this.n = pluginValueSetCp;
            return pluginValueSetCp.sparseArray();
        }
        if (iIntValue == 271047) {
            return fs();
        }
        if (iIntValue != 271051) {
            switch (iIntValue) {
                case 271035:
                    return n();
                case 271036:
                    return qg();
                case 271037:
                    return Long.class.cast(Long.valueOf(s()));
                case 271038:
                    return q();
                case 271039:
                    return l();
                case 271040:
                    return w();
                case 271041:
                    return x();
                case 271042:
                    return tj();
                default:
                    return null;
            }
        }
        return rv();
    }
}
