package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapInterstitialAd;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNInterstitialAdLoader implements AdapterInterstitialLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader
    public void load(Context context, AdapterInterstitialLoadRequest adapterInterstitialLoadRequest, final AdapterLoadCallback<AdapterInterstitialSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else {
            AdapterLoadRequest common = adapterInterstitialLoadRequest.getCommon();
            orCreateAdNative.loadInterstitialAd(new AdRequest.Builder().withSpaceId(Long.parseLong(common.getPlacementId())).withMinaId(common.getMinaId()).withQuery(common.getQuery()).build(), new TapAdNative.InterstitialAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNInterstitialAdLoader.1
                @Override // com.tapsdk.tapad.internal.CommonListener
                public void onError(int i, String str) {
                    adapterLoadCallback.onFailure(i, str);
                }

                @Override // com.tapsdk.tapad.TapAdNative.InterstitialAdListener
                public void onInterstitialAdLoad(TapInterstitialAd tapInterstitialAd) {
                    adapterLoadCallback.onSuccess(Collections.singletonList(new TapTapADNInterstitialSession(tapInterstitialAd)));
                }
            });
        }
    }
}
