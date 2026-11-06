package com.smartdigimkt.v;

import com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResult;
import com.smartdigimkt.sdk.api.format.SDMAdDeepRewardResultListener;
import com.smartdigimkt.sdk.api.format.SDMRewardedVideoAd;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements Runnable {
    final /* synthetic */ SDMRewardedVideoAd this$0;
    final /* synthetic */ int val$taskType;

    public c0(SDMRewardedVideoAd sDMRewardedVideoAd, int i) {
        this.this$0 = sDMRewardedVideoAd;
        this.val$taskType = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDMAdDeepRewardResultListener sDMAdDeepRewardResultListener = this.this$0.mDeepRewardListener;
        if (sDMAdDeepRewardResultListener != null) {
            try {
                sDMAdDeepRewardResultListener.onSuccess(Collections.singletonList(new SDMAdDeepRewardResult(this.val$taskType)));
            } catch (Throwable unused) {
            }
        }
    }
}
