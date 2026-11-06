package com.bytedance.sdk.openadsdk.i.ms.ms.ms;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f3918ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTNativeAd.ExpressRenderListener xr;

    public ah(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.xr = expressRenderListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f3918ms;
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

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xr == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        if (valueSetXr.intValue(-99999987) == 142101) {
            this.xr.onRenderSuccess((View) valueSetXr.objectValue(0, View.class), valueSetXr.floatValue(1), valueSetXr.floatValue(2), valueSetXr.booleanValue(3));
        }
        return null;
    }
}
