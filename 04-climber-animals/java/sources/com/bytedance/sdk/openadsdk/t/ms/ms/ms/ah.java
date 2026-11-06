package com.bytedance.sdk.openadsdk.t.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ch;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f4108ms;

    public ah(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f4108ms = fullScreenVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f4108ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 132101:
                this.f4108ms.onError(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                return null;
            case 132102:
                this.f4108ms.onFullScreenVideoAdLoad(new ch(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 132103:
                this.f4108ms.onFullScreenVideoCached(new ch(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            case 132104:
                this.f4108ms.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
