package com.tapsdk.tapad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tapsdk.tapad.feed.FeedOption;
import com.tapsdk.tapad.feed.TapFeedAdView;
import com.tapsdk.tapad.model.entities.ImageInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface TapFeedAd {

    public interface AdClickPassiveListener {
        void adCreativePassiveClick();

        void adPassiveShow();
    }

    public interface AdInteractionListener {
        void onAdClicked(View view, TapFeedAd tapFeedAd);

        void onAdCreativeClick(View view, TapFeedAd tapFeedAd);

        void onAdShow(TapFeedAd tapFeedAd);

        void onAdValidView(TapFeedAd tapFeedAd);

        void onDistinctAdShow(TapFeedAd tapFeedAd);
    }

    public interface ExpressRenderListener {
        void onAdClicked(TapFeedAdView tapFeedAdView);

        void onAdClosed(TapFeedAdView tapFeedAdView);

        void onAdShow(TapFeedAdView tapFeedAdView);

        void onAdValidShow(TapFeedAdView tapFeedAdView);

        void onRenderFail(TapFeedAdView tapFeedAdView, TapFeedAd tapFeedAd, int i, String str);

        void onRenderSuccess(TapFeedAdView tapFeedAdView);
    }

    public interface VideoAdListener {
        void onVideoError(TapFeedAd tapFeedAd, int i, int i2);

        void onVideoPause(TapFeedAd tapFeedAd);

        void onVideoPrepared(TapFeedAd tapFeedAd);

        void onVideoStart(TapFeedAd tapFeedAd);

        void onVideoVolumeClose(TapFeedAd tapFeedAd);

        void onVideoVolumeOpen(TapFeedAd tapFeedAd);
    }

    void closeDownloadFloatingDialog();

    void closeVideoVolume();

    void dispose();

    AdClickPassiveListener getAdClickPassiveListener();

    View getAdView();

    String getApkSize();

    ComplianceInfo getComplianceInfo();

    String getDescription();

    String getIconUrl();

    List<ImageInfo> getImageInfoList();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    float getScore();

    String getTitle();

    void openVideoVolume();

    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, AdInteractionListener adInteractionListener);

    @Deprecated
    void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, List<View> list5, AdInteractionListener adInteractionListener);

    void render(Activity activity, FeedOption feedOption);

    void render(FeedOption feedOption);

    void sendLossNotification(Map<String, Object> map);

    void sendWinNotification(Map<String, Object> map);

    void setDownloadListener(TapAppDownloadListener tapAppDownloadListener);

    void setExpressRenderListener(ExpressRenderListener expressRenderListener);

    void setVideoAdListener(VideoAdListener videoAdListener);

    void setVideoPlaySelfController(boolean z);

    void setVolumeVisible(boolean z);

    void startVideoPlay();

    void stopVideoPlay();
}
