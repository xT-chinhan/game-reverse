package com.anythink.network.toutiao;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATCustomVideo;
import com.anythink.dlopt.api.CustomAdapterDownloadListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTATNativeAd extends CustomNativeAd {
    TTNativeAd a;
    Context b;
    String c;
    boolean d = false;
    TTATCustomVideo e;
    boolean f;
    double g;
    View h;

    public TTATNativeAd(Context context, String str, TTNativeAd tTNativeAd, boolean z, Bitmap bitmap, int i, boolean z2) {
        this.b = context.getApplicationContext();
        this.c = str;
        this.a = tTNativeAd;
        this.f = z2;
        Map<String, Object> mediaExtraInfo = tTNativeAd.getMediaExtraInfo();
        mediaExtraInfo.get(MediationConstant.KEY_GM_POLICY);
        setNetworkInfoMap(mediaExtraInfo);
        setAdData(z, bitmap, i);
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0196  */
    public void setAdData(boolean z, Bitmap bitmap, int i) {
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setAdFrom(this.a.getSource());
        setStarRating(Double.valueOf(this.a.getAppScore()));
        setAppCommentNum(this.a.getAppCommentNum());
        TTImage icon = this.a.getIcon();
        if (icon != null) {
            setIconImageUrl(icon.getImageUrl());
        }
        List<TTImage> imageList = this.a.getImageList();
        ArrayList arrayList = new ArrayList();
        if (imageList != null && imageList.size() > 0) {
            for (int i2 = 0; i2 < imageList.size(); i2++) {
                TTImage tTImage = imageList.get(i2);
                if (tTImage != null) {
                    arrayList.add(tTImage.getImageUrl());
                    if (i2 == 0) {
                        setMainImageUrl(tTImage.getImageUrl());
                        setMainImageWidth(tTImage.getWidth());
                        setMainImageHeight(tTImage.getHeight());
                    }
                }
            }
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.a.getButtonText());
        TTNativeAd tTNativeAd = this.a;
        if (tTNativeAd instanceof TTDrawFeedAd) {
            TTFeedAd.CustomizeVideo customVideo = ((TTDrawFeedAd) tTNativeAd).getCustomVideo();
            if (customVideo != null) {
                setVideoUrl(customVideo.getVideoUrl());
                this.e = new TTATCustomVideo(customVideo);
            }
            ((TTDrawFeedAd) this.a).setCanInterruptVideoPlay(z);
            if (bitmap != null && i > 0) {
                ((TTDrawFeedAd) this.a).setPauseIcon(bitmap, i);
            }
        }
        ComplianceInfo complianceInfo = this.a.getComplianceInfo();
        if (complianceInfo != null && (!TextUtils.isEmpty(complianceInfo.getAppName()) || !TextUtils.isEmpty(complianceInfo.getAppVersion()) || !TextUtils.isEmpty(complianceInfo.getDeveloperName()) || !TextUtils.isEmpty(complianceInfo.getPrivacyUrl()) || !TextUtils.isEmpty(complianceInfo.getPermissionUrl()) || !TextUtils.isEmpty(complianceInfo.getFunctionDescUrl()))) {
            setAdAppInfo(new TTATDownloadAppInfo(complianceInfo, this.a.getAppSize()));
        }
        int i3 = this.a.getInteractionType() == 4 ? 1 : 0;
        if (this.a.getInteractionType() == 3) {
            i3 = 3;
        }
        if (this.a.getInteractionType() == 2) {
            i3 = 2;
        }
        setNativeInteractionType(i3);
        TTNativeAd tTNativeAd2 = this.a;
        if (tTNativeAd2 instanceof TTFeedAd) {
            TTFeedAd.CustomizeVideo customVideo2 = ((TTFeedAd) tTNativeAd2).getCustomVideo();
            if (customVideo2 != null) {
                setVideoUrl(customVideo2.getVideoUrl());
                this.e = new TTATCustomVideo(customVideo2);
            }
            setVideoDuration(((TTFeedAd) this.a).getVideoDuration());
            ((TTFeedAd) this.a).setVideoAdListener(new TTFeedAd.VideoAdListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.1
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdPaused(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoLoad(TTFeedAd tTFeedAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoError(int i4, int i5) {
                    TTATNativeAd.this.notifyAdVideoVideoPlayFail(String.valueOf(i4), String.valueOf(i5));
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoStart();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onVideoAdComplete(TTFeedAd tTFeedAd) {
                    TTATNativeAd.this.notifyAdVideoEnd();
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
                public final void onProgressUpdate(long j, long j2) {
                    if (TTATNativeAd.this.getVideoDuration() == 0.0d) {
                        TTATNativeAd.this.setVideoDuration(j2 / 1000.0d);
                    }
                    TTATNativeAd.this.g = j / 1000.0d;
                    TTATNativeAd tTATNativeAd = TTATNativeAd.this;
                    tTATNativeAd.notifyAdVideoPlayProgress((int) tTATNativeAd.g);
                }
            });
        }
        this.a.setDownloadListener(new TTAppDownloadListener() { // from class: com.anythink.network.toutiao.TTATNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadActive(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.d) {
                    if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                        return;
                    }
                    ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadUpdate(j, j2, str, str2);
                    return;
                }
                TTATNativeAd.this.d = true;
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadStart(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadPaused(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadPause(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFailed(long j, long j2, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadFail(j, j2, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onDownloadFinished(long j, String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onDownloadFinish(j, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public final void onInstalled(String str, String str2) {
                if (TTATNativeAd.this.mDownloadListener == null || !(TTATNativeAd.this.mDownloadListener instanceof CustomAdapterDownloadListener)) {
                    return;
                }
                ((CustomAdapterDownloadListener) TTATNativeAd.this.mDownloadListener).onInstalled(str, str2);
            }
        });
        int imageMode = this.a.getImageMode();
        if (imageMode == 2 || imageMode == 3 || imageMode == 4) {
            this.mAdSourceType = "2";
        } else if (imageMode == 5 || imageMode == 15) {
            this.mAdSourceType = "1";
        } else if (imageMode == 16) {
            this.mAdSourceType = "2";
        } else if (imageMode == 166) {
            this.mAdSourceType = "3";
        }
        if (TextUtils.equals(this.mAdSourceType, "1") || TextUtils.equals(this.mAdSourceType, "3")) {
            TTNativeAd tTNativeAd3 = this.a;
            if (tTNativeAd3 instanceof TTFeedAd) {
                setVideoWidth(((TTFeedAd) tTNativeAd3).getAdViewWidth());
                setVideoHeight(((TTFeedAd) this.a).getAdViewHeight());
            }
        }
    }

    private void a(List<View> list, View view) {
        if ((view instanceof ViewGroup) && view != this.a.getAdView()) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(list, viewGroup.getChildAt(i));
            }
            return;
        }
        if (view != this.a.getAdView()) {
            list.add(view);
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        View view2;
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (aTNativePrepareInfo instanceof ATNativePrepareExInfo) {
                List<View> creativeClickViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList();
                if (creativeClickViewList != null) {
                    arrayList.addAll(creativeClickViewList);
                }
                List<View> directDownloadViewList = ((ATNativePrepareExInfo) aTNativePrepareInfo).getDirectDownloadViewList();
                if (directDownloadViewList != null) {
                    arrayList2.addAll(directDownloadViewList);
                }
            }
            List<View> clickViewList = aTNativePrepareInfo.getClickViewList();
            if (clickViewList == null || clickViewList.isEmpty()) {
                clickViewList = new ArrayList<>();
                a(clickViewList, view);
            }
            List<View> list = clickViewList;
            a aVar = new a(this, (byte) 0);
            if (!list.isEmpty()) {
                if (!this.f && (view2 = this.h) != null) {
                    list.add(view2);
                }
                if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                    this.a.registerViewForInteraction((ViewGroup) view, list, list, arrayList, arrayList2, (View) null, aVar);
                } else {
                    this.a.registerViewForInteraction((ViewGroup) view, list, list, aVar);
                }
            } else {
                this.a.registerViewForInteraction((ViewGroup) view, view, aVar);
            }
            if (view.getContext() instanceof Activity) {
                this.a.setActivityForDownloadApp((Activity) view.getContext());
                bindDislikeListener(new AnonymousClass3((Activity) view.getContext()));
            }
        } catch (Throwable th) {
            Log.e("TTATNativeAd", "prepare() >>> failed: " + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.toutiao.TTATNativeAd$3, reason: invalid class name */
    final class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ Activity a;

        AnonymousClass3(Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (TTATNativeAd.this.a == null) {
                return;
            }
            TTAdDislike dislikeDialog = TTATNativeAd.this.a.getDislikeDialog(this.a);
            dislikeDialog.setDislikeInteractionCallback(new TTAdDislike.DislikeInteractionCallback() { // from class: com.anythink.network.toutiao.TTATNativeAd.3.1
                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onCancel() {
                }

                @Deprecated
                public final void onRefuse() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onShow() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
                public final void onSelected(int i, String str, boolean z) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }

                @Deprecated
                public final void onSelected(int i, String str) {
                    TTATNativeAd.this.notifyAdDislikeClick();
                }
            });
            if (dislikeDialog.isShow()) {
                return;
            }
            dislikeDialog.showDislikeDialog();
        }
    }

    private void a(Activity activity) {
        bindDislikeListener(new AnonymousClass3(activity));
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public Bitmap getAdLogo() {
        try {
            TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd != null) {
                return tTNativeAd.getAdLogo();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        a(view);
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd == null || view != tTNativeAd.getAdView()) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    a(viewGroup.getChildAt(i));
                }
                return;
            }
            return;
        }
        view.setOnClickListener(null);
        view.setClickable(false);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        TTNativeAd tTNativeAd = this.a;
        if (tTNativeAd != null) {
            this.h = tTNativeAd.getAdView();
        }
        return this.h;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        return this.g;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public ATCustomVideo getNativeCustomVideo() {
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        super.destroy();
        try {
            TTNativeAd tTNativeAd = this.a;
            if (tTNativeAd != null) {
                tTNativeAd.setActivityForDownloadApp(null);
                this.a.destroy();
                this.a = null;
            }
        } catch (Exception unused) {
        }
        this.b = null;
        this.h = null;
    }

    private class a implements TTNativeAd.AdInteractionListener {
        private a() {
        }

        /* synthetic */ a(TTATNativeAd tTATNativeAd, byte b) {
            this();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdClicked(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdClicked();
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
        public final void onAdShow(TTNativeAd tTNativeAd) {
            TTATNativeAd.this.notifyAdImpression();
        }
    }
}
