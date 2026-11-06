package com.byazt.qp;

import android.util.SparseArray;
import com.byazt.zv.IDownloadButtonClickListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1370, 37})
public abstract class pr extends com.byazt.ofr.x implements IDownloadButtonClickListener, LongSupplier {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.ofr.x
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        switch (i) {
            case 223100:
                handleComplianceDialog(com.byazt.ij.pr.pr((SparseArray<Object>) com.byazt.ij.pr.pr((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).hw().objectValue(-999902, SparseArray.class)).hw().booleanValue(223101));
                return null;
            case 223110:
                handleMarketFailedComplianceDialog();
                return null;
            default:
                return null;
        }
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }
}
