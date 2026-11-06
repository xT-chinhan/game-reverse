package com.bytedance.sdk.openadsdk.h.ms.ms.ms.ms;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3916ms;

    public ms(Function<SparseArray<Object>, Object> function) {
        this.f3916ms = function == null ? xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 123101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, bundle);
        this.f3916ms.apply(sparseArray);
    }
}
