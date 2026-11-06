package com.byazt.ka;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1667, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTRewardVideoAd.RewardAdInteractionListener n;

    public n(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.n = rewardAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 121101:
                this.n.onAdShow();
                return null;
            case 121102:
                this.n.onAdVideoBarClick();
                return null;
            case 121103:
                this.n.onAdClose();
                return null;
            case 121104:
                this.n.onVideoComplete();
                return null;
            case 121105:
                this.n.onVideoError();
                return null;
            case 121106:
                this.n.onRewardVerify(valueSetQg.booleanValue(0), valueSetQg.intValue(1), valueSetQg.stringValue(2), valueSetQg.intValue(3), valueSetQg.stringValue(4));
                return null;
            case 121107:
                this.n.onRewardArrived(valueSetQg.booleanValue(0), valueSetQg.intValue(1), (Bundle) valueSetQg.objectValue(2, Bundle.class));
                return null;
            case 121108:
                this.n.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
