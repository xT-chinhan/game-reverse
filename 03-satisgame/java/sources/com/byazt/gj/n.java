package com.byazt.gj;

import android.util.SparseArray;
import android.view.View;
import com.byazt.mo.d;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1253, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.AdInteractionListener n;

    public n(TTNativeAd.AdInteractionListener adInteractionListener) {
        this.n = adInteractionListener;
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
            case 141101:
                this.n.onAdClicked((View) valueSetQg.objectValue(0, View.class), new d(k.n(valueSetQg.objectValue(1, Object.class))));
                return null;
            case 141102:
                this.n.onAdCreativeClick((View) valueSetQg.objectValue(0, View.class), new d(k.n(valueSetQg.objectValue(1, Object.class))));
                return null;
            case 141103:
                this.n.onAdShow(new d(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
