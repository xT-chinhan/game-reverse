package com.byazt.zp;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2475, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final TTAdDislike.DislikeInteractionCallback n;

    public n(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.n = dislikeInteractionCallback;
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
            case 244101:
                this.n.onShow();
                return null;
            case 244102:
                this.n.onSelected(valueSetQg.intValue(0), valueSetQg.stringValue(1), valueSetQg.booleanValue(2));
                return null;
            case 244103:
                this.n.onCancel();
                return null;
            default:
                return null;
        }
    }
}
