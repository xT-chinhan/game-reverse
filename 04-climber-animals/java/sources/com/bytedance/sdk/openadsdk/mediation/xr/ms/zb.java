package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends com.bytedance.sdk.openadsdk.ao.ms.ms.ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4057ms;

    public zb(Function<SparseArray<Object>, Object> function) {
        super(function != null ? function : com.bykv.ms.ms.ms.ms.xr.ah);
        this.f4057ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.ms.ms.ch, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 130101);
        sparseArray.put(-99999985, Void.class);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.xr((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.re.ms.ms.ms.ms(fullScreenVideoAdInteractionListener));
            sparseArray.put(1, 0);
        }
        this.f4057ms.apply(sparseArray);
    }
}
