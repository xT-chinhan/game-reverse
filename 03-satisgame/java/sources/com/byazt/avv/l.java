package com.byazt.avv;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1893, 18})
public class l implements Function<SparseArray<Object>, Object> {
    private final MediationAppDialogClickListener n;

    public l(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.n = mediationAppDialogClickListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        if (valueSetQg.intValue(-99999987) == 270025) {
            this.n.onButtonClick(valueSetQg.intValue(0));
        }
        return null;
    }
}
