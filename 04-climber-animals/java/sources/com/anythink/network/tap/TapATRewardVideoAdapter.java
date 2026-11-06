package com.anythink.network.tap;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.tapsdk.tapad.TapAdManager;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapRewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATRewardVideoAdapter extends CustomRewardVideoAdapter {
    private final TapATInitManager a = TapATInitManager.getInstance();
    private int b = 0;
    private boolean c = false;
    private TapAdNative d;
    private TapRewardVideoAd e;
    private Map<String, Object> f;

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.c = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        int spaceId = this.a.getSpaceId(map);
        this.b = spaceId;
        if (spaceId == 0) {
            notifyATLoadFail("", "Tap RewardVideoAd spaceId is null or zero. spaceId:" + this.b);
        } else {
            this.a.initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.tap.TapATRewardVideoAdapter.1
                @Override // com.anythink.core.api.MediationInitCallback
                public final void onSuccess() {
                    TapATRewardVideoAdapter.this.postOnMainThread(new Runnable() { // from class: com.anythink.network.tap.TapATRewardVideoAdapter.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TapATRewardVideoAdapter.a(TapATRewardVideoAdapter.this, context, map2);
                        }
                    });
                }

                @Override // com.anythink.core.api.MediationInitCallback
                public final void onFail(String str) {
                    TapATRewardVideoAdapter.this.notifyATLoadFail("", str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATRewardVideoAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements TapAdNative.RewardVideoAdListener {
        AnonymousClass2() {
        }

        @Override // com.tapsdk.tapad.TapAdNative.RewardVideoAdListener
        public final void onRewardVideoAdLoad(TapRewardVideoAd tapRewardVideoAd) {
            if (tapRewardVideoAd != null) {
                TapATRewardVideoAdapter.this.e = tapRewardVideoAd;
                TapATRewardVideoAdapter.this.a.handleAdDataLoadedCallback(TapATRewardVideoAdapter.this.c, tapRewardVideoAd.getMediaExtraInfo(), TapATRewardVideoAdapter.this.mBiddingListener, TapATRewardVideoAdapter.this.mLoadListener, new BaseAd[0]);
            }
        }

        @Override // com.tapsdk.tapad.TapAdNative.RewardVideoAdListener
        public final void onRewardVideoCached(TapRewardVideoAd tapRewardVideoAd) {
            if (tapRewardVideoAd != null) {
                TapATRewardVideoAdapter.this.e = tapRewardVideoAd;
                TapATRewardVideoAdapter.this.a.handleAdLoadedCallback(TapATRewardVideoAdapter.this.c, TapATRewardVideoAdapter.this.e, tapRewardVideoAd.getMediaExtraInfo(), TapATRewardVideoAdapter.this.mBiddingListener, TapATRewardVideoAdapter.this.mLoadListener, new BaseAd[0]);
            } else {
                TapATRewardVideoAdapter.this.notifyATLoadFail("", "RewardVideoAd load failed, tapInterstitialAd = null.");
            }
        }

        @Override // com.tapsdk.tapad.internal.CommonListener
        public final void onError(int i, String str) {
            TapATRewardVideoAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        this.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadRewardVideoAd(this.a.getAdRequest(this.b, map), new AnonymousClass2());
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public void destory() {
        TapRewardVideoAd tapRewardVideoAd = this.e;
        if (tapRewardVideoAd != null) {
            tapRewardVideoAd.setRewardAdInteractionListener(null);
            this.e.dispose();
            this.e = null;
        }
        TapAdNative tapAdNative = this.d;
        if (tapAdNative != null) {
            tapAdNative.dispose();
            this.d = null;
        }
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkPlacementId() {
        return String.valueOf(this.b);
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return this.a.getNetworkVersion();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public String getNetworkName() {
        return this.a.getNetworkName();
    }

    @Override // com.anythink.core.api.IATBaseAdAdapter
    public boolean isAdReady() {
        return this.e != null;
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        TapRewardVideoAd tapRewardVideoAd = this.e;
        if (tapRewardVideoAd != null) {
            tapRewardVideoAd.setRewardAdInteractionListener(new TapRewardVideoAd.RewardAdInteractionListener() { // from class: com.anythink.network.tap.TapATRewardVideoAdapter.3
                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onAdValidShow() {
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onSkippedVideo() {
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onAdShow() {
                    TapATRewardVideoAdapter.f(TapATRewardVideoAdapter.this);
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onAdClose() {
                    TapATRewardVideoAdapter.g(TapATRewardVideoAdapter.this);
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onVideoComplete() {
                    if (TapATRewardVideoAdapter.this.mImpressionListener != null) {
                        TapATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onVideoError() {
                    if (TapATRewardVideoAdapter.this.mImpressionListener != null) {
                        TapATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayFailed("", "Tap RewardVideoAd play failed, onVideoError() called.");
                    }
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                    try {
                        if (TapATRewardVideoAdapter.this.f == null) {
                            TapATRewardVideoAdapter.this.f = new HashMap();
                        }
                        HashMap map = new HashMap();
                        map.put(TapATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_REWARD_AMOUNT, Integer.valueOf(i));
                        map.put(TapATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_REWARD_NAME, str);
                        map.put(TapATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_ERROR_CODE, Integer.valueOf(i2));
                        map.put(TapATConst.REWARD_EXTRA.REWARD_EXTRA_KEY_ERROR_MSG, str2);
                        TapATRewardVideoAdapter.this.f.put(ATAdConst.REWARD_EXTRA.REWARD_INFO, map);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (TapATRewardVideoAdapter.this.mImpressionListener != null) {
                        if (z) {
                            TapATRewardVideoAdapter.this.mImpressionListener.onReward();
                        } else {
                            TapATRewardVideoAdapter.this.mImpressionListener.onRewardFailed();
                        }
                    }
                }

                @Override // com.tapsdk.tapad.TapRewardVideoAd.RewardAdInteractionListener
                public final void onAdClick() {
                    if (TapATRewardVideoAdapter.this.mImpressionListener != null) {
                        TapATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }
            });
            this.e.showRewardVideoAd(activity);
        } else {
            this.mDismissType = 99;
            if (this.mImpressionListener != null) {
                this.mImpressionListener.onRewardedVideoAdPlayFailed("", "Tap RewardVideoAd show failed, mTapInterstitialAd = null.");
            }
        }
    }

    private void a(String str) {
        this.mDismissType = 99;
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onRewardedVideoAdPlayFailed("", str);
        }
    }

    private void a() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onRewardedVideoAdClosed();
        }
    }

    private void b() {
        if (this.mImpressionListener != null) {
            this.mImpressionListener.onRewardedVideoAdPlayStart();
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter, com.anythink.core.api.IATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f;
    }

    static /* synthetic */ void a(TapATRewardVideoAdapter tapATRewardVideoAdapter, Context context, Map map) {
        TapAdNative tapAdNativeCreateAdNative = TapAdManager.get().createAdNative(context);
        tapATRewardVideoAdapter.d = tapAdNativeCreateAdNative;
        tapAdNativeCreateAdNative.loadRewardVideoAd(tapATRewardVideoAdapter.a.getAdRequest(tapATRewardVideoAdapter.b, map), tapATRewardVideoAdapter.new AnonymousClass2());
    }

    static /* synthetic */ void f(TapATRewardVideoAdapter tapATRewardVideoAdapter) {
        if (tapATRewardVideoAdapter.mImpressionListener != null) {
            tapATRewardVideoAdapter.mImpressionListener.onRewardedVideoAdPlayStart();
        }
    }

    static /* synthetic */ void g(TapATRewardVideoAdapter tapATRewardVideoAdapter) {
        if (tapATRewardVideoAdapter.mImpressionListener != null) {
            tapATRewardVideoAdapter.mImpressionListener.onRewardedVideoAdClosed();
        }
    }
}
