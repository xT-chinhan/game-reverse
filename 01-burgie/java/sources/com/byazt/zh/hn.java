package com.byazt.zh;

import android.util.SparseArray;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1683, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    private final IMediationNativeAdTokenCallback pr;

    public hn(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.pr = iMediationNativeAdTokenCallback;
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
            case 270026:
                this.pr.onAdTokenLoaded(valueSetHw.stringValue(0), new com.byazt.ot.hn(ho.pr(valueSetHw.objectValue(1, Object.class))));
                return null;
            case 270027:
                this.pr.onAdTokenLoadedFail(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
