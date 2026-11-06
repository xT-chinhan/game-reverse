package com.byazt.aj;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1781, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final CSJSplashAd.SplashCardListener n;

    public qg(CSJSplashAd.SplashCardListener splashCardListener) {
        this.n = splashCardListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 112102:
                this.n.onSplashCardClick();
                return null;
            case 112103:
                this.n.onSplashCardClose();
                return null;
            case 121201:
                this.n.onSplashCardReadyToShow(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
