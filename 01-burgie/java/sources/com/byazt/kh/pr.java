package com.byazt.kh;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1277, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener pr;

    public pr(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.pr = fullScreenVideoAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 131101:
                this.pr.onAdShow();
                return null;
            case 131102:
                this.pr.onAdVideoBarClick();
                return null;
            case 131103:
                this.pr.onAdClose();
                return null;
            case 131104:
                this.pr.onVideoComplete();
                return null;
            case 131105:
                this.pr.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
