package com.byazt.hr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 5})
public class q implements Function<SparseArray<Object>, Object> {
    private final IMediationSplashRequestInfo n;

    public q(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.n = iMediationSplashRequestInfo;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        String adnName = "";
        switch (com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987)) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.n;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    adnName = this.n.getAdnName();
                }
                return String.valueOf(adnName);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.n;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    adnName = this.n.getAdnSlotId();
                }
                return String.valueOf(adnName);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.n;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    adnName = this.n.getAppId();
                }
                return String.valueOf(adnName);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.n;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    adnName = this.n.getAppkey();
                }
                return String.valueOf(adnName);
            default:
                return null;
        }
    }
}
