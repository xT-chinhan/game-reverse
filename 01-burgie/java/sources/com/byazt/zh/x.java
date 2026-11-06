package com.byazt.zh;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1683, 121})
public class x implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo pr;

    public x(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.pr = iMediationPreloadRequestInfo;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (com.byazt.ij.hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.pr.getAdType()));
            case 271045:
                SparseArray<Object> sparseArrayPr = com.byazt.bm.hw.pr(this.pr.getAdSlot());
                return sparseArrayPr != null ? sparseArrayPr : new SparseArray();
            case 271046:
                return this.pr.getPrimeRitList();
            default:
                return com.byazt.ij.hn.hw.apply(sparseArray);
        }
    }
}
