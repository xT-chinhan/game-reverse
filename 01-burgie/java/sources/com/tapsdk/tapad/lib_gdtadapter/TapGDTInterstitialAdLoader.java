package com.tapsdk.tapad.lib_gdtadapter;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTInterstitialAdLoader implements AdapterInterstitialLoader {
    private static final int ERROR_CREATIVE_TYPE_UNSUPPORTED = 10003;

    @Override // com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader
    public void load(Context context, AdapterInterstitialLoadRequest request, AdapterLoadCallback<AdapterInterstitialSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
            return;
        }
        if (request.isSelfRendered()) {
            loadSelfRendered(context, request, callback);
        } else if (!(context instanceof Activity)) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "context must be Activity");
        } else {
            loadHosted((Activity) context, request, callback);
        }
    }

    private void loadHosted(Activity activity, final AdapterInterstitialLoadRequest request, final AdapterLoadCallback<AdapterInterstitialSession> callback) {
        final UnifiedInterstitialAD[] provider = new UnifiedInterstitialAD[1];
        final TapGDTInterstitialSession[] session = new TapGDTInterstitialSession[1];
        provider[0] = new UnifiedInterstitialAD(activity, request.getCommon().getPlacementId(), new UnifiedInterstitialADListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTInterstitialAdLoader.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                TapGDTInterstitialSession[] tapGDTInterstitialSessionArr = session;
                if (tapGDTInterstitialSessionArr[0] != null) {
                    return;
                }
                tapGDTInterstitialSessionArr[0] = new TapGDTInterstitialSession(provider[0], request.getPresentationStyle() != 1);
                callback.onSuccess(Collections.singletonList(session[0]));
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError error) {
                callback.onFailure(error.getErrorCode(), error.getErrorMsg());
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                TapGDTInterstitialSession tapGDTInterstitialSession = session[0];
                if (tapGDTInterstitialSession != null) {
                    tapGDTInterstitialSession.onShow();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                TapGDTInterstitialSession tapGDTInterstitialSession = session[0];
                if (tapGDTInterstitialSession != null) {
                    tapGDTInterstitialSession.onClick();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                TapGDTInterstitialSession tapGDTInterstitialSession = session[0];
                if (tapGDTInterstitialSession != null) {
                    tapGDTInterstitialSession.onClose();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
                TapGDTInterstitialSession tapGDTInterstitialSession = session[0];
                if (tapGDTInterstitialSession != null) {
                    tapGDTInterstitialSession.onRenderSuccess();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
                TapGDTInterstitialSession tapGDTInterstitialSession = session[0];
                if (tapGDTInterstitialSession != null) {
                    tapGDTInterstitialSession.onRenderFailure();
                }
            }
        });
        if (request.getPresentationStyle() == 1) {
            provider[0].loadAD();
        } else {
            provider[0].loadFullScreenAD();
        }
    }

    private void loadSelfRendered(Context context, AdapterInterstitialLoadRequest request, final AdapterLoadCallback<AdapterInterstitialSession> callback) {
        new NativeUnifiedAD(context, request.getCommon().getPlacementId(), new NativeADUnifiedListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTInterstitialAdLoader.2
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                callback.onFailure(error.getErrorCode(), error.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> ads) {
                if (ads == null || ads.isEmpty() || ads.get(0) == null) {
                    callback.onFailure(10003, "GDT Interstitial 自渲染素材为空");
                } else {
                    callback.onSuccess(Collections.singletonList(new TapGDTNativeFullscreenSession(ads.get(0))));
                }
            }
        }).loadData(request.getCommon().getAdCount());
    }
}
