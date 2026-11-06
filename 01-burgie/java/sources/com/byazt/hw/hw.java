package com.byazt.hw;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 13, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final TTNativeExpressAd.ExpressAdInteractionListener pr;

    public hw(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.pr = expressAdInteractionListener;
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
            case 151101:
                this.pr.onAdClicked((View) valueSetHw.objectValue(0, View.class), valueSetHw.intValue(1));
                return null;
            case 151102:
                this.pr.onAdShow((View) valueSetHw.objectValue(0, View.class), valueSetHw.intValue(1));
                return null;
            case 151103:
                this.pr.onRenderFail((View) valueSetHw.objectValue(0, View.class), valueSetHw.stringValue(1), valueSetHw.intValue(2));
                return null;
            case 151104:
                this.pr.onRenderSuccess((View) valueSetHw.objectValue(0, View.class), valueSetHw.floatValue(1), valueSetHw.floatValue(2));
                return null;
            default:
                return null;
        }
    }
}
