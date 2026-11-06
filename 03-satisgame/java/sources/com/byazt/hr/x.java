package com.byazt.hr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 21})
public class x implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener n;

    public x(MediationShakeViewListener mediationShakeViewListener) {
        this.n = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n != null && com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987) == 270012) {
            this.n.onDismissed();
        }
        return null;
    }
}
