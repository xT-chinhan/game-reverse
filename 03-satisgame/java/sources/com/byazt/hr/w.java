package com.byazt.hr;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1840, 13})
public class w implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener n;

    public w(MediationExpressRenderListener mediationExpressRenderListener) {
        this.n = mediationExpressRenderListener;
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
            case 142101:
                this.n.onRenderSuccess((View) valueSetQg.objectValue(0, View.class), valueSetQg.floatValue(1), valueSetQg.floatValue(2), valueSetQg.booleanValue(3));
                return null;
            case 142102:
                this.n.onRenderFail((View) valueSetQg.objectValue(0, View.class), valueSetQg.stringValue(1), valueSetQg.intValue(2));
                return null;
            case 142103:
                this.n.onAdClick();
                return null;
            case 142104:
                this.n.onAdShow();
                return null;
            default:
                return null;
        }
    }
}
