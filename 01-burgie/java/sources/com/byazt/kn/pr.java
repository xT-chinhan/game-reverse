package com.byazt.kn;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 569, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTDrawFeedAd.DrawVideoListener pr;

    public pr(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.pr = drawVideoListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 171101:
                this.pr.onClick();
                return null;
            case 171102:
                this.pr.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
