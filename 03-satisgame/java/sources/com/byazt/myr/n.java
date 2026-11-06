package com.byazt.myr;

import android.util.SparseArray;
import com.byazt.ky.IDownloadButtonClickListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1982, 19})
public abstract class n extends com.byazt.gf.q implements IDownloadButtonClickListener, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    @Override // com.byazt.gf.q
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (i == 223100) {
            handleComplianceDialog(com.byazt.qvu.n.n((SparseArray<Object>) com.byazt.qvu.n.n((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).qg().objectValue(-999902, SparseArray.class)).qg().booleanValue(223101));
        } else if (i == 223110) {
            handleMarketFailedComplianceDialog();
        }
        return null;
    }
}
