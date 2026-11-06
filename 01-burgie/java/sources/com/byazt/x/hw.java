package com.byazt.x;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    private final IMediationDislikeCallback pr;

    public hw(IMediationDislikeCallback iMediationDislikeCallback) {
        this.pr = iMediationDislikeCallback;
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
            case 268013:
                this.pr.onSelected(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            case 268014:
                this.pr.onCancel();
                return null;
            case 268015:
                this.pr.onShow();
                return null;
            default:
                return null;
        }
    }
}
