package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapBannerAd;
import com.tapsdk.tapad.group.adapter.AdapterBannerLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNBannerLoader implements AdapterBannerLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerLoader
    public void load(Context context, AdapterLoadRequest adapterLoadRequest, final AdapterLoadCallback<AdapterBannerSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else {
            orCreateAdNative.loadBannerAd(new AdRequest.Builder().withSpaceId(Long.parseLong(adapterLoadRequest.getPlacementId())).withMinaId(adapterLoadRequest.getMinaId()).withQuery(adapterLoadRequest.getQuery()).build(), new TapAdNative.BannerAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNBannerLoader.1
                @Override // com.tapsdk.tapad.TapAdNative.BannerAdListener
                public void onBannerAdLoad(TapBannerAd tapBannerAd) {
                    if (tapBannerAd == null) {
                        adapterLoadCallback.onFailure(-1, "bannerAd is null");
                    } else {
                        adapterLoadCallback.onSuccess(Collections.singletonList(new TapTapADNBannerSession(tapBannerAd)));
                    }
                }

                @Override // com.tapsdk.tapad.internal.CommonListener
                public void onError(int i, String str) {
                    adapterLoadCallback.onFailure(i, str);
                }
            });
        }
    }
}
