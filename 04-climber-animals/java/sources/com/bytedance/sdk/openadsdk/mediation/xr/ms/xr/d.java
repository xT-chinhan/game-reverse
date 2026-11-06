package com.bytedance.sdk.openadsdk.mediation.xr.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationPreloadRequestInfo f4053ms;

    public d(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f4053ms = iMediationPreloadRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f4053ms == null) {
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
        if (this.f4053ms == null) {
            return null;
        }
        switch (com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.f4053ms.getAdType()));
            case 271045:
                return this.f4053ms.getAdSlot();
            case 271046:
                return this.f4053ms.getPrimeRitList();
            default:
                return null;
        }
    }
}
