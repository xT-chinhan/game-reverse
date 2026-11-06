package com.byazt.io;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1886, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final TTAdInteractionListener n;

    public qg(TTAdInteractionListener tTAdInteractionListener) {
        this.n = tTAdInteractionListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        int iIntValue = valueSetQg.intValue(-99999987);
        if (iIntValue == -2147483647) {
            return "TTAdInteractionListener";
        }
        if (iIntValue == 100101) {
            this.n.onAdEvent(valueSetQg.intValue(0), (Map) valueSetQg.objectValue(1, Map.class));
        }
        return null;
    }
}
