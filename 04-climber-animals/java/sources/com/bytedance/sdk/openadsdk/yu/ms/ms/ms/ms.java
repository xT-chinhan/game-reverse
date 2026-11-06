package com.bytedance.sdk.openadsdk.yu.ms.ms.ms;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4313ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTRewardVideoAd.RewardAdInteractionListener xr;

    public ms(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.xr = rewardAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f4313ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.xr == null) {
            return null;
        }
        SparseArray<Object> sparseArray = valueSet != null ? valueSet.sparseArray() : new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, cls);
        T t = (T) apply(sparseArray);
        if (t != null) {
            return t;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xr == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 121101:
                this.xr.onAdShow();
                return null;
            case 121102:
                this.xr.onAdVideoBarClick();
                return null;
            case 121103:
                this.xr.onAdClose();
                return null;
            case 121104:
                this.xr.onVideoComplete();
                return null;
            case 121105:
                this.xr.onVideoError();
                return null;
            case 121106:
                this.xr.onRewardVerify(valueSetXr.booleanValue(0), valueSetXr.intValue(1), valueSetXr.stringValue(2), valueSetXr.intValue(3), valueSetXr.stringValue(4));
                return null;
            case 121107:
                this.xr.onRewardArrived(valueSetXr.booleanValue(0), valueSetXr.intValue(1), (Bundle) valueSetXr.objectValue(2, Bundle.class));
                return null;
            case 121108:
                this.xr.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
