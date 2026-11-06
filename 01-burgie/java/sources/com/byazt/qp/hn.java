package com.byazt.qp;

import android.util.SparseArray;
import com.byazt.zv.DownloadMarketInterceptor;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1370, 20})
public abstract class hn extends com.byazt.ofr.x implements DownloadMarketInterceptor, LongSupplier {
    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        PluginValueSet pluginValueSetHw;
        if (pluginValueSet == null || i != 223901 || (pluginValueSetHw = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).hw()) == null) {
            return null;
        }
        return (T) com.byazt.xi.hw.pr().pr(223902, interceptObmMarket((Map) com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw().objectValue(223902, Map.class))).hw();
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
