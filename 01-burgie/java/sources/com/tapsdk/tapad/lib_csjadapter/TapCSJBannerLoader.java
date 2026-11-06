package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.tapsdk.tapad.group.adapter.AdapterBannerLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJBannerLoader implements AdapterBannerLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerLoader
    public void load(final Context context, AdapterLoadRequest request, final AdapterLoadCallback<AdapterBannerSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
            return;
        }
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final TapCSJBannerSizeResolver.Size bannerSize = TapCSJBannerSizeResolver.resolve(request.getAcceptedWidthPx(), request.getAcceptedHeightPx(), metrics.density, metrics.widthPixels);
        AdSlot adSlot = new AdSlot.Builder().setCodeId(request.getPlacementId()).setExpressViewAcceptedSize(bannerSize.widthDp, bannerSize.heightDp).setSupportDeepLink(true).setAdCount(request.getAdCount()).setAdLoadType(request.isPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).build();
        TTAdSdk.getAdManager().createAdNative(context).loadBannerExpressAd(adSlot, new TTAdNative.NativeExpressAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJBannerLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onNativeExpressAdLoad(List<TTNativeExpressAd> ads) {
                if (ads == null || ads.isEmpty()) {
                    callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "Banner广告返回为空");
                    return;
                }
                ArrayList arrayList = new ArrayList(ads.size());
                for (TTNativeExpressAd ad : ads) {
                    if (ad != null) {
                        arrayList.add(new TapCSJBannerSession(ad, context, bannerSize.widthPx, bannerSize.heightPx));
                    }
                }
                if (arrayList.isEmpty()) {
                    callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "Banner广告返回为空");
                } else {
                    callback.onSuccess(arrayList);
                }
            }
        });
    }
}
