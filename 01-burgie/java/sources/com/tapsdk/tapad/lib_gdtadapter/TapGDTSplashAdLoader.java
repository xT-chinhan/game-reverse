package com.tapsdk.tapad.lib_gdtadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoader;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTSplashAdLoader implements AdapterSplashLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashLoader
    public void load(Context context, AdapterSplashLoadRequest request, AdapterLoadCallback<AdapterSplashSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
        } else if (request.isSelfRendered()) {
            loadNative(context, request, callback);
        } else {
            loadHosted(context, request, callback);
        }
    }

    private void loadHosted(Context context, AdapterSplashLoadRequest request, final AdapterLoadCallback<AdapterSplashSession> callback) {
        final SplashAD[] provider = new SplashAD[1];
        final TapGDTSplashSession[] session = new TapGDTSplashSession[1];
        provider[0] = new SplashAD(context, request.getCommon().getPlacementId(), new SplashADListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTSplashAdLoader.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                TapGDTSplashSession tapGDTSplashSession = session[0];
                if (tapGDTSplashSession != null) {
                    tapGDTSplashSession.onClose();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError error) {
                callback.onFailure(error.getErrorCode(), error.getErrorMsg());
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                TapGDTSplashSession tapGDTSplashSession = session[0];
                if (tapGDTSplashSession != null) {
                    tapGDTSplashSession.onClick();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long remaining) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                TapGDTSplashSession tapGDTSplashSession = session[0];
                if (tapGDTSplashSession != null) {
                    tapGDTSplashSession.onShow();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long expirationTimestamp) {
                TapGDTSplashSession[] tapGDTSplashSessionArr = session;
                if (tapGDTSplashSessionArr[0] != null) {
                    return;
                }
                tapGDTSplashSessionArr[0] = new TapGDTSplashSession(provider[0], expirationTimestamp);
                callback.onSuccess(Collections.singletonList(session[0]));
            }
        }, (int) Math.min(2147483647L, request.getTimeoutMillis()));
        if (request.isProviderPreload()) {
            provider[0].preLoad();
        }
        provider[0].fetchAdOnly();
    }

    private void loadNative(final Context context, final AdapterSplashLoadRequest request, final AdapterLoadCallback<AdapterSplashSession> callback) {
        NativeUnifiedAD provider = new NativeUnifiedAD(context, request.getCommon().getPlacementId(), new NativeADUnifiedListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTSplashAdLoader.2
            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> ads) {
                ArrayList arrayList = new ArrayList();
                if (ads != null) {
                    for (NativeUnifiedADData ad : ads) {
                        if (ad != null) {
                            arrayList.add(new TapGDTNativeSplashSession(ad, request, context));
                        }
                    }
                }
                callback.onSuccess(arrayList);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                callback.onFailure(error.getErrorCode(), error.getErrorMsg());
            }
        });
        LoadAdParams params = new LoadAdParams();
        Map<String, String> extras = new HashMap<>();
        extras.put("query", request.getCommon().getQuery());
        params.setDevExtra(extras);
        provider.loadData(request.getCommon().getAdCount(), params);
    }
}
