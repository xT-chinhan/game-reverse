package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationSplashRequestInfo f3962ms;

    public d(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f3962ms = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3962ms == null) {
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
        if (this.f3962ms == null) {
            return null;
        }
        switch (com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987)) {
            case 267001:
                return this.f3962ms.getAdnName();
            case 267002:
                return this.f3962ms.getAdnSlotId();
            case 267003:
                return this.f3962ms.getAppId();
            case 267004:
                return this.f3962ms.getAppkey();
            default:
                return null;
        }
    }
}
