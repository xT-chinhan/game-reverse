package com.byazt.suf;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 797, 8})
public abstract class s implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract void n();

    public abstract void n(com.byazt.he.n nVar);

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
                return qg().sparseArray();
            case 270032:
                n();
                return null;
            case 270033:
                n(new com.byazt.he.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                return null;
            default:
                return null;
        }
    }
}
