package com.tapsdk.tapad.lib_gdtadapter;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterLoadCallback;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoadRequest;
import com.tapsdk.tapad.group.adapter.AdapterRewardLoader;
import com.tapsdk.tapad.group.adapter.AdapterRewardSession;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class TapGDTRewardedAdLoader implements AdapterRewardLoader {
    @Override // com.tapsdk.tapad.group.adapter.AdapterRewardLoader
    public void load(Context context, AdapterRewardLoadRequest request, AdapterLoadCallback<AdapterRewardSession> callback) {
        if (!TapGDTManagerHolder.initSuccess.get()) {
            callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "gdt sdk not init");
        } else if (request.isSelfRendered()) {
            loadSelfRendered(context, request, callback);
        } else {
            loadHosted(context, request, callback);
        }
    }

    private void loadSelfRendered(Context context, AdapterRewardLoadRequest request, final AdapterLoadCallback<AdapterRewardSession> callback) {
        new NativeUnifiedAD(context, request.getCommon().getPlacementId(), new NativeADUnifiedListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTRewardedAdLoader.1
            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError error) {
                callback.onFailure(error == null ? -1 : error.getErrorCode(), error == null ? "" : error.getErrorMsg());
            }

            @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
            public void onADLoaded(List<NativeUnifiedADData> ads) {
                if (ads == null || ads.isEmpty() || ads.get(0) == null) {
                    callback.onFailure(AVMDLDataLoader.KeyIsEnableEventInfo, "广告拉取为空");
                } else {
                    callback.onSuccess(Collections.singletonList(new TapGDTNativeFullscreenSession(ads.get(0))));
                }
            }
        }).loadData(request.getCommon().getAdCount());
    }

    private void loadHosted(Context context, final AdapterRewardLoadRequest request, final AdapterLoadCallback<AdapterRewardSession> callback) {
        final AtomicReference<RewardVideoAD> provider = new AtomicReference<>();
        final AtomicReference<TapGDTRewardSession> accepted = new AtomicReference<>();
        RewardVideoADListener listener = new RewardVideoADListener() { // from class: com.tapsdk.tapad.lib_gdtadapter.TapGDTRewardedAdLoader.2
            private AdapterAdEventSink sink() {
                TapGDTRewardSession session = (TapGDTRewardSession) accepted.get();
                return session == null ? AdapterAdEventSink.NONE : session.eventSink();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                RewardVideoAD ad = (RewardVideoAD) provider.get();
                if (ad == null) {
                    callback.onFailure(-1, "GDT 激励视频广告对象为空");
                    return;
                }
                TapGDTRewardSession session = new TapGDTRewardSession(ad);
                if (TapGDTRewardedAdLoader$2$$ExternalSyntheticBackportWithForwarding0.m(accepted, null, session)) {
                    callback.onSuccess(Collections.singletonList(session));
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                sink().onShow(null);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(Map<String, Object> metadata) {
                sink().onRewardVerify(true, request.getRewardAmount(), request.getRewardName(), 0, "");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                sink().onClick(null);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                sink().onVideoComplete(0L);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                sink().onClose();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError error) {
                TapGDTRewardSession session = (TapGDTRewardSession) accepted.get();
                int code = error == null ? -1 : error.getErrorCode();
                String message = error == null ? "" : error.getErrorMsg();
                if (session == null) {
                    callback.onFailure(code, message);
                } else {
                    session.eventSink().onRenderFailure(null, code, message);
                }
            }
        };
        RewardVideoAD ad = new RewardVideoAD(context, request.getCommon().getPlacementId(), listener);
        provider.set(ad);
        ad.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(request.getRewardExtra()).setUserId(request.getUserId()).build());
        ad.loadAD();
    }
}
