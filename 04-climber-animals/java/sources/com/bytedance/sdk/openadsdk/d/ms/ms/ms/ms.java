package com.bytedance.sdk.openadsdk.d.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final CSJSplashAd.SplashAdListener f3899ms;

    public ms(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f3899ms = splashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.f12ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f3899ms == null) {
            return null;
        }
        SparseArray<Object> sparseArray = valueSet != null ? valueSet.sparseArray() : new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
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
        if (this.f3899ms != null && sparseArray != null) {
            ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
            switch (valueSetXr.intValue(-99999987)) {
                case 111101:
                    this.f3899ms.onSplashAdShow(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.f3899ms.onSplashAdClick(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))));
                    break;
                case 111103:
                    this.f3899ms.onSplashAdClose(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))), valueSetXr.intValue(1));
                    break;
            }
        }
        return null;
    }
}
