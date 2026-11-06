package com.anythink.rewardvideo.a;

import android.content.Context;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements ATCommonImpressionListener {
    private boolean a;
    private int b;
    protected final f c;
    private volatile boolean d = false;
    private volatile boolean e = false;

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayStart() {
    }

    public d(f fVar, boolean z, int i) {
        this.c = fVar;
        this.a = z;
        this.b = i;
    }

    private boolean a() {
        return this.b == 1;
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdImpression() {
        f fVar;
        if (!this.a || (fVar = this.c) == null) {
            return;
        }
        fVar.onRewardedVideoAdPlayStart();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdShowFail(String str, String str2) {
        f fVar;
        if (!this.a || (fVar = this.c) == null) {
            return;
        }
        fVar.onRewardedVideoAdPlayFailed(str, str2);
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdClick() {
        if (!this.a || this.c == null) {
            return;
        }
        if (!(this.b == 1)) {
            onAdReward();
        }
        this.c.onRewardedVideoAdPlayClicked();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdDismiss() {
        if (!this.a || this.c == null) {
            return;
        }
        if (!this.d) {
            this.d = true;
            this.c.onRewardedVideoAdPlayEnd();
        }
        onAdReward();
        this.c.onRewardedVideoAdClosed();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdVideoPlayEnd() {
        if (!this.a || this.c == null || this.d) {
            return;
        }
        this.d = true;
        this.c.onRewardedVideoAdPlayEnd();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdReward() {
        if (this.c == null || this.e) {
            return;
        }
        this.e = true;
        this.c.onReward();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onAdRewardFailed() {
        if (this.c == null || this.e) {
            return;
        }
        this.e = true;
        this.c.onRewardFailed();
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDeeplinkCallback(boolean z) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDeeplinkCallback(z);
        }
    }

    @Override // com.anythink.core.api.ATCommonImpressionListener
    public void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.onDownloadConfirm(context, aTNetworkConfirmInfo);
        }
    }
}
