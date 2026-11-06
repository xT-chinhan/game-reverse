package com.byazt.hg;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1109, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener n;

    public n(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.n = fullScreenVideoAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        switch (s.n(sparseArray).qg().intValue(-99999987)) {
            case 131101:
                this.n.onAdShow();
                return null;
            case 131102:
                this.n.onAdVideoBarClick();
                return null;
            case 131103:
                this.n.onAdClose();
                return null;
            case 131104:
                this.n.onVideoComplete();
                return null;
            case 131105:
                this.n.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
