package com.tapsdk.tapad.lib_iqyadapter;

import android.content.Context;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.QyClient;
import com.mcto.sspsdk.QySdk;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoader;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYRewardedAdLoader implements AdapterRewardLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterRewardLoader
    public void load(Context context, final AdapterRewardLoadRequest request, final AdapterLoadCallback<AdapterRewardSession> callback) {
        if (!TapIQYManagerHolder.initSuccess.get()) {
            callback.onFailure(-1, "请初始化sdk");
            return;
        }
        QyClient client = QySdk.getAdClient();
        if (client == null) {
            callback.onFailure(-1, "爱奇艺创建qyClient 失败");
            return;
        }
        int orientation = request.getScreenOrientation() == 1 ? 2 : 1;
        IQYNative nativeClient = client.createAdNative(context);
        nativeClient.loadRewardVideoAd(QyAdSlot.newQyAwardAdSlot().codeId(request.getCommon().getPlacementId()).rewardVideoAdOrientation(orientation).rewardAmount(request.getRewardAmount()).rewardTips(request.getRewardName()).build(), new IQYNative.RewardVideoAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYRewardedAdLoader.1
            @Override // com.mcto.sspsdk.ssp.callback.AdErrorCallback
            public void onError(int code, String message) {
                callback.onFailure(code, message);
            }

            @Override // com.mcto.sspsdk.IQYNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(IQyRewardVideoAd ad) {
                callback.onSuccess(Collections.singletonList(new TapIQYRewardSession(ad, request)));
            }
        });
    }
}
