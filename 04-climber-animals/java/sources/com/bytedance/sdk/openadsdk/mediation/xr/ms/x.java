package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private IMediationPreloadRequestInfo f4050ms;

    public x(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.f4050ms = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.xr.ms.xr.d, java.util.function.Function
    /* JADX INFO: renamed from: ms */
    public Object apply(SparseArray<Object> sparseArray) {
        if (com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr().intValue(-99999987) == 271045) {
            IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f4050ms;
            if (iMediationPreloadRequestInfo == null) {
                return null;
            }
            SparseArray<Object> sparseArrayMs = ms.ms(iMediationPreloadRequestInfo.getAdSlot());
            return sparseArrayMs != null ? sparseArrayMs : new SparseArray();
        }
        return super.apply(sparseArray);
    }
}
