package com.byazt.x;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, 62})
public class fw implements Function<SparseArray<Object>, Object> {
    private final MediationShakeViewListener pr;

    public fw(MediationShakeViewListener mediationShakeViewListener) {
        this.pr = mediationShakeViewListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (com.byazt.ij.hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 270012:
                this.pr.onDismissed();
            default:
                return null;
        }
    }
}
