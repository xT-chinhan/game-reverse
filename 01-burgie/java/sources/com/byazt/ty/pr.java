package com.byazt.ty;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 951, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final TTAdDislike.DislikeInteractionCallback pr;

    public pr(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.pr = dislikeInteractionCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 244101:
                this.pr.onShow();
                return null;
            case 244102:
                this.pr.onSelected(valueSetHw.intValue(0), valueSetHw.stringValue(1), valueSetHw.booleanValue(2));
                return null;
            case 244103:
                this.pr.onCancel();
                return null;
            default:
                return null;
        }
    }
}
