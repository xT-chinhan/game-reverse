package com.byazt.myr;

import android.util.SparseArray;
import com.byazt.ky.DownloadMarketInterceptor;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1982, 8})
public abstract class s extends com.byazt.gf.q implements DownloadMarketInterceptor, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        PluginValueSet pluginValueSetQg;
        if (pluginValueSet == null || i != 223901 || (pluginValueSetQg = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).qg()) == null) {
            return null;
        }
        return (T) com.byazt.of.qg.n().n(223902, interceptObmMarket((Map) com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg().objectValue(223902, Map.class))).qg();
    }
}
