package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyNativeAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyClient;
import com.mcto.sspsdk.QySdk;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYNativeFeedAdLoader implements AdapterNativeFeedLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedLoader
    public void load(Context context, final AdapterLoadRequest request, final AdapterLoadCallback<AdapterNativeFeedSession> callback) {
        if (!TapIQYManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "请初始化SDK");
            return;
        }
        QyClient qyClient = QySdk.getAdClient();
        if (qyClient == null) {
            callback.onFailure(-1, "爱奇艺创建qyClient 失败");
        } else {
            IQYNative iqyNative = qyClient.createAdNative(context);
            iqyNative.loadNativeAd(QyAdSlot.newQyNativeAdSlot().codeId(request.getPlacementId()).adType(2).adCount(request.getAdCount()).build(), new IQYNative.QYNativeAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYNativeFeedAdLoader.1
                @Override // com.mcto.sspsdk.IQYNative.QYNativeAdListener
                public void onNativeAdLoad(List<IQyNativeAd> list) {
                    if (list == null || list.isEmpty()) {
                        callback.onFailure(-1, "爱奇艺返回广告为空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (IQyNativeAd ad : list) {
                        arrayList.add(new TapIQYNativeFeedSession(ad, request.getPlacementId()));
                    }
                    callback.onSuccess(arrayList);
                }

                @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
                public void onError(int i, String s) {
                    callback.onFailure(i, s);
                }
            });
        }
    }
}
