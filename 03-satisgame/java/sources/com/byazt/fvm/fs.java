package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 101})
public abstract class fs implements Function<SparseArray<Object>, Object> {
    public abstract void n(com.byazt.mi.qg qgVar);

    public abstract void n(Double d);

    public abstract void n(Double d, String str, String str2);

    public abstract void qg(Double d);

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
                case 210101:
                    n(Double.valueOf(pluginValueSetQg.doubleValue(0)));
                    return null;
                case 210102:
                    n(Double.valueOf(pluginValueSetQg.doubleValue(0)), (String) pluginValueSetQg.objectValue(1, String.class), (String) pluginValueSetQg.objectValue(2, String.class));
                    return null;
                case 210103:
                    qg(Double.valueOf(pluginValueSetQg.doubleValue(0)));
                    return null;
                case 210104:
                    n(new com.byazt.mi.qg((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
