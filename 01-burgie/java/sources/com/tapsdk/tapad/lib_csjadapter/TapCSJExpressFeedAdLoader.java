package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterExpressFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJExpressFeedAdLoader implements AdapterExpressFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterExpressFeedLoader
    public void load(final Context context, AdapterLoadRequest request, final AdapterLoadCallback<AdapterExpressFeedSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
            return;
        }
        int width = (int) AdapterViewSupport.pxToDp(context, request.getAcceptedWidthPx());
        int height = (int) AdapterViewSupport.pxToDp(context, request.getAcceptedHeightPx());
        if (width == 0) {
            width = (int) AdapterViewSupport.screenWidthDp(context);
        }
        AdSlot adSlot = new AdSlot.Builder().setCodeId(request.getPlacementId()).setAdCount(request.getAdCount()).setExpressViewAcceptedSize(width, height).setImageAcceptedSize(width, height).setAdLoadType(request.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).build();
        TTAdSdk.getAdManager().createAdNative(context).loadNativeExpressAd(adSlot, new TTAdNative.NativeExpressAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJExpressFeedAdLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
                ArrayList arrayList = new ArrayList();
                if (ads != null) {
                    for (TTNativeExpressAd ad : ads) {
                        if (ad != null) {
                            arrayList.add(new TapCSJExpressFeedSession(ad, context));
                        }
                    }
                }
                callback.onSuccess(arrayList);
            }
        });
    }
}
