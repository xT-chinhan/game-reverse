package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.anythink.core.api.ATAdConst;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATNativeExpressAd extends CustomNativeAd {
    private static final String i = "TTATNativeExpressAd";
    TTNativeExpressAd a;
    Context b;
    String c;
    double d;
    double e;
    boolean f;
    TTDislikeDialogAbstract g;
    View h;

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        return null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return true;
    }

    public TTATNativeExpressAd(Context context, String str, TTNativeExpressAd tTNativeExpressAd, boolean z, boolean z2) {
        this(context, str, tTNativeExpressAd, z, z2, 0.0f, 0.0f);
    }

    public TTATNativeExpressAd(Context context, String str, TTNativeExpressAd tTNativeExpressAd, boolean z, boolean z2, float f, float f2) {
        List<FilterWord> filterWords;
        this.f = false;
        this.b = context.getApplicationContext();
        this.c = str;
        this.a = tTNativeExpressAd;
        Map<String, Object> map = new HashMap<>();
        if (f > 0.0f) {
            map.put("express_width", Float.valueOf(f));
        }
        if (f2 > 0.0f) {
            map.put("express_height", Float.valueOf(f2));
        }
        if (this.a.getMediaExtraInfo() != null) {
            Map<? extends String, ? extends Object> mediaExtraInfo = this.a.getMediaExtraInfo();
            mediaExtraInfo.get(MediationConstant.KEY_GM_POLICY);
            map.putAll(mediaExtraInfo);
        }
        DislikeInfo dislikeInfo = this.a.getDislikeInfo();
        if (dislikeInfo != null && (filterWords = dislikeInfo.getFilterWords()) != null && filterWords.size() > 0) {
            Log.i(i, "getDislikeInfo, dislikeInfo=".concat(String.valueOf(dislikeInfo)));
            map.put(TTATConst.CUSTOM_DISLIKE_INFO, dislikeInfo);
        }
        setNetworkInfoMap(map);
        setAdData(z);
    }

    public void setAdData(boolean z) {
        this.a.setCanInterruptVideoPlay(z);
        int i2 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i2 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i2 = 2;
        }
        setNativeInteractionType(i2);
        this.a.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onClickRetry() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdContinuePlay() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdPaused() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoLoad() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoError(int i3, int i4) {
                Log.i(TTATNativeExpressAd.i, String.format("onVideoError, errorCode: %d, errorMsg: %s", Integer.valueOf(i3), String.valueOf(i4)));
                TTATNativeExpressAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i3), String.valueOf(i4));
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdStartPlay() {
                TTATNativeExpressAd.this.notifyAdVideoStart();
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onProgressUpdate(long j, long j2) {
                if (TTATNativeExpressAd.this.getVideoDuration() == 0.0d) {
                    TTATNativeExpressAd.this.setVideoDuration(j2 / 1000.0d);
                }
                TTATNativeExpressAd.this.d = j / 1000.0d;
                TTATNativeExpressAd tTATNativeExpressAd = TTATNativeExpressAd.this;
                tTATNativeExpressAd.notifyAdVideoPlayProgress((int) tTATNativeExpressAd.d);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
            public final void onVideoAdComplete() {
                TTATNativeExpressAd.this.notifyAdVideoEnd();
            }
        });
        this.a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeExpressAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.f) {
                    if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                    return;
                }
                TTATNativeExpressAd.this.f = true;
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j, long j2, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j, String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onDownloadFinish(j, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (TTATNativeExpressAd.this.mDownloadListener == null || !(TTATNativeExpressAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeExpressAd.this.mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.a.getImageMode();
        if (imageMode != 2 && imageMode != 3 && imageMode != 4) {
            if (imageMode == 5 || imageMode == 15) {
                this.mAdSourceType = "1";
                return;
            } else if (imageMode != 16) {
                return;
            }
        }
        this.mAdSourceType = "2";
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view == null || !(view.getContext() instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) view.getContext();
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            if (this.g != null) {
                Log.e(i, "bindDislike: setDislikeDialog=" + this.g);
                this.a.setDislikeDialog(this.g);
            } else {
                tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
            }
        }
    }

    private void a(Activity activity) {
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        if (this.g != null) {
            Log.e(i, "bindDislike: setDislikeDialog=" + this.g);
            this.a.setDislikeDialog(this.g);
        } else {
            tTNativeExpressAd.setDislikeCallback(activity, new AnonymousClass3());
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$3, reason: invalid class name */
    final class AnonymousClass3 implements TTAdDislike.DislikeInteractionCallback {
        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onCancel() {
        }

        @Deprecated
        public final void onRefuse() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onShow() {
        }

        AnonymousClass3() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
        public final void onSelected(int i, String str, boolean z) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }

        @Deprecated
        public final void onSelected(int i, String str) {
            TTATNativeExpressAd.this.notifyAdDislikeClick();
        }
    }

    private void b() {
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd == null) {
            return;
        }
        tTNativeExpressAd.setExpressInteractionListener(new AnonymousClass4());
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeExpressAd$4, reason: invalid class name */
    final class AnonymousClass4 implements TTNativeExpressAd.ExpressAdInteractionListener {
        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderFail(View view, String str, int i) {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onRenderSuccess(View view, float f, float f2) {
        }

        AnonymousClass4() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdClicked(View view, int i) {
            TTATNativeExpressAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
        public final void onAdShow(View view, int i) {
            Log.i(TTATNativeExpressAd.i, "onAdShow()");
            TTATNativeExpressAd.this.notifyAdImpression();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        TTNativeExpressAd tTNativeExpressAd;
        try {
            if (this.h == null && (tTNativeExpressAd = this.a) != null) {
                this.h = tTNativeExpressAd.getExpressAdView();
                TTNativeExpressAd tTNativeExpressAd2 = this.a;
                if (tTNativeExpressAd2 != null) {
                    tTNativeExpressAd2.setExpressInteractionListener(new AnonymousClass4());
                }
            }
            return this.h;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        Log.i(i, "destroy()");
        this.h = null;
        TTNativeExpressAd tTNativeExpressAd = this.a;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) null);
            this.a.destroy();
            this.a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.BaseAd
    public void setDevParams(Map<String, Object> map) {
        Object obj = map.get(ATAdConst.KEY.CUSTOM_DISLIKE_DIALOG);
        if (obj instanceof TTDislikeDialogAbstract) {
            Log.i(i, "setExtraMap: dislikeDialog=".concat(String.valueOf(obj)));
            this.g = (TTDislikeDialogAbstract) obj;
        }
    }
}
