package com.bytedance.sdk.openadsdk.i.ms.ms.ms;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.ao.ms.ms.sl;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f3919ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTNativeAd.AdInteractionListener xr;

    public ms(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.xr = adInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f3919ms;
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
            case 141101:
                this.xr.onAdClicked((View) valueSetXr.objectValue(0, View.class), new sl(ao.ms(valueSetXr.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.xr.onAdCreativeClick((View) valueSetXr.objectValue(0, View.class), new sl(ao.ms(valueSetXr.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.xr.onAdShow(new sl(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
