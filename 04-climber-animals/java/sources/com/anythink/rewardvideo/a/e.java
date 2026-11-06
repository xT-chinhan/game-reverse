package com.anythink.rewardvideo.a;

import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;

/* JADX INFO: loaded from: classes.dex */
public class e extends d implements CustomRewardedVideoEventListener {
    public e(f fVar, boolean z, int i) {
        super(fVar, z, i);
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdPlayStart() {
        if (this.c != null) {
            this.c.onRewardedVideoAdPlayStart();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdPlayEnd() {
        if (this.c != null) {
            this.c.onRewardedVideoAdPlayEnd();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdPlayFailed(String str, String str2) {
        if (this.c != null) {
            this.c.onRewardedVideoAdPlayFailed(str, str2);
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdClosed() {
        if (this.c != null) {
            this.c.onRewardedVideoAdClosed();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdPlayClicked() {
        if (this.c != null) {
            this.c.onRewardedVideoAdPlayClicked();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onReward() {
        if (this.c != null) {
            this.c.onReward();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardFailed() {
        if (this.c != null) {
            this.c.onRewardFailed();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdAgainPlayStart() {
        if (this.c != null) {
            this.c.onRewardedVideoAdAgainPlayStart();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdAgainPlayEnd() {
        if (this.c != null) {
            this.c.onRewardedVideoAdAgainPlayEnd();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
        if (this.c != null) {
            this.c.onRewardedVideoAdAgainPlayFailed(str, str2);
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onRewardedVideoAdAgainPlayClicked() {
        if (this.c != null) {
            this.c.onRewardedVideoAdAgainPlayClicked();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onAgainReward() {
        if (this.c != null) {
            this.c.onAgainReward();
        }
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
    public void onAgainRewardFailed() {
        if (this.c != null) {
            this.c.onAgainRewardFailed();
        }
    }
}
