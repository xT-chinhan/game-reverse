package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyClient;
import com.mcto.sspsdk.QySdk;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader;
import com.tapsdk.tapad.group.adapter.AdapterInterstitialSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYInterstitialAdLoader implements AdapterInterstitialLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterInterstitialLoader
    public void load(Context context, AdapterInterstitialLoadRequest request, final AdapterLoadCallback<AdapterInterstitialSession> callback) {
        if (!TapIQYManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
            return;
        }
        QyClient client = QySdk.getAdClient();
        if (client == null) {
            callback.onFailure(-1, "爱奇艺创建qyClient 失败");
            return;
        }
        final String placementId = request.getCommon().getPlacementId();
        QyAdSlot slot = QyAdSlot.newQyAdSlot().codeId(placementId).timeout((int) Math.min(2147483647L, request.getTimeoutMillis())).build();
        IQYNative nativeClient = client.createAdNative(context);
        nativeClient.loadFullScreenAd(slot, new IQYNative.FullScreenAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYInterstitialAdLoader.1
            @Override // com.mcto.sspsdk.IQYNative.FullScreenAdListener
            public void onFullScreenAdLoad(IQyFullScreenAd ad) {
                callback.onSuccess(Collections.singletonList(new TapIQYInterstitialSession(ad, placementId)));
            }

            @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }
        });
    }
}
