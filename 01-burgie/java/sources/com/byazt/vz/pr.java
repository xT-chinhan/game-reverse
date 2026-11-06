package com.byazt.vz;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1781, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final CSJSplashAd.SplashAdListener pr;

    public pr(CSJSplashAd.SplashAdListener splashAdListener) {
        this.pr = splashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null || sparseArray == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 111101:
                this.pr.onSplashAdShow(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 111102:
                this.pr.onSplashAdClick(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 111103:
                this.pr.onSplashAdClose(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))), valueSetHw.intValue(1));
                return null;
            default:
                return null;
        }
    }
}
