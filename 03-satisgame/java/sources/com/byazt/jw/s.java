package com.byazt.jw;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 69, 8})
public class s {
    public static final SparseArray<Object> n(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        sVarN.n(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        sVarN.n(265001, mediationConfigUserInfoForSegment.getUserId());
        sVarN.n(265002, mediationConfigUserInfoForSegment.getChannel());
        sVarN.n(265003, mediationConfigUserInfoForSegment.getSubChannel());
        sVarN.n(265004, mediationConfigUserInfoForSegment.getAge());
        sVarN.n(265005, mediationConfigUserInfoForSegment.getGender());
        sVarN.n(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return sVarN.qg().sparseArray();
    }
}
