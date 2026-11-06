package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyRewardVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public final class ng {
    public final IQYNative.RewardVideoAdListener a;

    public ng(IQYNative.RewardVideoAdListener rewardVideoAdListener) {
        this.a = rewardVideoAdListener;
    }

    public final void a(Object obj) {
        kh.a.a(new lg(this, (IQyRewardVideoAd) obj));
    }

    public final void a(int i, String str) {
        kh.a.a(new mg(this, i, str));
    }
}
