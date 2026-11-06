package com.bytedance.sdk.openadsdk.mediation.xr.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements IMediationNativeTokenInfo {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4045ms;

    public ah(Function<SparseArray<Object>, Object> function) {
        this.f4045ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.t.ms.ms.ms.xr(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.f4045ms.apply(sparseArray);
    }
}
