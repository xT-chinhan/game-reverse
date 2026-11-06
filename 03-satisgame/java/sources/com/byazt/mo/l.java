package com.byazt.mo;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 18})
public class l implements DownloadStatusController {
    public final Function<SparseArray<Object>, Object> n;

    public l(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222102);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
