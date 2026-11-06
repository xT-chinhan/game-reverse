package com.bytedance.sdk.openadsdk.mediation.init.ms.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static final SparseArray<Object> ms(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        xrVarMs.ms(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        xrVarMs.ms(265001, mediationConfigUserInfoForSegment.getUserId());
        xrVarMs.ms(265002, mediationConfigUserInfoForSegment.getChannel());
        xrVarMs.ms(265003, mediationConfigUserInfoForSegment.getSubChannel());
        xrVarMs.ms(265004, mediationConfigUserInfoForSegment.getAge());
        xrVarMs.ms(265005, mediationConfigUserInfoForSegment.getGender());
        xrVarMs.ms(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return xrVarMs.xr().sparseArray();
    }
}
