package com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationDislikeCallback f3965ms;

    public xr(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f3965ms = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3965ms == null) {
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
        if (this.f3965ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 268013:
                this.f3965ms.onSelected(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                return null;
            case 268014:
                this.f3965ms.onCancel();
                return null;
            case 268015:
                this.f3965ms.onShow();
                return null;
            default:
                return null;
        }
    }
}
