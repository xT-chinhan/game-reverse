package com.byazt.gj;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1253, 5})
public class q implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.IncentiveAdListener n;

    public q(TTNativeAd.IncentiveAdListener incentiveAdListener) {
        this.n = incentiveAdListener;
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
            case 145101:
                this.n.incentiveAdInfo((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 145102:
                this.n.incentiveAdRenderSuccess((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 145103:
                this.n.incentiveAdRenderFail((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 145104:
                this.n.incentiveAdClose();
                return null;
            default:
                return null;
        }
    }
}
