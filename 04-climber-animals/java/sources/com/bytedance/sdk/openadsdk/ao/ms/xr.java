package com.bytedance.sdk.openadsdk.ao.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.CSJSplashAdListener f1690ms;

    public xr(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.f1690ms = cSJSplashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f1690ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 114102:
                this.f1690ms.onSplashLoadSuccess(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.f1690ms.onSplashLoadFail(new com.bytedance.sdk.openadsdk.ao.ms.ms.ms(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.f1690ms.onSplashRenderSuccess(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 114105:
                this.f1690ms.onSplashRenderFail(new com.bytedance.sdk.openadsdk.ao.ms.ms.xr(ao.ms(valueSetXr.objectValue(0, Object.class))), new com.bytedance.sdk.openadsdk.ao.ms.ms.ms(ao.ms(valueSetXr.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
