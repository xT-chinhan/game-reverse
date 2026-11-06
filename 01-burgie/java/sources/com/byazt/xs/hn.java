package com.byazt.xs;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 676, 20})
public class hn {
    public static final SparseArray<Object> pr(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        hnVarPr.pr(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        hnVarPr.pr(265001, mediationConfigUserInfoForSegment.getUserId());
        hnVarPr.pr(265002, mediationConfigUserInfoForSegment.getChannel());
        hnVarPr.pr(265003, mediationConfigUserInfoForSegment.getSubChannel());
        hnVarPr.pr(265004, mediationConfigUserInfoForSegment.getAge());
        hnVarPr.pr(265005, mediationConfigUserInfoForSegment.getGender());
        hnVarPr.pr(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return hnVarPr.hw().sparseArray();
    }
}
