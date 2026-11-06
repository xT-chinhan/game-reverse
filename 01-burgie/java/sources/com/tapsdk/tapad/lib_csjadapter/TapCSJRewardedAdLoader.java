package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoader;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJRewardedAdLoader implements AdapterRewardLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterRewardLoader
    public void load(Context context, AdapterRewardLoadRequest request, AdapterLoadCallback<AdapterRewardSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(-1, "请初始化sdk");
        } else if (request.isSelfRendered()) {
            loadSelfRendered(context, request, callback);
        } else {
            loadHosted(context, request, callback);
        }
    }

    private void loadSelfRendered(Context context, AdapterRewardLoadRequest request, final AdapterLoadCallback<AdapterRewardSession> callback) {
        AdapterLoadRequest common = request.getCommon();
        AdSlot slot = new AdSlot.Builder().setCodeId(common.getPlacementId()).setAdCount(common.getAdCount()).setImageAcceptedSize(request.getAcceptedImageWidthPx(), request.getAcceptedImageHeightPx()).setAdLoadType(common.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).build();
        TTAdSdk.getAdManager().createAdNative(context).loadFeedAd(slot, new TTAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJRewardedAdLoader.1
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
                callback.onSuccess(arrayList);
            }
        });
    }

    private void loadHosted(Context context, AdapterRewardLoadRequest request, final AdapterLoadCallback<AdapterRewardSession> callback) {
        AdapterLoadRequest common = request.getCommon();
        AdSlot slot = new AdSlot.Builder().setCodeId(common.getPlacementId()).setAdLoadType(common.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).setRewardAmount(request.getRewardAmount()).setRewardName(request.getRewardName()).setExt(request.getRewardExtra()).setUserID(request.getUserId()).build();
        TTAdSdk.getAdManager().createAdNative(context).loadRewardVideoAd(slot, new TTAdNative.RewardVideoAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJRewardedAdLoader.2
            private TTRewardVideoAd accepted;

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd ad) {
                complete(ad);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd ad) {
                complete(ad);
            }

            private void complete(TTRewardVideoAd ad) {
                if (this.accepted != null || ad == null) {
                    return;
                }
                this.accepted = ad;
                callback.onSuccess(Collections.singletonList(new TapCSJRewardSession(ad)));
            }
        });
    }
}
