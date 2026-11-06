package com.byazt.ael;

import android.util.SparseArray;
import android.view.View;
import com.byazt.xjg.ho;
import com.byazt.xjg.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2250, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.AdInteractionListener pr;

    public pr(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.pr = adInteractionListener;
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
            case 141101:
                this.pr.onAdClicked((View) valueSetHw.objectValue(0, View.class), new k(ho.pr(valueSetHw.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.pr.onAdCreativeClick((View) valueSetHw.objectValue(0, View.class), new k(ho.pr(valueSetHw.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.pr.onAdShow(new k(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
