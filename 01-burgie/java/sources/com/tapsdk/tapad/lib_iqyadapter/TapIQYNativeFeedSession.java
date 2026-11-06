package com.tapsdk.tapad.lib_iqyadapter;

import android.app.Activity;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mar.sdk.IAction;
import com.mcto.sspsdk.IQyAppComplianceInfo;
import com.mcto.sspsdk.IQyAppDownloadListener;
import com.mcto.sspsdk.IQyNativeAd;
import com.mcto.sspsdk.QyImage;
import com.mcto.sspsdk.QyRewardProperty;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.group.adapter.AdapterAdEventSink;
import com.tapsdk.tapad.group.adapter.AdapterAdMetadata;
import com.tapsdk.tapad.group.adapter.AdapterAppComplianceInfo;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedBinding;
import com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession;
import com.tapsdk.tapad.group.adapter.AdapterNativeImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class TapIQYNativeFeedSession implements AdapterNativeFeedSession {
    private IQyNativeAd ad;
    private long apkSize;
    private String appName;
    private String appVersion;
    private String developer;
    private AdapterAdEventSink eventSink = AdapterAdEventSink.NONE;
    private String functionDescUrl;
    private String permissionUrl;
    private final String placementId;
    private String privacyUrl;

    TapIQYNativeFeedSession(IQyNativeAd ad, String placementId) {
        this.appName = "";
        this.appVersion = "";
        this.developer = "";
        this.privacyUrl = "";
        this.permissionUrl = "";
        this.functionDescUrl = "";
        this.ad = ad;
        this.placementId = placementId;
        IQyAppComplianceInfo complianceInfo = ad.getAppComplianceInfo();
        if (complianceInfo != null) {
            this.appName = complianceInfo.getAppName();
            Map<String, String> map = complianceInfo.getAllInfoKV();
            try {
                String a = map.get("包体大小");
                this.apkSize = Long.parseLong(a.substring(0, a.length() - 1)) * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            } catch (Exception e) {
            }
            try {
                this.appVersion = map.get("版本");
            } catch (Exception e2) {
            }
            try {
                this.developer = map.get("开发者");
            } catch (Exception e3) {
            }
            try {
                this.privacyUrl = map.get("隐私条款");
            } catch (Exception e4) {
            }
            try {
                this.permissionUrl = map.get("权限列表");
            } catch (Exception e5) {
            }
            try {
                this.functionDescUrl = map.get("应用功能");
            } catch (Exception e6) {
            }
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void setEventSink(AdapterAdEventSink sink) {
        this.eventSink = sink == null ? AdapterAdEventSink.NONE : sink;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public synchronized void bind(Activity activity, AdapterNativeFeedBinding binding) {
        final FrameLayout container = binding.getContainer();
        List<View> clickViews = binding.getClickViews();
        List<View> creativeViews = binding.getCreativeViews();
        FrameLayout newContainer = new FrameLayout(activity);
        binding.installProviderContainer(newContainer);
        View logoContainer = activity.getLayoutInflater().inflate(R.layout.dirichlet_iqy_logo_container, (ViewGroup) null);
        binding.addOverlay(logoContainer);
        this.ad.registerViewForInteraction(container, clickViews, creativeViews, null, new IQyNativeAd.IQyNativeAdInteractionListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYNativeFeedSession.1
            @Override // com.mcto.sspsdk.IQyNativeAd.IQyNativeAdInteractionListener
            public void onAdClicked(View view, IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onClick(view);
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyNativeAdInteractionListener
            public void onAdButtonClick(View view, IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onCreativeClick(view);
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyNativeAdInteractionListener
            public void onAdShow(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onShow(container);
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyNativeAdInteractionListener
            public void onAdClose(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onClose();
            }
        });
        this.ad.setDownloadListener(new IQyAppDownloadListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYNativeFeedSession.2
            final AtomicBoolean isDownloading = new AtomicBoolean(false);
            final AtomicBoolean hasFinished = new AtomicBoolean(false);
            final AtomicBoolean hasInstalled = new AtomicBoolean(false);
            long curBytes = 0;

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onIdle() {
            }

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onDownloadActive(float v, String s) {
                if (this.isDownloading.compareAndSet(false, true)) {
                    TapIQYNativeFeedSession.this.eventSink.onDownloadStart(TapIQYNativeFeedSession.this.apkSize, s, "");
                }
                this.curBytes = (long) (TapIQYNativeFeedSession.this.apkSize * v);
                TapIQYNativeFeedSession.this.eventSink.onDownloadProgress(TapIQYNativeFeedSession.this.apkSize, TapIQYNativeFeedSession.this.apkSize, this.curBytes, s, "");
            }

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onDownloadPaused(float v, String s) {
                this.isDownloading.set(false);
                long currBytes = (long) (TapIQYNativeFeedSession.this.apkSize * v);
                TapIQYNativeFeedSession.this.eventSink.onDownloadPause(TapIQYNativeFeedSession.this.apkSize, TapIQYNativeFeedSession.this.apkSize, currBytes, s, "");
            }

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onDownloadFailed(String s) {
                this.isDownloading.set(false);
                TapIQYNativeFeedSession.this.eventSink.onDownloadFailure(TapIQYNativeFeedSession.this.apkSize, TapIQYNativeFeedSession.this.apkSize, this.curBytes, s, "", -1, "");
            }

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onDownloadFinished(String s) {
                if (this.hasFinished.compareAndSet(false, true)) {
                    TapIQYNativeFeedSession.this.eventSink.onDownloadComplete(TapIQYNativeFeedSession.this.apkSize, TapIQYNativeFeedSession.this.apkSize, s, "");
                }
            }

            @Override // com.mcto.sspsdk.IQyAppDownloadListener
            public void onInstalled(String s) {
                if (this.hasInstalled.compareAndSet(false, true)) {
                    TapIQYNativeFeedSession.this.eventSink.onInstalled(TapIQYNativeFeedSession.this.apkSize, s, "");
                }
            }
        });
        this.ad.setAppVideoAdListener(new IQyNativeAd.IQyVideoAdListener() { // from class: com.tapsdk.tapad.lib_iqyadapter.TapIQYNativeFeedSession.3
            long duration;

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoLoad(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onVideoPrepared();
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoError(IQyNativeAd iQyNativeAd, int i, int i1) {
                TapIQYNativeFeedSession.this.eventSink.onVideoFailure(i, String.valueOf(i1));
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoAdStartPlay(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onVideoStart();
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoAdPaused(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onVideoPause();
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoAdContinuePlay(IQyNativeAd iQyNativeAd) {
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onProgressUpdate(IQyNativeAd iQyNativeAd, long l, long l1) {
                this.duration = l;
            }

            @Override // com.mcto.sspsdk.IQyNativeAd.IQyVideoAdListener
            public void onVideoAdComplete(IQyNativeAd iQyNativeAd) {
                TapIQYNativeFeedSession.this.eventSink.onVideoComplete(this.duration);
            }
        });
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getIconUrl() {
        if (this.ad.getIcon() == null) {
            return "";
        }
        return this.ad.getIcon().getHttpUrl();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public float getScore() {
        return 0.0f;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public List<AdapterNativeImage> getImages() {
        List<AdapterNativeImage> list = new ArrayList<>();
        QyImage coverImage = this.ad.getCoverImage();
        if (coverImage != null) {
            list.add(new AdapterNativeImage(coverImage.getHttpUrl(), 0, 0));
        }
        return list;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getTitle() {
        return this.ad.getTitle();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getDescription() {
        return this.ad.getDspName();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public String getApkSize() {
        return String.valueOf(this.apkSize);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public long getApkSizeBytes() {
        return this.apkSize;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getInteractionType() {
        switch (this.ad.getClickThroughType()) {
            case 0:
                return 3;
            case 11:
                return 1;
            case 14:
                return 2;
            default:
                return 0;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public int getImageMode() {
        return 0;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public AdapterAppComplianceInfo getComplianceInfo() {
        return new AdapterAppComplianceInfo(this.appName, this.appVersion, this.developer, this.privacyUrl, this.functionDescUrl, this.permissionUrl, "");
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterNativeFeedSession
    public View getMediaView() {
        IQyNativeAd iQyNativeAd = this.ad;
        if (iQyNativeAd == null) {
            return null;
        }
        return iQyNativeAd.getAdView();
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public boolean isValid() {
        return this.ad != null;
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public long getPrice() {
        Map<String, String> s = this.ad.getAdExtra();
        try {
            if (s.containsKey(IAction.PurchaseKey.Price)) {
                return Long.parseLong(s.get(IAction.PurchaseKey.Price));
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public Map<String, Object> getMetadata() {
        IQyNativeAd iQyNativeAd = this.ad;
        Map<String, String> extra = iQyNativeAd != null ? iQyNativeAd.getAdExtra() : Collections.emptyMap();
        Map<String, Object> map = new HashMap<>();
        if (extra.containsKey(QyRewardProperty.VERIFY_IMPRESSIONID)) {
            map.put(Constants.Bidding.REQUEST_ID, extra.get(QyRewardProperty.VERIFY_IMPRESSIONID));
        }
        if (extra.containsKey(IAction.PurchaseKey.Price)) {
            map.put(IAction.PurchaseKey.Price, extra.get(IAction.PurchaseKey.Price));
        }
        return AdapterAdMetadata.fromProvider(map);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendWin(long secondPrice, long winPrice, String followBidder) {
        IQyNativeAd iQyNativeAd = this.ad;
        Map<String, String> extra = iQyNativeAd != null ? iQyNativeAd.getAdExtra() : Collections.emptyMap();
        String impressionId = extra.get(QyRewardProperty.VERIFY_IMPRESSIONID);
        IQYBidInfoReporter.reportWin(impressionId, this.placementId, 5564, secondPrice, followBidder);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void sendLoss(long winPrice, String lossReason, String winBidder) {
        IQyNativeAd iQyNativeAd = this.ad;
        Map<String, String> extra = iQyNativeAd != null ? iQyNativeAd.getAdExtra() : Collections.emptyMap();
        String impressionId = extra.get(QyRewardProperty.VERIFY_IMPRESSIONID);
        IQYBidInfoReporter.reportLoss(impressionId, this.placementId, 5564, winPrice, winBidder, 1);
    }

    @Override // com.tapsdk.tapad.group.adapter.AdapterAdSession
    public void destroy() {
        this.ad = null;
    }
}
