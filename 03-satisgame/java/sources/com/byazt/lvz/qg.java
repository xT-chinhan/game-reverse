package com.byazt.lvz;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 463, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    private final MediationAdDislike n;

    public qg(MediationAdDislike mediationAdDislike) {
        this.n = mediationAdDislike;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 270032:
                this.n.showDislikeDialog();
                return null;
            case 270033:
                this.n.setDislikeCallback(new n(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
