package com.bytedance.sdk.openadsdk.y.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdDislike.DislikeInteractionCallback f4311ms;

    public ms(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f4311ms = dislikeInteractionCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f4311ms == null) {
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
        if (this.f4311ms == null) {
            return null;
        }
        ValueSet valueSetXr = xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 244101:
                this.f4311ms.onShow();
                return null;
            case 244102:
                this.f4311ms.onSelected(valueSetXr.intValue(0), valueSetXr.stringValue(1), valueSetXr.booleanValue(2));
                return null;
            case 244103:
                this.f4311ms.onCancel();
                return null;
            default:
                return null;
        }
    }
}
