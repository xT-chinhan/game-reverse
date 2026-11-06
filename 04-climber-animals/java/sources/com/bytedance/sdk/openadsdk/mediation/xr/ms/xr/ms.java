package com.bytedance.sdk.openadsdk.mediation.xr.ms.xr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final IMediationDrawAdTokenCallback f4055ms;

    public ms(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f4055ms = iMediationDrawAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f4055ms == null) {
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
        if (this.f4055ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 270029:
                this.f4055ms.onAdTokenLoaded(valueSetXr.stringValue(0), new com.bytedance.sdk.openadsdk.mediation.xr.ms.ms.ms(ao.ms(valueSetXr.objectValue(1, Object.class))));
                return null;
            case 270030:
                this.f4055ms.onAdTokenLoadedFail(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
