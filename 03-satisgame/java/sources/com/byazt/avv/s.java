package com.byazt.avv;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1893, 8})
public class s implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback n;

    public s(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.n = iMediationNativeAdTokenCallback;
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
            case 270026:
                this.n.onAdTokenLoaded(valueSetQg.stringValue(0), new com.byazt.lt.s(k.n(valueSetQg.objectValue(1, Object.class))));
                return null;
            case 270027:
                this.n.onAdTokenLoadedFail(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
