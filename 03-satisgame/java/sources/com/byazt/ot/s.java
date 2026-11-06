package com.byazt.ot;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 50, 8})
public abstract class s extends com.byazt.gf.q implements LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void n();

    public abstract void qg();

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 0) {
            qg();
            return null;
        }
        if (i != 1) {
            return null;
        }
        n();
        return null;
    }
}
