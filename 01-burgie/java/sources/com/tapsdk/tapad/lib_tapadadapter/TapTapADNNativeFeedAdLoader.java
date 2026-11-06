package com.tapsdk.tapad.lib_tapadadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNNativeFeedAdLoader implements AdapterNativeFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader
    public void load(final Context context, AdapterLoadRequest adapterLoadRequest, final AdapterLoadCallback<AdapterNativeFeedSession> adapterLoadCallback) {
        TapAdNative orCreateAdNative = TapTapADNManagerHolder.getOrCreateAdNative(context);
        if (orCreateAdNative == null) {
            adapterLoadCallback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "tapAdNative is null");
        } else {
            orCreateAdNative.loadNativeFeedAd(new AdRequest.Builder().withSpaceId(Long.parseLong(adapterLoadRequest.getPlacementId())).withMinaId(adapterLoadRequest.getMinaId()).withQuery(adapterLoadRequest.getQuery()).build(), new TapAdNative.NativeFeedAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeFeedAdLoader.1
                @Override // com.tapsdk.tapad.internal.CommonListener
                public void onError(int i, String str) {
                    adapterLoadCallback.onFailure(i, str);
                }

                @Override // com.tapsdk.tapad.TapAdNative.NativeFeedAdListener
                public void onNativeFeedAdLoad(List<TapFeedAd> list) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<TapFeedAd> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new TapTapADNNativeFeedSession(context, it.next()));
                    }
                    adapterLoadCallback.onSuccess(arrayList);
                }
            });
        }
    }
}
