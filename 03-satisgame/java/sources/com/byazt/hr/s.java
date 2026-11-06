package com.byazt.hr;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 8})
public class s implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener n;

    public s(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.n = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        if (valueSetQg.intValue(-99999987) != 266013) {
            return null;
        }
        return this.n.getMediationBannerViewFromNativeAd(new com.byazt.gk.n(k.n(valueSetQg.objectValue(0, Object.class))));
    }
}
