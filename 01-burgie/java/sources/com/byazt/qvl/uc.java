package com.byazt.qvl;

import android.util.SparseArray;
import com.byazt.xjg.g;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1416, 5})
public class uc implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.RewardVideoAdListener pr;

    public uc(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.pr = rewardVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetHw;
        if (this.pr != null && (valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw()) != null) {
            switch (valueSetHw.intValue(-99999987)) {
                case 124101:
                    this.pr.onError(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                    break;
                case 124102:
                    this.pr.onRewardVideoAdLoad(new g(ho.pr(valueSetHw.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.pr.onRewardVideoCached(new g(ho.pr(valueSetHw.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.pr.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
