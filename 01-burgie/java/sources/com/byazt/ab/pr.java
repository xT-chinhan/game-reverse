package com.byazt.ab;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1581, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTRewardVideoAd.RewardAdInteractionListener pr;

    public pr(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.pr = rewardAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 121101:
                this.pr.onAdShow();
                return null;
            case 121102:
                this.pr.onAdVideoBarClick();
                return null;
            case 121103:
                this.pr.onAdClose();
                return null;
            case 121104:
                this.pr.onVideoComplete();
                return null;
            case 121105:
                this.pr.onVideoError();
                return null;
            case 121106:
                this.pr.onRewardVerify(valueSetHw.booleanValue(0), valueSetHw.intValue(1), valueSetHw.stringValue(2), valueSetHw.intValue(3), valueSetHw.stringValue(4));
                return null;
            case 121107:
                this.pr.onRewardArrived(valueSetHw.booleanValue(0), valueSetHw.intValue(1), (Bundle) valueSetHw.objectValue(2, Bundle.class));
                return null;
            case 121108:
                this.pr.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
