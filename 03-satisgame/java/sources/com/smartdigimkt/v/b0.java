package com.smartdigimkt.v;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.smartdigimkt.sdk.api.format.SDMRewardedVideoAd;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements com.smartdigimkt.j1.a, com.smartdigimkt.j1.g {
    final /* synthetic */ SDMRewardedVideoAd this$0;

    public b0(SDMRewardedVideoAd sDMRewardedVideoAd) {
        this.this$0 = sDMRewardedVideoAd;
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClick(com.smartdigimkt.j1.w wVar) {
        this.this$0.printAdStatusLog("click", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClick();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdClosed() {
        this.this$0.printAdStatusLog(ILivePush.ClickType.CLOSE, "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdClose();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onAdShow(com.smartdigimkt.j1.w wVar) {
        this.this$0.printAdStatusLog("impression", "success", "");
        this.this$0.printAdStatusLog("play_start", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdPlayStart();
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onRewardTaskFirst() {
        this.this$0.printAdStatusLog("rewarded", "success", "taskType=1");
        this.this$0.notifyDoubleReward(1);
    }

    @Override // com.smartdigimkt.j1.g
    public void onRewarded() {
        this.this$0.printAdStatusLog("rewarded", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdReward();
        }
    }

    @Override // com.smartdigimkt.j1.a
    public void onShowFailed(com.smartdigimkt.h0.g gVar) {
        String str = gVar != null ? gVar.b : "";
        this.this$0.printAdStatusLog("show_failed", "fail", gVar != null ? gVar.a() : "", new com.smartdigimkt.z3.a(gVar != null ? gVar.a : "", str));
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdPlayFailed(com.smartdigimkt.z3.b.a("20002", str));
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayEnd() {
        this.this$0.printAdStatusLog("play_end", "success", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onAdPlayEnd();
        }
    }

    @Override // com.smartdigimkt.j1.g
    public void onVideoAdPlayStart() {
    }

    @Override // com.smartdigimkt.j1.a
    public void onDeeplinkCallback(boolean z) {
        this.this$0.printAdStatusLog(SDMAdConst.NETWORK_CUSTOM_KEY.DEEPLINK, z ? "success" : "fail", "");
        if (this.this$0.mDevListener != null) {
            this.this$0.mDevListener.onDeeplinkCallback(z);
        }
    }
}
