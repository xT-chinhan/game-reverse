package com.byazt.avv;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1893, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener n;

    public qg(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.n = iMediationInterstitialFullAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 131101:
                this.n.onAdShow();
                return null;
            case 131102:
                this.n.onAdVideoBarClick();
                return null;
            case 131103:
                this.n.onAdClose();
                return null;
            case 131104:
                this.n.onVideoComplete();
                return null;
            case 131105:
                this.n.onSkippedVideo();
                return null;
            case 131106:
                this.n.onInterstitialFullShowFail(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            case 131107:
                this.n.onVideoError();
                return null;
            case 131108:
                this.n.onAdOpened();
                return null;
            case 131109:
                this.n.onAdLeftApplication();
                return null;
            case 131110:
                this.n.onRewardVerify((Bundle) valueSetQg.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
