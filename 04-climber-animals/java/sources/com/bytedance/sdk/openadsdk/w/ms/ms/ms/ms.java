package com.bytedance.sdk.openadsdk.w.ms.ms.ms;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTNativeExpressAd.AdInteractionListener f4284ms;

    public ms(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f4284ms = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f4284ms == null) {
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
        if (this.f4284ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 151101:
                this.f4284ms.onAdClicked((View) valueSetXr.objectValue(0, View.class), valueSetXr.intValue(1));
                return null;
            case 151102:
                this.f4284ms.onAdShow((View) valueSetXr.objectValue(0, View.class), valueSetXr.intValue(1));
                return null;
            case 151103:
                this.f4284ms.onRenderFail((View) valueSetXr.objectValue(0, View.class), valueSetXr.stringValue(1), valueSetXr.intValue(2));
                return null;
            case 151104:
                this.f4284ms.onRenderSuccess((View) valueSetXr.objectValue(0, View.class), valueSetXr.floatValue(1), valueSetXr.floatValue(2));
                return null;
            case 151105:
                this.f4284ms.onAdDismiss();
                return null;
            default:
                return null;
        }
    }
}
