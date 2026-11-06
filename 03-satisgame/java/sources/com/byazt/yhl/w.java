package com.byazt.yhl;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.mo.sz;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 466, 13})
public class w implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.RewardVideoAdListener n;

    public w(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.n = rewardVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetQg;
        if (this.n != null && (valueSetQg = com.byazt.qvu.s.n(sparseArray).qg()) != null) {
            switch (valueSetQg.intValue(-99999987)) {
                case 124101:
                    this.n.onError(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                    break;
                case 124102:
                    this.n.onRewardVideoAdLoad(new sz(k.n(valueSetQg.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.n.onRewardVideoCached(new sz(k.n(valueSetQg.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.n.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
