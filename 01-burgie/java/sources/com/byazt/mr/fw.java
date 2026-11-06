package com.byazt.mr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 25, 62})
public abstract class fw implements Function<SparseArray<Object>, Object> {
    public abstract boolean hn();

    public abstract void hw();

    public abstract void pr();

    public abstract void pr(com.byazt.rz.pr prVar);

    public abstract void pr(String str);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        switch (pluginValueSetHw.intValue(-99999987)) {
            case -99999986:
                return new SparseArray();
            case 240101:
                pr();
                return null;
            case 240102:
                pr(new com.byazt.rz.pr((Function) pluginValueSetHw.objectValue(0, Function.class)));
                return null;
            case 240103:
                pr((String) pluginValueSetHw.objectValue(0, String.class));
                return null;
            case 240104:
                hw();
                return null;
            case 240105:
                return Boolean.class.cast(Boolean.valueOf(hn()));
            default:
                return null;
        }
    }
}
