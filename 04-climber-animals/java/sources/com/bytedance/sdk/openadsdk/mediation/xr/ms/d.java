package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.t.ms.ms.ms.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f4042ms;

    public d(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        super(fullScreenVideoAdListener);
        this.f4042ms = fullScreenVideoAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.ms.ms.ah, java.util.function.Function
    /* JADX INFO: renamed from: ms */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue == 132102) {
            if (this.f4042ms != null) {
                this.f4042ms.onFullScreenVideoAdLoad(new zb(ao.ms(valueSetXr.objectValue(0, Object.class))));
                return null;
            }
        } else if (iIntValue == 132103 && this.f4042ms != null) {
            this.f4042ms.onFullScreenVideoCached(new zb(ao.ms(valueSetXr.objectValue(0, Object.class))));
            return null;
        }
        return super.apply(sparseArray);
    }
}
