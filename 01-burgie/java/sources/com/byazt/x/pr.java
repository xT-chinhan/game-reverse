package com.byazt.x;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    private final IMediationAdSlot pr;

    public pr(IMediationAdSlot iMediationAdSlot) {
        this.pr = iMediationAdSlot;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (com.byazt.ij.hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 266001:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isSplashShakeButton()));
            case 266002:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isSplashPreLoad()));
            case 266003:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isMuted()));
            case 266004:
                return Float.class.cast(Float.valueOf(this.pr.getVolume()));
            case 266005:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isUseSurfaceView()));
            case 266006:
                return this.pr.getExtraObject();
            case 266007:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isBidNotify()));
            case 266008:
                return this.pr.getScenarioId();
            case 266009:
                return Boolean.class.cast(Boolean.valueOf(this.pr.isAllowShowCloseBtn()));
            case 266010:
                return Float.class.cast(Float.valueOf(this.pr.getShakeViewWidth()));
            case 266011:
                return Float.class.cast(Float.valueOf(this.pr.getShakeViewHeight()));
            case 266012:
                return this.pr.getWxAppId();
            case 266101:
                return new hn(this.pr.getMediationNativeToBannerListener());
            case 266102:
                return new x(this.pr.getMediationSplashRequestInfo());
            case 266103:
                return this.pr.getRewardName();
            case 266104:
                return Integer.class.cast(Integer.valueOf(this.pr.getRewardAmount()));
            case 8260031:
                return this.pr;
            default:
                return null;
        }
    }
}
