package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationNativeToBannerListener f3960ms;

    public ah(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f3960ms = iMediationNativeToBannerListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3960ms == null) {
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
        if (this.f3960ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        if (valueSetXr.intValue(-99999987) != 266013) {
            return null;
        }
        return this.f3960ms.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.ms.ms(ao.ms(valueSetXr.objectValue(0, Object.class))));
    }
}
