package com.byazt.hr;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    private final IMediationDislikeCallback n;

    public qg(IMediationDislikeCallback iMediationDislikeCallback) {
        this.n = iMediationDislikeCallback;
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
            case 268013:
                this.n.onSelected(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            case 268014:
                this.n.onCancel();
                return null;
            case 268015:
                this.n.onShow();
                return null;
            default:
                return null;
        }
    }
}
