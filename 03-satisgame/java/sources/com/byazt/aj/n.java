package com.byazt.aj;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1781, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final CSJSplashAd.SplashAdListener n;

    public n(CSJSplashAd.SplashAdListener splashAdListener) {
        this.n = splashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n != null && sparseArray != null) {
            ValueSet valueSetQg = s.n(sparseArray).qg();
            switch (valueSetQg.intValue(-99999987)) {
                case 111101:
                    this.n.onSplashAdShow(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))));
                    break;
                case 111102:
                    this.n.onSplashAdClick(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))));
                    break;
                case 111103:
                    this.n.onSplashAdClose(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))), valueSetQg.intValue(1));
                    break;
            }
        }
        return null;
    }
}
