package com.byazt.lt;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1377, 8})
public class s implements IMediationNativeTokenInfo {
    private final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.byazt.yhl.qg(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }
}
