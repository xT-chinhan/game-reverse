package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQySplash;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyClient;
import com.mcto.sspsdk.QySdk;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterSplashLoader;
import com.tapsdk.tapad.group.adapter.AdapterSplashSession;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYSplashAdLoader implements AdapterSplashLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterSplashLoader
    public void load(Context context, final AdapterSplashLoadRequest request, final AdapterLoadCallback<AdapterSplashSession> callback) {
        if (!TapIQYManagerHolder.initSuccess.get()) {
            callback.onFailure(-1, "请初始化sdk");
            return;
        }
        QyClient client = QySdk.getAdClient();
        if (client == null) {
            callback.onFailure(-1, "爱奇艺创建qyClient 失败");
            return;
        }
        final String placementId = request.getCommon().getPlacementId();
        QyAdSlot slot = QyAdSlot.newQySplashAdSlot().supportPreRequest(request.isProviderPreload()).codeId(placementId).timeout((int) Math.min(2147483647L, request.getTimeoutMillis())).build();
        IQYNative nativeClient = client.createAdNative(context);
        nativeClient.loadSplashAd(slot, new IQYNative.SplashAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYSplashAdLoader.1
            @Override // com.mcto.sspsdk.IQYNative.SplashAdListener
            public void onTimeout() {
                callback.onFailure(-1, "开屏请求超时：" + request.getTimeoutMillis());
            }

            @Override // com.mcto.sspsdk.IQYNative.SplashAdListener
            public void onSplashAdLoad(IQySplash ad) {
                callback.onSuccess(Collections.singletonList(new TapIQYSplashSession(ad, placementId)));
            }

            @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }
        });
    }
}
