package com.byazt.xl;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 503, 37})
public abstract class pr implements Function<SparseArray<Object>, Object> {
    public PluginValueSet pr;

    public abstract void pr(Bundle bundle);

    private PluginValueSet pr() {
        return com.byazt.ij.pr.pr().hw();
    }

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
                PluginValueSet pluginValueSet = this.pr;
                if (pluginValueSet != null) {
                    return pluginValueSet.sparseArray();
                }
                PluginValueSet pluginValueSetPr = pr();
                this.pr = pluginValueSetPr;
                return pluginValueSetPr.sparseArray();
            case 123101:
                pr((Bundle) pluginValueSetHw.objectValue(0, Bundle.class));
            default:
                return null;
        }
    }
}
