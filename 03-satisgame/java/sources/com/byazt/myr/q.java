package com.byazt.myr;

import android.util.SparseArray;
import com.byazt.hj.DownloadController;
import com.byazt.hj.DownloadEventConfig;
import com.byazt.hj.DownloadModel;
import com.byazt.ky.OnItemClickListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1982, 5})
public abstract class q extends com.byazt.gf.q implements OnItemClickListener, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onItemClick();

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        PluginValueSet pluginValueSetQg = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).qg();
        if (i == 223200 && pluginValueSetQg != null) {
            PluginValueSet pluginValueSetQg2 = com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSetQg.objectValue(-999902, SparseArray.class)).qg();
            onItemClick((Function<SparseArray<Object>, Object>) pluginValueSetQg2.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetQg2.objectValue(223202, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetQg2.objectValue(223203, Function.class));
        }
        return null;
    }

    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.byazt.ky.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        onItemClick();
    }
}
