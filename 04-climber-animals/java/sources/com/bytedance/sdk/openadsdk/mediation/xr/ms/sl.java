package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends com.bytedance.sdk.openadsdk.ao.ms.ms.ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4049ms;

    public sl(Function<SparseArray<Object>, Object> function) {
        super(function != null ? function : com.bykv.ms.ms.ms.ms.xr.ah);
        this.f4049ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.ms.ms.ny, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 140111);
        sparseArray.put(-99999985, Void.class);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.mediation.ad.ms.ms.xr.c((MediationExpressRenderListener) expressRenderListener));
            sparseArray.put(1, 1);
        } else {
            sparseArray.put(0, new com.bytedance.sdk.openadsdk.i.ms.ms.ms.ah(expressRenderListener));
            sparseArray.put(1, 0);
        }
        this.f4049ms.apply(sparseArray);
    }
}
