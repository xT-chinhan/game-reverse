package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapRewardVideoAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoader;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNRewardedAdLoader implements AdapterRewardLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterRewardLoader
    public void load(Context context, AdapterRewardLoadRequest adapterRewardLoadRequest, final AdapterLoadCallback<AdapterRewardSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else {
            AdapterLoadRequest common = adapterRewardLoadRequest.getCommon();
            orCreateAdNative.loadRewardVideoAd(new AdRequest.Builder().withSpaceId(Long.parseLong(common.getPlacementId())).withRewardAmount(adapterRewardLoadRequest.getRewardAmount()).withRewardName(adapterRewardLoadRequest.getRewardName()).withQuery(common.getQuery()).withUserId(adapterRewardLoadRequest.getUserId()).withExtra1(adapterRewardLoadRequest.getRewardExtra()).withMinaId(common.getMinaId()).build(), new TapAdNative.RewardVideoAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNRewardedAdLoader.1
                private TapRewardVideoAd accepted;

                private void complete(TapRewardVideoAd tapRewardVideoAd) {
                    if (this.accepted != null || tapRewardVideoAd == null) {
                        return;
                    }
                    this.accepted = tapRewardVideoAd;
                    adapterLoadCallback.onSuccess(Collections.singletonList(new TapTapADNRewardSession(tapRewardVideoAd)));
                }

                @Override // com.tapsdk.tapad.internal.CommonListener
                public void onError(int i, String str) {
                    adapterLoadCallback.onFailure(i, str);
                }

                @Override // com.tapsdk.tapad.TapAdNative.RewardVideoAdListener
                public void onRewardVideoAdLoad(TapRewardVideoAd tapRewardVideoAd) {
                    complete(tapRewardVideoAd);
                }

                @Override // com.tapsdk.tapad.TapAdNative.RewardVideoAdListener
                public void onRewardVideoCached(TapRewardVideoAd tapRewardVideoAd) {
                    complete(tapRewardVideoAd);
                }
            });
        }
    }
}
