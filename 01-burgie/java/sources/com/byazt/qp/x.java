package com.byazt.qp;

import android.util.SparseArray;
import com.byazt.bek.DownloadController;
import com.byazt.bek.DownloadEventConfig;
import com.byazt.bek.DownloadModel;
import com.byazt.zv.OnItemClickListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1370, 121})
public abstract class x extends com.byazt.ofr.x implements OnItemClickListener, LongSupplier {
    public abstract void onItemClick();

    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        PluginValueSet pluginValueSetHw = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).hw();
        if (i == 223200 && pluginValueSetHw != null) {
            PluginValueSet pluginValueSetHw2 = com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSetHw.objectValue(-999902, SparseArray.class)).hw();
            onItemClick((Function<SparseArray<Object>, Object>) pluginValueSetHw2.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetHw2.objectValue(223202, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetHw2.objectValue(223203, Function.class));
        }
        return null;
    }

    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.byazt.zv.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        onItemClick();
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
