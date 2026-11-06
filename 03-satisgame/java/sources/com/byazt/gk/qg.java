package com.byazt.gk;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1526, 26})
public class qg implements MediationAdDislike {
    private final Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270032);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 270033);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.hr.qg(iMediationDislikeCallback));
        this.n.apply(sparseArray);
    }
}
