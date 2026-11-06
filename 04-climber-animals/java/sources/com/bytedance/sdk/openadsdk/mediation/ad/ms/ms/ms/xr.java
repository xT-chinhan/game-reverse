package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements MediationAdDislike {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3958ms;

    public xr(Function<SparseArray<Object>, Object> function) {
        this.f3958ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270032);
        sparseArray.put(-99999985, Void.class);
        this.f3958ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270033);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr.xr(iMediationDislikeCallback));
        this.f3958ms.apply(sparseArray);
    }
}
