package com.byazt.nq;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1068, 5})
public abstract class q extends s {
    public PluginValueSet n;

    public abstract void n();

    @Override // com.byazt.nq.s
    public PluginValueSet cp() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetQg = qg();
        this.n = pluginValueSetQg;
        return pluginValueSetQg;
    }

    private PluginValueSet qg() {
        return com.byazt.qvu.n.n(super.cp()).qg();
    }

    @Override // com.byazt.nq.s, java.util.function.Function
    /* JADX INFO: renamed from: n */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return cp().sparseArray();
        }
        if (iIntValue == 270007) {
            n();
            return null;
        }
        return super.apply(sparseArray);
    }
}
