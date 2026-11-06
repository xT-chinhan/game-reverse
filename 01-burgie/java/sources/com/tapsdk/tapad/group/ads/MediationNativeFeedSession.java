package com.tapsdk.tapad.group.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import com.tapsdk.tapad.group.adapter.AdapterViewSupport;
import com.tapsdk.tapad.group.ads.entities.ComplianceInfo;
import com.tapsdk.tapad.group.ads.entities.ImageInfo;
import com.tapsdk.tapad.group.views.DirichletAdNativeContainer;
import com.tapsdk.tapad.group.views.DirichletAdView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class MediationNativeFeedSession extends AdapterAdCandidate<AdapterNativeFeedSession> {
    private final AtomicBoolean didNotifyShow;
    private DirichletAppDownloadListener downloadListener;
    private volatile DirichletAdView feedMediaView;
    private DirichletNativeFeedAd.AdInteractionListener interactionListener;
    private FrameLayout.LayoutParams logoParams;
    private boolean selfDoubleWindow;
    private DirichletNativeFeedAd.VideoAdListener videoAdListener;

    public MediationNativeFeedSession(AdapterNativeFeedSession adapterNativeFeedSession) {
        super(adapterNativeFeedSession);
        this.didNotifyShow = new AtomicBoolean(false);
    }

    private FrameLayout.LayoutParams getLogoLayoutParams(Context context) {
        FrameLayout.LayoutParams layoutParams = this.logoParams;
        if (layoutParams != null) {
            return layoutParams;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388693;
        layoutParams2.setMargins(0, 0, AdapterViewSupport.dpToPx(context, 8.0f), AdapterViewSupport.dpToPx(context, 8.0f));
        return layoutParams2;
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public void cancelDownload() {
        effects().onDownloadCancel(this);
        getSession().cancelDownload();
    }

    public void confirmDownload() {
        effects().onDownloadConfirm(this);
        getSession().confirmDownload();
    }

    public View getAdView() {
        View mediaView = getSession().getMediaView();
        effects().codebitGetView(this, mediaView);
        effects().spaceGetView(this, mediaView);
        if (mediaView == null || mediaView.getContext() == null) {
            return mediaView;
        }
        if (this.feedMediaView == null) {
            synchronized (this) {
                if (this.feedMediaView == null) {
                    this.feedMediaView = new DirichletAdView(mediaView.getContext());
                    this.feedMediaView.setAdContent(mediaView, "native_feed", androidNetworkType());
                }
            }
        }
        return this.feedMediaView;
    }

    @Deprecated
    public String getApkSize() {
        return safe(getSession().getApkSize());
    }

    public long getApkSizeBytes() {
        return getSession().getApkSizeBytes();
    }

    public ComplianceInfo getComplianceInfo() {
        final AdapterAppComplianceInfo complianceInfo = getSession().getComplianceInfo() == null ? AdapterAppComplianceInfo.EMPTY : getSession().getComplianceInfo();
        return new ComplianceInfo() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession.1
            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getAdLogIconUrl() {
                return complianceInfo.getAdLogoUrl();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getAppName() {
                return complianceInfo.getAppName();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getAppVersion() {
                return complianceInfo.getAppVersion();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getDeveloperName() {
                return complianceInfo.getDeveloperName();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getFunctionDescUrl() {
                return complianceInfo.getFunctionDescriptionUrl();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getPermissionUrl() {
                return complianceInfo.getPermissionUrl();
            }

            @Override // com.tapsdk.tapad.group.ads.entities.ComplianceInfo
            public String getPrivacyUrl() {
                return complianceInfo.getPrivacyUrl();
            }
        };
    }

    public String getDescription() {
        return safe(getSession().getDescription());
    }

    public String getIconUrl() {
        return safe(getSession().getIconUrl());
    }

    public List<ImageInfo> getImageInfoList() {
        List<AdapterNativeImage> images = getSession().getImages();
        if (images == null || images.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(images.size());
        for (AdapterNativeImage adapterNativeImage : images) {
            if (adapterNativeImage != null) {
                ImageInfo imageInfo = new ImageInfo();
                imageInfo.imageUrl = adapterNativeImage.getUrl();
                imageInfo.width = adapterNativeImage.getWidth();
                imageInfo.height = adapterNativeImage.getHeight();
                arrayList.add(imageInfo);
            }
        }
        return arrayList;
    }

    public int getImageMode() {
        return getSession().getImageMode();
    }

    public int getInteractionType() {
        return getSession().getInteractionType();
    }

    public float getScore() {
        return getSession().getScore();
    }

    public String getTitle() {
        return safe(getSession().getTitle());
    }

    /* JADX INFO: renamed from: lambda$onClick$1$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m55lambda$onClick$1$comtapsdktapadgroupadsMediationNativeFeedSession(View view) {
        this.interactionListener.onAdClick(view, (DirichletNativeFeedAd) getOuterAd());
    }

    /* JADX INFO: renamed from: lambda$onCreativeClick$2$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m56lambda$onCreativeClick$2$comtapsdktapadgroupadsMediationNativeFeedSession(View view) {
        this.interactionListener.onAdClick(view, (DirichletNativeFeedAd) getOuterAd());
    }

    /* JADX INFO: renamed from: lambda$onDownloadProgress$7$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m57lambda$onDownloadProgress$7$comtapsdktapadgroupadsMediationNativeFeedSession(int i) {
        this.downloadListener.onUpdateDownloadProgress(i);
    }

    /* JADX INFO: renamed from: lambda$onShow$0$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m58lambda$onShow$0$comtapsdktapadgroupadsMediationNativeFeedSession() {
        this.interactionListener.onAdShow((DirichletNativeFeedAd) getOuterAd());
    }

    /* JADX INFO: renamed from: lambda$onVideoFailure$4$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m59lambda$onVideoFailure$4$comtapsdktapadgroupadsMediationNativeFeedSession(int i, String str) {
        this.videoAdListener.onVideoError((DirichletNativeFeedAd) getOuterAd(), 200011, getAdnTrackId() + "," + i + "," + str);
    }

    /* JADX INFO: renamed from: lambda$onVideoPause$6$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m60lambda$onVideoPause$6$comtapsdktapadgroupadsMediationNativeFeedSession() {
        this.videoAdListener.onVideoPause((DirichletNativeFeedAd) getOuterAd());
    }

    /* JADX INFO: renamed from: lambda$onVideoPrepared$3$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m61lambda$onVideoPrepared$3$comtapsdktapadgroupadsMediationNativeFeedSession() {
        this.videoAdListener.onVideoPrepared((DirichletNativeFeedAd) getOuterAd());
    }

    /* JADX INFO: renamed from: lambda$onVideoStart$5$com-tapsdk-tapad-group-ads-MediationNativeFeedSession, reason: not valid java name */
    /* synthetic */ void m62lambda$onVideoStart$5$comtapsdktapadgroupadsMediationNativeFeedSession() {
        this.videoAdListener.onVideoStart((DirichletNativeFeedAd) getOuterAd());
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate
    public void onBeforeSessionDestroy() {
        if (this.feedMediaView != null) {
            this.feedMediaView.destroy();
        }
        this.feedMediaView = null;
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onClick(final View view) {
        super.onClick(view);
        if (this.interactionListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m55lambda$onClick$1$comtapsdktapadgroupadsMediationNativeFeedSession(view);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onCreativeClick(final View view) {
        super.onCreativeClick(view);
        if (this.interactionListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m56lambda$onCreativeClick$2$comtapsdktapadgroupadsMediationNativeFeedSession(view);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadComplete(long j, long j2, String str, String str2) {
        super.onDownloadComplete(j, j2, str, str2);
        final DirichletAppDownloadListener dirichletAppDownloadListener = this.downloadListener;
        if (dirichletAppDownloadListener != null) {
            Objects.requireNonNull(dirichletAppDownloadListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    dirichletAppDownloadListener.onDownloadComplete();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadFailure(long j, long j2, long j3, String str, String str2, int i, String str3) {
        super.onDownloadFailure(j, j2, j3, str, str2, i, str3);
        final DirichletAppDownloadListener dirichletAppDownloadListener = this.downloadListener;
        if (dirichletAppDownloadListener != null) {
            Objects.requireNonNull(dirichletAppDownloadListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    dirichletAppDownloadListener.onDownloadError();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadPause(long j, long j2, long j3, String str, String str2) {
        super.onDownloadPause(j, j2, j3, str, str2);
        final DirichletAppDownloadListener dirichletAppDownloadListener = this.downloadListener;
        if (dirichletAppDownloadListener != null) {
            Objects.requireNonNull(dirichletAppDownloadListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    dirichletAppDownloadListener.onDownloadPause();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadProgress(long j, long j2, long j3, String str, String str2) {
        super.onDownloadProgress(j, j2, j3, str, str2);
        if (this.downloadListener == null || j2 <= 0) {
            return;
        }
        final int i = (int) ((j3 * 100) / j2);
        AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m57lambda$onDownloadProgress$7$comtapsdktapadgroupadsMediationNativeFeedSession(i);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadStart(long j, String str, String str2) {
        super.onDownloadStart(j, str, str2);
        final DirichletAppDownloadListener dirichletAppDownloadListener = this.downloadListener;
        if (dirichletAppDownloadListener != null) {
            Objects.requireNonNull(dirichletAppDownloadListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    dirichletAppDownloadListener.onDownloadStart();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onDownloadWindowConfirm() {
        super.onDownloadWindowConfirm();
        DirichletNativeFeedAd.AdInteractionListener adInteractionListener = this.interactionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onDownloadWindowConfirm((DirichletNativeFeedAd) getOuterAd());
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onInstalled(long j, String str, String str2) {
        super.onInstalled(j, str, str2);
        final DirichletAppDownloadListener dirichletAppDownloadListener = this.downloadListener;
        if (dirichletAppDownloadListener != null) {
            Objects.requireNonNull(dirichletAppDownloadListener);
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    dirichletAppDownloadListener.onInstalled();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onShow(View view) {
        if (this.didNotifyShow.compareAndSet(false, true)) {
            super.onShow(view);
            if (this.interactionListener != null) {
                AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m58lambda$onShow$0$comtapsdktapadgroupadsMediationNativeFeedSession();
                    }
                });
            }
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoFailure(final int i, final String str) {
        super.onVideoFailure(i, str);
        if (this.videoAdListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m59lambda$onVideoFailure$4$comtapsdktapadgroupadsMediationNativeFeedSession(i, str);
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoPause() {
        super.onVideoPause();
        if (this.videoAdListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m60lambda$onVideoPause$6$comtapsdktapadgroupadsMediationNativeFeedSession();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoPrepared() {
        super.onVideoPrepared();
        if (this.videoAdListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m61lambda$onVideoPrepared$3$comtapsdktapadgroupadsMediationNativeFeedSession();
                }
            });
        }
    }

    @Override // com.tapsdk.tapad.group.ads.AdapterAdCandidate, com.tapsdk.tapad.group.adapter.AdapterAdEventSink
    public void onVideoStart() {
        super.onVideoStart();
        if (this.videoAdListener != null) {
            AdapterAdCandidate.dispatchCallback(new Runnable() { // from class: com.tapsdk.tapad.group.ads.MediationNativeFeedSession$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m62lambda$onVideoStart$5$comtapsdktapadgroupadsMediationNativeFeedSession();
                }
            });
        }
    }

    public void pauseDownload() {
        getSession().pauseDownload();
    }

    public synchronized void registerViewForInteraction(Activity activity, DirichletAdNativeContainer dirichletAdNativeContainer, List<View> list, List<View> list2, DirichletNativeFeedAd.AdInteractionListener adInteractionListener) {
        this.interactionListener = adInteractionListener;
        getSession().bind(activity, new AdapterNativeFeedBinding(dirichletAdNativeContainer, list, list2, getLogoLayoutParams(activity), doubleWindow(), this.selfDoubleWindow));
    }

    public void resumeDownload() {
        getSession().resumeDownload();
    }

    public void setDownloadListener(DirichletAppDownloadListener dirichletAppDownloadListener) {
        this.downloadListener = dirichletAppDownloadListener;
    }

    public void setIsSelfDoubleWindow(boolean z) {
        this.selfDoubleWindow = z;
    }

    public void setLogoLayoutParams(FrameLayout.LayoutParams layoutParams) {
        this.logoParams = layoutParams;
    }

    public void setVideoAdListener(DirichletNativeFeedAd.VideoAdListener videoAdListener) {
        this.videoAdListener = videoAdListener;
    }
}
