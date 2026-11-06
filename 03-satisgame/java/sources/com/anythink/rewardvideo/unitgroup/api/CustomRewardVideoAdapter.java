package com.anythink.rewardvideo.unitgroup.api;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.api.ATCommonImpressionListener;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.bridge.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomRewardVideoAdapter extends ATBaseAdAdapter {
    protected CustomRewardedVideoEventListener mImpressionListener;

    public abstract void show(Activity activity);

    @Override // com.anythink.core.api.bridge.ATBaseAdAdapter, com.anythink.core.api.bridge.IATBaseAdAdapter
    public void internalFormatShow(Activity activity, ViewGroup viewGroup, final ATCommonImpressionListener aTCommonImpressionListener) {
        final CustomRewardedVideoEventListener customRewardedVideoEventListener = aTCommonImpressionListener instanceof CustomRewardedVideoEventListener ? (CustomRewardedVideoEventListener) aTCommonImpressionListener : null;
        this.mImpressionListener = new CustomRewardedVideoEventListener() { // from class: com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter.1
            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdPlayStart() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdPlayStart();
                    return;
                }
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdVideoPlayStart();
                    aTCommonImpressionListener.onAdImpression();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdPlayEnd() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdPlayEnd();
                    return;
                }
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdVideoPlayEnd();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdPlayFailed(String str, String str2) {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdPlayFailed(str, str2);
                    return;
                }
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdShowFail(str, str2);
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdClosed() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdClosed();
                    return;
                }
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdDismiss();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdPlayClicked() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdPlayClicked();
                    return;
                }
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdClick();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onReward() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onReward();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardFailed() {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onAdRewardFailed();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onDeeplinkCallback(boolean z) {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onDeeplinkCallback(z);
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onDownloadConfirm(Context context, ATNetworkConfirmInfo aTNetworkConfirmInfo) {
                ATCommonImpressionListener aTCommonImpressionListener2 = aTCommonImpressionListener;
                if (aTCommonImpressionListener2 != null) {
                    aTCommonImpressionListener2.onDownloadConfirm(context, aTNetworkConfirmInfo);
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdAgainPlayStart() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdAgainPlayStart();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdAgainPlayEnd() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdAgainPlayEnd();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdAgainPlayFailed(String str, String str2) {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdAgainPlayFailed(str, str2);
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onRewardedVideoAdAgainPlayClicked() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onRewardedVideoAdAgainPlayClicked();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onAgainReward() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onAgainReward();
                }
            }

            @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener
            public final void onAgainRewardFailed() {
                CustomRewardedVideoEventListener customRewardedVideoEventListener2 = customRewardedVideoEventListener;
                if (customRewardedVideoEventListener2 != null) {
                    customRewardedVideoEventListener2.onAgainRewardFailed();
                }
            }
        };
        try {
            show(activity);
        } catch (Throwable th) {
            if (this.mImpressionListener != null) {
                this.mImpressionListener.onRewardedVideoAdPlayFailed("", "show failed: " + th.getMessage());
            }
        }
    }

    public void clearImpressionListener() {
        this.mImpressionListener = null;
    }

    public int getAdRewardCallbackType() {
        if (this.serverExtraInfo != null) {
            return this.serverExtraInfo.c();
        }
        return 1;
    }
}
