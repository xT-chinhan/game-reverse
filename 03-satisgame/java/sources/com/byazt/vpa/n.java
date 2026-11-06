package com.byazt.vpa;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 489, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract void n(Bundle bundle);

    private PluginValueSet n() {
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
        if (iIntValue != -99999986) {
            if (iIntValue == 123101) {
                n((Bundle) pluginValueSetQg.objectValue(0, Bundle.class));
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetN = n();
        this.n = pluginValueSetN;
        return pluginValueSetN.sparseArray();
    }
}
