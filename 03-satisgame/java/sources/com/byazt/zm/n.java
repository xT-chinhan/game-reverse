package com.byazt.zm;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1279, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTNativeExpressAd.AdInteractionListener n;

    public n(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
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
            case 151101:
                this.n.onAdClicked((View) valueSetQg.objectValue(0, View.class), valueSetQg.intValue(1));
                return null;
            case 151102:
                this.n.onAdShow((View) valueSetQg.objectValue(0, View.class), valueSetQg.intValue(1));
                return null;
            case 151103:
                this.n.onRenderFail((View) valueSetQg.objectValue(0, View.class), valueSetQg.stringValue(1), valueSetQg.intValue(2));
                return null;
            case 151104:
                this.n.onRenderSuccess((View) valueSetQg.objectValue(0, View.class), valueSetQg.floatValue(1), valueSetQg.floatValue(2));
                return null;
            case 151105:
                this.n.onAdDismiss();
                return null;
            default:
                return null;
        }
    }
}
