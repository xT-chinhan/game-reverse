package com.byazt.zm;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1279, 8})
public class s implements Function<SparseArray<Object>, Object> {
    public final TTNativeExpressAd.ExpressVideoAdListener n;

    public s(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.n = expressVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 152101:
                this.n.onVideoLoad();
                return null;
            case 152102:
                this.n.onVideoError(valueSetQg.intValue(0), valueSetQg.intValue(1));
                return null;
            case 152103:
                this.n.onVideoAdStartPlay();
                return null;
            case 152104:
                this.n.onVideoAdPaused();
                return null;
            case 152105:
                this.n.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.n.onProgressUpdate(valueSetQg.longValue(0), valueSetQg.longValue(1));
                return null;
            case 152107:
                this.n.onVideoAdComplete();
                return null;
            case 152108:
                this.n.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
