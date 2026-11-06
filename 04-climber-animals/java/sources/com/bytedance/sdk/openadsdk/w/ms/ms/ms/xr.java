package com.bytedance.sdk.openadsdk.w.ms.ms.ms;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f4285ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTNativeExpressAd.ExpressAdInteractionListener xr;

    public xr(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.xr = expressAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f4285ms;
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
            case 151101:
                this.xr.onAdClicked((View) valueSetXr.objectValue(0, View.class), valueSetXr.intValue(1));
                return null;
            case 151102:
                this.xr.onAdShow((View) valueSetXr.objectValue(0, View.class), valueSetXr.intValue(1));
                return null;
            case 151103:
                this.xr.onRenderFail((View) valueSetXr.objectValue(0, View.class), valueSetXr.stringValue(1), valueSetXr.intValue(2));
                return null;
            case 151104:
                this.xr.onRenderSuccess((View) valueSetXr.objectValue(0, View.class), valueSetXr.floatValue(1), valueSetXr.floatValue(2));
                return null;
            default:
                return null;
        }
    }
}
