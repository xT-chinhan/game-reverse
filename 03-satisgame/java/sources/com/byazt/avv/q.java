package com.byazt.avv;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1893, 5})
public class q implements Function<SparseArray<Object>, Object> {
    private final IMediationPreloadRequestInfo n;

    public q(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.n = iMediationPreloadRequestInfo;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        switch (com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987)) {
            case 271044:
                return Integer.class.cast(Integer.valueOf(this.n.getAdType()));
            case 271045:
                SparseArray<Object> sparseArrayN = com.byazt.jd.qg.n(this.n.getAdSlot());
                return sparseArrayN != null ? sparseArrayN : new SparseArray();
            case 271046:
                return this.n.getPrimeRitList();
            default:
                return com.byazt.qvu.s.qg.apply(sparseArray);
        }
    }
}
