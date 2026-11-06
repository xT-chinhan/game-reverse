package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNExpressFeedAdLoader implements AdapterExpressFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader
    public void load(Context context, final AdapterLoadRequest adapterLoadRequest, final AdapterLoadCallback<AdapterExpressFeedSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else {
            orCreateAdNative.loadExpressFeedAd(new AdRequest.Builder().withSpaceId(Long.parseLong(adapterLoadRequest.getPlacementId())).withQuery(adapterLoadRequest.getQuery()).withMinaId(adapterLoadRequest.getMinaId()).build(), new TapAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNExpressFeedAdLoader.1
                @Override // com.tapsdk.tapad.internal.CommonListener
                public void onError(int i, String str) {
                    adapterLoadCallback.onFailure(i, str);
                }

                @Override // com.tapsdk.tapad.TapAdNative.FeedAdListener
                public void onFeedAdLoad(List<TapFeedAd> list) {
                    ArrayList arrayList = new ArrayList();
                    if (list != null) {
                        for (TapFeedAd tapFeedAd : list) {
                            if (tapFeedAd != null) {
                                arrayList.add(new TapTapADNExpressFeedSession(tapFeedAd, adapterLoadRequest.getAcceptedWidthPx(), adapterLoadRequest.getAcceptedHeightPx()));
                            }
                        }
                    }
                    adapterLoadCallback.onSuccess(arrayList);
                }
            });
        }
    }
}
