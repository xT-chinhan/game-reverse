package com.bytedance.sdk.openadsdk.mediation.xr.ms.xr;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f4056ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final IMediationInterstitialFullAdListener xr;

    public xr(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.xr = iMediationInterstitialFullAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f4056ms;
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
            case 131101:
                this.xr.onAdShow();
                return null;
            case 131102:
                this.xr.onAdVideoBarClick();
                return null;
            case 131103:
                this.xr.onAdClose();
                return null;
            case 131104:
                this.xr.onVideoComplete();
                return null;
            case 131105:
                this.xr.onSkippedVideo();
                return null;
            case 131106:
                this.xr.onInterstitialFullShowFail(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                return null;
            case 131107:
                this.xr.onVideoError();
                return null;
            case 131108:
                this.xr.onAdOpened();
                return null;
            case 131109:
                this.xr.onAdLeftApplication();
                return null;
            case 131110:
                this.xr.onRewardVerify((Bundle) valueSetXr.objectValue(0, Bundle.class));
                return null;
            default:
                return null;
        }
    }
}
