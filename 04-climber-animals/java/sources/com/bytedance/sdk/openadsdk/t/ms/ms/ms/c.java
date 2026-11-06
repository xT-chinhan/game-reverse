package com.bytedance.sdk.openadsdk.t.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.ao.ms.ms.u;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.RewardVideoAdListener f4109ms;

    public c(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f4109ms = rewardVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ValueSet valueSetXr;
        if (this.f4109ms != null && (valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr()) != null) {
            switch (valueSetXr.intValue(-99999987)) {
                case 124101:
                    this.f4109ms.onError(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                    break;
                case 124102:
                    this.f4109ms.onRewardVideoAdLoad(new u(ao.ms(valueSetXr.objectValue(0, Object.class))));
                    break;
                case 124103:
                    this.f4109ms.onRewardVideoCached(new u(ao.ms(valueSetXr.objectValue(0, Object.class))));
                    break;
                case 124104:
                    this.f4109ms.onRewardVideoCached();
                    break;
            }
        }
        return null;
    }
}
