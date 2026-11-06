package com.byazt.ael;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2250, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.ExpressRenderListener pr;

    public hn(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.pr = expressRenderListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 142101:
                this.pr.onRenderSuccess((View) valueSetHw.objectValue(0, View.class), valueSetHw.floatValue(1), valueSetHw.floatValue(2), valueSetHw.booleanValue(3));
            default:
                return null;
        }
    }
}
