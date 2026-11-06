package com.byazt.avv;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1893, 19})
public class n implements Function<SparseArray<Object>, Object> {
    private final IMediationDrawAdTokenCallback n;

    public n(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.n = iMediationDrawAdTokenCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987);
        valueSetQg.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case 270029:
                this.n.onAdTokenLoaded(valueSetQg.stringValue(0), new com.byazt.lt.n(k.n(valueSetQg.objectValue(1, Object.class))));
                return null;
            case 270030:
                this.n.onAdTokenLoadedFail(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
