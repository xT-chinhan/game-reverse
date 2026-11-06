package com.byazt.vz;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1781, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final CSJSplashAd.SplashCardListener pr;

    public hw(CSJSplashAd.SplashCardListener splashCardListener) {
        this.pr = splashCardListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 112102:
                this.pr.onSplashCardClick();
                return null;
            case 112103:
                this.pr.onSplashCardClose();
                return null;
            case 121201:
                this.pr.onSplashCardReadyToShow(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
