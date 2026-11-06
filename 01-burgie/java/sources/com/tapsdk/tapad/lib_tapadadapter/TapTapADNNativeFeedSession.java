package com.tapsdk.tapad.lib_tapadadapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tapsdk.tapad.ComplianceInfo;
import com.tapsdk.tapad.TapAppDownloadListener;
import com.tapsdk.tapad.TapFeedAd;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.internal.runtime.image.MechanicalImageLoader;
import com.tapsdk.tapad.lib_tapadadapter.utils.Utils;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class TapTapADNNativeFeedSession implements AdapterNativeFeedSession {
    private final TapFeedAd ad;
    private final WeakReference<Context> contextWeakReference;
    private AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    volatile FrameLayout mediaView;

    public TapTapADNNativeFeedSession(Context context, TapFeedAd tapFeedAd) {
        this.ad = tapFeedAd;
        this.contextWeakReference = new WeakReference<>(context);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void bind(Activity activity, AdapterNativeFeedBinding adapterNativeFeedBinding) {
        View adView;
        final FrameLayout container = adapterNativeFeedBinding.getContainer();
        List<View> clickViews = adapterNativeFeedBinding.getClickViews();
        List<View> creativeViews = adapterNativeFeedBinding.getCreativeViews();
        adapterNativeFeedBinding.installProviderContainer(new FrameLayout(activity));
        FrameLayout frameLayout = new FrameLayout(activity);
        ImageView imageView = new ImageView(activity);
        TextView textView = new TextView(activity);
        textView.setText("广告");
        textView.setTextSize(2, 8.0f);
        textView.setTextColor(Color.parseColor("#B2ffffff"));
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AdapterViewSupport.dpToPx(activity, 10.0f), AdapterViewSupport.dpToPx(activity, 10.0f));
        layoutParams.rightMargin = AdapterViewSupport.dpToPx(activity, 2.0f);
        layoutParams.gravity = 17;
        String adLogoUrl = getComplianceInfo().getAdLogoUrl();
        if (!TextUtils.isEmpty(adLogoUrl)) {
            linearLayout.addView(imageView, layoutParams);
            int iDpToPx = AdapterViewSupport.dpToPx(activity, 10.0f);
            MechanicalImageLoader.load(imageView, adLogoUrl, MechanicalImageLoader.Options.builder().targetSize(iDpToPx, iDpToPx).build());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        linearLayout.addView(textView, layoutParams2);
        frameLayout.setBackgroundColor(Color.parseColor("#4D000000"));
        int iDpToPx2 = AdapterViewSupport.dpToPx(activity, 2.0f);
        frameLayout.setPadding(iDpToPx2, iDpToPx2, iDpToPx2, iDpToPx2);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        adapterNativeFeedBinding.addOverlay(frameLayout);
        container.requestLayout();
        this.ad.registerViewForInteraction(activity, container, clickViews, creativeViews, null, null, null, new TapFeedAd.AdInteractionListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeFeedSession.1
            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdClicked(View view, TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onClick(view);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdCreativeClick(View view, TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onCreativeClick(view);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdShow(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onShow(container);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onAdValidView(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onShow(container);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onDistinctAdShow(TapFeedAd tapFeedAd) {
            }

            @Override // com.tapsdk.tapad.TapFeedAd.AdInteractionListener
            public void onDownloadWindowConfirm(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onDownloadWindowConfirm();
            }
        });
        if (this.mediaView != null && (adView = this.ad.getAdView()) != null) {
            this.mediaView.removeAllViews();
            ViewParent parent = adView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(adView);
            }
            this.mediaView.addView(adView, new ViewGroup.LayoutParams(-1, -1));
            this.mediaView.requestLayout();
        }
        this.ad.setDownloadListener(new TapAppDownloadListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeFeedSession.2
            final long apkSize;
            final String appName;
            final String fileName = "";
            long curBytes = 0;

            {
                this.apkSize = TapTapADNNativeFeedSession.this.ad.getApkSizeBytes();
                this.appName = TapTapADNNativeFeedSession.this.getComplianceInfo().getAppName();
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onDownloadComplete() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNNativeFeedSession.this.eventSink;
                long j = this.apkSize;
                adapterAdEventSink.onDownloadComplete(j, j, this.appName, "");
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onDownloadError() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNNativeFeedSession.this.eventSink;
                long j = this.apkSize;
                adapterAdEventSink.onDownloadFailure(j, j, this.curBytes, this.appName, "", -1, "");
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onDownloadPause() {
                AdapterAdEventSink adapterAdEventSink = TapTapADNNativeFeedSession.this.eventSink;
                long j = this.apkSize;
                adapterAdEventSink.onDownloadPause(j, j, this.curBytes, this.appName, "");
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onDownloadStart() {
                TapTapADNNativeFeedSession.this.eventSink.onDownloadStart(this.apkSize, this.appName, "");
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onIdle() {
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onInstalled() {
                TapTapADNNativeFeedSession.this.eventSink.onInstalled(this.apkSize, this.appName, "");
            }

            @Override // com.tapsdk.tapad.TapAppDownloadListener
            public void onUpdateDownloadProgress(int i) {
                this.curBytes = (this.apkSize * ((long) i)) / 100;
                AdapterAdEventSink adapterAdEventSink = TapTapADNNativeFeedSession.this.eventSink;
                long j = this.apkSize;
                adapterAdEventSink.onDownloadProgress(j, j, this.curBytes, this.appName, "");
            }
        });
        this.ad.setVideoAdListener(new TapFeedAd.VideoAdListener() { // from class: com.tapsdk.tapad.lib_tapadadapter.TapTapADNNativeFeedSession.3
            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoError(TapFeedAd tapFeedAd, int i, String str) {
                TapTapADNNativeFeedSession.this.eventSink.onVideoFailure(i, str);
            }

            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoPause(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onVideoPause();
            }

            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoPrepared(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onVideoPrepared();
            }

            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoStart(TapFeedAd tapFeedAd) {
                TapTapADNNativeFeedSession.this.eventSink.onVideoStart();
            }

            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoVolumeClose(TapFeedAd tapFeedAd) {
            }

            @Override // com.tapsdk.tapad.TapFeedAd.VideoAdListener
            public void onVideoVolumeOpen(TapFeedAd tapFeedAd) {
            }
        });
        if (adapterNativeFeedBinding.isSelfDoubleWindow()) {
            this.ad.setIsSelfDoubleWindow(true);
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void cancelDownload() {
        this.ad.cancelDownload();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public void confirmDownload() {
        this.ad.confirmDownload();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad.dispose();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getApkSize() {
        return this.ad.getApkSize();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public long getApkSizeBytes() {
        return this.ad.getApkSizeBytes();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        ComplianceInfo complianceInfo = this.ad.getComplianceInfo();
        return complianceInfo == null ? AdapterAppComplianceInfo.EMPTY : new AdapterAppComplianceInfo(complianceInfo.getAppName(), complianceInfo.getAppVersion(), complianceInfo.getDeveloperName(), complianceInfo.getPrivacyUrl(), complianceInfo.getFunctionDescUrl(), complianceInfo.getPermissionUrl(), complianceInfo.getAdLogIconUrl());
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getDescription() {
        return this.ad.getDescription();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getIconUrl() {
        return this.ad.getIconUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getImageMode() {
        return this.ad.getImageMode();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public List<AdapterNativeImage> getImages() {
        ArrayList arrayList = new ArrayList();
        for (ImageInfo imageInfo : this.ad.getImageInfoList()) {
            if (imageInfo != null) {
                arrayList.add(new AdapterNativeImage(imageInfo.imageUrl, imageInfo.width, imageInfo.height));
            }
        }
        return arrayList;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getInteractionType() {
        return this.ad.getInteractionType() == 1 ? 1 : 0;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public View getMediaView() {
        if (this.mediaView != null) {
            return this.mediaView;
        }
        Context context = this.contextWeakReference.get();
        View adView = this.ad.getAdView();
        if (context == null) {
            return adView;
        }
        this.mediaView = new FrameLayout(this.contextWeakReference.get());
        if (adView != null) {
            this.mediaView.addView(adView);
        }
        this.mediaView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        return this.mediaView;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        return this.ad.getMediaExtraInfo();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        return this.ad.getPrice();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public float getScore() {
        return this.ad.getScore();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getTitle() {
        return this.ad.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.ad.isValid();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long j, String str, String str2) {
        this.ad.sendLossNotification(Utils.getLossMap(j, str, str2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long j, long j2, String str) {
        this.ad.sendWinNotification(Utils.getWinMap(j, j2));
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink adapterAdEventSink) {
        if (adapterAdEventSink == null) {
            adapterAdEventSink = AdapterAdEventSink.NONE;
        }
        this.eventSink = adapterAdEventSink;
    }
}
