package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr.ms {
    public ka(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr.ms, java.util.function.Function
    /* JADX INFO: renamed from: ms */
    public Object apply(SparseArray<Object> sparseArray) {
        int iIntValue = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987);
        if (iIntValue == 266101) {
            return new com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr.ah((IMediationNativeToBannerListener) super.apply(sparseArray));
        }
        if (iIntValue == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.apply(sparseArray);
            if (iMediationSplashRequestInfo != null) {
                return new ny(iMediationSplashRequestInfo);
            }
            return null;
        }
        return super.apply(sparseArray);
    }
}
