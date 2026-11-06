package com.byazt.fvm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 464, 21})
public abstract class x implements Function<SparseArray<Object>, Object> {
    public abstract void n();

    public abstract void n(com.byazt.lr.n nVar);

    public abstract void n(String str);

    public abstract void qg();

    public abstract boolean s();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n(sparseArray).qg();
        int iIntValue = pluginValueSetQg.intValue(-99999987);
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 240101:
                    n();
                    return null;
                case 240102:
                    n(new com.byazt.lr.n((Function) pluginValueSetQg.objectValue(0, Function.class)));
                    return null;
                case 240103:
                    n((String) pluginValueSetQg.objectValue(0, String.class));
                    return null;
                case 240104:
                    qg();
                    return null;
                case 240105:
                    return Boolean.class.cast(Boolean.valueOf(s()));
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
