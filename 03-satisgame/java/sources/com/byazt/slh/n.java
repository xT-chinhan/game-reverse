package com.byazt.slh;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2214, 19})
public abstract class n implements Function<SparseArray<Object>, Object> {
    public PluginValueSet n;

    public abstract String n();

    public abstract void n(int i, int i2);

    public abstract void n(long j);

    public abstract void n(long j, int i, int i2);

    public abstract void q();

    public abstract void qg();

    public abstract void qg(long j);

    public abstract void s();

    public abstract void s(long j);

    public PluginValueSet l() {
        PluginValueSet pluginValueSet = this.n;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetW = w();
        this.n = pluginValueSetW;
        return pluginValueSetW;
    }

    private PluginValueSet w() {
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
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 162101:
                    return n();
                case 162102:
                    qg();
                    return null;
                case 162103:
                    n(pluginValueSetQg.longValue(0));
                    return null;
                case 162104:
                    qg(pluginValueSetQg.longValue(0));
                    return null;
                case 162105:
                    s();
                    return null;
                case 162106:
                    s(pluginValueSetQg.longValue(0));
                    return null;
                case 162107:
                    q();
                    return null;
                case 162108:
                    n(pluginValueSetQg.intValue(0), pluginValueSetQg.intValue(1));
                    return null;
                case 162109:
                    n(pluginValueSetQg.longValue(0), pluginValueSetQg.intValue(1), pluginValueSetQg.intValue(2));
                    return null;
                default:
                    return null;
            }
        }
        return l().sparseArray();
    }
}
