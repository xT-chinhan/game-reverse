package com.byazt.zh;

import android.util.SparseArray;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1683, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    private final IMediationDrawAdTokenCallback pr;

    public pr(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.pr = iMediationDrawAdTokenCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        int iIntValue = valueSetHw.intValue(-99999987);
        valueSetHw.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case 270029:
                this.pr.onAdTokenLoaded(valueSetHw.stringValue(0), new com.byazt.ot.pr(ho.pr(valueSetHw.objectValue(1, Object.class))));
                return null;
            case 270030:
                this.pr.onAdTokenLoadedFail(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
