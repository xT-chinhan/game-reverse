package com.byazt.ot;

import android.support.v4.view.PointerIconCompat;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_ZOOM_IN, 20})
public class hn implements IMediationNativeTokenInfo {
    private final Function<SparseArray<Object>, Object> pr;

    public hn(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? com.byazt.ij.hn.hw : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.byazt.qvl.hw(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.pr.apply(sparseArray);
    }
}
