package com.byazt.x;

import android.util.SparseArray;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeToBannerListener pr;

    public hn(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.pr = iMediationNativeToBannerListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 266013:
                return this.pr.getMediationBannerViewFromNativeAd(new com.byazt.ao.pr(ho.pr(valueSetHw.objectValue(0, Object.class))));
            default:
                return null;
        }
    }
}
