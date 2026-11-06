package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.nativead.api.ATNativePrepareExInfo;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.smartdigimkt.sdk.api.AdError;
import com.smartdigimkt.sdk.api.format.SDMNativeAd;
import com.smartdigimkt.sdk.api.format.SDMNativeAdListener;
import com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AdxATNativeAd extends CustomNativeAd {
    SDMNativeAd a;
    Context b;
    boolean c;
    View d;
    Object e;
    private WeakReference<AdxATAdapter> f;

    class a implements SDMNativeAdListener {
        a() {
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdClick() {
            AdxATNativeAd.this.notifyAdClicked();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdClosed() {
            AdxATNativeAd.this.notifyAdDislikeClick();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onAdShow() {
            AdxATNativeAd.this.notifyAdImpression();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onDeeplinkCallback(boolean z) {
            AdxATNativeAd.this.notifyDeeplinkCallback(z);
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdListener
        public void onShowFailed(AdError adError) {
        }
    }

    class b implements SDMNativeAdMediaViewListener {
        b() {
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
        public void onProgressUpdate(long j, long j2) {
            if (AdxATNativeAd.this.getVideoDuration() == 0.0d) {
                AdxATNativeAd.this.setVideoDuration(j2 / 1000.0d);
            }
            AdxATNativeAd.this.notifyAdVideoPlayProgress((int) (j / 1000.0d));
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
        public void onVideoAdComplete() {
            AdxATNativeAd.this.notifyAdVideoEnd();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
        public void onVideoAdStartPlay(long j) {
            AdxATNativeAd.this.setVideoDuration(j / 1000.0d);
            AdxATNativeAd.this.notifyAdVideoStart();
        }

        @Override // com.smartdigimkt.sdk.api.format.SDMNativeAdMediaViewListener
        public void onVideoError(String str, String str2) {
            AdxATNativeAd.this.notifyAdVideoVideoPlayFail(str, str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00b8  */
    public AdxATNativeAd(Context context, SDMNativeAd sDMNativeAd, AdxATAdapter adxATAdapter) {
        this.b = context.getApplicationContext();
        this.a = sDMNativeAd;
        this.f = new WeakReference<>(adxATAdapter);
        this.a.setListener(new a());
        this.c = sDMNativeAd.isTemplateAd();
        int adType = this.a.getAdType();
        if (adType == 1) {
            this.mAdSourceType = "1";
        } else if (adType == 2) {
            this.mAdSourceType = "2";
        }
        if (this.a.isTemplateAd()) {
            return;
        }
        setAdChoiceIconUrl(this.a.getAdChoiceIconUrl());
        setTitle(this.a.getTitle());
        setDescriptionText(this.a.getDescription());
        setIconImageUrl(this.a.getIcon());
        String mainImageUrl = this.a.getMainImageUrl();
        setMainImageUrl(mainImageUrl);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(mainImageUrl)) {
            arrayList.add(mainImageUrl);
        }
        setImageUrlList(arrayList);
        setCallToActionText(this.a.getCallToAction());
        if (this.a.isDownloadApp()) {
            setAdAppInfo(new AdxAppInfo(this.a));
        }
        int interactionType = this.a.getInteractionType();
        if (interactionType == 1) {
            setNativeInteractionType(1);
        } else if (interactionType == 2 || interactionType == 3) {
            setNativeInteractionType(2);
        } else if (interactionType == 4) {
            setNativeInteractionType(1);
        } else if (interactionType == 6 || interactionType == 7) {
            setNativeInteractionType(3);
        }
        setMainImageWidth(this.a.getAdImageWidth());
        setMainImageHeight(this.a.getAdImageHeight());
        setVideoWidth(this.a.getAdVideoWidth());
        setVideoHeight(this.a.getAdVideoHeight());
        setVideoDuration(this.a.getVideoDuration() / 1000.0d);
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void clear(View view) {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.unregisterView();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        AdxATAdapter adxATAdapter;
        WeakReference<AdxATAdapter> weakReference = this.f;
        if (weakReference != null && (adxATAdapter = weakReference.get()) != null) {
            adxATAdapter.destory();
            this.f.clear();
        }
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.setListener(null);
            this.a.destroy();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        if (this.d == null) {
            this.d = this.a.getMediaView(this.b, new b());
        }
        return this.d;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public ViewGroup getCustomAdContainer() {
        return this.a.getCustomAdContainer();
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public int getDownloadStatus() {
        int downloadStatus;
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd == null || (downloadStatus = sDMNativeAd.getDownloadStatus()) < 0) {
            return 0;
        }
        return downloadStatus;
    }

    @Override // com.anythink.nativead.unitgroup.a
    public Object getObject() {
        return this.e;
    }

    @Override // com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getShakeView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        return this.a.generateShakeViewContainer();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.IATThirdPartyMaterial
    public double getVideoProgress() {
        SDMNativeAd sDMNativeAd = this.a;
        return sDMNativeAd != null ? sDMNativeAd.getVideoCurrentPosition() / 1000.0d : super.getVideoProgress();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public boolean isNativeExpress() {
        return this.a.isTemplateAd();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onPause() {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.onPause();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void onResume() {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.onResume();
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void pauseVideo() {
        this.a.pauseVideo();
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.onResume();
        }
        if (this.a != null) {
            this.a.registerAdView(view, aTNativePrepareInfo.getClickViewList(), aTNativePrepareInfo instanceof ATNativePrepareExInfo ? ((ATNativePrepareExInfo) aTNativePrepareInfo).getCreativeClickViewList() : null, aTNativePrepareInfo.getChoiceViewLayoutParams(), aTNativePrepareInfo.getCloseView());
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void resumeVideo() {
        this.a.resumeVideo();
    }

    public void setAdObject(Object obj) {
        this.e = obj;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void setVideoMute(boolean z) {
        super.setVideoMute(z);
        SDMNativeAd sDMNativeAd = this.a;
        if (sDMNativeAd != null) {
            sDMNativeAd.setMute(z);
        }
    }
}
