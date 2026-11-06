package com.anythink.network.baidu;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaiduATNativePortraitVideoAd extends BaiduATNativeAd {
    BaiduNativeManager f;
    RequestParameters g;
    boolean h;
    private FeedPortraitVideoView i;
    private Context j;

    protected interface LoadCallbackListener {
        void onFail(String str, String str2);

        void onSuccess(NativeResponse nativeResponse, CustomNativeAd customNativeAd);
    }

    public BaiduATNativePortraitVideoAd(Context context, BaiduNativeManager baiduNativeManager, RequestParameters requestParameters, boolean z) {
        this.j = context;
        this.f = baiduNativeManager;
        this.g = requestParameters;
        this.h = z;
    }

    public void load(final LoadCallbackListener loadCallbackListener) {
        this.f.loadPortraitVideoAd(this.g, new BaiduNativeManager.FeedAdListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onVideoDownloadSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeLoad(List<NativeResponse> list) {
                if (list != null && list.size() > 0) {
                    NativeResponse nativeResponse = list.get(0);
                    BaiduATNativePortraitVideoAd baiduATNativePortraitVideoAd = BaiduATNativePortraitVideoAd.this;
                    baiduATNativePortraitVideoAd.a(baiduATNativePortraitVideoAd.j, nativeResponse);
                    loadCallbackListener.onSuccess(nativeResponse, BaiduATNativePortraitVideoAd.this);
                    return;
                }
                loadCallbackListener.onFail("", "callback onNativeLoad but no ad");
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                loadCallbackListener.onFail(String.valueOf(i), str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public final void onNoAd(int i, String str, NativeResponse nativeResponse) {
                loadCallbackListener.onFail(String.valueOf(i), str);
            }
        });
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.a == null) {
            return null;
        }
        if (this.i == null) {
            FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(this.b);
            this.i = feedPortraitVideoView;
            feedPortraitVideoView.setAdData(this.a);
            this.i.setVideoMute(this.e);
            this.i.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.anythink.network.baidu.BaiduATNativePortraitVideoAd.2
                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void pauseBtnClick() {
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playPause() {
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playResume() {
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playRenderingStart() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoStart();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playCompletion() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoEnd();
                }

                @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
                public final void playError() {
                    BaiduATNativePortraitVideoAd.this.notifyAdVideoVideoPlayFail("", "BaiduATNativePortraitVideoAd video play error");
                }
            });
        }
        return this.i;
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        FeedPortraitVideoView feedPortraitVideoView;
        if (this.i != null) {
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null) {
                clickViewList = new ArrayList<>();
            }
            if (!clickViewList.contains(this.i)) {
                clickViewList.add(this.i);
            }
            aTNativePrepareInfo.setClickViewList(clickViewList);
            super.prepare(this.i, aTNativePrepareInfo);
        } else {
            super.prepare(view, aTNativePrepareInfo);
        }
        if (!this.h || (feedPortraitVideoView = this.i) == null) {
            return;
        }
        feedPortraitVideoView.play();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        super.resumeVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.i;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        super.pauseVideo();
        FeedPortraitVideoView feedPortraitVideoView = this.i;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        FeedPortraitVideoView feedPortraitVideoView = this.i;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.getCurrentPosition() / 1000.0d;
        }
        return 0.0d;
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        FeedPortraitVideoView feedPortraitVideoView = this.i;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }

    @Override // com.anythink.network.baidu.BaiduATNativeAd, com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        FeedPortraitVideoView feedPortraitVideoView = this.i;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
            this.i = null;
        }
    }
}
