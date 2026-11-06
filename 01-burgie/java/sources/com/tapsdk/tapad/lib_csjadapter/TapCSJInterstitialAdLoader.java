package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJInterstitialAdLoader implements AdapterInterstitialLoader {
    private static final int ERROR_CREATIVE_TYPE_UNSUPPORTED = 10003;

    @Override // com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader
    public void load(Context context, AdapterInterstitialLoadRequest request, AdapterLoadCallback<AdapterInterstitialSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
        } else if (request.isSelfRendered()) {
            loadSelfRendered(context, request.getCommon(), callback);
        } else {
            loadHosted(context, request.getCommon(), callback);
        }
    }

    private void loadHosted(Context context, AdapterLoadRequest request, final AdapterLoadCallback<AdapterInterstitialSession> callback) {
        AdSlot slot = new AdSlot.Builder().setCodeId(request.getPlacementId()).setAdLoadType(request.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).setAdCount(request.getAdCount()).build();
        TTAdSdk.getAdManager().createAdNative(context).loadFullScreenVideoAd(slot, new TTAdNative.FullScreenVideoAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJInterstitialAdLoader.1
            private TapCSJInterstitialSession session;

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ad) {
                complete(ad);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd ad) {
                complete(ad);
            }

            private void complete(TTFullScreenVideoAd ad) {
                if (this.session != null || ad == null) {
                    return;
                }
                TapCSJInterstitialSession tapCSJInterstitialSession = new TapCSJInterstitialSession(ad);
                this.session = tapCSJInterstitialSession;
                callback.onSuccess(Collections.singletonList(tapCSJInterstitialSession));
            }
        });
    }

    private void loadSelfRendered(Context context, AdapterLoadRequest request, final AdapterLoadCallback<AdapterInterstitialSession> callback) {
        AdSlot slot = new AdSlot.Builder().setCodeId(request.getPlacementId()).setAdLoadType(request.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).setAdCount(request.getAdCount()).setImageAcceptedSize(request.getAcceptedWidthPx(), request.getAcceptedHeightPx()).build();
        TTAdSdk.getAdManager().createAdNative(context).loadFeedAd(slot, new TTAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJInterstitialAdLoader.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> ads) {
                ArrayList arrayList = new ArrayList();
                if (ads != null) {
                    for (TTFeedAd ad : ads) {
                        if (ad != null) {
                            arrayList.add(new TapCSJNativeFullscreenSession(ad));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    callback.onFailure(10003, "CSJ Interstitial 自渲染素材为空");
                } else {
                    callback.onSuccess(arrayList);
                }
            }
        });
    }
}
