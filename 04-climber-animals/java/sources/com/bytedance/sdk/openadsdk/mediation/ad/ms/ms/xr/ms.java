package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationAdSlot f3964ms;

    public ms(IMediationAdSlot iMediationAdSlot) {
        this.f3964ms = iMediationAdSlot;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3964ms == null) {
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

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f3964ms == null) {
            return null;
        }
        int iIntValue = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987);
        if (iIntValue != 8260030) {
            switch (iIntValue) {
                case 266001:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isSplashShakeButton()));
                case 266002:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isSplashPreLoad()));
                case 266003:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isMuted()));
                case 266004:
                    return Float.class.cast(Float.valueOf(this.f3964ms.getVolume()));
                case 266005:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isUseSurfaceView()));
                case 266006:
                    return this.f3964ms.getExtraObject();
                case 266007:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isBidNotify()));
                case 266008:
                    return this.f3964ms.getScenarioId();
                case 266009:
                    return Boolean.class.cast(Boolean.valueOf(this.f3964ms.isAllowShowCloseBtn()));
                case 266010:
                    return Float.class.cast(Float.valueOf(this.f3964ms.getShakeViewWidth()));
                case 266011:
                    return Float.class.cast(Float.valueOf(this.f3964ms.getShakeViewHeight()));
                case 266012:
                    return this.f3964ms.getWxAppId();
                default:
                    switch (iIntValue) {
                        case 266101:
                            return this.f3964ms.getMediationNativeToBannerListener();
                        case 266102:
                            return this.f3964ms.getMediationSplashRequestInfo();
                        case 266103:
                            return this.f3964ms.getRewardName();
                        case 266104:
                            return Integer.class.cast(Integer.valueOf(this.f3964ms.getRewardAmount()));
                        default:
                            return null;
                    }
            }
        }
        return this.f3964ms;
    }
}
