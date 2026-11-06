package com.byazt.x;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 121, 5})
public class uc implements Function<SparseArray<Object>, Object> {
    private final MediationExpressRenderListener pr;

    public uc(MediationExpressRenderListener mediationExpressRenderListener) {
        this.pr = mediationExpressRenderListener;
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
            case 142101:
                this.pr.onRenderSuccess((View) valueSetHw.objectValue(0, View.class), valueSetHw.floatValue(1), valueSetHw.floatValue(2), valueSetHw.booleanValue(3));
                return null;
            case 142102:
                this.pr.onRenderFail((View) valueSetHw.objectValue(0, View.class), valueSetHw.stringValue(1), valueSetHw.intValue(2));
                return null;
            case 142103:
                this.pr.onAdClick();
                return null;
            case 142104:
                this.pr.onAdShow();
                return null;
            default:
                return null;
        }
    }
}
