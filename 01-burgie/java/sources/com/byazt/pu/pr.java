package com.byazt.pu;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1522, 37})
public abstract class pr implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract void hn();

    public abstract void hn(long j);

    public abstract void hw();

    public abstract void hw(long j);

    public abstract String pr();

    public abstract void pr(int i, int i2);

    public abstract void pr(long j);

    public abstract void pr(long j, int i, int i2);

    public abstract void x();

    public PluginValueSet c() {
        PluginValueSet pluginValueSet = this.pr;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetUc = uc();
        this.pr = pluginValueSetUc;
        return pluginValueSetUc;
    }

    private PluginValueSet uc() {
        return com.byazt.ij.pr.pr().hw();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        int iIntValue = pluginValueSetHw.intValue(-99999987);
        pluginValueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return c().sparseArray();
            case 162101:
                return pr();
            case 162102:
                hw();
                return null;
            case 162103:
                pr(pluginValueSetHw.longValue(0));
                return null;
            case 162104:
                hw(pluginValueSetHw.longValue(0));
                return null;
            case 162105:
                hn();
                return null;
            case 162106:
                hn(pluginValueSetHw.longValue(0));
                return null;
            case 162107:
                x();
                return null;
            case 162108:
                pr(pluginValueSetHw.intValue(0), pluginValueSetHw.intValue(1));
                return null;
            case 162109:
                pr(pluginValueSetHw.longValue(0), pluginValueSetHw.intValue(1), pluginValueSetHw.intValue(2));
                return null;
            default:
                return null;
        }
    }
}
