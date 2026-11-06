package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 18})
public abstract class l implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract void n();

    public abstract void qg();

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
        return com.byazt.qvu.n.n().qg();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        pluginValueSetQg.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return s().sparseArray();
            case 222101:
                n();
                return null;
            case 222102:
                qg();
                return null;
            default:
                return null;
        }
    }
}
