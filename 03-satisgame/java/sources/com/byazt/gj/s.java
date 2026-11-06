package com.byazt.gj;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1253, 8})
public class s implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.ExpressRenderListener n;

    public s(TTNativeAd.ExpressRenderListener expressRenderListener) {
        this.n = expressRenderListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        if (valueSetQg.intValue(-99999987) == 142101) {
            this.n.onRenderSuccess((View) valueSetQg.objectValue(0, View.class), valueSetQg.floatValue(1), valueSetQg.floatValue(2), valueSetQg.booleanValue(3));
        }
        return null;
    }
}
