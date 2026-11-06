package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyBannerStyle;
import com.mcto.sspsdk.QyClient;
import com.mcto.sspsdk.QySdk;
import com.tapsdk.tapad.group.adapter.AdapterBannerLoader;
import com.tapsdk.tapad.group.adapter.AdapterBannerSession;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYBannerLoader implements AdapterBannerLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterBannerLoader
    public void load(Context context, final AdapterLoadRequest request, final AdapterLoadCallback<AdapterBannerSession> callback) {
        if (!TapIQYManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
            return;
        }
        QyClient client = QySdk.getAdClient();
        if (client == null) {
            callback.onFailure(-1, "爱奇艺创建qyClient 失败");
        } else {
            IQYNative adNative = client.createAdNative(context);
            adNative.loadBannerAd(QyAdSlot.newQyBannerAdSlot().codeId(request.getPlacementId()).bannerStyle(QyBannerStyle.QYBANNER_STRIP).build(), new IQYNative.BannerAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYBannerLoader.1
                @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
                public void onError(int code, String message) {
                    callback.onFailure(code, message);
                }

                @Override // com.mcto.sspsdk.IQYNative.BannerAdListener
                public void onBannerAdLoad(IQyBanner ad) {
                    if (ad == null) {
                        callback.onFailure(-1, "爱奇艺 Banner 返回为空");
                    } else {
                        callback.onSuccess(Collections.singletonList(new TapIQYBannerSession(ad, request.getPlacementId())));
                    }
                }
            });
        }
    }
}
