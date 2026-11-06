package com.mcto.sspsdk;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IQyNativeAd {

    public interface IQyCustomizeVideo {
        String getVideoUrl();

        void reportVideoBreak(long j);

        void reportVideoContinue(long j);

        void reportVideoError(long j, int i, int i2);

        void reportVideoFinish();

        void reportVideoPause(long j);

        void reportVideoProgressUpdate(long j);

        void reportVideoStart(boolean z);

        void reportVideoStartError(int i, int i2);
    }

    public interface IQyNativeAdInteractionListener {
        void onAdButtonClick(View view, IQyNativeAd iQyNativeAd);

        void onAdClicked(View view, IQyNativeAd iQyNativeAd);

        void onAdClose(IQyNativeAd iQyNativeAd);

        void onAdShow(IQyNativeAd iQyNativeAd);
    }

    public interface IQyVideoAdListener {
        void onProgressUpdate(IQyNativeAd iQyNativeAd, long j, long j2);

        void onVideoAdComplete(IQyNativeAd iQyNativeAd);

        void onVideoAdContinuePlay(IQyNativeAd iQyNativeAd);

        void onVideoAdPaused(IQyNativeAd iQyNativeAd);

        void onVideoAdStartPlay(IQyNativeAd iQyNativeAd);

        void onVideoError(IQyNativeAd iQyNativeAd, int i, int i2);

        void onVideoLoad(IQyNativeAd iQyNativeAd);
    }

    void destroy();

    int getActionType();

    Map<String, String> getAdExtra();

    View getAdView();

    IQyAppComplianceInfo getAppComplianceInfo();

    String getButtonText();

    int getClickThroughType();

    QyImage getCoverImage();

    String getDspName();

    long getDuration();

    int getHeight();

    QyImage getIcon();

    String getName();

    int getTemplateType();

    String getTitle();

    int getWidth();

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, IQyNativeAdInteractionListener iQyNativeAdInteractionListener);

    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, IQyNativeAdInteractionListener iQyNativeAdInteractionListener);

    void setActionStart();

    void setActionStop();

    void setActivityForDownloadApp(Activity activity);

    void setAppVideoAdListener(IQyVideoAdListener iQyVideoAdListener);

    void setDownloadListener(IQyAppDownloadListener iQyAppDownloadListener);

    void setMute(boolean z);
}
