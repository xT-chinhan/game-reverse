package com.byazt.hr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 19})
public class n implements Function<SparseArray<Object>, Object> {
    private final IMediationAdSlot n;

    public n(IMediationAdSlot iMediationAdSlot) {
        this.n = iMediationAdSlot;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        int iIntValue = com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987);
        if (iIntValue != 8260031) {
            switch (iIntValue) {
                case 266001:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isSplashShakeButton()));
                case 266002:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isSplashPreLoad()));
                case 266003:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isMuted()));
                case 266004:
                    return Float.class.cast(Float.valueOf(this.n.getVolume()));
                case 266005:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isUseSurfaceView()));
                case 266006:
                    return this.n.getExtraObject();
                case 266007:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isBidNotify()));
                case 266008:
                    return this.n.getScenarioId();
                case 266009:
                    return Boolean.class.cast(Boolean.valueOf(this.n.isAllowShowCloseBtn()));
                case 266010:
                    return Float.class.cast(Float.valueOf(this.n.getShakeViewWidth()));
                case 266011:
                    return Float.class.cast(Float.valueOf(this.n.getShakeViewHeight()));
                case 266012:
                    return this.n.getWxAppId();
                default:
                    switch (iIntValue) {
                        case 266101:
                            return new s(this.n.getMediationNativeToBannerListener());
                        case 266102:
                            return new q(this.n.getMediationSplashRequestInfo());
                        case 266103:
                            return this.n.getRewardName();
                        case 266104:
                            return Integer.class.cast(Integer.valueOf(this.n.getRewardAmount()));
                        default:
                            return null;
                    }
            }
        }
        return this.n;
    }
}
