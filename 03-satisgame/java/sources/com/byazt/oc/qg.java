package com.byazt.oc;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 891, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final TTFeedAd.VideoRewardListener n;

    public qg(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.n = videoRewardListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        if (valueSetQg.intValue(-99999987) == 163101) {
            this.n.onFeedRewardCountDown(valueSetQg.intValue(0));
        }
        return null;
    }
}
