package com.bytedance.sdk.openadsdk.ao.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements DownloadStatusController {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1681ms;

    public ka(Function<SparseArray<Object>, Object> function) {
        this.f1681ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222101);
        sparseArray.put(-99999985, Void.class);
        this.f1681ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222102);
        sparseArray.put(-99999985, Void.class);
        this.f1681ms.apply(sparseArray);
    }
}
