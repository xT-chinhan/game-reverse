package com.byazt.drg;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2388, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTDrawFeedAd.DrawVideoListener n;

    public n(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.n = drawVideoListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        switch (s.n(sparseArray).qg().intValue(-99999987)) {
            case 171101:
                this.n.onClick();
                return null;
            case 171102:
                this.n.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
