package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJNativeFeedAdLoader implements AdapterNativeFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader
    public void load(Context context, AdapterLoadRequest request, final AdapterLoadCallback<AdapterNativeFeedSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
        } else {
            AdSlot adSlot = new AdSlot.Builder().setCodeId(request.getPlacementId()).setAdCount(request.getAdCount()).setImageAcceptedSize(request.getAcceptedWidthPx(), request.getAcceptedHeightPx()).setAdLoadType(request.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).build();
            TTAdSdk.getAdManager().createAdNative(context).loadFeedAd(adSlot, new TTAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJNativeFeedAdLoader.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onError(int i, String s) {
                    callback.onFailure(i, s);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                public void onFeedAdLoad(List<TTFeedAd> list) {
                    ArrayList arrayList = new ArrayList();
                    for (TTFeedAd item : list) {
                        arrayList.add(new TapCSJNativeFeedSession(item));
                    }
                    callback.onSuccess(arrayList);
                }
            });
        }
    }
}
