package com.anythink.network.tap;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATInitMediation;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.TapAdNative;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.TapFeedAdView;
import com.tapsdk.tapad.feed.VideoOption;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TapATExpressAd extends CustomNativeAd {
    private static final String a = "TapATExpressAd";
    private static final int b = 0;
    private TapAdNative c;
    private TapFeedAd d;
    private int e;
    private View g;
    private final RenderCallback h;
    private int f = -2;
    private final TapATExpressAd i = this;

    public interface RenderCallback {
        void onRenderFail(String str, int i);

        void onRenderSuccess(TapATExpressAd tapATExpressAd);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    public TapATExpressAd(TapFeedAd tapFeedAd, TapAdNative tapAdNative, Map<String, Object> map, RenderCallback renderCallback) {
        this.e = -1;
        this.d = tapFeedAd;
        this.c = tapAdNative;
        this.h = renderCallback;
        if (tapFeedAd != null) {
            if (map != null) {
                this.e = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, -1);
            }
            int imageMode = this.d.getImageMode();
            if (imageMode == 1) {
                this.mAdSourceType = "2";
            } else if (imageMode == 2) {
                this.mAdSourceType = "1";
            }
            ComplianceInfo complianceInfo = this.d.getComplianceInfo();
            if (complianceInfo != null && (!TextUtils.isEmpty(complianceInfo.getAppName()) || !TextUtils.isEmpty(complianceInfo.getAppVersion()) || !TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
                setAdAppInfo(new TapATAdAppInfo(complianceInfo));
            }
            int interactionType = this.d.getInteractionType();
            if (interactionType == 1) {
                setNativeInteractionType(1);
            } else if (interactionType == 2) {
                setNativeInteractionType(3);
            } else if (interactionType == 3) {
                setNativeInteractionType(2);
            } else {
                setNativeInteractionType(0);
            }
            this.d.setExpressRenderListener(new AnonymousClass1());
            this.d.render(new FeedOption.Builder().expressWidth(this.e).expressHeight(this.f).videoOption(new VideoOption.Builder().autoPlayPolicy(VideoOption.AutoPlayPolicy.ALWAYS).build()).build());
        }
    }

    private void a(Map<String, Object> map) {
        if (this.d == null) {
            return;
        }
        if (map != null) {
            this.e = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH, -1);
        }
        int imageMode = this.d.getImageMode();
        if (imageMode == 1) {
            this.mAdSourceType = "2";
        } else if (imageMode == 2) {
            this.mAdSourceType = "1";
        }
        ComplianceInfo complianceInfo = this.d.getComplianceInfo();
        if (complianceInfo != null && (!TextUtils.isEmpty(complianceInfo.getAppName()) || !TextUtils.isEmpty(complianceInfo.getAppVersion()) || !TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
            setAdAppInfo(new TapATAdAppInfo(complianceInfo));
        }
        int interactionType = this.d.getInteractionType();
        if (interactionType == 1) {
            setNativeInteractionType(1);
        } else if (interactionType == 2) {
            setNativeInteractionType(3);
        } else if (interactionType == 3) {
            setNativeInteractionType(2);
        } else {
            setNativeInteractionType(0);
        }
        this.d.setExpressRenderListener(new AnonymousClass1());
        this.d.render(new FeedOption.Builder().expressWidth(this.e).expressHeight(this.f).videoOption(new VideoOption.Builder().autoPlayPolicy(VideoOption.AutoPlayPolicy.ALWAYS).build()).build());
    }

    /* JADX INFO: renamed from: com.anythink.network.tap.TapATExpressAd$1, reason: invalid class name */
    final class AnonymousClass1 implements TapFeedAd.ExpressRenderListener {
        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onAdValidShow(TapFeedAdView tapFeedAdView) {
        }

        AnonymousClass1() {
        }

        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onRenderSuccess(TapFeedAdView tapFeedAdView) {
            Log.i(TapATExpressAd.a, "onRenderSuccess()");
            TapATExpressAd.this.g = tapFeedAdView;
            if (TapATExpressAd.this.h != null) {
                TapATExpressAd.this.h.onRenderSuccess(TapATExpressAd.this.i);
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onRenderFail(TapFeedAdView tapFeedAdView, TapFeedAd tapFeedAd, int i, String str) {
            Log.e(TapATExpressAd.a, String.format("onRenderFail, errorCode: %d, errorMsg: %s", Integer.valueOf(i), str));
            if (TapATExpressAd.this.h != null) {
                TapATExpressAd.this.h.onRenderFail(str, i);
            }
        }

        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onAdShow(TapFeedAdView tapFeedAdView) {
            TapATExpressAd.this.notifyAdImpression();
        }

        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onAdClicked(TapFeedAdView tapFeedAdView) {
            TapATExpressAd.this.notifyAdClicked();
        }

        @Override // com.tapsdk.tapad.TapFeedAd.ExpressRenderListener
        public final void onAdClosed(TapFeedAdView tapFeedAdView) {
            TapATExpressAd.this.notifyAdDislikeClick();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        return this.g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd != null) {
            if (tapFeedAd.getInteractionType() == 1) {
                this.d.setDownloadListener(new TapAppDownloadListener() { // from class: com.anythink.network.tap.TapATExpressAd.2
                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onIdle() {
                    }

                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onDownloadStart() {
                        if (TapATExpressAd.this.mDownloadListener == null || !(TapATExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                            return;
                        }
                        ((CustomAdapterDownloadListener) TapATExpressAd.this.mDownloadListener).onDownloadStart(0L, 0L, "", TapATExpressAd.this.getTitle());
                    }

                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onDownloadComplete() {
                        if (TapATExpressAd.this.mDownloadListener == null || !(TapATExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                            return;
                        }
                        ((CustomAdapterDownloadListener) TapATExpressAd.this.mDownloadListener).onDownloadFinish(0L, "", TapATExpressAd.this.getTitle());
                    }

                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onUpdateDownloadProgress(int i) {
                        if (TapATExpressAd.this.mDownloadListener == null || !(TapATExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                            return;
                        }
                        ((CustomAdapterDownloadListener) TapATExpressAd.this.mDownloadListener).onDownloadUpdate(0L, i, "", TapATExpressAd.this.getTitle());
                    }

                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onDownloadError() {
                        if (TapATExpressAd.this.mDownloadListener == null || !(TapATExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                            return;
                        }
                        ((CustomAdapterDownloadListener) TapATExpressAd.this.mDownloadListener).onDownloadFail(0L, 0L, "", TapATExpressAd.this.getTitle());
                    }

                    @Override // com.tapsdk.tapad.TapAppDownloadListener
                    public final void onInstalled() {
                        if (TapATExpressAd.this.mDownloadListener == null || !(TapATExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                            return;
                        }
                        ((CustomAdapterDownloadListener) TapATExpressAd.this.mDownloadListener).onInstalled("", TapATExpressAd.this.getTitle());
                    }
                });
            }
            if (TextUtils.equals(this.mAdSourceType, "1")) {
                this.d.setVideoAdListener(new TapFeedAd.VideoAdListener() { // from class: com.anythink.network.tap.TapATExpressAd.3
                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoPause(TapFeedAd tapFeedAd2) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoPrepared(TapFeedAd tapFeedAd2) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoVolumeClose(TapFeedAd tapFeedAd2) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoVolumeOpen(TapFeedAd tapFeedAd2) {
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoStart(TapFeedAd tapFeedAd2) {
                        TapATExpressAd.this.notifyAdVideoStart();
                    }

                    @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
                    public final void onVideoError(TapFeedAd tapFeedAd2, int i, int i2) {
                        TapATExpressAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i), String.valueOf(i2));
                    }
                });
            }
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.resume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.pause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd != null) {
            tapFeedAd.startVideoPlay();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd != null) {
            tapFeedAd.stopVideoPlay();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        TapAdNative tapAdNative = this.c;
        if (tapAdNative != null) {
            tapAdNative.dispose();
            this.c = null;
        }
        TapFeedAd tapFeedAd = this.d;
        if (tapFeedAd != null) {
            tapFeedAd.dispose();
            this.d = null;
        }
    }
}
