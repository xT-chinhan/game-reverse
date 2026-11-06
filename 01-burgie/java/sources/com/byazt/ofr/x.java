package com.byazt.ofr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1195, 121})
public abstract class x implements Function<SparseArray<Object>, Object> {
    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr(sparseArray).hw();
        return applyFunction(pluginValueSetHw.intValue(-99999987, 0), pluginValueSetHw, (Class) pluginValueSetHw.objectValue(-99999985, Class.class));
    }
}
