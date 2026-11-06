package com.byazt.jb;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1009, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    private final MediationAdDislike pr;

    public hw(MediationAdDislike mediationAdDislike) {
        this.pr = mediationAdDislike;
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
            case 270032:
                this.pr.showDislikeDialog();
                return null;
            case 270033:
                this.pr.setDislikeCallback(new pr(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
