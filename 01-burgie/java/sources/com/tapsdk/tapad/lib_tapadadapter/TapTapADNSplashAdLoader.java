package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.TapSplashAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoader;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNSplashAdLoader implements AdapterSplashLoader {
    private static AdRequest createRequest(Context context, AdapterSplashLoadRequest adapterSplashLoadRequest) {
        return new AdRequest.Builder().withSpaceId(Long.parseLong(adapterSplashLoadRequest.getCommon().getPlacementId())).withMinaId(adapterSplashLoadRequest.getCommon().getMinaId()).withQuery(adapterSplashLoadRequest.getCommon().getQuery()).withExpressViewAcceptedSize(resolveWidth(context, adapterSplashLoadRequest), resolveHeight(context, adapterSplashLoadRequest)).build();
    }

    private static void loadHosted(Context context, TapAdNative tapAdNative, AdapterSplashLoadRequest adapterSplashLoadRequest, final AdapterLoadCallback<AdapterSplashSession> adapterLoadCallback) {
        tapAdNative.loadSplashAd(createRequest(context, adapterSplashLoadRequest), new TapAdNative.SplashAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNSplashAdLoader.1
            @Override // com.tapsdk.tapad.internal.CommonListener
            public void onError(int i, String str) {
                adapterLoadCallback.onFailure(i, str);
            }

            @Override // com.tapsdk.tapad.TapAdNative.SplashAdListener
            public void onSplashAdLoad(TapSplashAd tapSplashAd) {
                adapterLoadCallback.onSuccess(Collections.singletonList(new TapTapADNSplashSession(tapSplashAd)));
            }
        });
    }

    private static void loadNative(final Context context, TapAdNative tapAdNative, final AdapterSplashLoadRequest adapterSplashLoadRequest, final AdapterLoadCallback<AdapterSplashSession> adapterLoadCallback) {
        tapAdNative.loadNativeFeedAd(createRequest(context, adapterSplashLoadRequest), new TapAdNative.NativeFeedAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNSplashAdLoader.2
            @Override // com.tapsdk.tapad.internal.CommonListener
            public void onError(int i, String str) {
                adapterLoadCallback.onFailure(i, str);
            }

            @Override // com.tapsdk.tapad.TapAdNative.NativeFeedAdListener
            public void onNativeFeedAdLoad(List<TapFeedAd> list) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (TapFeedAd tapFeedAd : list) {
                        if (tapFeedAd != null) {
                            arrayList.add(new TapTapADNNativeSplashSession(context, tapFeedAd, adapterSplashLoadRequest.isDoubleWindow()));
                        }
                    }
                }
                adapterLoadCallback.onSuccess(arrayList);
            }
        });
    }

    private static int resolveHeight(Context context, AdapterSplashLoadRequest adapterSplashLoadRequest) {
        return adapterSplashLoadRequest.getCommon().getAcceptedHeightPx() > 0 ? adapterSplashLoadRequest.getCommon().getAcceptedHeightPx() : resolveScreenDimension(context, adapterSplashLoadRequest, false);
    }

    private static int resolveScreenDimension(Context context, AdapterSplashLoadRequest adapterSplashLoadRequest, boolean z) {
        int iScreenWidthPx = AdapterViewSupport.screenWidthPx(context);
        int iScreenHeightPx = AdapterViewSupport.screenHeightPx(context);
        if (adapterSplashLoadRequest.getScreenOrientation() == 1) {
            return z ? Math.max(iScreenWidthPx, iScreenHeightPx) : Math.min(iScreenWidthPx, iScreenHeightPx);
        }
        if (adapterSplashLoadRequest.getScreenOrientation() == 2) {
            return z ? Math.min(iScreenWidthPx, iScreenHeightPx) : Math.max(iScreenWidthPx, iScreenHeightPx);
        }
        return z ? iScreenWidthPx : iScreenHeightPx;
    }

    private static int resolveWidth(Context context, AdapterSplashLoadRequest adapterSplashLoadRequest) {
        return adapterSplashLoadRequest.getCommon().getAcceptedWidthPx() > 0 ? adapterSplashLoadRequest.getCommon().getAcceptedWidthPx() : resolveScreenDimension(context, adapterSplashLoadRequest, true);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashLoader
    public void load(Context context, AdapterSplashLoadRequest adapterSplashLoadRequest, AdapterLoadCallback<AdapterSplashSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else if (adapterSplashLoadRequest.isSelfRendered()) {
            loadNative(context, orCreateAdNative, adapterSplashLoadRequest, adapterLoadCallback);
        } else {
            loadHosted(context, orCreateAdNative, adapterSplashLoadRequest, adapterLoadCallback);
        }
    }
}
