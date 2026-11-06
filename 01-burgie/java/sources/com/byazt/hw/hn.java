package com.byazt.hw;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 13, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    public final TTNativeExpressAd.ExpressVideoAdListener pr;

    public hn(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.pr = expressVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 152101:
                this.pr.onVideoLoad();
                return null;
            case 152102:
                this.pr.onVideoError(valueSetHw.intValue(0), valueSetHw.intValue(1));
                return null;
            case 152103:
                this.pr.onVideoAdStartPlay();
                return null;
            case 152104:
                this.pr.onVideoAdPaused();
                return null;
            case 152105:
                this.pr.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.pr.onProgressUpdate(valueSetHw.longValue(0), valueSetHw.longValue(1));
                return null;
            case 152107:
                this.pr.onVideoAdComplete();
                return null;
            case 152108:
                this.pr.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
