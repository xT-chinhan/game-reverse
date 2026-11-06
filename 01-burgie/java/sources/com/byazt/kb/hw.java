package com.byazt.kb;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1621, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final TTFeedAd.VideoRewardListener pr;

    public hw(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.pr = videoRewardListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 163101:
                this.pr.onFeedRewardCountDown(valueSetHw.intValue(0));
            default:
                return null;
        }
    }
}
