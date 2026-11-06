package com.tapsdk.tapad.lib_csjadapter;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoader;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class TapCSJSplashAdLoader implements AdapterSplashLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashLoader
    public void load(Context context, AdapterSplashLoadRequest request, AdapterLoadCallback<AdapterSplashSession> callback) {
        if (!TapCSJManagerHolder.initSuccess.get()) {
            callback.onFailure(-1, "请初始化sdk");
        } else if (request.isSelfRendered()) {
            loadNative(context, request, callback);
        } else {
            loadHosted(context, request, callback);
        }
    }

    private void loadHosted(Context context, AdapterSplashLoadRequest request, final AdapterLoadCallback<AdapterSplashSession> callback) {
        AdSlot slot = new AdSlot.Builder().setCodeId(request.getCommon().getPlacementId()).setAdLoadType(request.isProviderPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).setExpressViewAcceptedSize(AdapterViewSupport.pxToDp(context, resolveViewWidth(context, request)), AdapterViewSupport.pxToDp(context, resolveViewHeight(context, request))).build();
        final AtomicBoolean callbackSent = new AtomicBoolean(false);
        TTAdSdk.getAdManager().createAdNative(context).loadSplashAd(slot, new TTAdNative.CSJSplashAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJSplashAdLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd ad) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError error) {
                if (callbackSent.compareAndSet(false, true)) {
                    callback.onFailure(error.getCode(), error.getMsg());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd ad) {
                if (callbackSent.compareAndSet(false, true)) {
                    callback.onSuccess(Collections.singletonList(new TapCSJSplashSession(ad)));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd ad, CSJAdError error) {
                if (callbackSent.compareAndSet(false, true)) {
                    callback.onFailure(error.getCode(), error.getMsg());
                }
            }
        }, (int) Math.min(2147483647L, request.getTimeoutMillis()));
    }

    private void loadNative(Context context, final AdapterSplashLoadRequest request, final AdapterLoadCallback<AdapterSplashSession> callback) {
        AdSlot slot = new AdSlot.Builder().setCodeId(request.getCommon().getPlacementId()).setAdCount(request.getCommon().getAdCount()).setImageAcceptedSize(resolveImageWidth(context, request), resolveImageHeight(context, request)).setAdLoadType(request.isProviderPreload() ? TTAdLoadType.PRELOAD : TTAdLoadType.LOAD).build();
        TTAdSdk.getAdManager().createAdNative(context).loadFeedAd(slot, new TTAdNative.FeedAdListener() { // from class: com.tapsdk.tapad.lib_csjadapter.TapCSJSplashAdLoader.2
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
                            arrayList.add(new TapCSJNativeSplashSession(ad, request.isDoubleWindow()));
                        }
                    }
                }
                callback.onSuccess(arrayList);
            }
        });
    }

    private static int resolveImageWidth(Context context, AdapterSplashLoadRequest request) {
        return request.getAcceptedImageWidthPx() > 0 ? request.getAcceptedImageWidthPx() : resolveViewWidth(context, request);
    }

    private static int resolveImageHeight(Context context, AdapterSplashLoadRequest request) {
        return request.getAcceptedImageHeightPx() > 0 ? request.getAcceptedImageHeightPx() : resolveViewHeight(context, request);
    }

    private static int resolveViewWidth(Context context, AdapterSplashLoadRequest request) {
        if (request.getCommon().getAcceptedWidthPx() > 0) {
            return request.getCommon().getAcceptedWidthPx();
        }
        return resolveScreenDimension(context, request, true);
    }

    private static int resolveViewHeight(Context context, AdapterSplashLoadRequest request) {
        if (request.getCommon().getAcceptedHeightPx() > 0) {
            return request.getCommon().getAcceptedHeightPx();
        }
        return resolveScreenDimension(context, request, false);
    }

    private static int resolveScreenDimension(Context context, AdapterSplashLoadRequest request, boolean width) {
        int screenWidth = AdapterViewSupport.screenWidthPx(context);
        int screenHeight = AdapterViewSupport.screenHeightPx(context);
        if (request.getScreenOrientation() == 1) {
            return width ? Math.max(screenWidth, screenHeight) : Math.min(screenWidth, screenHeight);
        }
        if (request.getScreenOrientation() == 2) {
            return width ? Math.min(screenWidth, screenHeight) : Math.max(screenWidth, screenHeight);
        }
        return width ? screenWidth : screenHeight;
    }
}
