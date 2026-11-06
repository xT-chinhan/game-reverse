package com.byazt.zh;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1683, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    private final IMediationInterstitialFullAdListener pr;

    public hw(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.pr = iMediationInterstitialFullAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 131101:
                this.pr.onAdShow();
                return null;
            case 131102:
                this.pr.onAdVideoBarClick();
                return null;
            case 131103:
                this.pr.onAdClose();
                return null;
            case 131104:
                this.pr.onVideoComplete();
                return null;
            case 131105:
                this.pr.onSkippedVideo();
                return null;
            case 131106:
                this.pr.onInterstitialFullShowFail(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            case 131107:
                this.pr.onVideoError();
                return null;
            case 131108:
                this.pr.onAdOpened();
                return null;
            case 131109:
                this.pr.onAdLeftApplication();
                return null;
            case 131110:
                this.pr.onRewardVerify((Bundle) valueSetHw.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
